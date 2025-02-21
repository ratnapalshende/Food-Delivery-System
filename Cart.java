import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<FoodItem, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public void addItem(FoodItem item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public void removeItem(FoodItem item) {
        items.remove(item);
    }

    // Override toString() for proper printing
    @Override
    public String toString() {
        if (items.isEmpty()) return "Cart is empty.";
        
        StringBuilder cartContents = new StringBuilder("Cart Items:\n");
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            cartContents.append(entry.getKey().getName())  // Assuming FoodItem has getName()
                        .append(" x ")
                        .append(entry.getValue())
                        .append("\n");
        }
        return cartContents.toString();
    }
}
