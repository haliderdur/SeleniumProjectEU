package com.cydeo.tests.day5_testNG_intro_dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {

    public void selenium_test() {

        // Browser driver setup
        WebDriverManager.chromedriver().setup();

        // Open browser
        WebDriver driver = new ChromeDriver();

        // Maximize the page
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Get "https://google.com"
        driver.get("https://google.com");

        // Assert: title is "Google"
        Assert.assertEquals(driver.getTitle(), "Google");


    }
}
