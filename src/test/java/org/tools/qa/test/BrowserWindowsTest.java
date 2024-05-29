package org.tools.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://demoqa.com/browser-windows";
    }
    @Test
    public void test() {

        driver.get(baseURL);

        //Click on New Tab Button
        driver.findElement(By.id("tabButton")).click();
        //Tab List
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        //Switch to new Tab
        driver.switchTo().window(browserTabs.get(1));
        //Check is it correct Page
        String myURL = driver.getCurrentUrl();
        System.out.println(myURL);

        Assert.assertNotEquals(myURL, baseURL);
        driver.findElement(By.xpath("/html[1]/body[1]/h1[1]"));
        //Close Tabs
        driver.close();
        driver.switchTo().window(browserTabs.get(0));

        //Click on New Tab Button
        driver.findElement(By.id("windowButton")).click();
        //Tab List
        List<String> browserWindows = new ArrayList<>(driver.getWindowHandles());
        //Switch to new Tab
        driver.switchTo().window(browserWindows.get(1));
        //Check is it correct Page
        String myURL2 = driver.getCurrentUrl();
        System.out.println(myURL2);

        Assert.assertNotEquals(myURL2, baseURL);
        driver.findElement(By.xpath("/html[1]/body[1]/h1[1]"));
        //Close Tabs
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
