package com.example.demo.Model.Entity;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // One cart is associated with one user
    @OneToOne
    @JoinColumn(name = "user_id")
    private user user;

    // One cart can contain multiple products
    @ManyToMany
    @JoinTable(
            name = "cart_products",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    // Constructors, getters, and setters

    // Additional fields, methods, and annotations as needed
}
