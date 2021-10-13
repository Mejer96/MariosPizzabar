package com.company;

import java.util.*;

public class SystemClass {

    public static void showMenu() {
        System.out.println("1. Vesuvio: Tomatsauce, ost, skinke, og oregano. Pris: 57");
        System.out.println("2. Amerikaner: Tomatsauce, ost, oksefars og oregano. Pris 53");
        System.out.println("3. Cacciatore: Tomatsauce, ost, pepperoni og oregano. Pris 57");
        System.out.println("4. Carbona: Tomatsauce, ost, pepperoni og oregano. Pris 63");
        System.out.println("5. Dennis: Tomatsauce, ost, skinke, pepperoni, cocktailpølser, og oregano. Pris: 65");
        System.out.println("6. Bertil: Tomatsauce, ost, bacon, og oregano. Pris 57");
        System.out.println("7. Silvia: Tomatsauce, ost, pepperoni, rød peber, løg, oliven, og oregano. Pris 61");
        System.out.println("8. Victoria: Tomatsauce, ost, skinke, ananas, champignon, løg og oregano. Pris 61");
        System.out.println("9. Toronfo: Tomatsauce, ost, skinke, bacon, kebab, chili og oregano. Pris 61");
        System.out.println("10. Capricciosa: Tomatsauce, ost, skinke, champignon og oregano. Pris 61");
        System.out.println("11. Hawaii: Tomatsauce, ost, skinke, ananas og oregano. Pris 61");
        System.out.println("12. Le Blissola: Tomatsauce, ost, skinke, rejer og oregano. Pris 61");
        System.out.println("13. Venezia: Tomatsauce, ost, skinke, bacon og oregano. Pris 61.");
        System.out.println("14. Mafia: Tomatsauce, ost, pepperoni, bacon, løg og oregano. Pris 61.");
    }

    public static int gameMenu() {
        // 1 to register order. 2 to show menu. 3 to remove order. 4 to show orders. 5 to show stats. 6 to show income. 7 to exit.
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        boolean loop = true;
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("What would you like to do?");
        System.out.println("1 to register order.\n2 to show menu.\n3 to remove order.\n4 to show orders.\n5 to show stats.\n6 to show income.\n7 to exit.");

        while (loop) {

            System.out.print(">");
            userInput = scanner.nextInt();

            for (int i = 0; i < array.length; i++) {
                if (userInput == array[i]) {
                    loop = false;
                    break;
                } else if (i == array.length-1){
                    System.out.println("Invalid input. Try again.");
                }
            }
        }
        return userInput;
    }

