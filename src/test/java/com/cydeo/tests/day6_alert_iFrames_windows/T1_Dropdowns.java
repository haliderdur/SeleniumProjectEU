package com.cydeo.tests.day6_alert_iFrames_windows;

//TC #5: Selecting state from State dropdown and verifying result

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Dropdowns {
    WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void selectState() {

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia
        stateDropdown.selectByValue("VA");

        //5. Select California
        stateDropdown.selectByIndex(5);

        //6. Verify final selected option is California.
        String expectedOptionText = "California";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOptionText, expectedOptionText);

    }

}
