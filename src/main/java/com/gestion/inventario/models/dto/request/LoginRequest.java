package com.gestion.inventario.models.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoginRequest {
    @NotNull(message = "El email no puede ser nulo")
    @NotBlank(message = "El email no puede ser vacio")
    private String email;

    @NotNull(message = "El password no puede ser nulo")
    @NotBlank(message = "El password no puede ser vacio")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
