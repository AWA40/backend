package com.example.foodorderingapplication;

public class Order {

    private OrderStatus OrderStatus;
    private long finalCost;

    private Order(OrderStatus OrderStatus, long finalCost) {

        this.OrderStatus = OrderStatus;
        this.finalCost = finalCost;

    }

    public OrderStatus getOrderStatus()
    {
        return OrderStatus;
    }
    
    public void setOrderStatus(OrderStatus OrderStatus)
    {
        this.OrderStatus = OrderStatus;
    }

    public long getFinalCost()
    {
        return finalCost;
    }

    public void setFinalCost(long finalCost)
    {
        this.finalCost = finalCost;
    }
    
}
