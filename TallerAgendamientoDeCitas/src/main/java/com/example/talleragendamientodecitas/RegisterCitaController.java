package com.example.talleragendamientodecitas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class RegisterCitaController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField cedulaField;
    @FXML
    private TextField telefonoField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField fechaField;
    @FXML
    private TextField servicioField;

    private Barberia barberia = new Barberia();

    @FXML
    protected void handleRegistrarCita(ActionEvent event) {
        try {
            String nombre = nameField.getText();
            String cedula = cedulaField.getText();
            String telefono = telefonoField.getText();
            String email = emailField.getText();
            String fechaTexto = fechaField.getText();
            LocalDateTime fechaHora;

            // Validación de la fecha
            try {
                fechaHora = parseFecha(fechaTexto);
            } catch (DateTimeParseException ex) {
                showAlert(Alert.AlertType.ERROR, "Error de Formato", "La fecha y hora deben estar en el formato YYYY-MM-DDTHH:MM.");
                return;
            }

            String servicio = servicioField.getText();

            Cliente cliente = new Cliente(nombre, cedula, telefono, email);
            Cita cita = new Cita(cliente, fechaHora, servicio);
            barberia.agendarCita(cita);
            showAlert(Alert.AlertType.INFORMATION, "Cita Registrada", "La cita ha sido registrada exitosamente.");
        } catch (Exception ex) {
            showAlert(Alert.AlertType.ERROR, "Error", "Hubo un error al registrar la cita: " + ex.getMessage());
        }
    }

    private LocalDateTime parseFecha(String fechaTexto) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return LocalDateTime.parse(fechaTexto, formatter);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    protected void handleVolver(ActionEvent event) throws Exception {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("MainView.fxml")));
        stage.setScene(scene);
    }
}
