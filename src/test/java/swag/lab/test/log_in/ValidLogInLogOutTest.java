package swag.lab.test.log_in;

import org.openqa.selenium.By;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import swag.lab.test.fun.LogInPageFun;
import swag.lab.test.page_object.LogInPageObject;
import swag.lab.test.page_object.PLPPageObject;
import swag.lab.test.utility.BeforeAll;



public class ValidLogInLogOutTest extends BeforeAll {

    @Test(priority = 1, description = "TC-001 - Valid Log In Test")

    public void validLogInLogOutTest() {

        //Valid Log In
        LogInPageFun.logInValidAccount(driver, wait);
        //Log Out
        LogInPageFun.logOutFun(driver, wait);







    }





}




