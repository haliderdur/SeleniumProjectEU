package com.cydeo.tests.day8_properties_config_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Reading_Properties {

    @Test
    public void reading_properties_test() throws IOException {
        // 1-Create the object of Properties
        Properties properties = new Properties();

        // 2-We need to open the file in java memory: FileInputStream
        FileInputStream file = new FileInputStream("configuration.properties");

        // 3-Load the properties object using FileInputStream object
        properties.load(file);

        // 4-Use "properties" object to read value
        String browserProperty = properties.getProperty("browser");
        String usernameProperty = properties.getProperty("username");
        String environmentProperty = properties.getProperty("environment");

        System.out.println("browserProperty = " + browserProperty);
        System.out.println("usernameProperty = " + usernameProperty);
        System.out.println("environmentProperty = " + environmentProperty);


    }
}
