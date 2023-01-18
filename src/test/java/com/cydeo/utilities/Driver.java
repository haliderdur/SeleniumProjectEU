package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating a provate constructor so we can prevent
    access to the object of this class from outside of the class
     */
    private Driver() {
    }

    /*
    We make WebDriver private, cuz we want to prevent access from outside of the class
    We make WebDriver static, cuz we will use it in a static method
     */
    private static WebDriver driver;

    /*
    Create a re-usable utility method which will return same driver instance when we call it
    */
    public static WebDriver getDriver() {

        if (driver == null) {
            /*
            Read browser type from ConfigurationReader.properties
            This way, I can control which browser is opened from outside of my code
            */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depends on the browser type that will be return from configuration.properties file
            switch statement will determine the case, and open the matching browser
            */
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driver;
    }


}
