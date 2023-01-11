package com.cydeo.tests.day8_properties_config_reader;

import org.testng.annotations.Test;

public class Leraning_Properties {

    @Test
    public void java_properties_reading_test() {

        // Key = value
        // os.name = Windows 10
        // user.name = halid
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));

    }

}
