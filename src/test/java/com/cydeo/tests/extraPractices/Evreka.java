package com.cydeo.tests.extraPractices;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Evreka {

    @Test
    public void evrekaTask() {
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // Locate the search box and search the item
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("iphone13 512" + Keys.ENTER);

        // locate the first option after search
        WebElement choice1 = Driver.getDriver().findElement(By.xpath("//span[.='iPhone 13 Pro, 512GB, Silver - Unlocked (Renewed Premium)']"));

        // check whether if the results are displayed or not
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//span[.='RESULTS']")).isDisplayed(), "Results are NOT displayed");

        // click the first option
        choice1.click();

        // Locators
        WebElement productName = Driver.getDriver().findElement(By.id("productTitle"));
        WebElement color = Driver.getDriver().findElement(By.id("inline-twister-expanded-dimension-text-color_name"));
        WebElement size = Driver.getDriver().findElement(By.id("inline-twister-expanded-dimension-text-size_name"));
        WebElement price = Driver.getDriver().findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium apexPriceToPay']"));
        WebElement stock = Driver.getDriver().findElement(By.id("availability"));

        // print texts
        System.out.println(productName.getText().substring(0, 9)); // .substring() to get only "iphone 13", not the whole product listing name
        System.out.println("Size: " + size.getText());
        System.out.println("Color: " +color.getText());
        System.out.println("Price: " + price.getText());
        System.out.println("Availability in stock: " + stock.getText());
    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }
}
