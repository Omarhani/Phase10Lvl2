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
        loginPage.insertLoginCreditial(dataModel().Login.ValidCreditials.Email,dataModel().Login.ValidCreditials.Password);
        homePage = loginPage.clickOnLoginButton();
        homePage.verifyUserName(dataModel().UserName);
        homePage.clickOnLogOutButton();

        // Scenario 2: Valid email and incorrect password
        loginPage.insertLoginCreditial(dataModel().Login.InvalidCreditials.InvalidPassword.Email,dataModel().Login.InvalidCreditials.InvalidPassword.Password);
        loginPage.clickOnLoginButton();
        loginPage.verifyEmailOrPasswordIsIncorrectMSG(dataModel().EmailOrPasswordIsIncorrectMSG);


    }
}
