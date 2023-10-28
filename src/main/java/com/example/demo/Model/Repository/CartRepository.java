package com.example.demo.Model.Repository;

import com.example.demo.Model.Entity.Cart;
import com.example.demo.Model.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository  extends JpaRepository<Cart, Long> {
}
