package com.cydeo.tests.extraPractices;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsHandling_W3Schools {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void windowHandle_Test() {

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
        System.out.println(driver.getTitle());

        WebElement acceptCookies = driver.findElement(By.id("accept-choices"));
        acceptCookies.click();

        //2. Get the current window’s handle and write to the console window. It must be the first window handle.
        String firstWindow = driver.getWindowHandle();

        // Switch to iFrame
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame(iframe);

        //3. Locate the “Visit W3Schools.com!” link and click it.
        WebElement visitW3SchoolsLink = driver.findElement(By.xpath("//a[.='Visit W3Schools.com!']"));
        visitW3SchoolsLink.click();

        //4. Get all window handles and hold them in a list.
        Set<String> allWindows = driver.getWindowHandles();
        System.out.println("allWindows = " + allWindows);

        //5. Write to total window handle number to the console. It must be 2.
        System.out.println("Number of Windows = " + allWindows.size());

        //6. Switch to the second window.
        for (String eachWindow : allWindows) {
            driver.switchTo().window(eachWindow);
        }

        //7. Get the current window’s handle and write to the console window. It must be a second window handle.
        System.out.println("Second Window Handle = " + driver.getWindowHandle());

        //8. Check the upper left side logo in the second window.
        WebElement logo = driver.findElement(By.xpath("//i[@class='fa fa-logo']"));
        Assert.assertTrue(logo.isDisplayed());


        //9. Go back (Switch) to the first window.
        Iterator<String> it = allWindows.iterator();
        while (it.hasNext()) {
            String secondWindow = it.next();

            if (!firstWindow.equals(secondWindow)) {
                driver.switchTo().window(firstWindow);
            }
        }

        //10.Get the current window’s handle
        //11. write to the console window. It must be the first window handle.
        System.out.println("First Window Handle = " + driver.getWindowHandle());

        // Check the See Run Button Text. It must contain “Run >” text.
        WebElement runButton = driver.findElement(By.xpath("//button[.='Run ❯']"));
        String runButtonText = runButton.getText();
        Assert.assertTrue(runButtonText.contains("Run ❯"));
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
}
