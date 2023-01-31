package com.cydeo.tests.extraPractices;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Flipkart_Task {

    @Test
    public void flipkartTest() throws InterruptedException {
        Driver.getDriver().get("https://www.flipkart.com/");

        WebElement dismissLogin = Driver.getDriver().findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        if (dismissLogin.isDisplayed()) {
            dismissLogin.click();
        }

        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@class='_3704LK']"));
        searchBox.sendKeys("apple watch" + Keys.ENTER);

        WebElement sortHighToLow = Driver.getDriver().findElement(By.xpath("//div[.='Price -- High to Low']"));
        sortHighToLow.click();

        WebElement mostExpensiveProductTitle = Driver.getDriver().findElement(By.xpath("(//div[.='APPLE Watch Ultra GPS + Cellular'])[1]"));
        WebElement mostExpensiveProductPrice = Driver.getDriver().findElement(By.xpath("(//div[@class='_30jeq3 _1_WHN1'])[1]"));

        Thread.sleep(2000);

        String rupeePrice = mostExpensiveProductPrice.getText().replace(",", "");

        System.out.println(mostExpensiveProductTitle.getText());
        System.out.println("Rupee: " + rupeePrice);


        try {
            double euroPrice = Integer.parseInt(rupeePrice.substring(1)) * 0.011;
            System.out.println("Euro: €" + euroPrice);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }
}
