package com.pinsoft.shopapp.service;

import com.pinsoft.shopapp.entity.Product;
import com.pinsoft.shopapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {this.repository = repository;}

    public List<Product> getAllProducts() {

        return repository.findAll();

    }

    public Product getProduct(String name) {

        var category = repository.findByName(name);

        if (category.isEmpty()) {
            throw new RuntimeException("Product not found with name:" + name);
        } else {
            return category.get();
        }

    }
}
