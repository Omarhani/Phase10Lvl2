package cart;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailPage;
import pages.ShoppingCartPage;

public class CartTest extends BaseTests {

@Test
    public void testProductQuantityInCart (){

        String actualResult =homePage.getHomePageMsg();
        String expectedResult ="FEATURES ITEMS";
        Assert.assertEquals(expectedResult,actualResult);
        
        ProductDetailPage productDetailPage = homePage.clickOnViewProductButton();

        String actualResult2 = productDetailPage.getAssertMessage();
        String expectedResult2 ="CATEGORY";
        Assert.assertEquals(expectedResult2,actualResult2);

        productDetailPage.increaseQuantityTO4();

        productDetailPage.clickOnAddCart();
        ShoppingCartPage shoppingCartPage = productDetailPage.clickOnViewCartLink();

        String actualResult3 = shoppingCartPage.shoppingCartValidationMsg();
        String expectedResult3 ="Shopping Cart";
        Assert.assertEquals(expectedResult3,actualResult3);












    }
}
