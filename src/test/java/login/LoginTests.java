package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class LoginTests extends BaseTests {


    @Test
    public void loginUserWithCorrectEmailAndPassword() throws FileNotFoundException {
        homePage.verifyHomeLinkIsOrange(dataModel().HomeColor);

        // Scenario 1: Valid email and password
        LoginPage loginPage = homePage.clickOnSignUpAndLoginButton();
        loginPage.insertLoginEmail(dataModel().Login.ValidCreditials.Email);
        loginPage.insertLoginPassword(dataModel().Login.ValidCreditials.Password);
        homePage = loginPage.clickOnLoginButtonAndSuccess();
        homePage.verifyUserName(dataModel().UserName);
        homePage.clickOnLogOutButton();

        // Scenario 2: Valid email and incorrect password
        homePage.clickOnSignUpAndLoginButton();
        loginPage.insertLoginEmail(dataModel().Login.InvalidCreditials.InvalidPassword.Email);
        loginPage.insertLoginPassword(dataModel().Login.InvalidCreditials.InvalidPassword.Password); // Fixed this line
        loginPage.clickOnLoginButtonAndFail();
        loginPage.verifyEmailOrPasswordIsIncorrectMSG(dataModel().EmailOrPasswordIsIncorrectMSG);


    }
}
