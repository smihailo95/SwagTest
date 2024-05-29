package org.tools.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class MenuTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://demoqa.com/menu";
    }
    @Test
    public void test() throws InterruptedException {
        driver.get(baseURL);
        //Mouse Over
        Actions actions = new Actions(driver);
        WebElement menu2 = driver.findElement(By.xpath("//a[contains(text(),'Main Item 2')]"));
        actions.moveToElement(menu2);
        Thread.sleep(5000);
        WebElement Sublist = driver.findElement(By.xpath("//a[contains(text(),'SUB SUB LIST »')]"));
        actions.moveToElement(Sublist).moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Sub Sub Item 1')]"))).click().build().perform();



    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }


}
