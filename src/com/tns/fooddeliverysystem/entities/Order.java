package com.tns.fooddeliverysystem.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents an Order in the Food Delivery System.
 * Each Order has a unique ID, associated Customer, a collection of FoodItems with quantities,
 * a status (default "Pending"), an optional DeliveryPerson, and a delivery address.
 */
public class Order {
    // Fields
    private int orderId;
    private Customer customer;
    private Map<FoodItem, Integer> items;
    private String status;
    private DeliveryPerson deliveryPerson;
    private String deliveryAddress;

    /**
     * Constructor that initializes the order with a unique orderId and the associated customer.
     * It also initializes the items map and sets the default status to "Pending".
     * items    the initial map of FoodItems to their quantities (can be empty)
     */
    public Order(int orderId, Customer customer, Map<FoodItem, Integer> items) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = (items != null) ? items : new HashMap<>();
        this.status = "Pending";
        this.deliveryPerson = null; // Not assigned initially
        this.deliveryAddress = "";
    }

    // Getters and Setters

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<FoodItem, Integer> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * Adds a FoodItem to the order with the specified quantity.
     * If the FoodItem already exists, its quantity is incremented.
     *
     * @param foodItem the FoodItem to add
     * @param quantity the quantity to add
     */
    public void addItem(FoodItem foodItem, int quantity) {
        if (items.containsKey(foodItem)) {
            items.put(foodItem, items.get(foodItem) + quantity);
        } else {
            items.put(foodItem, quantity);
        }
    }

    /**
     * Returns a string representation of the Order.
     * If the delivery person is not assigned, it displays "Not Assigned".
     *
     * @return a formatted string showing order details
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{orderId=").append(orderId)
          .append(", customer=").append(customer.getUsername())
          .append(", items=").append(items)
          .append(", status='").append(status).append("'");
        if (deliveryPerson != null) {
            sb.append(", deliveryPerson=").append(deliveryPerson.getName());
        } else {
            sb.append(", deliveryPerson=Not Assigned");
        }
        sb.append("}");
        return sb.toString();
    }
}
