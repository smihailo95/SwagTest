package swag.lab.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

    public class CheckOutTest {
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
        public void chechOut() {
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
            //Click on Add to cart
            driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
            //Click on Shopping Bag
            driver.findElement(By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]")).click();
            //Check is Product in Bag
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/a[1]/div[1]")).isDisplayed();
            //Click on Checkout
            driver.findElement(By.id("checkout")).click();
            //Click on First Name Field
            driver.findElement(By.id("first-name")).click();
            //Enter Valid First Name
            driver.findElement(By.id("first-name")).sendKeys("Mihailo");
            //Click on Last Name Field
            driver.findElement(By.id("last-name")).click();
            //Enter Valid Last Name
            driver.findElement(By.id("last-name")).sendKeys("Stojanovic");
            //Click on Zip Postal Code
            driver.findElement(By.id("postal-code")).click();
            //Enter Valid Zip Postal Code
            driver.findElement(By.id("postal-code")).sendKeys("Arandjelovac");
            //Click on Continue
            driver.findElement(By.id("continue")).click();
            //Click on Finish
            driver.findElement(By.id("finish")).click();
            //Check if the Text appers
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/h2[1]")).isDisplayed();
            //Click on Back Home
            driver.findElement(By.id("back-to-products")).click();
            //Check is on Product page
            driver.findElement(By.xpath("//span[contains(text(),'Products')]")).isDisplayed();
            //Click on Menu
            driver.findElement(By.id("react-burger-menu-btn")).click();
            //Click Log Out
            driver.findElement(By.id("logout_sidebar_link")).click();
        }
        @AfterTest
        public void afterTest(){
            driver.quit();
        }
    }
