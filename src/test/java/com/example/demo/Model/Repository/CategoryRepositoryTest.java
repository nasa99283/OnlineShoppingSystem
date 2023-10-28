
package com.example.demo.Model.Repository;

import com.example.demo.Model.Entity.Category;
import com.example.demo.Model.Repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testSaveCategory() {
        // Create a new category
        Category category = new Category();
        category.setName("Test Category");

        // Save the category to the repository
        categoryRepository.save(category);

        // Fetch the category from the repository
        Category savedCategory = categoryRepository.findByName("Test Category");

        // Assert that the saved category is not null
        assertNotNull(savedCategory);

        // Assert that the name of the saved category is correct
        assertEquals("Test Category", savedCategory.getName());
    }

    // Add more test methods as needed for other repository methods

}
