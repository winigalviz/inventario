package com.gestion.inventario.controllers;

import com.gestion.inventario.models.dto.request.RoleRequest;
import com.gestion.inventario.models.entities.RoleEntity;
import com.gestion.inventario.service.CrudService;
import com.gestion.inventario.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RolesController extends BaseControllerAbstract<RoleEntity, RoleRequest, Integer> {

    @Autowired
    private RoleService roleService;

    @Override
    protected CrudService<RoleEntity, RoleRequest, Integer> getService() {
        return roleService;
    }
}
