package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class DataArraysAndArraylists {

    public static void showStats(ArrayList <PizzaClass> arraylist) {
        // using a nested loop that increments the Arraycounter every time arrayPizzas matches with a pizzaNumber
        // from the parameter arraylist. This keeps the elements from both arrays synchronized.
        int[] arrayCounter = new int[14];
        int[] arrayPizzas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};


        for (int index = 0; index < arrayPizzas.length; index++ ) {

            for (int i = 0; i < arraylist.size(); i++) {
                if (arraylist.get(i).getNumber() == arrayPizzas[index]) {
                    arrayCounter[index]++;
                }
            }
        }

        for (int i = 0; i < arrayPizzas.length; i++) {
            System.out.println("Pizza number " + arrayPizzas[i] + ": Sold " + arrayCounter[i] + " times." );
        }
    }

    public static void getIncome(ArrayList <PizzaClass> arraylist) {
        int income = 0;

        for (int i = 0; i < arraylist.size(); i++) {
            income += arraylist.get(i).getPrice();
        }
        System.out.println("Your total income for today is: " + income + " dkk.");
    }

    public static ArrayList<PizzaClass> removeOrder(ArrayList <PizzaClass> arraylist) {
        // matches customerID with elements of arraylist and removes the elements with a customerID equal to input.
        Scanner scanner = new Scanner(System.in);
        String customerId = null;
        boolean loop = true;
        boolean validInput = false;
        int removeActiveOrdersLoop = 0;

        while (loop) {
            System.out.println("Please enter the customer ID for the order you would like to remove:");
            for (int i = 0; i < arraylist.size(); i++) {
                System.out.println("Pizza number: " + arraylist.get(i).getNumber() + ". " + "to " + arraylist.get(i).getCustomer() +  ". Customer ID: " + arraylist.get(i).getCustomerID() + " : Scheduled to: " + arraylist.get(i).getScheduledTo());
            }

            System.out.print(">");
            customerId = scanner.nextLine();

            for (int i = 0; i < arraylist.size(); i++) {
                if (customerId.equals(arraylist.get(i).getCustomerID())) {
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
            // which caused that the next element would get ignored by the loop.
            while (removeActiveOrdersLoop < arraylist.size()) {
                if (customerId.equals(arraylist.get(removeActiveOrdersLoop).getCustomerID())) {
                    arraylist.remove(i);
                    removeActiveOrdersLoop = 0;
                } else {
                    removeActiveOrdersLoop++;
                }
            }
            loop = false;
        }
        return arraylist;
    }
}
