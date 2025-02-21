
public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();

        FoodItem pizza = new FoodItem("Pizza", 8.99);
        FoodItem burger = new FoodItem("Burger", 5.49);

        cart.addItem(pizza, 2);
        cart.addItem(burger, 1);
        cart.addItem(pizza, 1); // Updating quantity

        System.out.println(cart);

        cart.removeItem(burger);
        System.out.println("After removing burger:");
        System.out.println(cart);
    }
}
