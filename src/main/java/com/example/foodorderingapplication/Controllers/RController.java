package com.example.foodorderingapplication.Controllers;

import java.util.List;

import com.example.foodorderingapplication.Customer;
import com.example.foodorderingapplication.Order;
import com.example.foodorderingapplication.Product;
import com.example.foodorderingapplication.RestaurantManager;
import com.example.foodorderingapplication.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/app")
public class RController {

    @Autowired
    Controller controller;

    // Customer:
    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable Long customerId){
        return controller.findCustomerById(customerId);
    }
    
    /*@GetMapping("/Customer")
    public ResponseEntity<String> setCustomer(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok("Log in as customer" +username);
    }*/

    @PostMapping("/insertCustomer")
    public Customer insert(@RequestBody Customer customer){
        return controller.addCustomer(customer);
    }

    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long customerId, @RequestBody Customer customer){
        return controller.updateCustomer(customerId, customer);
    }
    //----------------------------------------------------------
    // RestaurantManager:
    @GetMapping("/getRestaurantManager/{id}")
    public RestaurantManager getRestaurantManager(@PathVariable Long adminId){
        return controller.findManagerById(adminId);
    }
    
    /*@GetMapping("/admin")
    public ResponseEntity<String> setAdmin(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok("Logged in as Admin" +username);
    }*/

    @PostMapping("/insertRestaurantManager")
    public RestaurantManager insert(@RequestBody RestaurantManager manager){
        return controller.addManager(manager);
    }

    @PutMapping("/updateManager/{id}")
    public ResponseEntity<RestaurantManager> update(@PathVariable Long adminId, @RequestBody RestaurantManager manager){
        return controller.updateManager(adminId, manager);
    }
    //----------------------------------------------------------
    // Order:
    @GetMapping("/getOrder")
    public List<Order> OrderList(){
        return controller.findAll();
    }

    @GetMapping("/getOrder/{id}")
    public Order getOrder(@PathVariable Long orderId){
        return controller.findOrderById(orderId);
    }

    @PostMapping("/insertOrder")
    public Order insert(@RequestBody Order order){
        return controller.addOrder(order);
    }

    /*@PutMapping("/updateOrder/{id}")
    public ResponseEntity<Order> update(@PathVariable Long orderId, @RequestBody Order order){
        return controller.updateOrder(orderId, order);
    }*/

    @PutMapping("/cancelOrder/{id}")
    public ResponseEntity<Order> cancel(@PathVariable Long orderId){
        return controller.cancelOrder(orderId);
    }
    //----------------------------------------------------------
    // Product:
    @GetMapping("/getProduct")
    public List<Product> ProductList(){
        return controller.listProducts();
    }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable Long productId){
        return controller.findProductById(productId);
    }

    @PostMapping("/insertProduct")
    public Product insertProduct(@RequestBody Product product){
        return controller.newProduct(product);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product product){
        return controller.updateProduct(productId, product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long productId){
        return controller.deleteProduct(productId);
    }
    //----------------------------------------------------------
    // Restaurant:
    @GetMapping("/getRestaurant")
    public List<Restaurant> RestaurantList(){
        return controller.listRestaurants();
    }

    @GetMapping("/getRestaurant/{id}")
    public Restaurant getRestaurant(@PathVariable Long restaurantId){
        return controller.findRestaurantById(restaurantId);
    }

    @GetMapping("/getRestaurant/{name}")
    public Restaurant getRestaurant(@PathVariable String restaurantName){
        return controller.findRestaurantByName(restaurantName);
    }

    @PostMapping("/insertRestaurant")
    public Restaurant insertRestaurant(@RequestBody Restaurant restaurant){
        return controller.insertNewRestaurant(restaurant);
    }

    @PutMapping("/updateRestaurant/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long restaurantId, @RequestBody Restaurant restaurant){
        return controller.updateRestaurant(restaurantId, restaurant);
    }

    @DeleteMapping("/deleteRestaurant/{id}")
    public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable Long restaurantId){
        return controller.deleteRestaurant(restaurantId);
    }
}
