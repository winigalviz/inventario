package com.gestion.inventario.service.impl;

import com.gestion.inventario.models.dto.request.CategorySaveRequest;
import com.gestion.inventario.models.entities.CategoryEntity;
import com.gestion.inventario.models.repositories.CategoryRepository;
import com.gestion.inventario.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public CategoryEntity save(CategorySaveRequest request) {
        CategoryEntity category = new CategoryEntity();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setProducts(request.getProducts());
        return this.categoryRepository.save(category);
    }
}
