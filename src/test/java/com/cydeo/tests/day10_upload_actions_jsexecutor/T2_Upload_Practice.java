package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    //TC #2 Upload Test
    @Test
    public void upload_test() {

        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        String path = "C:/Users/halid/OneDrive/Masaüstü/eric.jpg";

        //3. Upload the file.
        WebElement chooseFiledBtn = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        chooseFiledBtn.sendKeys(path);

        WebElement uploaddBtn = Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));
        uploaddBtn.click();

        //4. Assert:
        //-File uploaded text is displayed on the page
        WebElement fileUploadedText = Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadedText.isDisplayed());

    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.getDriver().quit();
    }
}
