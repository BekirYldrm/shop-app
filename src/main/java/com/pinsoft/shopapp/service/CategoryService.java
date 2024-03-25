package com.pinsoft.shopapp.service;

import com.pinsoft.shopapp.entity.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryByName(String name);
}
