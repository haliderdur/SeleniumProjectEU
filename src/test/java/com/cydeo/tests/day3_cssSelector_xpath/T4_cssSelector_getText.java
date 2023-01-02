package com.cydeo.tests.day3_cssSelector_xpath;

//TC #4: NextBaseCRM, locators, getText(), getAttribute() practice

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {

    public static void main(String[] args) {

        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Verify “Reset password” button text is as expected:
        //Expected: Reset password
        // WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[class='login-btn']"));    // Located using class attribute
        WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[value='Reset password']"));  // Located using value attribute

        String actualResetPasswordButtonText = resetPasswordButton.getText();
        String expectedResetPasswordButtonText = "Reset password";

        if (actualResetPasswordButtonText.equals(expectedResetPasswordButtonText)) {
            System.out.println("Reset Password button text verification PASSED!");
        } else {
            System.out.println("actualResetPasswordButtonText = " + actualResetPasswordButtonText);
            System.out.println("expectedResetPasswordButtonText = " + expectedResetPasswordButtonText);

            System.out.println("Reset Password button text verification FAILED!!!");
        }

        driver.close();


    }
}
