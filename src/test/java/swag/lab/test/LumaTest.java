package swag.lab.test;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LumaTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://magento.softwaretestingboard.com/";
}
    @Test
    public void luma() {
        driver.get(baseURL);
        //Check Luma Start Page
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/header[1]/div[2]/a[1]/img[1]")).isDisplayed();
        //Click on Create an Account
        driver.findElement(By.xpath("//body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();
        //Check Sing In Page
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/h1[1]/span[1]")).isDisplayed();
        //Click on First Name in Field
        driver.findElement(By.id("firstname")).click();
        //Enter Valid First in Name
        driver.findElement(By.id("firstname")).sendKeys("Mihailo");
        //Click on Last Name in Field
        driver.findElement(By.id("lastname")).click();
        //Enter Valid Last Name in Field
        driver.findElement(By.id("lastname")).sendKeys("Stojanovic");
        //Click on E-mail Field
        driver.findElement(By.id("email_address")).click();

        String prefix = "MyTestEmail_";
        String myMail = prefix +
                RandomStringUtils.randomAlphanumeric(9).toLowerCase();

        //Enter Valid E-mail addres
        driver.findElement(By.id("email_address")).sendKeys(myMail + "@yopmail.com");
        //Click on Password Field
        driver.findElement(By.id("password")).click();
        //Enter Valid Password in Field
        driver.findElement(By.id("password")).sendKeys("Testiranje99899");
        //Click on Confirm Password
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/fieldset[2]/div[3]/div[1]/input[1]")).click();
        //Enter Valid Confirm Password
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/fieldset[2]/div[3]/div[1]/input[1]")).sendKeys("Testiranje99899");
        //Click on Create Account
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]/span[1]")).click();
        //Check My Account page
        driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).isDisplayed();






    }

    @AfterTest
    public void afterTest() {
    driver.quit();}
}
