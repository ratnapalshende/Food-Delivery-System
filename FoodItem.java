import java.util.Objects;

public class FoodItem {
    private final String name;  // Made final
    private final double price; // Made final

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {  // Add getter for price
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FoodItem foodItem = (FoodItem) obj;
        return Double.compare(foodItem.price, price) == 0 && Objects.equals(name, foodItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}