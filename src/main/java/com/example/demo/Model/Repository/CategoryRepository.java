package com.example.demo.Model.Repository;



import com.example.demo.Model.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
