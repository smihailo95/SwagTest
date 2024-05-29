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

public class ParaBankTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://parabank.parasoft.com/parabank/index.htm";
}
    @Test
    public void paraBank() {
        driver.get(baseURL);
        //Verify Start Page
        driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='topPanel']/a[2]/img[1]")).isDisplayed();
        //Click on Register
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        //Check us Sing In Page
        driver.findElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]")).isDisplayed();
        //Click on First Name Field
        driver.findElement(By.id("customer.firstName")).click();
        //Enter First Name
        driver.findElement(By.id("customer.firstName")).sendKeys("Petar");
        //Click od Last Name Field
        driver.findElement(By.id("customer.lastName")).click();
        //Enter Last Name Field
        driver.findElement(By.id("customer.lastName")).sendKeys("Petrovic");
        //Click on Address Field
        driver.findElement(By.id("customer.address.street")).click();

        String prefix = "MyTestEmail_";
        String myMail = prefix +
                RandomStringUtils.randomAlphanumeric(9).toLowerCase();

        //Enter Address Field
        driver.findElement(By.id("customer.address.street")).sendKeys(myMail + "@yopmail.com");
        //Click on City Field
        driver.findElement(By.id("customer.address.city")).click();
        //Enter City Field
        driver.findElement(By.id("customer.address.city")).sendKeys("Krusevac");
        //Click on State Field
        driver.findElement(By.id("customer.address.state")).click();
        //Enter State Field
        driver.findElement(By.id("customer.address.state")).sendKeys("Srbija");
        //Click Zip Code Field
        driver.findElement(By.id("customer.address.zipCode")).click();
        //Enter Zip Code Field
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("34300");
        //Click Phone # Field
        driver.findElement(By.id("customer.phoneNumber")).click();
        //Enter Phone # Field
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("0651234567");
        //Click on SSN Field
        driver.findElement(By.id("customer.ssn")).click();
        //Enter SSN Field
        driver.findElement(By.id("customer.ssn")).sendKeys("ne");
        //Click on Username Field
        driver.findElement(By.id("customer.username")).click();
        //Enter Username in Field
        driver.findElement(By.id("customer.username")).sendKeys("petarpetrovic99");
        //Click on Password Field
        driver.findElement(By.id("customer.password")).click();
        //Enter Password in Field
        driver.findElement(By.id("customer.password")).sendKeys("krusevac9");
        //Click on Confirm Field
        driver.findElement(By.id("repeatedPassword")).click();
        //Enter Confirm in Field
        driver.findElement(By.id("repeatedPassword")).sendKeys("krusevac9");
        //Click on REGISTER Button
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/form[1]/table[1]/tbody[1]/tr[13]/td[2]/input[1]")).click();
        //Click on Log Out Button
        driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
        //Verify Para Bank Start Page
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/a[2]/img[1]")).isDisplayed();




    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
