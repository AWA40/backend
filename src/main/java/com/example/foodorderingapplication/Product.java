package com.example.foodorderingapplication;

public class Product {

    private String productName, productDescription;
    private double price;

    public Product(String productName, String productDescription, double price){

        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;

    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getProductDescription()
    {
        return productDescription;
    }

    public void setProductDescription(String productDescription)
    {
        this.productDescription = productDescription;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
    
}
