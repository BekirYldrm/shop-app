package com.pinsoft.shopapp.service;

import com.pinsoft.shopapp.entity.Product;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductByName(String name);
    void addProduct(MultipartFile file, String name, double price, String explanation, String categoryName);
}
