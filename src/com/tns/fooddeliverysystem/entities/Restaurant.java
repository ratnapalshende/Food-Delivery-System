package com.tns.fooddeliverysystem.entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    // Fields
    private int id;
    private String name;
    private List<FoodItem> menu; // List of FoodItems offered by the restaurant

    // Constructor
    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
        this.menu = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<FoodItem> getMenu() {
        return menu;
    }

    // Method to add a FoodItem to the menu
    public void addFoodItem(FoodItem foodItem) {
        menu.add(foodItem);
    }

    // Method to remove a FoodItem by its ID
    public void removeFoodItem(int foodItemId) {
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getId() == foodItemId) {
                menu.remove(i);
                break;
            }
        }
    }

    // toString() method
    @Override
    public String toString() {
        return "Restaurant [id=" + id + ", name=" + name + ", menu=" + menu + "]";
    }
}
