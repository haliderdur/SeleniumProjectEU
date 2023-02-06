package com.cydeo.tests.extraPractices;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Flipkart_Task {

    @Test
    public void flipkartTest() {
        Driver.getDriver().get("https://www.flipkart.com/");
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement dismissLogin = Driver.getDriver().findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        if (dismissLogin.isDisplayed()) {
            dismissLogin.click();
        }

        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@class='_3704LK']"));
        searchBox.sendKeys("apple watch" + Keys.ENTER);

        WebElement sortHighToLow = Driver.getDriver().findElement(By.xpath("//div[.='Price -- High to Low']"));
        sortHighToLow.click();

        WebElement mostExpensiveProductTitle = Driver.getDriver().findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
        WebElement mostExpensiveProductPrice = Driver.getDriver().findElement(By.xpath("(//div[@class='_30jeq3 _1_WHN1'])[1]"));

        System.out.println(mostExpensiveProductTitle.getText());
        System.out.println(mostExpensiveProductPrice.getText());

/*
        try {
            double euroPrice = Integer.parseInt(mostExpensiveProductPrice.getText().substring(1).replace(",","")) * 0.011;
            System.out.println("Euro: €" + euroPrice);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
*/

    }
}
