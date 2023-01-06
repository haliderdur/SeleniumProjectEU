package com.cydeo.tests.day5_testNG_intro_dropdowns;

//TC #1: StaleElementReferenceException handling


import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementRefEx {

    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //3. Click to “Add Element” button
        WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();

        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));

        if (deleteButton.isDisplayed()) {
            System.out.println("\"Delete\" button is displayed. PASSED!");
        } else {
            System.out.println("\"Delete\" button is not displayed. FAILED!!!");
        }

        //5. Click to “Delete” button.
        deleteButton.click();

        //6. Verify “Delete” button is NOT displayed after clicking.
        try {
            if (!(deleteButton.isDisplayed())) {
                System.out.println("\"Delete\" button disaapeared after click. PASSED!");
            } else {
                System.out.println("\"Delete\" button is remained after click. FAILED!!!");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("-->Stale Element Reference Exception thrown.");
            System.out.println("--> Web Element is completely deleted.");
            System.out.println("\"Delete\" button disaapeared after click. PASSED!");
        }

        driver.close();

    }
}
