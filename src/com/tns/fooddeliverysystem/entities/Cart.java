import java.util.*;

class FoodItem {
    private String name;
    private int price;

    public FoodItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (Rs." + price + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FoodItem foodItem = (FoodItem) obj;
        return Objects.equals(name, foodItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

public class Cart {
    private Map<FoodItem, Integer> items;

    public Cart() {
        items = new HashMap<>();
    }

    public void addItem(FoodItem foodItem, int quantity) {
        items.put(foodItem, items.getOrDefault(foodItem, 0) + quantity);
    }

    public void removeItem(FoodItem foodItem) {
        items.remove(foodItem);
    }

    public Map<FoodItem, Integer> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder cartDetails = new StringBuilder("Cart contains:\n");
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            cartDetails.append(entry.getKey()).append(" - Quantity: ").append(entry.getValue()).append("\n");
        }
        return cartDetails.toString();
    }

    // Main method to test the Cart class independently
    public static void main(String[] args) {
        Cart cart = new Cart();
        FoodItem burger = new FoodItem("Burger", 100);
        FoodItem pizza = new FoodItem("Pizza", 250);

        // Adding items
        cart.addItem(burger, 2);
        cart.addItem(pizza, 1);
        System.out.println(cart);

        // Removing an item
        cart.removeItem(burger);
        System.out.println("After removing Burger:\n" + cart);
    }
}
