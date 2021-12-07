package com.example.foodorderingapplication.Repositories;

import com.example.foodorderingapplication.RestaurantManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantManagerRepo extends JpaRepository<RestaurantManager, Long> {

    //RestaurantManager findManagerById(Long adminId);
    
    RestaurantManager findByUsername(String username);
    
}
