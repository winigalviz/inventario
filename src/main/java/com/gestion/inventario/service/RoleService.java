package com.gestion.inventario.service;

import com.gestion.inventario.models.dto.request.RoleRequest;
import com.gestion.inventario.models.entities.RoleEntity;

import java.util.List;

public interface RoleService {
    List<RoleEntity> getAll();
    RoleEntity save(RoleRequest request);
    RoleEntity update(RoleRequest request, Integer id);
    void delete(Integer id);
}
