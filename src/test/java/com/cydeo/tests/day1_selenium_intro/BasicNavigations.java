package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        // Setup the browser driver
        WebDriverManager.chromedriver().setup();

        // Create instance of Selenium WebDriver - This is the line openning an empty browser
        WebDriver driver = new ChromeDriver();

        // to maximize browser window
        driver.manage().window().maximize();

        // Go to "tesla.com"
        driver.get("https://www.tesla.com");

        // get the title of the page - driver.getTitle();
        String currentTitle = driver.getTitle();
        System.out.println("Current Title = " + currentTitle);

        // to get current URL
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL = " + currentURL);

        // Stop code execution for 2 seconds
        Thread.sleep(2000);

        // use selenium to navigate back
        driver.navigate().back();

        // Stop code execution for 2 seconds
        Thread.sleep(2000);

        // use selenium to navigate forward
        driver.navigate().forward();

        Thread.sleep(2000);

        // use selenium to navigate refresh
        driver.navigate().refresh();

        Thread.sleep(2000);

        // use navigate().to(); method
        driver.navigate().to("https://www.amazon.com");

        // get the title of the page - driver.getTitle();
        currentTitle = driver.getTitle();
        System.out.println("Current Title = " + currentTitle);

        // to get current URL
        currentURL = driver.getCurrentUrl();
        System.out.println("Current URL = " + currentURL);


        // to close the current oppened window
        driver.close();

        // to close all the oppened windows - after quit() method, we can not execute any other line of codes
        driver.quit();


    }
}
