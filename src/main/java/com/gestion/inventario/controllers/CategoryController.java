package com.gestion.inventario.controllers;

import com.gestion.inventario.models.dto.request.CategorySaveRequest;
import com.gestion.inventario.models.entities.CategoryEntity;
import com.gestion.inventario.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<CategoryEntity> categories = this.categoryService.getAll();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody CategorySaveRequest request) {
        CategoryEntity category = this.categoryService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }
}
