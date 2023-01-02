package com.cydeo.tests.day3_cssSelector_xpath;

// TC #1: NextBaseCRM, locators and getText() practice

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_locators_getText {

    public static void main(String[] args) {

        // 1- Open a chrome browser

        // WebDriverManager.chromedriver().setup();
        // ChromeDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        // 3- Enter incorrect username: “incorrect”
        WebElement inputusername = driver.findElement(By.className("login-inp"));
        inputusername.sendKeys("incorrect@test.com");

        // 4- Enter incorrect password: “incorrect”
        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("incorrectPassword");

        // 5- Click to login button.
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        // 6- Verify error message text is as expected:
        // Expected: Incorrect login or password
        WebElement errorMessage = driver.findElement(By.className("errortext"));

        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = errorMessage.getText();

        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Error message verification PASSED!");
        } else {
            System.out.println("Error message verification FAILED!!!");
        }

        driver.close();


    }
}
