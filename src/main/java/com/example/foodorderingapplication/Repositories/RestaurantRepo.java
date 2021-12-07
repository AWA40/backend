package com.example.foodorderingapplication.Repositories;

import com.example.foodorderingapplication.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {

    /*Restaurant findRestaurantById(Long restaurantId);

    Restaurant findRestaurantByName(String restaurantName);*/

}
