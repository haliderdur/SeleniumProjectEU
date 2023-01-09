package com.cydeo.tests.day6_alert_iFrames_windows;

//TC #1: Information alert practice

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_Alert_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

    @Test
    public void alert_Test1() {

        //3. Click to “Click for JS Alert” button
        WebElement JSAlertBtn = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        JSAlertBtn.click();

        //4. Click to OK button from the alert
        // To be able to click Alert OK button, we need to switch driver focus to Alert itself
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT displayed!!!");

        String expectedMessage = "You successfully clicked an alert";
        String actualMessage = resultText.getText();

        Assert.assertEquals(actualMessage, expectedMessage, "Actual result text is NOT expected!!!");

    }

}
