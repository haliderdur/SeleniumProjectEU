package com.cydeo.tests.extraPractices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PolymerTask {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void PolymerTest() throws InterruptedException {

        driver.get("https://todomvc.com/");

        // locate JavaScript tab and click
        WebElement javaScriptTab = driver.findElement(By.xpath("//div[.='JavaScript']"));
        javaScriptTab.click();

        // locate polymer link and click
        WebElement polymerLink = driver.findElement(By.xpath("//a[.='Polymer']"));
        polymerLink.click();

        // locate inputBox and add items
        WebElement inputBox = driver.findElement(By.xpath("//input[@id='new-todo']"));
        inputBox.sendKeys("4 bananas" + Keys.ENTER);
        inputBox.sendKeys("3 apples" + Keys.ENTER);
        Thread.sleep(2000);

        // locate second item and it's destroy button
        WebElement secondItem = driver.findElement(By.xpath("(//div[@class='style-scope td-item'])[2]"));
        WebElement secondItemDestroyBtn = driver.findElement(By.xpath("(//button[@class='destroy style-scope td-item'])[2]"));

        // click on destroy button
        Actions action = new Actions(driver);
        action.moveToElement(secondItem).click(secondItemDestroyBtn).perform();

        // add new second item
        inputBox.sendKeys("6 lemons" + Keys.ENTER);
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

}
