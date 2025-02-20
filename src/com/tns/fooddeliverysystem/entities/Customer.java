package com.tns.fooddeliverysystem.entities;

public class Customer extends User {
    private Cart cart; 

    public Customer(int userId, String username, long contactNo, Cart cart) {
        super(userId, username, contactNo);
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cart=" + (cart != null ? "Available" : "Not Assigned");
    }
}
