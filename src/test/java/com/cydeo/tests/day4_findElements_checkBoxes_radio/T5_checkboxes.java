package com.cydeo.tests.day4_findElements_checkBoxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T5_checkboxes {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //1. Go to https://practice.cydeo.com/checkboxes
        driver.get("https://practice.cydeo.com/checkboxes");

        // Locate checkboxes
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@name='checkbox1']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='checkbox2']"));

        //2. Confirm checkbox #1 is NOT selected by default
        System.out.println("checkbox1.isSelected(), expecting FALSE = " + checkbox1.isSelected());

        //3. Confirm checkbox #2 is SELECTED by default.
        System.out.println("checkbox2.isSelected(), expecting TRUE = " + checkbox2.isSelected());

        //4. Click checkbox #1 to select it.
        Thread.sleep(2000);
        checkbox1.click();

        //5. Click checkbox #2 to deselect it.
        Thread.sleep(2000);
        checkbox2.click();

        //6. Confirm checkbox #1 is SELECTED.
        System.out.println("checkbox1.isSelected(), expecting TRUE = " + checkbox1.isSelected());

        //7. Confirm checkbox #2 is NOT selected.
        System.out.println("checkbox2.isSelected(), expecting FALSE = " + checkbox2.isSelected());


        driver.close();
    }
}
