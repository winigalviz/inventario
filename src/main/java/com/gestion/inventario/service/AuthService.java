package com.gestion.inventario.service;

import com.gestion.inventario.models.dto.LoginResponseDTO;
import com.gestion.inventario.models.dto.request.LoginRequest;
import com.gestion.inventario.models.dto.request.RegisterRequest;
import com.gestion.inventario.models.entities.UserEntity;

public interface AuthService {
    UserEntity register(RegisterRequest request);
    LoginResponseDTO login(LoginRequest request);
}
