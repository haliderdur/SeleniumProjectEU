package com.cydeo.tests.day3_cssSelector_xpath;

//TC #2: NextBaseCRM, locators, getText(), getAttribute() practice

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {

    public static void main(String[] args) {

        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));
        String actualRememberMeLabel = rememberMeLabel.getText();
        String expectedRememberMeLabel = "Remember me on this computer";

        if (actualRememberMeLabel.equals(expectedRememberMeLabel)) {
            System.out.println("\"Remember me\" label verification PASSED!");
        } else {
            System.out.println("actualRememberMeLabel = " + actualRememberMeLabel);
            System.out.println("expectedRememberMeLabel = " + expectedRememberMeLabel);

            System.out.println("\"Remember me\" label verification FAILED!!!");
        }

        System.out.println();

        //4- Verify “forgot password” link text is as expected:
        //Expected: FORGOT YOUR PASSWORD?
        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        String actualForgotPasswordLinkText = forgotPasswordLink.getText();
        String expectedForgotPasswordLinkText = "FORGOT YOUR PASSWORD?";

        if (actualForgotPasswordLinkText.equals(expectedForgotPasswordLinkText)) {
            System.out.println("\"Forgot Your Password\" link text verification PASSED!");
        } else {
            System.out.println("\"Forgot Your Password\" link text verification FAILED!!!");
            System.out.println("actualForgotPasswordLinkText = " + actualForgotPasswordLinkText);
            System.out.println("expectedForgotPasswordLinkText = " + expectedForgotPasswordLinkText);
        }

        System.out.println();

        //5- Verify “forgot password” href attribute
        // Expected: Forgot_password?
        String actualForgotPasswordHrefAttValue = forgotPasswordLink.getAttribute("href");
        String expectedForgotPasswordHrefAttValue = "Forgot_password=yes";

        if (actualForgotPasswordHrefAttValue.equals(expectedForgotPasswordHrefAttValue)) {
            System.out.println("\"Forgot Password attribute\" verification PASSED!");
        } else {
            System.out.println("\"Forgot Password href attribute\" verification FAILED!!!");
            System.out.println("actualForgotPasswordHrefAttValue = " + actualForgotPasswordHrefAttValue);
            System.out.println("expectedForgotPasswordHrefAttValue = " + expectedForgotPasswordHrefAttValue);
        }

        driver.close();
    }
}
































