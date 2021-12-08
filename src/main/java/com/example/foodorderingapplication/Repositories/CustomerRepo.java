package com.example.foodorderingapplication.Repositories;

import com.example.foodorderingapplication.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    //Customer findCustomerByIdd(Long customerId);
    
    @Query
    Customer findByUsername(String username);

}
