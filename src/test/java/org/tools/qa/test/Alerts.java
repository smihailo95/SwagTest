package org.tools.qa.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://demoqa.com/alerts";

    }
    @Test
    public void test() throws InterruptedException {

        driver.get(baseURL);
        //Alert Button
        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        //Secund Button Alert
        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        //Confirm Alert
        driver.findElement(By.id("confirmButton")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmResult")).isDisplayed();
        //Prompt Alert
        driver.findElement(By.id("promtButton")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();

        //Print Message from Alert
        driver.findElement(By.id("promtButton")).click();
        String myText = driver.switchTo().alert().getText();
        System.out.println(myText);
        //Enter Text
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("text");
        alert.accept();
        Thread.sleep(3000);
        driver.findElement(By.id("promptResult")).isDisplayed();
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }



}
