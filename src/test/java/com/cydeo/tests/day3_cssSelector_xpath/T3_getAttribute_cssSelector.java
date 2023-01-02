package com.cydeo.tests.day3_cssSelector_xpath;

//TC #3: NextBaseCRM, locators, getText(), getAttribute() practice

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_cssSelector {

    public static void main(String[] args) {

        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        // WebElement loginButton = driver.findElement(By.className("login-btn"));

        // WebElement loginButton = driver.findElement(By.cssSelector("input[class='login-btn']"));   //  Located using class attribute
        // WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));       //  Located using tyoe attribute
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log In']"));         //  Located using value attribute

        // Getting the value of the attribute "value"
        String actualLoginButtonText = loginButton.getAttribute("value");
        String expectedLoginButtonText = "Log In";

        if (actualLoginButtonText.equals(expectedLoginButtonText)) {
            System.out.println("Login Button text verification PASSED!");
        } else {
            System.out.println("actualLoginButtonText = " + actualLoginButtonText);
            System.out.println("expectedLoginButtonText = " + expectedLoginButtonText);

            System.out.println("Login Button text verification FAILED!!!");
        }

        driver.close();


    }
}
