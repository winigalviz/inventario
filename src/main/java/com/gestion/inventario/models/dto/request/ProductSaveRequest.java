package com.gestion.inventario.models.dto.request;

import com.gestion.inventario.models.entities.CategoryEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductSaveRequest {

    @NotNull(message = "El name no puede ser nulo")
    @NotBlank(message = "El name no puede ser nulo")
    private String name;

    private String description;

    @NotNull(message = "El stock no puede ser nulo")
    @NotBlank(message = "El stock no puede ser nulo")
    private Integer stock = 0;

    @NotNull(message = "El precio no puede ser nulo")
    @NotBlank(message = "El precio no puede ser nulo")
    private Double price;

    private CategoryEntity category;

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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductSaveRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
