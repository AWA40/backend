package com.example.foodorderingapplication.Repositories;

import com.example.foodorderingapplication.RestaurantManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface RestaurantManagerRepo extends JpaRepository<RestaurantManager, Long> {

    //RestaurantManager findManagerById(Long adminId);
    
    @Query
    RestaurantManager findByUsername(String username);
    
}
