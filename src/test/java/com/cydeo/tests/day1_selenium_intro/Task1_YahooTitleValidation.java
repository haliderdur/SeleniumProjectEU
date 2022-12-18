package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleValidation {

    public static void main(String[] args) {

        // TC #`: Yahoo title validation

        // setup for browser driver
        WebDriverManager.chromedriver().setup();

        // open Chrome browser
        WebDriver driver = new ChromeDriver();

        // to make page fullscreen
        driver.manage().window().maximize();

        // go to yahoo.com
        driver.get("https://www.yahoo.com");

        // obtain the title of yahoo.com
        String actualTitle = driver.getTitle();

        String expectedTitle = "Yahoo";

        System.out.println("Expected title = " + expectedTitle);
        System.out.println("Actual title = " + actualTitle);

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Actual title is same as expected title. PASS!");
        } else {
            System.out.println("Actual title is NOT same as expected title. FAILED!");
        }


    }
}