    public static String customerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the customer: ");
        System.out.print(">");
        return scanner.nextLine();
    }

    public static String generateCustomerID() {
        Random random = new Random();
        int length = 5;
        String characters = "abcdefghijklmnopqrstuvxyzæå123456789";
        char[] array = new char[length];
        String customerID = "#";


        for (int i = 0; i < length; i++) {
            array[i] = characters.charAt(random.nextInt(characters.length()));
        }

        for (int i = 0; i < length; i++) {
            String toString = String.valueOf(array[i]);
            customerID = customerID.concat(toString);
        }
        return customerID;
    }


    public static int numberOfOrders() {
        // prompts user to input number of orders by the same customer.
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        boolean whileLoop = true;

        System.out.println("Please enter the amount of orders u just received from the customer: ");

        while (whileLoop) {
            System.out.println(">");
            try {
            userInput = scanner.nextInt();
            whileLoop = false;
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number. Try again.");
            }
        }
        return userInput;
    }

    public static int enterPizzaNumber() {
        // prompts user to enter the pizza's number on the menu.
        Scanner scanner = new Scanner(System.in);
        int userInputNumberOfOrders;
        int order = 0;
        boolean whileLoop = true;


        System.out.println("Please enter the order u just received:");

        while (whileLoop) {

            System.out.println(">");
            try {
                order = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
                scanner.next();
                continue;
            }
            if (order < 1 || order > 14) {
                System.out.println("The number u just entered is not on the menu. try again");
            } else {
                whileLoop = false;
            }
        }
        return order;
    }


    public static String scheduledAt() {
        // prompts the user to input the time when the order should be ready. Then modify the minutes into decimals, so the scheduled time can be compared properly.
        Scanner scanner = new Scanner(System.in);
        boolean whileLoop = true;
        int hours = 0;
        int minutes = 0;
        String hoursToString = null;
        String minutesToString = null;
        String stringToReturn;

        System.out.println("Enter the estimated time for when the order is ready:");

        while (whileLoop) {
            System.out.println("Hour:");
            System.out.print(">");
            try {
            hours = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number. Try again.");
                scanner.next();
                continue;
            }
            if (hours < 0 || hours > 23) {
                System.out.println("Hours can not be below 0 or higher than 23.");
                continue;
            }
            System.out.println("Minutes:");
            System.out.print(">");
            try {
            minutes = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number. Try again.");
                scanner.next();
                continue;
            }
            if (minutes < 1 || minutes > 59) {
                System.out.println("Minutes can not be below 1 or higher than 59");
                continue;
            }
            hoursToString = String.valueOf(hours);
            minutesToString = String.valueOf(minutes);
            whileLoop = false;
        }
        if (minutesToString.length() == 1) {
            // handles situations where minutes are single digit and would look odd on the terminal.
            stringToReturn = hoursToString + ".0" + minutesToString;
        } else {
            stringToReturn = hoursToString + "." + minutesToString;
        }

        return stringToReturn;
    }

    public static double scheduledToNumericalValue(String scheduledTo) {
        String[] array = scheduledTo.split("\\.");
        double hoursToDouble = Double.parseDouble(array[0]);
        double minutesToDouble = Double.parseDouble(array[1]);
        minutesToDouble /= 100;

        return hoursToDouble + minutesToDouble;
    }

    public static PizzaClass addPizzaToOrders(int orderNumber, double scheduledAt, String scheduledAtReadable, String customer, String customerID) {
        // method compares orderNumber from user with the menu, creates necessary variables to create a PizzaClass and creates an object of that class.
        String name = null;
        String topping = null;
        int price = 0;

        switch (orderNumber) {
            case 1:
                name = "Vesuvio";
                topping = "Tomatsauce, ost, skinke, og oregano.";
                price = 57;
                break;
            case 2:
                name = "Amerikaner";
                topping = "Tomatsauce, ost, oksefars og oregano.";
                price = 53;
                break;
            case 3:
                name = "Cacciatore";
                topping = "Tomatsauce, ost, pepperoni og oregano.";
                price = 57;
                break;
            case 4:
                name = "Carbona";
                topping = "Tomatsauce, ost, pepperoni og oregano.";
                price = 63;
                break;
            case 5:
                name = "Dennis";
                topping = "Tomatsauce, ost, skinke, pepperoni, cocktailpølser, og oregano";
                price = 65;
                break;
            case 6:
                name = "Bertil";
                topping = "Tomatsauce, ost, bacon, og oregano";
                price = 57;
                break;
            case 7:
                name = "Silvia";
                topping = "Tomatsauce, ost, pepperoni, rød peber, løg, oliven, og oregano";
                price = 61;
                break;
            case 8:
                name = "Victoria";
                topping = "Tomatsauce, ost, skinke, ananas, champignon, løg og oregano";
                price = 61;
                break;
            case 9:
                name = "Toronfo";
                topping = "Tomatsauce, ost, skinke, bacon, kebab, chili og oregano";
                price = 61;
                break;
            case 10:
                name = "Capricciosa";
                topping = "Tomatsauce, ost, skinke, champignon og oregano";
                price = 61;
                break;
            case 11:
                name = "Hawaii";
                topping = "Tomatsauce, ost, skinke, ananas og oregano";
                price = 61;
                break;
            case 12:
                name = "Le Blissola";
                topping =  "Tomatsauce, ost, skinke, rejer og oregano";
                price = 61;
                break;
            case 13:
                name = "Venezia";
                topping = "Tomatsauce, ost, skinke, bacon og oregano";
                price = 61;
                break;
            case 14:
                name = "Mafia";
                topping = "Tomatsauce, ost, pepperoni, bacon, løg og oregano";
                price = 61;
        }
        PizzaClass pizza = new PizzaClass(orderNumber, name, topping, scheduledAt, price, customer, scheduledAtReadable, customerID);
        return pizza;
    }

    public static ArrayList<PizzaClass> sortOrdersByTime(ArrayList<PizzaClass> array) {
        // comparator method to sort the arraylist by scheduled time in ascending order.
        Collections.sort(array, new SortByTime());

        return array;
    }


}
