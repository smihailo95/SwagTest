package swag.lab.test;

import org.openqa.selenium.By;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class LogInTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://www.saucedemo.com/";
    }
    @Test
    public void validLogin() {
        driver.get(baseURL);
        //Click Username Field
        driver.findElement(By.id("user-name")).click();
        //Enter Valid Username in Field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Click Password Field
        driver.findElement(By.id("password")).click();
        //Enter Valid Password in Field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on LogIn Button
        driver.findElement(By.id("login-button")).click();
        //Verify ur Product appers
        driver.findElement(By.xpath("//span[contains(text(),'Products')]")).isDisplayed();
    }
    @AfterTest
    public  void afterTest() {
        driver.quit();
    }



}
