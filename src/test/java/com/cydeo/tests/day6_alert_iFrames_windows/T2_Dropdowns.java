package com.cydeo.tests.day6_alert_iFrames_windows;

//TC #6: Selecting date on dropdown and verifying

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

public class T2_Dropdowns {

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
    public void tearDownMethod() {
        driver.close();
    }

    @Test
    public void selectDate() {

        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //3. Select “December 1st, 1924” and verify it is selected.
        //Select year using  : visible text
        yearDropdown.selectByVisibleText("1924");
        //Select month using   : value attribute
        monthDropdown.selectByValue("11");
        //Select day using : index number
        dayDropdown.selectByIndex(0);

        String expectedYear = "1924";
        String expectedMonth = "December";
        String expectedDay = "1";

        // getting actual values from browser
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYear, expectedYear, "Year is not matching. FAILED!!!");
        Assert.assertEquals(actualMonth, expectedMonth, "Month is not matching. FAILED!!!");
        Assert.assertEquals(actualDay, expectedDay, "Day is not matching. FAILED!!!");

    }
}
