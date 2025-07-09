package com.gestion.inventario.service;

import com.gestion.inventario.models.dto.request.ProductSaveRequest;
import com.gestion.inventario.models.entities.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAll();
    ProductEntity save(ProductSaveRequest request);
}
