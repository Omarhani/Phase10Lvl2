package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class LoginTests extends BaseTests {


    @Test(priority = 1)
    public void loginUserWithCorrectEmailAndPassword() throws FileNotFoundException {
        LoginPage loginPage =homePage.clickOnSignUpAndLoginButton();
        loginPage.insertLoginEmail(dataModel().Login.ValidCreditials.Email);
        loginPage.insertLoginPassword(dataModel().Login.ValidCreditials.Password);
        homePage=loginPage.clickOnLoginButtonAndSuccess();
        homePage.verifyUserName(dataModel().UserName);
        homePage.clickOnLogOutButton();

    }

    @Test(priority = 2)
    public void loginUserWithCorrectEmailAndInCorrectPassword() throws FileNotFoundException {
        LoginPage loginPage =homePage.clickOnSignUpAndLoginButton();
        loginPage.insertLoginEmail(dataModel().Login.InvalidCreditials.InvalidPassword.Email);
        loginPage.insertLoginPassword(dataModel().Login.InvalidCreditials.InvalidPassword.Email);
        loginPage.clickOnLoginButtonAndFail();
        loginPage.verifyEmailOrPasswordIsIncorrectMSG(dataModel().EmailOrPasswordIsIncorrectMSG);


    }
}
