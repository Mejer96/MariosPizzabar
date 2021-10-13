package com.company;

public class PizzaClass {
    int number;
    String name;
    String topping;
    double scheduledTo;
    double price;
    String customer;
    String customerID;
    String scheduledToReadable;

    PizzaClass(int number, String name, String topping, double scheduledTo, double price, String customer, String scheduledToReadable, String customerID) {
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
}

