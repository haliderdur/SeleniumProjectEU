package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class T1_Registration_Form {

    @Test
    public void registration_form_Test() {
        //TC#1: Registration form confirmation
        //Note: Use JavaFaker OR read from configuration.properties file when possible.
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        Faker faker = new Faker();

        //3. Enter first name
        WebElement firstNameInputBox = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        String firstName = faker.name().firstName();
        firstNameInputBox.sendKeys(firstName);

        //4. Enter last name
        WebElement lastNameInputBox = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        String lastName = faker.name().lastName();
        lastNameInputBox.sendKeys(lastName);

        //5. Enter username
        WebElement userNameInputBox = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        // String userName = faker.name().username().replaceAll(".","");
        String userName = faker.bothify(firstName.substring(1)+lastName.substring(1)+"####");
        userNameInputBox.sendKeys(userName);

        //6. Enter email address
        WebElement emailInputBox = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        emailInputBox.sendKeys(userName+"@email.com");

        //7. Enter password
        WebElement passwordInputBox = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        String password = faker.internet().password();
        passwordInputBox.sendKeys(password);

        //8. Enter phone number
        WebElement phoneInputBox = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        String phone = faker.numerify("###-###-####");
        phoneInputBox.sendKeys(phone);

        //9. Select a gender from radio buttons
        WebElement maleRadioBtn = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        maleRadioBtn.click();

        //10. Enter date of birth
        WebElement birthdayInputBox = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        int day = faker.number().numberBetween(1,31);
        int month = faker.number().numberBetween(1,12);
        int year = faker.number().numberBetween(1910,2004);
        String birthday = faker.numerify(month+"/"+day+"/"+year);
        birthdayInputBox.sendKeys(birthday);

        //11. Select Department/Office
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1,10));


        //12. Select Job Title
        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitleDropdown.selectByIndex(faker.number().numberBetween(1,8));

        //13. Select programming language from checkboxes
        WebElement javaCheckBox = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        javaCheckBox.click();

        //14. Click to sign up button
        WebElement signupBtn = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        signupBtn.click();

        //15. Verify success message “You’ve successfully completed registration.” is displayed.
        String signedUpWindow = Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().window(signedUpWindow);

        WebElement successText = Driver.getDriver().findElement(By.tagName("p"));
        Assert.assertTrue(successText.isDisplayed());

    }

    @AfterMethod
    public void tearDownMethod(){
        Driver.getDriver().quit();
    }
}
