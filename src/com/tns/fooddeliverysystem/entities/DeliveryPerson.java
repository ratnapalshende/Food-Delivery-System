package com.tns.fooddeliverysystem.entities;

public class DeliveryPerson {
    // Private fields
    private int deliveryPersonId;
    private String name;
    private long contactNo;

    // Constructor
    public DeliveryPerson(int deliveryPersonId, String name, long contactNo) {
        this.deliveryPersonId = deliveryPersonId;
        this.name = name;
        this.contactNo = contactNo;
    }

    // Getter methods
    public int getDeliveryPersonId() {
        return deliveryPersonId;
    }

    public String getName() {
        return name;
    }

    public long getContactNo() {
        return contactNo;
    }

    // Overriding toString() method
    @Override
    public String toString() {
        return "DeliveryPerson{" +
               "deliveryPersonId=" + deliveryPersonId +
               ", name='" + name + '\'' +
               ", contactNo=" + contactNo +
               '}';
    }

   
}
