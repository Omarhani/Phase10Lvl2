package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class LogoutTests extends BaseTests {
    @Test(priority = 1)
    public void loginUserWithCorrectEmailAndPassword() throws FileNotFoundException {
        LoginPage loginPage =homePage.clickOnSignUpAndLoginButton();
        loginPage.insertLoginEmail(dataModel().Login.ValidCreditials.Email);
        loginPage.insertLoginPassword(dataModel().Login.ValidCreditials.Password);
        homePage=loginPage.clickOnLoginButtonAndSuccess();
        homePage.verifyUserName(dataModel().UserName);
        homePage.clickOnLogOutButton();

    }


}
