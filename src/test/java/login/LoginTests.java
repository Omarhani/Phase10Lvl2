package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class LoginTests extends BaseTests {


    @Test
    public void t1() throws FileNotFoundException {
        LoginPage loginPage = homePage.clickOnSignUpAndLoginButton();
        loginPage.insertEmail(dataModel().Login.ValidCreditials.Username);
    }
}
