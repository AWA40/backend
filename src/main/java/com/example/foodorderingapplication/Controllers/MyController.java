package com.example.foodorderingapplication.Controllers;

import java.util.*;

import com.example.foodorderingapplication.Customer;
import com.example.foodorderingapplication.Order;
import com.example.foodorderingapplication.OrderStatus;
import com.example.foodorderingapplication.Product;
import com.example.foodorderingapplication.Restaurant;
import com.example.foodorderingapplication.RestaurantManager;
import com.example.foodorderingapplication.Repositories.CustomerRepo;
import com.example.foodorderingapplication.Repositories.OrderRepo;
import com.example.foodorderingapplication.Repositories.ProductRepo;
import com.example.foodorderingapplication.Repositories.RestaurantManagerRepo;
import com.example.foodorderingapplication.Repositories.RestaurantRepo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Toiminnot controllerin rajapinnoille

@Service
public class MyController implements Controller {

    MyController myController;

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    RestaurantManagerRepo adminRepo;
    @Autowired
    RestaurantRepo restaurantRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    OrderRepo orderRepo;

    //-------------------------------------------------------
    // These are for the Customer model:

    @Override
    public Customer findCustomerById(Long customerId) {
        return myController.findCustomerById(customerId);
    }

    @Override
    public Customer addCustomer(Customer customer){
        return customerRepo.save(customer);
    }
    
    /*@Override
    public Customer loadCustomerByUsername(String username) throws UsernameNotFoundException {
        
        Customer customerDb = customerRepo.findByUsername(username);

        if(customerDb == null){
            throw new UsernameNotFoundException("Not in database");
        } else {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority((customerDb.getRole().toString())));
            return new Customer(username, customerDb.getPassword(), authorities);
        }
    }*/

    @Override
    public ResponseEntity<Customer> updateCustomer(Long customerId, Customer customer) {

        Customer customerDb = myController.findCustomerById(customerId);

        if(customerDb == null){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(customer, customerDb, "customerId");
        customerDb = customerRepo.save(customerDb);
        return ResponseEntity.ok(customerDb);
    }
    //-----------------------------------------------------------
    //These are for the RestaurantManager model:
    @Override
    public RestaurantManager findManagerById(Long adminId) {
        return myController.findManagerById(adminId);
    }

    @Override
    public RestaurantManager addManager(RestaurantManager manager){
        return adminRepo.save(manager);
    }
    
    /*@Override
    public RestaurantManager loadManagerByUsername(String username) throws UsernameNotFoundException {

        RestaurantManager managerDb = adminRepo.findByUsername(username);

        if(managerDb == null){
            throw new UsernameNotFoundException("Not in database");
        } else {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority((managerDb.getRole().toString())));
            return new RestaurantManager(username, managerDb.getPassword(), authorities);
        }
    }*/

    @Override
    public ResponseEntity<RestaurantManager> updateManager(Long adminId, RestaurantManager restaurantManager) {
        
        RestaurantManager managerDb = myController.findManagerById(adminId);

        if(managerDb == null){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(restaurantManager, managerDb, "adminId");
        managerDb = adminRepo.save(managerDb);
        return ResponseEntity.ok(managerDb);
    }
    //-----------------------------------------------------------
    //These are for the Order model:
    @Override
    public List<Order> findAll() {
        return myController.findAll();
    }


    @Override
    public Order findOrderById(Long orderId) {
        return myController.findOrderById(orderId);
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepo.save(order);
    }

    /*@Override
    public ResponseEntity<Order> updateOrder(Long orderId, Order order) {

        Order orderDb = orderRepo.findOrderById(orderId);

        // Use switch case to determine the status of the order

        switch(orderDb.getOrderStatus()){
            case RECEIVED:
            orderDb.setOrderStatus(OrderStatus.PREPARING);
            orderDb = orderRepo.save(orderDb);
            return ResponseEntity.ok(orderDb);
            case PREPARING:
            orderDb.setOrderStatus(OrderStatus.READYFORDELIVERY);
            orderDb = orderRepo.save(orderDb);
            return ResponseEntity.ok(orderDb);
            case DELIVERING:
            orderDb.setOrderStatus(OrderStatus.DELIVERED);
            orderDb = orderRepo.save(orderDb);
            return ResponseEntity.ok(orderDb);
            case DELIVERED:
            orderDb.setOrderStatus(OrderStatus.DELIVERED);
            orderDb = orderRepo.save(orderDb);
            return ResponseEntity.ok(orderDb);
            default:
            return ResponseEntity.notFound().build();
        }
    }*/

    @Override
    public ResponseEntity<Order> cancelOrder(Long orderId) {

        Order orderDb = myController.findOrderById(orderId);

        if(orderDb == null){
            return ResponseEntity.notFound().build();
        }
        //orderDb.setOrderStatus(OrderStatus.CANCELED);
        orderDb = orderRepo.save(orderDb);
        return ResponseEntity.ok(orderDb);
    }
    //-----------------------------------------------------------
    // These are for the Product model:

    @Override
    public List<Product> listProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product findProductById(Long productId) {
        return myController.findProductById(productId);
    }

    @Override
    public Product newProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public ResponseEntity<Product> updateProduct(Long productId, Product product) {
       
        Product productDb = myController.findProductById(productId);

        if(productDb == null){
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(product, productDb, "productId");
        productDb = productRepo.save(productDb);
        return ResponseEntity.ok(productDb);
    }

    @Override
    public ResponseEntity<Product> deleteProduct(Long productId) {
       
        Product product = myController.findProductById(productId);
        
        if(product == null){
            return ResponseEntity.notFound().build();
        }

        productRepo.delete(product);
        return ResponseEntity.noContent().build();
    }
    //-----------------------------------------------------------
    //These are for the Restaurant model:
    @Override
    public List<Restaurant> listRestaurants() {
        return restaurantRepo.findAll();
    }

    @Override
    public Restaurant findRestaurantById(Long restaurantId) {
       return myController.findRestaurantById(restaurantId);
    }

    @Override
    public Restaurant findRestaurantByName(String restaurantName){
        return myController.findRestaurantByName(restaurantName);
    }
    
    @Override
    public Restaurant insertNewRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    @Override
    public ResponseEntity<Restaurant> updateRestaurant(Long restaurantId, Restaurant restaurant) {
        
        Restaurant restaurantDb = myController.findRestaurantById(restaurantId);

        if(restaurantDb == null){
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(restaurant, restaurantDb, "restaurantId");
        restaurantDb = restaurantRepo.save(restaurantDb);
        return ResponseEntity.ok(restaurantDb);
    }

    @Override
    public ResponseEntity<Restaurant> deleteRestaurant(Long restaurantId) {

        Restaurant restaurant = myController.findRestaurantById(restaurantId);

        if(restaurant == null){
            return ResponseEntity.notFound().build();
        }

        restaurantRepo.delete(restaurant);
        return ResponseEntity.noContent().build();
    }
}
