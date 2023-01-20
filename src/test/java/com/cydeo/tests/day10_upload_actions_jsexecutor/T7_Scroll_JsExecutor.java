package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_Scroll_JsExecutor {

    //TC #7: Scroll using JavascriptExecutor
    @Test
    public void scroll_js_test() {

        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //3- Scroll down to “Cydeo” link
        WebElement cydeoLink = Driver.getDriver().findElement(By.xpath("//a[@href='https://cydeo.com/']"));
        js.executeScript("arguments[0].scrollIntoView(true);", cydeoLink);

        //4- Scroll up to “Home” link
        WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[.='Home']"));
        js.executeScript("arguments[0].scrollIntoView(true);", homeLink);

        //5- Use below provided JS method only
        //JavaScript method to use : arguments[0].scrollIntoView(true)
    }

}
