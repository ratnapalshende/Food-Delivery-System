package com.tns.fooddeliverysystem.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a shopping cart that holds FoodItems along with their quantities.
 * This class models a many-to-many relationship between FoodItem and Cart.
 */
public class Cart {
    private Map<FoodItem, Integer> items;

    // Default constructor initializes the items map.
    public Cart() {
        items = new HashMap<>();
    }

    /**
     * Adds a food item to the cart with the given quantity.
     * If the item already exists, its quantity is increased.
     *
     * @param foodItem the FoodItem to add.
     * @param quantity the quantity of the food item.
     */
    public void addItem(FoodItem foodItem, int quantity) {
        if (items.containsKey(foodItem)) {
            items.put(foodItem, items.get(foodItem) + quantity);
        } else {
            items.put(foodItem, quantity);
        }
    }

    /**
     * Removes a food item from the cart.
     *
     * @param foodItem the FoodItem to remove.
     */
    public void removeItem(FoodItem foodItem) {
        items.remove(foodItem);
    }

    /**
     * Returns the map of food items and their corresponding quantities.
     *
     * @return a map of FoodItem to quantity.
     */
    public Map<FoodItem, Integer> getItems() {
        return items;
    }

    /**
     * Clears all items from the cart.
     */
    public void clear() {
        items.clear();
    }

    /**
     * Returns a string representation of the cart, including each food item,
     * its quantity, and the total cost for that item.
     *
     * @return a formatted string of cart contents.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cart:\n");
        double totalCost = 0;
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            FoodItem item = entry.getKey();
            int quantity = entry.getValue();
            double cost = item.getPrice() * quantity;
            sb.append("Food Item: ").append(item.getName())
              .append(", Quantity: ").append(quantity)
              .append(", Cost: Rs. ").append(cost)
              .append("\n");
            totalCost += cost;
        }
        sb.append("Total Cost: Rs. ").append(totalCost);
        return sb.toString();
    }
}
