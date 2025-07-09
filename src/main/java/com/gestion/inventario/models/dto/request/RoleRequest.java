package com.gestion.inventario.models.dto.request;

import com.gestion.inventario.models.entities.UserEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

public class RoleRequest {

    @NotNull(message = "El name no puede ser nulo")
    @NotBlank(message = "El name no puede estar vacio")
    private String name;

    private Set<UserEntity> users = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "RoleSaveRequest{" +
                "name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
