package com.gestion.inventario.models.dto.request;

import com.gestion.inventario.models.entities.ProductEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CategoryRequest {

    @NotBlank(message = "El name no puede ser vacio")
    @NotNull(message = "El name no puede ser nulo")
    private String name;

    @NotBlank(message = "La description no puede ser vacio")
    @NotNull(message = "La description no puede ser nulo")
    private String description;

    private List<ProductEntity> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CategorySaveRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", products=" + products +
                '}';
    }
}
