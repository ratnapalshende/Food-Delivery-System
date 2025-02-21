package com.tns.fooddeliverysystem.entities;

/**
 * Customer class that extends User.
 * Each customer has a one-to-one relationship with a Cart.
 */
public class Customer extends User {
    private Cart cart;

    public Customer(int userId, String username, long contactNo) {
        super(userId, username, contactNo);
        // Initialize the customer's cart
        this.cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId=" + getUserId() +
                ", username='" + getUsername() + '\'' +
                ", contactNo=" + getContactNo() +
                '}';
    }
}
