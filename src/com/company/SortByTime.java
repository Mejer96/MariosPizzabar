package com.company;

import java.util.Comparator;

public class SortByTime implements Comparator<PizzaClass> {
    // method that will sort through arraylist of objects
    public int compare(PizzaClass a, PizzaClass b) {
      double Delta = a.scheduledTo - b.scheduledTo;
        if (Delta > 0) {
            return 1;
        } else if (Delta < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
