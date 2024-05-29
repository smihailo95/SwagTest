package org.tools.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SliderTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://demoqa.com/slider";
    }
    @Test
    public void test() throws InterruptedException {
        driver.get(baseURL);
        String sliderValue = driver.findElement(By.id("sliderValue")).getAttribute("value");
        System.out.println("First Value");

        //Web element
        WebElement slider = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/span[1]/input[1]"));
        //Creating Object for Action class
        Actions action = new Actions(driver);
        //Move slider by 300 pixels offset using dragAndDropBy method
        action.dragAndDropBy(slider, 300, 0).build().perform();
        Thread.sleep(5000);

        String secondSliderValue = driver.findElement(By.id("sliderValue")).getAttribute("value");
        System.out.println("Second Result" + secondSliderValue);
        Assert.assertNotEquals(sliderValue, secondSliderValue);
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
