package com.gestion.inventario.service;

import java.util.List;
import java.util.Optional;

public interface CrudService <T, R, ID> {
    T save(R request);
    Optional<T> findById(ID id);
    List<T> findAll();
    T update(ID id, R request);
    void deleteById(ID id);
}
