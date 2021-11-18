package com.example.foodorderingapplication.Repositories;


import com.example.foodorderingapplication.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {

    Product findProductById(Long productId);

    
}
