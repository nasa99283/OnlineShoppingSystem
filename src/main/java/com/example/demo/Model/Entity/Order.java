package com.example.demo.Model.Entity;
import jakarta.persistence.*;
import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Each order item corresponds to a specific product
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    // Constructors, getters, and setters

    // Additional fields, methods, and annotations as needed
}
