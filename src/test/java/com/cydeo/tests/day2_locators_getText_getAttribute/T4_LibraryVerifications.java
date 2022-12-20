package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #4: Library verifications
    1. Open Chrome browser
    2. Go to http://library2.cybertekschool.com/login.html
    3. Enter username: “incorrect@email.com”
    4. Enter password: “incorrect password”
    5. Verify: visually “Sorry, Wrong Email or Password” displayed
        PS: Locate username input box using “className” locator
        Locate password input box using “id” locator
        Locate Sign in button using “tagName” locator
 */
public class T4_LibraryVerifications {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://library2.cybertekschool.com/login.html");

        WebElement emailPlaceHolder = driver.findElement(By.className("form-control"));
        emailPlaceHolder.sendKeys("incorrect@email.com");

        Thread.sleep(2000);

        WebElement passwordPlaceHolder = driver.findElement(By.id("inputPassword"));
        passwordPlaceHolder.sendKeys("incorrect password");

        Thread.sleep(2000);

        WebElement buttonSignIn = driver.findElement(By.tagName("button"));
        buttonSignIn.click();

        WebElement sorryMessage = driver.findElement(By.className("mb-4"));

        if (sorryMessage.equals("Sorry, Wrong Email or Password") || sorryMessage.isDisplayed()) {
            System.out.println("Test PASS!");
        } else {
            System.out.println("Test FAILED!!!");
        }

        driver.close();


    }
}
