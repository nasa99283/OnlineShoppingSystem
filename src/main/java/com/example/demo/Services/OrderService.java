package com.example.demo.Services;

import com.example.demo.Model.Entity.Order;

import java.util.List;

public interface OrderService {

    Order saveOrder(Order order);

    Order getOrderById(Long orderId);

    List<Order> getAllOrders();

    void deleteOrder(Long orderId);

    // Additional order-related methods can be added as needed
}
