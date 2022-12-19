package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {

    /*
    TC #1: Cydeo practice tool verifications
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com
        3. Verify URL contains
            Expected: cydeo
        4. Verify title:
            Expected: Practice
     */

    public static void main(String[] args) throws InterruptedException {

        // setup web driver manager and chrome driver
        WebDriverManager.chromedriver().setup();
        // create instance of chrome driver
        WebDriver driver = new ChromeDriver();

        driver.get("https://practice.cydeo.com");


// Verify that actual title is same as expected title "Practise"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test PASS! Actual title \"" + actualTitle + "\" is same as expected title \"" + expectedTitle + "\"");
        } else {
            System.err.println("Test Fail! Actual title \"" + actualTitle + "\" is NOT same as expected title \"" + expectedTitle + "\"");
        }


// Verify that current URL contains "cydeo"
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://practice.cydeo.com";

        if (currentURL.contains("cydeo")) {
            System.out.println("Test PASS! Current URL contains \"cydeo\": " + currentURL);
        } else {
            System.err.println("Test FAIL!");
        }


        driver.quit();


    }
}
