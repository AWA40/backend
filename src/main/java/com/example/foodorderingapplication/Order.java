package com.example.foodorderingapplication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
     
    @Column(name = "order_status")
    private OrderStatus OrderStatus;

    @Column(name = "final_cost")
    private long finalCost;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;

    private Order(OrderStatus OrderStatus, long finalCost, Long orderId) {

        this.OrderStatus = OrderStatus;
        this.finalCost = finalCost;
        this.orderId = orderId;

    }

    public Long getOrderId()
    {
        return orderId;
    }

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
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
