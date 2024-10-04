package com.corndel.supportbank.examples;

import java.util.ArrayList;
import java.util.List;

public class WrapperClass {

    public static void main(String[] args) {
        // Primitives
        // int char double float boolean
        int number = 45;

        // Objects
        String name = "Charlie";
        name = new String("Charlie");
        // Wrappers
        // Integer Double Character
        // - PRIMITIVES to be an object
        // because this is a class it inherits from Object
        // boxing
        Integer myNumber = Integer.valueOf(45);
        myNumber = 45;


        // Collections - List, Map, Set
        List<Integer> myNumbers = new ArrayList<>();
        myNumbers.add(myNumber);
        myNumbers.add(66);
        // unboxing
        int firstItem = myNumbers.getFirst();

        // CASTING
        List<Object> myObjects = new ArrayList<>();
        myObjects.add(myNumber);

        firstItem = (int) myObjects.getFirst();
    }
}
