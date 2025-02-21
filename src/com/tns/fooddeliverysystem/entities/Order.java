import java.util.*;

public class Order {
    private int orderId;
    private Customer customer;
    private Map<FoodItem, Integer> items;
    private String status;
    private DeliveryPerson deliveryPerson;
    private String deliveryAddress;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new HashMap<>();
        this.status = "Pending";
        this.deliveryPerson = null;
        this.deliveryAddress = "";
    }

    public void addItem(FoodItem foodItem, int quantity) {
        items.put(foodItem, items.getOrDefault(foodItem, 0) + quantity);
    }

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

    @Override
    public String toString() {
        return "Order ID: " + orderId + "\n" +
               "Customer: " + customer + "\n" +
               "Items: " + items + "\n" +
               "Status: " + status + "\n" +
               "Delivery Person: " + (deliveryPerson != null ? deliveryPerson : "Not Assigned") + "\n" +
               "Delivery Address: " + (deliveryAddress.isEmpty() ? "Not Provided" : deliveryAddress);
    }
}
