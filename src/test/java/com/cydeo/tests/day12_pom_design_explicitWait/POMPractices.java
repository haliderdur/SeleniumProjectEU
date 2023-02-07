package com.cydeo.tests.day12_pom_design_explicitWait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class POMPractices {

    LibraryLoginPage libraryLoginPage;

    @BeforeMethod
    public void setupMethod() {
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");
        libraryLoginPage = new LibraryLoginPage();
    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }

    @Test
    public void requiredFieldErrorMessage_test() {
        //TC #1: Required field error message test

        //3- Do not enter any information
        //4- Click to “Sign in” button
        libraryLoginPage.signInButton.click();

        //5- Verify expected error is displayed:
        //Expected: This field is required.
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());

        //7- Enter wrong username and password information and verify expected error is displayed:
        libraryLoginPage.inputUsername.clear();
        libraryLoginPage.inputUsername.sendKeys("abc@zxc.com");
        libraryLoginPage.inputPassword.sendKeys("123asd");
        libraryLoginPage.signInButton.click();
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());

    }

    @Test
    public void invalidEmailFormatErrorMessage_test() {
        //TC #2: Invalid email format error message test

        //3- Enter invalid email format
        libraryLoginPage.inputUsername.sendKeys("abcabc" + Keys.ENTER);

        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.
        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());

    }

    @Test
    public void libraryNegativeLogin_test() {
        //TC #3: Library negative login

        //3- Enter incorrect username or incorrect password
        libraryLoginPage.inputUsername.clear();
        libraryLoginPage.inputUsername.sendKeys("abc@zxc.com");
        libraryLoginPage.inputPassword.sendKeys("123asd");
        libraryLoginPage.signInButton.click();

        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());

    }
}
