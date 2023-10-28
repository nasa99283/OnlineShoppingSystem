
package com.example.demo.Model.Repository;


import com.example.demo.Model.Entity.Category;
import com.example.demo.Model.Entity.Product;
import com.example.demo.Model.Repository.CategoryRepository;
import com.example.demo.Model.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testProductCreationAndRetrieval() {
        // Creating a category



        // Creating a product
        Product product = new Product("teshirt","M","red",5.8);
        productRepository.save(product);

        assertNotNull(product.getId()); // Assuming the ID is generated upon save

        // Retrieving products by category ID


        // Retrieving products by color and category ID


    }
}
