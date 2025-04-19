package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.io.FileNotFoundException;

import static org.testng.Assert.assertEquals;
import static reader.ReadDataFromJson.dataModel;
import static utils.MethodHandles.myAssertEquals;

public class LoginTests extends BaseTests {


    @Test
    public void t1() throws FileNotFoundException {
        LoginPage loginPage = homePage.clickOnSignUpAndLoginButton();
        loginPage.insertEmail(dataModel().Login.ValidCreditials.Username);

        myAssertEquals("1", "1");
    }

    @Test
    public void t2() throws FileNotFoundException {
        LoginPage loginPage = homePage.clickOnSignUpAndLoginButton();
        loginPage.insertEmail(dataModel().Login.ValidCreditials.Username);
        myAssertEquals("1", "2");
    }
}
