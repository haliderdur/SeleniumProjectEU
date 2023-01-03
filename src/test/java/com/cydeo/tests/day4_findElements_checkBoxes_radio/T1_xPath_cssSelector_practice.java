package com.cydeo.tests.day4_findElements_checkBoxes_radio;

//TC #1: XPATH and cssSelector Practices

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        // Locate homeLink using cssSelector, class value syntax #1
        WebElement homeLink_ex1 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        // Locate homeLink using cssSelector syntax #2
        WebElement homeLink_ex2 = driver.findElement(By.cssSelector("a.nav-link"));
        // Locate only using cssSelector, href value
        WebElement homeLink_ex3 = driver.findElement(By.cssSelector("a[href='/']"));


        //b. “Forgot password” header
        // Locate header using cssSelector: Locate parent element and move down to h2
        WebElement header_ex1 = driver.findElement(By.cssSelector("div.example>h2"));
        // Locate header using xpath, and using web elements text 'Forgot Password'
        WebElement header_ex2 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        // instead of using text(), we can use '.' in xpath expression
        WebElement header_ex3 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));


        //c. “E-mail” text
        // Locate email label using with xpath
        WebElement emailLabel_ex1 = driver.findElement(By.xpath("//label[@for='email']"));


        //d. E-mail input box
        WebElement inputBox_ex1 = driver.findElement(By.xpath("//label[@for='email']"));
        // Locate input box using xpath contains method / tagName[contains(@attribute,'value')]
        WebElement inputBox_ex2 = driver.findElement(By.xpath("//input[contains(@pattern,'a-z0-')]"));


        //e. “Retrieve password” button
        // Locate button using cssSelector, class and id values
        WebElement retrievePasswordButton_ex1 = driver.findElement(By.cssSelector("button[class='radius']"));  // button.radius
        WebElement retrievePasswordButton_ex2 = driver.findElement(By.cssSelector("button[id='form_submit']"));// button#form_submit
        // Locate button using xpath
        WebElement retrievePasswordButton_ex3 = driver.findElement(By.xpath("//button[@id='form_submit']"));
        WebElement retrievePasswordButton_ex4 = driver.findElement(By.xpath("//button[@class='radius']"));
        WebElement retrievePasswordButton_ex5 = driver.findElement(By.xpath("//button[@type='submit']"));


        //f. “Powered by Cydeo text
        WebElement poweredByCydeoText_ex1 = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        WebElement poweredByCydeoText_ex2 = driver.findElement(By.cssSelector("div[style='text-align: center;']"));

        //4. Verify all web elements are displayed.
        System.out.println("homeLink_ex2.isDisplayed() = " + homeLink_ex2.isDisplayed());
        System.out.println("header_ex1.isDisplayed() = " + header_ex1.isDisplayed());
        System.out.println("emailLabel_ex1.isDisplayed() = " + emailLabel_ex1.isDisplayed());
        System.out.println("inputBox_ex2.isDisplayed() = " + inputBox_ex2.isDisplayed());
        System.out.println("retrievePasswordButton_ex4.isDisplayed() = " + retrievePasswordButton_ex4.isDisplayed());
        System.out.println("poweredByCydeoText_ex1.isDisplayed() = " + poweredByCydeoText_ex1.isDisplayed());

        driver.close();
    }
}
