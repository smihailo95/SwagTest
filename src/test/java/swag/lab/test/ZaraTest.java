package swag.lab.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ZaraTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://www.zara.com/rs/en/";
    }
    @Test
    public void zara() {
        driver.get(baseURL);
        //Check Start Page
        driver.findElement(By.xpath("//header/div[1]/div[1]/h1[1]/a[1]/*[1]")).isDisplayed();
        //Click on Log in button
        driver.findElement(By.xpath("//span[contains(text(),'LOG IN')]")).click();
        //Check Log in page
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/main[1]/article[1]/div[1]/div[2]/div[1]/div[1]/section[1]/h2[1]/span[1]")).isDisplayed();
        //Click on E-mail Field






    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }



}
