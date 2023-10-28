package com.example.demo.Model.Entity;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDateTime paymentDate;

    // One payment is associated with one order
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Constructors, getters, and setters

    // Additional fields, methods, and annotations as needed
}
