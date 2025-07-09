package com.gestion.inventario.controllers;

import com.gestion.inventario.models.dto.request.RoleRequest;
import com.gestion.inventario.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RolesController {

    @Autowired
    private RoleService roleService;


    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.roleService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody RoleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.roleService.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody RoleRequest request, @PathVariable Integer id) {
        return ResponseEntity.ok(this.roleService.update(request, id));
    }
}
