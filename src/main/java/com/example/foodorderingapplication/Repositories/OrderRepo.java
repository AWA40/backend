package com.example.foodorderingapplication.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foodorderingapplication.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    Order findOrderById(Long orderId);
    
}
