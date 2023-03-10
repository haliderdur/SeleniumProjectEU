package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T3_Actions_HoverMouse {

    //TC #3: Hover Test
    @Test
    public void hovering_test() {

        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        // Locate all images
        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[3]"));

        // Locate all the "user" texts
        WebElement user1Text = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement user2Text = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement user3Text = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user3']"));

        // Locate all "view profile" texts
        WebElement user1ViewProfile = Driver.getDriver().findElement(By.xpath("//a[@href='/users/1']"));
        WebElement user2ViewProfile = Driver.getDriver().findElement(By.xpath("//a[@href='/users/2']"));
        WebElement user3ViewProfile = Driver.getDriver().findElement(By.xpath("//a[@href='/users/3']"));

        Actions actions = new Actions(Driver.getDriver());

        //2. Hover over to first image
        actions.moveToElement(img1).perform();
        //3. Assert:
        //a. “name: user1” is displayed
        //b. “view profile” is displayed
        Assert.assertTrue(user1Text.isDisplayed());
        Assert.assertTrue(user1ViewProfile.isDisplayed());

        //4. Hover over to second image
        actions.moveToElement(img2).perform();
        //5. Assert:
        //a. “name: user2” is displayed
        //b. “view profile” is displayed
        Assert.assertTrue(user2Text.isDisplayed());
        Assert.assertTrue(user2ViewProfile.isDisplayed());

        //6. Hover over to third image
        actions.moveToElement(img3).perform();
        //7. Confirm:
        //a. “name: user3” is displayed
        //b. “view profile” is displayed
        Assert.assertTrue(user3Text.isDisplayed());
        Assert.assertTrue(user3ViewProfile.isDisplayed());

    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.getDriver().quit();
    }
}
