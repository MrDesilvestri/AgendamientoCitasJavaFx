package com.example.talleragendamientodecitas;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Barberia {
    private List<Cita> citas;
    private ObjectMapper mapper;

    public Barberia() {
        citas = new ArrayList<>();
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // Registrar el módulo
    }

    public void agendarCita(Cita cita) throws IOException {
        citas.add(cita);
        guardarCita(cita);
    }

    private void guardarCita(Cita cita) throws IOException {
        String fechaDirectorio = cita.getFechaHora().toLocalDate().toString();
        String directorio = "citas/" + fechaDirectorio;
        Files.createDirectories(Paths.get(directorio));

        String archivo = directorio + "/" + cita.getCliente().getCedula() + ".json";
        mapper.writeValue(new File(archivo), cita);
    }

    public List<Cita> consultarCitas(LocalDate fecha) throws IOException {
        String fechaDirectorio = fecha.toString();
        String directorio = "citas/" + fechaDirectorio;
        List<Cita> citasDelDia = new ArrayList<>();

        if (Files.exists(Paths.get(directorio))) {
            Files.list(Paths.get(directorio)).forEach(path -> {
                try {
                    Cita cita = mapper.readValue(path.toFile(), Cita.class);
                    citasDelDia.add(cita);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        return citasDelDia;
    }
}
