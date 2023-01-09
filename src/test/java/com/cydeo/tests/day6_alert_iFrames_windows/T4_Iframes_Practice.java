package com.cydeo.tests.day6_alert_iFrames_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_Iframes_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {

        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }

    //@Ignore
    @Test
    public void iFrameTest() {

        // We need to switch driver focus to iframe (from outer HTML to inner HTML)

        // WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        // driver.switchTo().frame(iframeElement);
        driver.switchTo().frame("mce_0_ifr");

        //Locate the p tag
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));
        //4. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(yourContentGoesHereText.isDisplayed());

        // We need to switch back to outer HTML from inner HTML (from inner HTML to outer HTML)
        driver.switchTo().parentFrame();

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        WebElement headerText = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(headerText.isDisplayed());


    }
}
