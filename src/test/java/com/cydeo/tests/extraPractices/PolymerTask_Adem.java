package com.cydeo.tests.extraPractices;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PolymerTask_Adem extends TestBase {

    @Test
    public void doubleCLickTest() throws InterruptedException {
        driver.get("https://todomvc.com/");

        // Click within the javascript tab
        WebElement clickJS = driver.findElement(By.xpath("//div[.='JavaScript']"));
        clickJS.click();

        //Select polymer link
        WebElement polymerLink = driver.findElement(By.xpath("//a[.='Polymer']"));
        polymerLink.click();

        // Add two things item
        WebElement firstTodo = driver.findElement(By.id("new-todo"));
        firstTodo.sendKeys("Don't forget to watch all the recordings" + Keys.ENTER);


        WebElement secondTodo = driver.findElement(By.id("new-todo"));
        secondTodo.sendKeys("Watch also shorts" + Keys.ENTER);

        // Edit second item
        Actions actions = new Actions(driver);
        WebElement edit = driver.findElement(By.xpath("//label[.='Watch also shorts']"));
        actions.doubleClick(edit).perform();


        // Select all the text by CONTROL+A
        actions.keyDown(Keys.CONTROL).sendKeys(String.valueOf('a')).perform();

        Thread.sleep(3000);

        // Edit the text of second item
        actions.keyUp(Keys.CONTROL).sendKeys("Don't forget to watch shorts also" + Keys.ENTER).perform();

        driver.quit();


    }

}

