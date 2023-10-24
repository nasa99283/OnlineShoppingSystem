package com.example.demo.Services;
import com.example.demo.Model.Entity.Category;
import com.example.demo.Model.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public class CategoryServiceImp {




    @Service
    public class CategoryServiceImpl implements CategoryService {

        @Autowired
        private CategoryRepository categoryRepository;

        @Override
        public List<Category> getAllCategories() {
            return categoryRepository.findAll();
        }

        @Override
        public Category getCategoryById(Long id) {
            return categoryRepository.findById(id).orElse(null);
        }

        @Override
        public Category saveCategory(Category category) {
            return categoryRepository.save(category);
        }

        @Override
        public void deleteCategory(Long id) {
            categoryRepository.deleteById(id);
        }
    }


}
