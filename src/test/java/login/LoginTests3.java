package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class LoginTests3 extends BaseTests {


    @Test
    public void t5() throws FileNotFoundException {
        LoginPage loginPage = homePage.clickOnSignUpAndLoginButton();
        loginPage.insertEmail(dataModel().Login.ValidCreditials.Username);
    }

    @Test
    public void t6() throws FileNotFoundException {
        LoginPage loginPage = homePage.clickOnSignUpAndLoginButton();
        loginPage.insertEmail(dataModel().Login.ValidCreditials.Username);
    }
}
