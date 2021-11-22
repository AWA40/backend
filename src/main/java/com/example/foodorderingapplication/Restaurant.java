package com.example.foodorderingapplication;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {
    
    @Column(name = "restaurant_name")
    private String restaurantName;
    
    @Column(name = "address")
    private String address;

    @Column(name = "operating_hours")
    private long operatingHours;
    
    @Enumerated(EnumType.STRING)
    private Type type;
    
    @Column(name = "menu")
    private List<Product> menu;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_id")
    private Long restaurantId;

    public Restaurant(String restaurantName, String address, long operatingHours, Type type, Long restaurantId){

        this.restaurantName = restaurantName;
        this.address = address;
        this.operatingHours = operatingHours;
        this.type = type;
        this.restaurantId = restaurantId;

    }

    public Long getRestaurantId()
    {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId)
    {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName()
    {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName)
    {
        this.restaurantName = restaurantName;
    }

    public String Address()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public long getOperatingHours()
    {
        return operatingHours;
    }

    public void setOperatingHours(long operatingHours)
    {
        this.operatingHours = operatingHours;
    }

    public Type getType()
    {
        return type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }
    
    public List<Product> getMenu()
    {
        return menu;
    }

    public void setMenu(List<Product> menu)
    {
        this.menu = menu;
    }
    
}
