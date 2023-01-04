package com.cydeo.tests.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class T5_errorTextVerification {

    public static void main(String[] args) {

        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Enter incorrect username into login box:
        WebElement loginInputBox = driver.findElement(By.cssSelector("input[name='USER_LOGIN']"));
        loginInputBox.sendKeys("incorrectUsername");

        //4- Click to `Reset password` button
        WebElement ResetPasswordButton = driver.findElement(By.xpath("//button[@value='Reset password']"));
        ResetPasswordButton.click();

        //5- Verify “error” label is as expected
        //Expected: Login or E-mail not found
        WebElement errorText = driver.findElement(By.className("errortext"));

        String actualErrorText = errorText.getText();
        String expectedErrorText = "Login or E-mail not found";

        if (actualErrorText.equalsIgnoreCase(expectedErrorText)) {
            System.out.println("Error Text verification PASSED!");
        } else {
            System.out.println("Error Text verification FAILED!!!");
        }

        driver.close();


    }

}
