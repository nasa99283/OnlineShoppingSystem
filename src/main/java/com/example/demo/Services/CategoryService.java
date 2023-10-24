package com.example.demo.Services;
import com.example.demo.Model.Entity.Category;

import java.util.List;
public interface CategoryService {

        List<Category> getAllCategories();

        Category getCategoryById(Long id);

        Category saveCategory(Category category);

        void deleteCategory(Long id);
    }


