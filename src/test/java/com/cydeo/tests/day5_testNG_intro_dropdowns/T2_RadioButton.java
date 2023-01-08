package com.cydeo.tests.day5_testNG_intro_dropdowns;

//TC #2: Radiobutton handling


import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_RadioButton {
    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //3. Click to “Hockey” radio button
        WebElement hockeyBtn = driver.findElement(By.xpath("//input[@id='hockey']"));

        //4. Verify “Hockey” radio button is selected after clicking.
        hockeyBtn.click();

        if (hockeyBtn.isSelected()) {
            System.out.println("\"Hockey radio button\" is selected. PASSED!");
        } else {
            System.out.println("\"Hockey radio button\" is NOT selected. FAILED!!!");
        }

        driver.close();


    }
}
