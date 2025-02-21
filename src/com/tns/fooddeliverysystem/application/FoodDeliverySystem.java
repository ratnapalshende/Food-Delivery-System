package com.tns.fooddeliverysystem.application;

import java.util.*;
import com.tns.fooddeliverysystem.entities.*;


public class FoodDeliverySystem {

    // Static collections to store data
    static Scanner scanner = new Scanner(System.in);
    static List<Restaurant> restaurants = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();
    static List<DeliveryPerson> deliveryPersons = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    static int orderCounter = 1; // For assigning order IDs

    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String RED = "\u001B[31m";

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n" + BLUE + "Food Delivery System Main Menu:" + RESET);
            System.out.println(YELLOW + "1. Customer Module");
            System.out.println("2. Restaurant Module");
            System.out.println("3. Delivery Person Module");
            System.out.println("4. Exit" + RESET);
            System.out.print(CYAN + "Choose an option: " + RESET);
            
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    customerMenu();
                    break;
                case 2:
                    restaurantMenu();
                    break;
                case 3:
                    deliveryPersonMenu();
                    break;
                case 4:
                    System.out.println(GREEN + "Thank you for using Food Delivery System!" + RESET);
                    return;
                default:
                    System.out.println(RED + "Invalid option. Try again." + RESET);
            }
        }
    }

    // -------------------- Admin Module --------------------
    static void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Food Item to Restaurant");
            System.out.println("3. Remove Food Item from Restaurant");
            System.out.println("4. View Restaurants and Menus");
            System.out.println("5. View Orders");
            System.out.println("6. Add Delivery Person");
            System.out.println("7. Assign Delivery Person to Order");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    addRestaurant();
                    break;
                case 2:
                    addFoodItemToRestaurant();
                    break;
                case 3:
                    removeFoodItemFromRestaurant();
                    break;
                case 4:
                    viewRestaurantsAndMenus();
                    break;
                case 5:
                    viewAllOrders();
                    break;
                case 6:
                    addDeliveryPerson();
                    break;
                case 7:
                    assignDeliveryPersonToOrder();
                    break;
                case 8:
                    System.out.println("Exiting Admin Module");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void addRestaurant() {
        System.out.print("Enter Restaurant ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Restaurant Name: ");
        String name = scanner.nextLine();
        Restaurant restaurant = new Restaurant(id, name);
        restaurants.add(restaurant);
        System.out.println("Restaurant added successfully!");
    }

    static void addFoodItemToRestaurant() {
        System.out.print("Enter Restaurant ID: ");
        int restId = Integer.parseInt(scanner.nextLine());
        Restaurant restaurant = findRestaurantById(restId);
        if (restaurant == null) {
            System.out.println("Restaurant not found!");
            return;
        }
        System.out.print("Enter Food Item ID: ");
        int foodId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Food Item Name: ");
        String foodName = scanner.nextLine();
        System.out.print("Enter Food Item Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        FoodItem foodItem = new FoodItem(foodId, foodName, price);
        restaurant.addFoodItem(foodItem);
        System.out.println("Food item added successfully!");
    }

    static void removeFoodItemFromRestaurant() {
        System.out.print("Enter Restaurant ID: ");
        int restId = Integer.parseInt(scanner.nextLine());
        Restaurant restaurant = findRestaurantById(restId);
        if (restaurant == null) {
            System.out.println("Restaurant not found!");
            return;
        }
        System.out.print("Enter Food Item ID: ");
        int foodId = Integer.parseInt(scanner.nextLine());
        restaurant.removeFoodItem(foodId);
        System.out.println("Food item removed successfully!");
    }

    static void viewRestaurantsAndMenus() {
        System.out.println("Restaurants and Menus:");
        for (Restaurant r : restaurants) {
            System.out.println("Restaurant ID: " + r.getId() + ", Name: " + r.getName());
            List<FoodItem> menu = r.getMenu();
            for (FoodItem f : menu) {
                System.out.println("- Food Item ID: " + f.getId() + ", Name: " + f.getName() + ", Price: Rs. " + f.getPrice());
            }
        }
    }

    static void viewAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders placed yet!");
            return;
        }
        System.out.println("Orders:");
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    static void addDeliveryPerson() {
        System.out.print("Enter Delivery Person ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Delivery Person Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact No.: ");
        long contact = Long.parseLong(scanner.nextLine());
        DeliveryPerson dp = new DeliveryPerson(id, name, contact);
        deliveryPersons.add(dp);
        System.out.println("Delivery person added successfully!");
    }

    static void assignDeliveryPersonToOrder() {
        System.out.print("Enter Order ID: ");
        int orderId = Integer.parseInt(scanner.nextLine());
        Order order = findOrderById(orderId);
        if (order == null) {
            System.out.println("Order not found!");
            return;
        }
        System.out.print("Enter Delivery Person ID: ");
        int dpId = Integer.parseInt(scanner.nextLine());
        DeliveryPerson dp = findDeliveryPersonById(dpId);
        if (dp == null) {
            System.out.println("Delivery Person not found!");
            return;
        }
        order.setDeliveryPerson(dp);
        System.out.println("Delivery person assigned to order successfully!");
    }

    // -------------------- Customer Module --------------------
    static void customerMenu() {
        while (true) {
            System.out.println("\n" + BLUE + "Customer Menu:" + RESET);
            System.out.println(YELLOW + "1. Add Customer");
            System.out.println("2. View Food Items");
            System.out.println("3. Add Food to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("7. Exit" + RESET);
            System.out.print(CYAN + "Choose an option: " + RESET);
            
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    viewRestaurantsAndMenus();
                    break;
                case 3:
                    addFoodToCart();
                    break;
                case 4:
                    viewCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 6:
                    viewCustomerOrders();
                    break;
                case 7:
                    System.out.println(GREEN + "Exiting Customer Module" + RESET);
                    return;
                default:
                    System.out.println(RED + "Invalid option. Try again." + RESET);
            }
        }
    }

    static void addCustomer() {
        System.out.println("\n" + PURPLE + "Adding New Customer" + RESET);
        System.out.print(CYAN + "Enter User ID: " + RESET);
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print(CYAN + "Enter Username: " + RESET);
        String username = scanner.nextLine();
        System.out.print(CYAN + "Enter Contact No.: " + RESET);
        long contact = Long.parseLong(scanner.nextLine());
        
        Customer customer = new Customer(id, username, contact);
        customers.add(customer);
        System.out.println(GREEN + "Customer created successfully!" + RESET);
    }

    static void addFoodToCart() {
        System.out.print("Enter Customer ID: ");
        int custId = Integer.parseInt(scanner.nextLine());
        Customer customer = findCustomerById(custId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        System.out.print("Enter Restaurant ID: ");
        int restId = Integer.parseInt(scanner.nextLine());
        Restaurant restaurant = findRestaurantById(restId);
        if (restaurant == null) {
            System.out.println("Restaurant not found!");
            return;
        }
        System.out.print("Enter Food Item ID: ");
        int foodId = Integer.parseInt(scanner.nextLine());
        FoodItem foodItem = null;
        for (FoodItem f : restaurant.getMenu()) {
            if (f.getId() == foodId) {
                foodItem = f;
                break;
            }
        }
        if (foodItem == null) {
            System.out.println("Food Item not found in the selected restaurant!");
            return;
        }
        System.out.print("Enter Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        customer.getCart().addItem(foodItem, quantity);
        System.out.println("Food item added to cart!");
    }

    static void viewCart() {
        System.out.print("Enter Customer ID: ");
        int custId = Integer.parseInt(scanner.nextLine());
        Customer customer = findCustomerById(custId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        System.out.println("Cart:");
        double total = 0;
        Map<FoodItem, Integer> items = customer.getCart().getItems();
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            FoodItem foodItem = entry.getKey();
            int quantity = entry.getValue();
            double cost = foodItem.getPrice() * quantity;
            System.out.println("Food Item: " + foodItem.getName() + ", Quantity: " + quantity + ", Cost: Rs. " + cost);
            total += cost;
        }
        System.out.println("Total Cost: Rs. " + total);
    }

    static void placeOrder() {
        System.out.print("Enter Customer ID: ");
        int custId = Integer.parseInt(scanner.nextLine());
        Customer customer = findCustomerById(custId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        Map<FoodItem, Integer> cartItems = customer.getCart().getItems();
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }
        Order order = new Order(orderCounter++, customer, new HashMap<>(cartItems));
        order.setStatus("Pending");
        orders.add(order);
        // Clear the customer's cart after placing the order
        customer.getCart().clear();
        System.out.println("Order placed successfully! Your order ID is: " + order.getOrderId());
    }

    static void viewCustomerOrders() {
        System.out.print("Enter Customer ID: ");
        int custId = Integer.parseInt(scanner.nextLine());
        Customer customer = findCustomerById(custId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        boolean found = false;
        System.out.println("Orders:");
        for (Order o : orders) {
            if (o.getCustomer().getUserId() == custId) {
                System.out.println(o);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No orders found for this customer.");
        }
    }

    // -------------------- Restaurant Module --------------------
    static void restaurantMenu() {
        while (true) {
            System.out.println("\n" + BLUE + "Restaurant Menu:" + RESET);
            System.out.println(YELLOW + "1. Add Restaurant");
            System.out.println("2. Add Food Item");
            System.out.println("3. Remove Food Item");
            System.out.println("4. View Menu");
            System.out.println("5. Exit" + RESET);
            System.out.print(CYAN + "Choose an option: " + RESET);
            
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1: addRestaurant(); break;
                case 2: addFoodItemToRestaurant(); break;
                case 3: removeFoodItemFromRestaurant(); break;
                case 4: viewRestaurantsAndMenus(); break;
                case 5: 
                    System.out.println(GREEN + "Exiting Restaurant Module" + RESET);
                    return;
                default:
                    System.out.println(RED + "Invalid option. Try again." + RESET);
            }
        }
    }

    // -------------------- Delivery Person Module --------------------
    static void deliveryPersonMenu() {
        while (true) {
            System.out.println("\n" + BLUE + "Delivery Person Menu:" + RESET);
            System.out.println(YELLOW + "1. Add Delivery Person");
            System.out.println("2. View Orders");
            System.out.println("3. Update Order Status");
            System.out.println("4. Exit" + RESET);
            System.out.print(CYAN + "Choose an option: " + RESET);
            
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1: addDeliveryPerson(); break;
                case 2: viewAllOrders(); break;
                case 3: assignDeliveryPersonToOrder(); break;
                case 4:
                    System.out.println(GREEN + "Exiting Delivery Person Module" + RESET);
                    return;
                default:
                    System.out.println(RED + "Invalid option. Try again." + RESET);
            }
        }
    }

    // -------------------- Helper Methods --------------------
    static Restaurant findRestaurantById(int id) {
        for (Restaurant r : restaurants) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    static Order findOrderById(int id) {
        for (Order o : orders) {
            if (o.getOrderId() == id) {
                return o;
            }
        }
        return null;
    }

    static DeliveryPerson findDeliveryPersonById(int id) {
        for (DeliveryPerson dp : deliveryPersons) {
            if (dp.getDeliveryPersonId() == id) {
                return dp;
            }
        }
        return null;
    }

    static Customer findCustomerById(int id) {
        for (Customer c : customers) {
            if (c.getUserId() == id) {
                return c;
            }
        }
        return null;
    }
}
