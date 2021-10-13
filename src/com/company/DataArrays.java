package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class DataArrays {

    public static void mostPopularOrders(ArrayList <PizzaClass> array) {
        // using a nested loop that increments the Arraycounter every time arrayPizzas matches with pizzaNumber
        // from the parameter arraylist. This keeps the elements from both arrays synchronized.
        int[] arrayCounter = new int[14];
        int[] arrayPizzas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        for (int index = 0; index < arrayPizzas.length; index++ ) {

            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).number == arrayPizzas[index]) {
                    arrayCounter[index]++;
                }
            }
        }

        for (int i = 0; i < arrayPizzas.length; i++) {
            System.out.println("Pizza number " + arrayPizzas[i] + ": Sold " + arrayCounter[i] + " times." );
        }
    }

    public static void getIncome(ArrayList <PizzaClass> array) {
        int income = 0;

        for (int i = 0; i < array.size(); i++) {
            income += array.get(i).price;
        }
        System.out.println("Your total income for today is: " + income + " dkk.");
    }

    public static ArrayList<PizzaClass> removeOrder(ArrayList <PizzaClass> array) {
        Scanner scanner = new Scanner(System.in);
        String customerId = null;
        boolean loop = true;
        boolean validInput = false;

        while (loop) {
            System.out.println("Please enter the customer ID for the order you would like to remove:");
            for (int i = 0; i < array.size(); i++) {
                System.out.println("Pizza number: " + array.get(i).number + ". " + "to " + array.get(i).customer +  ". Customer ID: " + array.get(i).customerID + " : Scheduled to: " + array.get(i).scheduledTo);
            }

            customerId = scanner.nextLine();

            for (int i = 0; i < array.size(); i++) {
                if (customerId.equals(array.get(i).customerID)) {
                    validInput = true;
                    break;
                }
            }
            if (!validInput) {
                System.out.println("Invalid costumer ID. Try again.");
                continue;
            }

            int i = 0;
            // while loop is reset for every match to avoid situations where the remove() methods shifts the elements to the left
            // which could cause that some elements would get ignored by the loop.
            while (i < array.size()) {
                if (customerId.equals(array.get(i).customerID)) {
                    array.remove(i);
                    i = 0;
                } else {
                    i++;
                }
            }
            loop = false;
        }
        return array;
    }
}
