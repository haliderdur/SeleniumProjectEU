package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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

    public static void main(String[] args) {

        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //3- Write “apple” in search box
        //4- Click google search button
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("apple");




    }
}
