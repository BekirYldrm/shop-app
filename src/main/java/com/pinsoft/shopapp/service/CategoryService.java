package com.pinsoft.shopapp.service;

import com.pinsoft.shopapp.entity.Category;
import com.pinsoft.shopapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class CategoryService {
    private final CategoryRepository repository;


    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAllCategories() {

        return repository.findAll();

    }

    public Category getCategory(String name) {

        var category = repository.findByName(name);

        if (category.isEmpty()) {
            throw new RuntimeException("Category not found with name:" + name);
        } else {
            return category.get();
        }

    }


}
