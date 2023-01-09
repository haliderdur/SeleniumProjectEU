package com.cydeo.tests.day6_alert_iFrames_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T5_Window_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");
    }


    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }


    @Test
    public void multiple_windowTest() {

        //Storing the main page's window handle as string is good practice to reuse it in future
        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        //4. Assert: Title is “Windows”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";

        Assert.assertEquals(actualTitle, expectedTitle, "Actual title is NOT same as expected title!!!");

        System.out.println("Actual title before click: " + actualTitle);
        //5. Click to: “Click Here” link
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();


        //6. Switch to new Window.
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String each : allWindowHandles) {

            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());

        }

        //7. Assert: Title is “New Window”
        String expectedTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitleAfterClick);

        System.out.println("Actual title after click: " + actualTitle);

        // to go main page, we can use already stored main handle
        // driver.switchTo().window(mainHandle);

    }

}
