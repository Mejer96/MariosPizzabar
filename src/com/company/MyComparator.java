package com.company;

import java.util.Comparator;

public class MyComparator implements Comparator<PizzaClass> {
    // method that will sort through arraylist of objects and return int value depending on tha comparison.
    // returns 1 if a is higher than b
    // returns -1 if a is equal to b
    // returns 0 if a is lower than b
    public int compare(PizzaClass a, PizzaClass b) {
      double Delta = a.getScheduledTo() - b.getScheduledTo();
        if (Delta > 0) {
            return 1;
        } else if (Delta < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
