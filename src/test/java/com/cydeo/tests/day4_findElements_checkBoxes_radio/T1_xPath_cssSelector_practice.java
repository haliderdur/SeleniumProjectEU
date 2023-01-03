package com.cydeo.tests.day4_findElements_checkBoxes_radio;

//TC #1: XPATH and cssSelector Practices

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class T1_xPath_cssSelector_practice {

    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link
        //b. “Forgot password” header
        //c. “E-mail” text
        //d. E-mail input box
        //e. “Retrieve password” button
        //f. “Powered by Cydeo text

        //4. Verify all web elements are displayed.


    }
}
