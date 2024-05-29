package swag.lab.test.fun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import swag.lab.test.page_object.BurgerMenuPageObject;
import swag.lab.test.page_object.LogInPageObject;
import swag.lab.test.page_object.PLPPageObject;

public class LogInPageFun {

    public static void logInValidAccount (WebDriver driver, WebDriverWait wait) {

        //Click Username Field
        driver.findElement(LogInPageObject.userNameField).click();
        //enter Valid Username
        driver.findElement(LogInPageObject.userNameField).sendKeys("standard_user");
        //Click Password Field
        driver.findElement(LogInPageObject.passwordField).click();
        //Enter Valid Password
        driver.findElement(LogInPageObject.passwordField).sendKeys("secret_sauce");
        //Click Log In Button
        driver.findElement(LogInPageObject.logInButton).click();
        //Product is Present
        wait.until(ExpectedConditions.visibilityOfElementLocated(PLPPageObject.haderProductText));

    }

    public static void logOutFun (WebDriver driver, WebDriverWait wait) {

        //Click on Burger Menu
        driver.findElement(BurgerMenuPageObject.burgerMenu).click();
        //Click LogOut Button
        driver.findElement(BurgerMenuPageObject.logOut).click();
        //Verify Log In Page
        driver.findElement(LogInPageObject.logInButton).isDisplayed();





    }





}
