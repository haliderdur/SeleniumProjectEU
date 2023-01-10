package com.cydeo.tests.day7_webtables_utilities_javafaker;


import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T1_windowHandling {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        //1. Create new test and make set ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDownMethod() {
        //driver.quit();
    }

    @Test
    public void window_handling_test() {

        //2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3. Copy paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");


        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {

            driver.switchTo().window(each);
            System.out.println("Current URL   : " + driver.getCurrentUrl());
            System.out.println("Current Title : " + driver.getTitle());

            //4. Create a logic to switch to the tab where Etsy.com is open
            if (driver.getCurrentUrl().contains("etsy")) {
                break;
            }
        }


        //5. Assert: Title contains “Etsy”
        String expectedInTitle = "Etsy";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));


    }


}
