package swag.lab.test.fun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import swag.lab.test.page_object.ProductListingPagePageObject;

public class PLPfun {

    public static void clickOnFirstPLP (WebDriver driver, WebDriverWait wait) {

        //Click on First PLP Product
        driver.findElement(ProductListingPagePageObject.firstProductFromList).isDisplayed();
        driver.findElement(ProductListingPagePageObject.firstProductFromList).click();
    }


}
