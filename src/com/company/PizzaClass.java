package com.company;

public class PizzaClass {
    private int number;
    private String name;
    private String topping;
    private double scheduledTo;
    private int price;
    private String customer;
    private String customerID;
    private String scheduledToReadable;

    PizzaClass(int number, String name, String topping, double scheduledTo, int price, String customer, String scheduledToReadable, String customerID) {
        this.number = number;
        this.name = name;
        this.topping = topping;
        this.scheduledTo = scheduledTo;
        this.price = price;
        this.customer = customer;
        this.scheduledToReadable = scheduledToReadable;
        this.customerID = customerID;
    }

    public String toString() {
        return number + ". " + name +": " + topping + "\nScheduled to: " + scheduledToReadable + ". Price: " + price + " dkk.";
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
    public String getTopping() {
        return topping;
    }

    public double getScheduledTo() {
        return scheduledTo;
    }

    public int getPrice() {
        return price;
    }

    public String getCustomer() {
        return customer;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getScheduledToReadable() {
        return scheduledToReadable;
    }


}

