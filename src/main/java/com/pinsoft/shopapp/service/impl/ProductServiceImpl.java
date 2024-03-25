package com.pinsoft.shopapp.service.impl;

import com.pinsoft.shopapp.entity.Category;
import com.pinsoft.shopapp.entity.Product;
import com.pinsoft.shopapp.repository.CategoryRepository;
import com.pinsoft.shopapp.repository.ProductRepository;
import com.pinsoft.shopapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductByName(String name){
        return productRepository.findByName(name);
    }

    @Override
    public void addProduct(MultipartFile file, String name, double price, String explanation, String categoryName) {
        Product product = new Product();

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains("..")){
            System.out.println(" geçersiz dosya");
        }
        try {
            product.setBase64image(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        product.setName(name);
        product.setPrice(price);
        product.setExplanation(explanation);
        Category category = categoryRepository.findByName(categoryName);
        product.setCategory(category);

        productRepository.save(product);


    }
}

