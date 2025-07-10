package com.gestion.inventario.service;

import com.gestion.inventario.exception.RecursoNotFoundException;
import com.gestion.inventario.models.dto.request.ProductSaveRequest;
import com.gestion.inventario.models.entities.ProductEntity;
import com.gestion.inventario.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements CrudService<ProductEntity, ProductSaveRequest, Integer> {

    private final String MSG_ERROR = "No se encontro Product con el id: ";

    @Autowired
    private ProductRepository productRepository;

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

    @Override
    public Optional<ProductEntity> findById(Integer id) {
        return this.productRepository.findById(id);
    }

    @Override
    public List<ProductEntity> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public ProductEntity update(Integer id, ProductSaveRequest request) {
        Optional<ProductEntity> productDB = this.productRepository.findById(id);
        if (productDB.isPresent()) {
            ProductEntity product = productDB.get();
            product.setName(request.getName());
            product.setStock(request.getStock());
            product.setPrice(request.getPrice());
            product.setDescription(request.getDescription());
            product.setCategory(request.getCategory());
        }
        throw new RecursoNotFoundException(MSG_ERROR + id);
    }

    @Override
    public void deleteById(Integer id) {
        Optional<ProductEntity> productDB = this.productRepository.findById(id);
        if (productDB.isPresent()) {
            this.productRepository.delete(productDB.get());
        } else {
            throw new RecursoNotFoundException(MSG_ERROR + id);
        }
    }
}
