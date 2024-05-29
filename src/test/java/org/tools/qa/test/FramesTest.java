package org.tools.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FramesTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://demoqa.com/frames";
    }
    @Test
    public void test() {
        driver.get(baseURL);

        //Switch to Frame 1
        driver.switchTo().frame("frame1");
        driver.findElement(By.id("sampleHeading")).isDisplayed();
        driver.switchTo().defaultContent();
    }
    @AfterTest
    public void aftertest() {
        driver.quit();
    }



}
