package com.example.foodorderingapplication.Repositories;

import com.example.foodorderingapplication.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

    Customer findCustomerById(Long customerId);
    
    Customer findByUsername(String username);

}
