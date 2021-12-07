package com.example.foodorderingapplication.Controllers;

import java.util.List;

import com.example.foodorderingapplication.Customer;
import com.example.foodorderingapplication.Order;
import com.example.foodorderingapplication.Product;
import com.example.foodorderingapplication.Restaurant;
import com.example.foodorderingapplication.RestaurantManager;

import org.springframework.http.ResponseEntity;

// MyControllerin rajapinnat tähän, ei mitään kummallisempaa

public interface Controller {

    // Käsittelee Customer puolen toiminnot, nämä riittänee toistaiseksi:
    //public Customer findCustomerById(Long customerId);
    public Customer addCustomer(Customer customer);
    //public Customer loadCustomerByUsername(String username);
    //public ResponseEntity<Customer> updateCustomer(Long customerId, Customer customer);
    
    // Käsittelee Admin puolen toiminnot, nämä kai riittää:
    public RestaurantManager findManagerById(Long adminId);
    public RestaurantManager addManager(RestaurantManager manager);
    //public RestaurantManager loadManagerByUsername(String username);
    public ResponseEntity<RestaurantManager> updateManager(Long adminId, RestaurantManager restaurantManager);

    // Käsittelee Order puolen toiminnot:
    public List<Order> listOrders();
    public Order findOrderById(Long orderId);
    public Order addOrder(Order order);
    //public ResponseEntity<Order> updateOrder(Long orderId, Order order);
    public ResponseEntity<Order> cancelOrder(Long id);

    // Käsittelee Product puolen toiminnot:
    public List<Product> listProducts();
    public Product findProductById(Long productId);
    public Product newProduct(Product product);
    public ResponseEntity<Product> updateProduct(Long productId, Product product);
    public ResponseEntity<Product> deleteProduct(Long productId);
    // Lisää vielä toiminto, jossa tuote lisätään ravintolaan

    // Käsittelee Restaurant puolen toiminnot:
    public List<Restaurant> listRestaurants();
    public Restaurant findRestaurantById(Long restaurantId);
    public Restaurant findRestaurantByName(String restaurantName);
    public Restaurant insertNewRestaurant(Restaurant restaurant);
    public ResponseEntity<Restaurant> updateRestaurant(Long restaurantId, Restaurant restaurant);
    public ResponseEntity<Restaurant> deleteRestaurant(Long restaurantId);
    
}
