package com.example.talleragendamientodecitas;

import java.time.LocalDateTime;

public class Cita {
    private Cliente cliente;
    private LocalDateTime fechaHora;
    private String servicio;

    public Cita(Cliente cliente, LocalDateTime fechaHora, String servicio) {
        this.cliente = cliente;
        this.fechaHora = fechaHora;
        this.servicio = servicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "cliente=" + cliente +
                ", fechaHora=" + fechaHora +
                ", servicio='" + servicio + '\'' +
                '}';
    }
}

