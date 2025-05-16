package RegisterUserWithExistingEmail;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class registerUserWithExistingEmailTest extends BaseTests {

    @Test
    public void testRegistrationWithExistingEmail (){

        String actualResult =homePage.getHomePageMsg();
        System.out.println("Actual Result is " + actualResult);
        String expectedResult ="FEATURES ITEMS";
        System.out.println("Expected Result is " + expectedResult);
        Assert.assertEquals(expectedResult,actualResult);
        LoginPage loginPage = homePage.clickOnSignUpLoginButton();

        String actualResult2 = loginPage.getSignUpText();
        System.out.println("Actual Result2 is "+ actualResult2);
        String expectedResult2 ="New User Signup!";
        System.out.println("Expected Result2 is " + expectedResult2);
        Assert.assertEquals(expectedResult2,actualResult2);

        loginPage.insertName("Asmaa");
        loginPage.insertExistingEmail("sss@gmail.com");

        String actualResult3 = loginPage.getEmailExistingText();
        System.out.println("actual Result3 is "+ actualResult3);
        String expectedResult3 ="Email Address already exist!";
        System.out.println("Expected Result3 is " + expectedResult3);
        Assert.assertEquals(expectedResult3,actualResult3);


    }
}
