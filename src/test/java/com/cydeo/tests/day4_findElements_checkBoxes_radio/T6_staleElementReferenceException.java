package com.cydeo.tests.day4_findElements_checkBoxes_radio;

//TC #6: StaleElementReferenceException Task

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T6_staleElementReferenceException {

    public static void main(String[] args) {

        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        //3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoLink = driver.findElement(By.cssSelector("a[href='https://cydeo.com/']"));

        //4- Refresh the page.
        driver.navigate().refresh();

        //Refreshing the web element reference by re-assigning(re-locating) the web element
        cydeoLink = driver.findElement(By.cssSelector("a[href='https://cydeo.com/']"));


        //5- Verify it is displayed, again.
        try {
            System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }

        driver.close();

    }
}

