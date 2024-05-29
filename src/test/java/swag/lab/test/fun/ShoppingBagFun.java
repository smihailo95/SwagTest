package swag.lab.test.fun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingBagFun {

    public static void shoppingBagTest(WebDriver driver, WebDriverWait wait) {

        //Click on Product Name
        driver.findElement(By.xpath("//div[@id='']")).click();

        //Add to Cart
        driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();

        // Click on Shopping Bag
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]")).click();








    }


}
