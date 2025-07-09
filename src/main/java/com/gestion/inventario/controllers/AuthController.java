package com.gestion.inventario.controllers;

import com.gestion.inventario.models.dto.LoginResponseDTO;
import com.gestion.inventario.models.dto.request.LoginRequest;
import com.gestion.inventario.models.dto.request.LoginRegisterResponse;
import com.gestion.inventario.models.dto.request.RegisterRequest;
import com.gestion.inventario.models.entities.UserEntity;
import com.gestion.inventario.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        UserEntity user = this.authService.register(request);
        LoginRequest authRequest = new LoginRequest();
        authRequest.setEmail(user.getEmail());
        authRequest.setPassword(request.getPassword());
        LoginResponseDTO response = this.authService.login(authRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new LoginRegisterResponse(response.text));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        LoginResponseDTO response = this.authService.login(request);
        if (response.isOk()) {
            return ResponseEntity.ok(new LoginRegisterResponse(response.text));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response.text);
    }
}
