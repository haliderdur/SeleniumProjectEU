package com.cydeo.tests.day6_alert_iFrames_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class T6_DataProvider {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://google.com");

        WebElement rejectCookies = driver.findElement(By.id("W0wltc")); // to bypass cookies preference pop-up / accept or reject
        rejectCookies.sendKeys(Keys.ENTER);

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @Test(dataProvider = "searchData")
    public void searchMethod(String searchKeyword, String expectedTitle) {
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        searchBox.sendKeys(searchKeyword + Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), expectedTitle);

    }

    @DataProvider(name = "searchData")
    public Object[][] testData() {
        return new Object[][]{
                {"selenium", "selenium - Google Search"},
                {"java", "java - Google Search"},
                {"cydeo", "cydeo - Google Search"},
                {"SDET", "SDET - Google Search"},
        };
    }

}
