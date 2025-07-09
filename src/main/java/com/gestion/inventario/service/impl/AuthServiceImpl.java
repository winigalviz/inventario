package com.gestion.inventario.service.impl;

import com.gestion.inventario.models.dto.LoginResponseDTO;
import com.gestion.inventario.models.dto.request.LoginRequest;
import com.gestion.inventario.models.dto.request.RegisterRequest;
import com.gestion.inventario.models.entities.RoleEntity;
import com.gestion.inventario.models.entities.UserEntity;
import com.gestion.inventario.models.repositories.RoleRepository;
import com.gestion.inventario.models.repositories.UserRepository;
import com.gestion.inventario.service.AuthService;
import com.gestion.inventario.service.CustomUserDetailsService;
import com.gestion.inventario.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity register(RegisterRequest request) {
        UserEntity user = new UserEntity();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        for (Integer idRole : request.getRoles()) {
            this.roleRepository.findById(idRole).ifPresent(roles::add);
        }
        user.setRoles(roles);
        return this.userRepository.save(user);
    }

    @Override
    public LoginResponseDTO login(LoginRequest request) {
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        final UserDetails user = userDetailsService.loadUserByUsername(request.getEmail());
        if (user != null && this.passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            loginResponseDTO.setText(jwtService.generateToken(user));
            loginResponseDTO.setOk(true);
        } else {
            loginResponseDTO.setText("Credenciales invalidas");
            loginResponseDTO.setOk(false);
        }
        return loginResponseDTO;
    }
}
