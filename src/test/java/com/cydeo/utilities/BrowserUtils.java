package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
In this class, there are only general utility methods that are not related to any specific page
 */
public class BrowserUtils {

    //"sleep" accepts int (seconds) and executes Thread.sleep for given duration
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }


    /*
    "switchWindowAndVerify" method accepts 3 arguments and switches between windows
    arg1: WebDriver (driver)
    arg2: expectedInURL ==> to verify if the URL contains given String.
    - if condition mathes, will break the loop
    arg3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify(WebDriver driver, String expectedInURL, String expectedInTitle) {

        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String each : allWindowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current URL   : " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedInURL)) {
                break;
            }
        }

        //5. Assert: Title contains expectedInTitle
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }


    //"verifyTitle" accepts String "expectedTitle" and Asserts if its True
    public static void verifyTitle(WebDriver driver, String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }


    // Utility method for ExplicitWait so I dont have to repeat the same lines
    public static void waitForInvisibilityOf(WebElement webElement) {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

}
