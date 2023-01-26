package com.cydeo.tests.extraPractices;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class T1_SmartBear_softwarelink_verif {

    @Test
    public void smartbearLink_test() {

        //TC #1: Smartbear software link verification
        //1. Open browser
        //2. Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        WebElement userNameInput = Driver.getDriver().findElement(By.name("ctl00$MainContent$username"));
        WebElement passwordInput = Driver.getDriver().findElement(By.name("ctl00$MainContent$password"));
        WebElement loginBtn = Driver.getDriver().findElement(By.name("ctl00$MainContent$login_button"));

        //3. Enter username: “Tester”
        userNameInput.sendKeys("Tester");
        //4. Enter password: “test”
        passwordInput.sendKeys("test");

        //5. Click to Login button
        loginBtn.click();

        //6. Print out count of all the links on landing page
        List<WebElement> allLinks = new ArrayList<>();
        allLinks.addAll(Driver.getDriver().findElements(By.tagName("a")));

        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getAttribute("href"));
        }

        //7. Print out each link text on this page
        for (WebElement eachLinkText : allLinks) {
            System.out.println(eachLinkText.getText());
        }
        System.out.println("Total Links = " + allLinks.size());

        ////////////////////////////////////////////

        try {

            List<WebElement> editBtns = new ArrayList<>();

            for (int i = 2; i <= 9; i++) {

                editBtns.addAll(Driver.getDriver().findElements(By.xpath("//table[@class='SampleTable']//tr[" + i + "]//td[13]")));


                for (WebElement eachEditBtn : editBtns) {
                    BrowserUtils.sleep(1);
                    eachEditBtn.click();

                    WebElement productDropdown = Driver.getDriver().findElement(By.name("ctl00$MainContent$fmwOrder$ddlProduct"));
                    // WebElement productFamilyAlbum = Driver.getDriver().findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']//option[.='FamilyAlbum']"));

                    Select obj = new Select(productDropdown);
                    obj.selectByVisibleText("FamilyAlbum");

                    Faker faker = new Faker();

                    WebElement inputQuantity = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
                    inputQuantity.clear();
                    int quantity = faker.number().numberBetween(1, 20);
                    inputQuantity.sendKeys("" + quantity);

                    WebElement inputPricePerUnit = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtUnitPrice']"));
                    inputPricePerUnit.clear();
                    int price = 50;
                    inputPricePerUnit.sendKeys("" + price);


                    WebElement inputDiscount = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtDiscount']"));
                    inputDiscount.clear();
                    int discountAmount = 0;

                    if (quantity >= 5 && quantity < 10) {
                        discountAmount = (price * 10) / 100;
                    } else if (quantity >= 10) {
                        discountAmount = (price * 25) / 100;
                    } else {
                        discountAmount = 0;
                    }
                    inputDiscount.sendKeys("" + discountAmount);


                    WebElement inputTotal = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtTotal']"));
                    inputTotal.clear();
                    int totalPrice;

                    if (discountAmount == 0) {
                        totalPrice = price;
                    } else {
                        totalPrice = ((quantity * price) * (100 - discountAmount)) / 100;
                    }
                    inputTotal.sendKeys("" + totalPrice);


                    WebElement inputCxName = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
                    inputCxName.clear();
                    String customerName = faker.name().fullName();
                    inputCxName.sendKeys(customerName);

                    WebElement inputStreet = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
                    inputStreet.clear();
                    String street = faker.address().streetAddress();
                    inputStreet.sendKeys(street);

                    WebElement inputCity = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
                    inputCity.clear();
                    String city = faker.address().cityName();
                    inputCity.sendKeys(city);

                    WebElement inputState = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
                    inputState.clear();
                    String state = faker.address().state();
                    inputState.sendKeys(state);

                    WebElement inputZipCode = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
                    inputZipCode.clear();
                    String zipCode = faker.address().zipCode().replaceAll("-", "");
                    inputZipCode.sendKeys(zipCode);

                    WebElement americanExpRadioBtn = Driver.getDriver().findElement(By.xpath("//input[@value='American Express']"));
                    americanExpRadioBtn.click();

                    WebElement inputCredirtCard = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
                    inputCredirtCard.clear();
                    String creditCardNumber = faker.finance().creditCard(CreditCardType.AMERICAN_EXPRESS).replaceAll("-", "");
                    inputCredirtCard.sendKeys(creditCardNumber);


                    WebElement inputExpireDate = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
                    inputExpireDate.clear();
                    String expireDateMonth = "" + faker.number().numberBetween(1, 12);
                    String expireDateYear = "" + faker.number().numberBetween(LocalDate.now().getYear() + 1, LocalDate.now().getYear() + 6);

                    if (!(expireDateMonth.equals("10") || expireDateMonth.equals("11") || expireDateMonth.equals("12"))) {
                        expireDateMonth = 0 + "" + expireDateMonth;
                    }

                    inputExpireDate.sendKeys(expireDateMonth + "/" + expireDateYear.substring(2, 4));
                    BrowserUtils.sleep(1);

                    WebElement updateBtn = Driver.getDriver().findElement(By.xpath("//a[.='Update']"));
                    updateBtn.click();


                    BrowserUtils.sleep(2);

/*
                Alert alert = Driver.getDriver().switchTo().alert();
                alert.dismiss();
                NOT WORKING
*/


/*
                Actions action = new Actions(Driver.getDriver());
                action.sendKeys(Keys.ESCAPE).build().perform();
                String cancel = Keys.ESCAPE.toString();
                alert.sendKeys(cancel);
                NOT WORKING
*/

/*
                WebElement body = Driver.getDriver().findElement(By.tagName("body"));
                body.sendKeys(Keys.ESCAPE);
                NOT WORKING

 */

/*
                Alert alert = Driver.getDriver().switchTo().alert();
                Robot r = new Robot();
                r.keyPress(KeyEvent.VK_ESCAPE);
                r.keyRelease(KeyEvent.VK_ESCAPE);
                NOT WORKING

 */


                }
                // editBtn.click();

            }
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }
}
