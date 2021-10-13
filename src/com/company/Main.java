package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<PizzaClass> activeOrders = new ArrayList<>();
        ArrayList<PizzaClass> orderHistory = new ArrayList<>();
        boolean loop = true;
        int order = 0;

        while (loop) {
            int userInput = SystemClass.gameMenu();
            // 1 to register order. 2 to show menu. 3 to remove order. 4 to show orders. 5 to show stats. 6 to show income.
            switch (userInput) {
                case 1:
                    int numberOfOrders = SystemClass.numberOfOrders();
                    String scheduledTo = SystemClass.scheduledAt();
                    String customerName = SystemClass.customerName();
                    String customerID = SystemClass.generateCustomerID();
                    double scheduledToNumericalValue = SystemClass.scheduledToNumericalValue(scheduledTo);

                    for (int i = 0; i < numberOfOrders; i++) {
                        order = SystemClass.enterPizzaNumber();
                        PizzaClass newPizza = SystemClass.addPizzaToOrders(order, scheduledToNumericalValue, scheduledTo, customerName, customerID);
                        activeOrders.add(newPizza);
                        orderHistory.add(newPizza);
                    }

                    for (int i = 0; i < activeOrders.size(); i++) {
                        System.out.println(activeOrders.get(i).toString());
                    }
                    break;
                case 2:
                    SystemClass.showMenu();
                    break;
                case 3:
                    activeOrders = DataArrays.removeOrder(activeOrders);
                    break;
                case 4:
                    ArrayList<PizzaClass> sortedOrders = SystemClass.sortOrdersByTime(activeOrders);
                    for (int i = 0; i < sortedOrders.size(); i++) {
                        System.out.println(sortedOrders.get(i).name + ":");
                        System.out.println("Scheduled to be ready at: " + sortedOrders.get(i).scheduledToReadable);
                    }
                    break;
                case 5:
                    DataArrays.mostPopularOrders(orderHistory);
                    break;
                case 6:
                    DataArrays.getIncome(orderHistory);
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    loop = false;
                    break;
            }
        }
    }
}
