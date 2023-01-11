package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_Config_Practice {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        // To get browserType dynamically from configuration.properties file
        String browserType = ConfigurationReader.getProperty("browser");

        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @Test
    public void google_search_test() {

        WebElement rejectCookies = driver.findElement(By.id("W0wltc")); // to bypass cookies preference pop-up / accept or reject
        rejectCookies.sendKeys(Keys.ENTER);

        WebElement searchBoxElement = driver.findElement(By.xpath("//input[@name='q']"));
        searchBoxElement.sendKeys("apple" + Keys.ENTER);

        String actualTitle = driver.getTitle();
        String expectedTitle = "apple - Google Search";

        Assert.assertEquals(actualTitle, expectedTitle, "Actual title data does NOT correspond with expected title data!!!");


    }

}
