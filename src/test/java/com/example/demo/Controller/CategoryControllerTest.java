package com.example.demo.Controller;

import com.example.demo.Model.Entity.Category;
import com.example.demo.Services.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void testUpdateCategoryEndpoint() throws Exception {
        // Mock data
        Long categoryId = 1L;
        Category existingCategory = new Category(categoryId, "InitialCategory");
        Category updatedCategory = new Category(categoryId, "UpdatedCategory");

        // Mock the service method
        Mockito.when(categoryService.getCategoryById(categoryId)).thenReturn(Optional.of(existingCategory));
        Mockito.when(categoryService.updateCategory(categoryId, updatedCategory)).thenReturn(updatedCategory);

        // Perform the PUT request
        mockMvc.perform(put("/api/categories/{id}", categoryId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedCategory)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(categoryId))
                .andExpect(jsonPath("$.name").value("UpdatedCategory"));
    }
}
