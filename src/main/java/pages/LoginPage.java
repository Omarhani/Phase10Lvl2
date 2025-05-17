package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //locators
    private final By loginEmail = By.xpath("//input[@data-qa=\"login-email\"]");
    private final By password = By.name("password");
    private final By loginButton = By.xpath("//button[contains(text(),\"Login\")]");
    private final By emailOrPasswordIsIncorrectMSG = By.xpath("//p[contains(text(),\"Your email or password is incorrect!\")]");

    //Methods
    public void insertLoginCreditial(String mailText,String passwordText)
    {
        sendKeys(loginEmail, 10,mailText);
        sendKeys(password,10,passwordText);
    }
    public HomePage clickOnLoginButtonAndSuccess()
    {
        click(loginButton,5);
        return new HomePage(driver);
    }

    public void clickOnLoginButtonAndFail()
    {
        click(loginButton,5);

    }
    private String getEmailOrPasswordIsIncorrectMSG()
    {

        return getText(emailOrPasswordIsIncorrectMSG , 5);
    }
    public void verifyEmailOrPasswordIsIncorrectMSG(String emailOrPasswordIsIncorrectMSG)
    {
        myAssertEquals(getEmailOrPasswordIsIncorrectMSG(),emailOrPasswordIsIncorrectMSG);
    }

}
