package com.codegym.service;

import com.codegym.entity.Product;
import com.codegym.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{

    @Autowired
    ProductRepo productRepo;
    @Override
    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public Product save(Product product) {
        Product newProduct = productRepo.save(product);
        return newProduct;
    }

    @Override
    public void remove(Long id) {

    }
}
