package com.example.foodorderingapplication;

import java.util.List;

public class Restaurant {

    private String restaurantName, address;
    private long operatingHours;
    private Type type;
    private List<Product> menu;

    public Restaurant(String restaurantName, String address, long operatingHours, Type type){

        this.restaurantName = restaurantName;
        this.address = address;
        this.operatingHours = operatingHours;
        this.type = type;

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
