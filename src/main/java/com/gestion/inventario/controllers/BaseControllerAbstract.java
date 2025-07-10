package com.gestion.inventario.controllers;

import com.gestion.inventario.service.CrudService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class BaseControllerAbstract<T, R, ID> {

    protected abstract CrudService<T, R, ID> getService();

    @Operation(summary = "Crear nuevo registro")
    @PostMapping
    public T create(@Valid @RequestBody R request) {
        return getService().save(request);
    }

    @Operation(summary = "Obtener por ID")
    @GetMapping("/{id}")
    public Optional<T> getById(@PathVariable ID id) {
        return getService().findById(id);
    }

    @Operation(summary = "Obtener todos los registros")
    @GetMapping
    public List<T> getAll() {
        return getService().findAll();
    }

    @Operation(summary = "Actualizar registro existente")
    @PutMapping("/{id}")
    public T update(@PathVariable ID id, @Valid @RequestBody R request) {
        return getService().update(id, request);
    }

    @Operation(summary = "Eliminar por ID")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        getService().deleteById(id);
    }
}
