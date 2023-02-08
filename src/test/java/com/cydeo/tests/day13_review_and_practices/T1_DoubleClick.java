package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DoubleClickPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.Style;

public class T1_DoubleClick {

    @Test
    public void t1_doubleClick_test() {
        //TC #1: Double Click Test
        //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        // create the page object
        DoubleClickPage doubleClickPage = new DoubleClickPage();

        // accept cookies
        doubleClickPage.acceptCookies.click();

        //2. Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult");

        //3. Double click on the text “Double-click me to change my text color.”
        Actions action = new Actions(Driver.getDriver());
        action.doubleClick(doubleClickPage.textToDoubleClick).perform();

        //4. Assert: Text’s “style” attribute value contains “red”.
        String actualStyleAttributeValue = doubleClickPage.textToDoubleClick.getAttribute("Style");
        String expectedStyleAttributeValue = "red";
        Assert.assertTrue(actualStyleAttributeValue.contains(expectedStyleAttributeValue));
    }
}
