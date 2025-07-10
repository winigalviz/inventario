package com.gestion.inventario.controllers;

import com.gestion.inventario.models.dto.request.ProductSaveRequest;
import com.gestion.inventario.models.entities.ProductEntity;
import com.gestion.inventario.service.CrudService;
import com.gestion.inventario.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseControllerAbstract<ProductEntity, ProductSaveRequest, Integer> {

    @Autowired
    private ProductService productService;

    @Override
    protected CrudService<ProductEntity, ProductSaveRequest, Integer> getService() {
        return productService;
    }
}
