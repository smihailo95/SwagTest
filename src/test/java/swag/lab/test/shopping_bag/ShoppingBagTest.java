package swag.lab.test.shopping_bag;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import swag.lab.test.fun.CardFun;
import swag.lab.test.fun.LogInPageFun;
import swag.lab.test.fun.PDPfun;
import swag.lab.test.fun.PLPfun;
import swag.lab.test.page_object.LogInPageObject;
import swag.lab.test.utility.BeforeAll;

public class ShoppingBagTest extends BeforeAll {

    @Test

    public void shoppingBagTest() throws InterruptedException {

        //Log in
        LogInPageFun.logInValidAccount(driver, wait);


        //Click on First Product from PLP
        PLPfun.clickOnFirstPLP(driver, wait);

        //Get Name of Product in PDP
        PDPfun.getNameOfProduct(driver, wait);

        //Add to Cart
        PDPfun.addProductToBag(driver, wait);

        //Go to Cart
        CardFun.goToCart(driver, wait);

        //Check name of product in cart
        CardFun.getProductNameInCart(driver, wait);

        //Check Names
        Assert.assertEquals();






    }





}
