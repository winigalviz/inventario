package com.gestion.inventario.service;

import com.gestion.inventario.exception.RecursoNotFoundException;
import com.gestion.inventario.models.dto.request.CategoryRequest;
import com.gestion.inventario.models.entities.CategoryEntity;
import com.gestion.inventario.models.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements CrudService<CategoryEntity, CategoryRequest, Integer>  {

    private final String MSG_ERROR = "No se encontro Category con el id: ";

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity save(CategoryRequest request) {
        CategoryEntity category = new CategoryEntity();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setProducts(request.getProducts());
        return this.categoryRepository.save(category);
    }

    @Override
    public Optional<CategoryEntity> findById(Integer id) {
        return this.categoryRepository.findById(id);
    }

    @Override
    public List<CategoryEntity> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public CategoryEntity update(Integer id, CategoryRequest request) {
        Optional<CategoryEntity> categoryDB = this.categoryRepository.findById(id);
        if (categoryDB.isPresent()) {
            CategoryEntity category = categoryDB.get();
            category.setName(request.getName());
            category.setDescription(request.getDescription());
            category.setProducts(request.getProducts());
            return this.categoryRepository.save(category);
        }
        throw new RecursoNotFoundException(MSG_ERROR + id);
    }

    @Override
    public void deleteById(Integer id) {
        Optional<CategoryEntity> categoryDB = this.categoryRepository.findById(id);
        if (categoryDB.isPresent()) {
            this.categoryRepository.delete(categoryDB.get());
        } else {
            throw new RecursoNotFoundException(MSG_ERROR + id);
        }
    }
}