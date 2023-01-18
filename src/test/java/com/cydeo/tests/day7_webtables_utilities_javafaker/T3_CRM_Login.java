package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CRM_Login extends TestBase {


    @BeforeMethod
    public void setupMethod() {
        //1. Create new test and make set ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @Test
    public void crm_login_test() {
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        /*
        Credentials:
            helpdesk1@cybertekschool.com  UserUser
            Helpdesk2@cybertekschool.com  UserUser
         */

        //3. Enter valid username
        WebElement inputUserName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUserName.sendKeys("helpdesk1@cybertekschool.com");

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //6. Verify title is as expected:
        //Expected: My tasks
        BrowserUtils.verifyTitle(driver, "My tasks");
    }

    @Test
    public void crm_login_test_2() {
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        // Calling utility method to login helpdesk1
        CRM_Utilities.crm_login(driver);

        //6. Verify title is as expected:
        //Expected: My tasks
        BrowserUtils.verifyTitle(driver, "My tasks");
    }

    @Test
    public void crm_login_test_3() {
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        // Calling utility method to login helpdesk2
        CRM_Utilities.crm_login(driver, "helpdesk2@cybertekschool.com", "UserUser");

        BrowserUtils.sleep(1);
        //6. Verify title is as expected:
        //Expected: (1) Portal
        BrowserUtils.verifyTitle(driver, "(1) Portal");
    }
}
