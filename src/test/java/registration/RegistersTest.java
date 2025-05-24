package registration;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class RegistersTest extends BaseTests {

    @Test
    public void testRegistrationWithExistingEmail() {

        String actualResult =homePage.getHomePageMsg();
        String expectedResult ="FEATURES ITEMS";
        Assert.assertEquals(expectedResult,actualResult);
        LoginPage loginPage = homePage.clickOnSignUpLoginButton();

        String actualResult2 = loginPage.getSignUpText();
        String expectedResult2 ="New User Signup!";
        Assert.assertEquals(expectedResult2,actualResult2);

        loginPage.insertName("Asmaa");
        loginPage.insertExistingEmail("sss@gmail.com");

        String actualResult3 = loginPage.getEmailExistingText();
        String expectedResult3 ="Email Address already exist!";
        Assert.assertEquals(expectedResult3,actualResult3);


    }
}
