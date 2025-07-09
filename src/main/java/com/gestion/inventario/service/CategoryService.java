package com.gestion.inventario.service;

import com.gestion.inventario.models.dto.request.CategorySaveRequest;
import com.gestion.inventario.models.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> getAll();
    CategoryEntity save(CategorySaveRequest request);
}
