package com.gestion.inventario.models.dto;

import java.time.LocalDateTime;

public class ErrorResponse {

    private String mensaje;
    private LocalDateTime timestamp;
    private int codigo;

    public ErrorResponse(String mensaje, int codigo) {
        this.mensaje = mensaje;
        this.codigo = codigo;
        this.timestamp = LocalDateTime.now();
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "mensaje='" + mensaje + '\'' +
                ", timestamp=" + timestamp +
                ", codigo=" + codigo +
                '}';
    }
}
