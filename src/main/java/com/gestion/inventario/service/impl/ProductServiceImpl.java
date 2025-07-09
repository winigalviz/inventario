package com.gestion.inventario.service.impl;

import com.gestion.inventario.models.dto.request.ProductSaveRequest;
import com.gestion.inventario.models.entities.ProductEntity;
import com.gestion.inventario.models.repositories.ProductRepository;
import com.gestion.inventario.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductEntity> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public ProductEntity save(ProductSaveRequest request) {
        ProductEntity product = new ProductEntity();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setStock(request.getStock());
        product.setPrice(request.getPrice());
        product.setCategory(request.getCategory());
        return this.productRepository.save(product);
    }

}
