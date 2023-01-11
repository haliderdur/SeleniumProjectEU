package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTableUtils {

    /*
    • Return type: String
    • Arg1: WebDriver driver
    • Arg2: String costumerName
    This method should accept a costumerName and return the costumer order date
    as a String.
     */
    public static String returnOrderDate(WebDriver driver, String costumerName) {

        String locator = "//td[.='" + costumerName + "']/following-sibling::td[3]";

        WebElement customerDateCell = driver.findElement(By.xpath(locator));

        return customerDateCell.getText();
    }


}
