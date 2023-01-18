package com.cydeo.tests.day9_javafaker_testbase_driverutil;

public class Singleton {

    // Create a private constructor
    private Singleton() {
    }

    // Create private static String
    private static String word;

    public static String getWord() {

        if (word == null) {
            System.out.println("First time call. Word object is null. Assigning value to it now!");
            word = "something";
        } else {
            System.out.println("Word already has value");
        }
        return word;
    }
}
