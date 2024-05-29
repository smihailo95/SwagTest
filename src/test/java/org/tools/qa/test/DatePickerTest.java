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

public class DatePickerTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://demoqa.com/date-picker";
    }
    @Test
    public void test() {
        driver.get(baseURL);
        //Click on Select date
        driver.findElement(By.id("datePickerMonthYearInput")).click();
        //Select December
        driver.findElement(By.xpath("//option[contains(text(),'December')]")).click();
        //Select Year
        driver.findElement(By.xpath("//option[contains(text(),'1995')]")).click();
        //Select Day
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[3]/div[4]")).click();

        String myDateSelected = driver.findElement(By.id("datePickerMonthYearInput")).getAttribute("value");
        System.out.println();

        String myDate = "13/12/1995";
        Assert.assertNotEquals(myDateSelected, myDate);



    }
    @AfterTest
    public void aftertest() {
        driver.quit();
    }





}
