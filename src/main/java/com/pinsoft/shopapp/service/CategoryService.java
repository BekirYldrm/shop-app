package com.pinsoft.shopapp.service;

import com.pinsoft.shopapp.entity.Category;
import com.pinsoft.shopapp.entity.Product;
import com.pinsoft.shopapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {

        return categoryRepository.findAll();

    }

    public Category getCategoryByName(String name){
        return categoryRepository.findByName(name);
    }


}
