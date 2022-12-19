package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC#3: Google search
    1- Open a Chrome browser
    2- Go to: https://google.com
    3- Write “apple” in search box
    4- Click google search button
    5- Verify title:
    Expected: Title should start with “apple” word
 */
public class T3_GoogleSearch {

    public static void main(String[] args) throws InterruptedException {

        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //3- Write “apple” in search box
        //4- Click google search button
        Thread.sleep(1500);
        WebElement rejectCookies = driver.findElement(By.id("W0wltc")); // to bypass cookies preference pop-up / accept or reject
        rejectCookies.sendKeys(Keys.ENTER);
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("apple" + Keys.ENTER);

        //5- Verify title:
        //Expected: Title should start with “apple” word

        String actualTitle = driver.getTitle();
        if (actualTitle.startsWith("apple")) {
            System.out.println("Test PASS! title: " + actualTitle);
        } else {
            System.out.println("Test FAILED!!! title: " + actualTitle);
        }

        driver.close();


    }
}
