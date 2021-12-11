package com.example.foodorderingapplication.Controllers;

import java.util.List;

import com.example.foodorderingapplication.Customer;
import com.example.foodorderingapplication.Order;
import com.example.foodorderingapplication.Product;
import com.example.foodorderingapplication.RestaurantManager;
import com.example.foodorderingapplication.Repositories.CustomerRepo;
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


// Rest Controller tästä

@RestController
@RequestMapping("/app")
public class RController {

    @Autowired
    Controller controller;

    @Autowired
    CustomerRepo customerRepo;

    // Customer:
    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return controller.findCustomerById(id);
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
    public RestaurantManager getRestaurantManager(@PathVariable Long id){
        return controller.findManagerById(id);
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
    public ResponseEntity<RestaurantManager> update(@PathVariable Long id, @RequestBody RestaurantManager manager){
        return controller.updateManager(id, manager);
    }
    //----------------------------------------------------------
    // Order:
    @GetMapping("/getOrder")
    public List<Order> OrderList(){
        return controller.findAll();
    }

    @GetMapping("/getOrder/{id}")
    public Order getOrder(@PathVariable Long id){
        return controller.findOrderById(id);
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
    public ResponseEntity<Order> cancel(@PathVariable Long id){
        return controller.cancelOrder(id);
    }
    //----------------------------------------------------------
    // Product:
    @GetMapping("/getProduct")
    public List<Product> ProductList(){
        return controller.listProducts();
    }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable Long id){
        return controller.findProductById(id);
    }

    @PostMapping("/insertProduct")
    public Product insertProduct(@RequestBody Product product){
        return controller.newProduct(product);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        return controller.updateProduct(id, product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        return controller.deleteProduct(id);
    }
    //----------------------------------------------------------
    // Restaurant:
    @GetMapping("/getRestaurant")
    public List<Restaurant> RestaurantList(){
        return controller.listRestaurants();
    }

    @GetMapping("/getRestaurant/{id}")
    public Restaurant getRestaurant(@PathVariable Long id){
        return controller.findRestaurantById(id);
    }

    /*@GetMapping("/getRestaurant/{name}")
    public Restaurant getRestaurantByName(@PathVariable String restaurantName){
        return controller.findRestaurantByName(restaurantName);
    }*/

    @PostMapping("/insertRestaurant")
    public Restaurant insertRestaurant(@RequestBody Restaurant restaurant){
        return controller.insertNewRestaurant(restaurant);
    }

    @PutMapping("/updateRestaurant/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant){
        return controller.updateRestaurant(id, restaurant);
    }

    @DeleteMapping("/deleteRestaurant/{id}")
    public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable Long id){
        return controller.deleteRestaurant(id);
    }
}
