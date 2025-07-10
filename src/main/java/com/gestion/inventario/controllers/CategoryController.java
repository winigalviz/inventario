package com.gestion.inventario.controllers;

import com.gestion.inventario.models.dto.request.CategoryRequest;
import com.gestion.inventario.models.entities.CategoryEntity;
import com.gestion.inventario.service.CategoryService;
import com.gestion.inventario.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController extends BaseControllerAbstract<CategoryEntity, CategoryRequest, Integer>{
    @Autowired
    private CategoryService categoryService;

    @Override
    protected CrudService<CategoryEntity, CategoryRequest, Integer> getService() {
        return categoryService;
    }
}
