package com.gestion.inventario.controllers;

import com.gestion.inventario.service.CrudService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class BaseControllerAbstract<T, R, ID> {

    protected abstract CrudService<T, R, ID> getService();

    @PostMapping
    public T create(@RequestBody R request) {
        return getService().save(request);
    }

    @GetMapping("/{id}")
    public Optional<T> getById(@PathVariable ID id) {
        return getService().findById(id);
    }

    @GetMapping
    public List<T> getAll() {
        return getService().findAll();
    }

    @PutMapping("/{id}")
    public T update(@PathVariable ID id, @RequestBody R request) {
        return getService().update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        getService().deleteById(id);
    }
}
