package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

/*
In this class, there are only general utility methods that are not related to any specific page
 */
public class BrowserUtils {

    /*
    "sleep" accepts int (seconds) and executes Thread.sleep for given duration
     */
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

    /*
    "verifyTitle" accepts String "expectedTitle" and Asserts if its True
     */
    public static void verifyTitle(WebDriver driver, String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

}
