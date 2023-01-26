package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T3_Scroll_Actions_Practice {

    //TC #4: Scroll practice
    @Test
    public void scroll_test() {

        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        WebElement powereByCydeoText = Driver.getDriver().findElement(By.xpath("//a[.='CYDEO']"));
        Actions action = new Actions(Driver.getDriver());

        //4- Scroll using Actions class “moveTo(element)” method
        action.moveToElement(powereByCydeoText).perform();

        //2- Scroll back up to “Home” link using PageUP button
        action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();

    }

}
