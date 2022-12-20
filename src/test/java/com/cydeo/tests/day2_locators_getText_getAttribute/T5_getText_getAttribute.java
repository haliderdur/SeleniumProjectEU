package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #5: getText() and getAttribute() method practice
    1- Open a chrome browser
    2- Go to: https://practice.cydeo.com/registration_form
    3- Verify header text is as expected:
        Expected: Registration form
    4- Locate “First name” input box
    5- Verify placeholder attribute’s value is as expected:
        Expected: first name
 */
public class T5_getText_getAttribute {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/registration_form ");

        String expectedHeaderText = "Registration form";
        WebElement headerText = driver.findElement(By.tagName("h2"));
        String actualHeaderText = headerText.getText();

        if (actualHeaderText.equals(expectedHeaderText)) {
            System.out.println("Header text test PASS!");
        } else {
            System.out.println("Header text test FAILED!!!");
        }


        String expectedFirstNamePlaceHolderAttribute = "first name";
        WebElement FirstNamePlaceHolderAttribute = driver.findElement(By.name("firstname"));
        String actualFirstNamePlaceHolderAttribute = FirstNamePlaceHolderAttribute.getAttribute("placeholder");

        if (actualFirstNamePlaceHolderAttribute.equals(expectedFirstNamePlaceHolderAttribute)) {
            System.out.println("Place Holder Attribute test PASS!");
        } else {
            System.out.println("Place Holder Attribute test FAILED!!!");
        }

        driver.close();

    }
}
