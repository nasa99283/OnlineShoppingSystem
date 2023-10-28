package com.example.demo.Services;
import com.example.demo.Model.Entity.Category;
import com.example.demo.Model.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private  final CategoryRepository categoryRepository;


    @Autowired
    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional <Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }


    @Override
    public Category updateCategory(Long id, Category updatedCategory) {
        Optional<Category> existingCategoryOptional = categoryRepository.findById(id);

        if (existingCategoryOptional.isPresent()) {
            Category existingCategory = existingCategoryOptional.get();

            // Log the existing and updated category for debugging
            System.out.println("Existing Category: " + existingCategory);
            System.out.println("Updated Category: " + updatedCategory);

            // Update fields with non-null values from the updatedCategory
            if (updatedCategory.getName() != null) {
                existingCategory.setName(updatedCategory.getName());
            }

            // Log the updated category for debugging
            System.out.println("Updated Category after modification: " + existingCategory);

            // Save the updated category to the database
            Category savedCategory = categoryRepository.save(existingCategory);

            // Log the saved category for debugging
            System.out.println("Saved Category: " + savedCategory);

            return savedCategory;
        } else {
            // Log that the category with the given id is not found
            System.out.println("Category with ID " + id + " not found");


            return null;
        }
    }



}



