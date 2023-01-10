package com.cydeo.utilities;

// TASk: NEW METHOD CREATION
// Method name : getDriver
// Static method
// Accepts String arg: browserName
//  - This arg will determine what type of browser is opened
//  - if "chrome" passed --> it will open chrome browser
//  - if "firefox" passed --> it will open firefox browser
// RETURN TYPE: "WebDriver"

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserName) {

        WebDriver driver;
/*
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            default:
                System.out.println("Given browser type does not exist or does not supported: " + browserName);
                driver = null;
        }
        driver.manage().window().maximize();
        
 */

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        } else {
            System.out.println("Given browser type does not exist or does not supported: " + browserName);
            System.out.println("Driver = null");
            return null;
        }
    }

}
