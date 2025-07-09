package com.gestion.inventario.models.dto;

public class LoginResponseDTO {
    public String text;
    public boolean isOk;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    @Override
    public String toString() {
        return "LoginResponseDTO{" +
                "text='" + text + '\'' +
                ", isOk=" + isOk +
                '}';
    }
}
