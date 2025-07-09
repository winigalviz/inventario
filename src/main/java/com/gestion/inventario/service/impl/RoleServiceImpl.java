package com.gestion.inventario.service.impl;

import com.gestion.inventario.exception.RecursoNotFoundException;
import com.gestion.inventario.models.dto.request.RoleRequest;
import com.gestion.inventario.models.entities.RoleEntity;
import com.gestion.inventario.models.repositories.RoleRepository;
import com.gestion.inventario.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private final String MSG_ERROR = "No se encontro rol con el id: ";

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleEntity> getAll() {
        return this.roleRepository.findAll();
    }

    @Override
    public RoleEntity save(RoleRequest request) {
        RoleEntity role = new RoleEntity();
        role.setName(request.getName());
        role.setUsers(request.getUsers());
        return this.roleRepository.save(role);
    }

    @Override
    public RoleEntity update(RoleRequest request, Integer id) {
        Optional<RoleEntity> roleDB = this.roleRepository.findById(id);
        if (roleDB.isPresent()) {
            RoleEntity role = roleDB.get();
            role.setName(request.getName());
            if(!request.getUsers().isEmpty()) {
                role.setUsers(request.getUsers());
            }
            this.roleRepository.save(role);
        }
        throw new RecursoNotFoundException(MSG_ERROR + id);
    }

    @Override
    public void delete(Integer id) {
        Optional<RoleEntity> roleDB = this.roleRepository.findById(id);
        if (roleDB.isPresent()) {
            this.roleRepository.delete(roleDB.get());
            return;
        }
        throw new RecursoNotFoundException(MSG_ERROR + id);
    }
}
