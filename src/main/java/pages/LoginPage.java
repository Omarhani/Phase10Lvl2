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
    private final By signUpText = By.xpath("(//div[@class='signup-form']/h2)");
    private final By name = By.xpath("//input[@name='name']");
    private final By email = By.xpath("(//input[@name='email'])[2]");
    private final By emailExistingText = By.xpath("//div[@class='signup-form']//p[text()='Email Address already exist!']");
    private final By signUpButton =By.xpath("(//button[@class='btn btn-default'])[2]");

    //Methods
    public void insertLoginCreditial(String mailText,String passwordText)
    {
        sendKeys(loginEmail, 10,mailText);
        sendKeys(password,10,passwordText);
    }
    public HomePage clickOnLoginButton()
    {
        click(loginButton,5);
        return new HomePage(driver);
    }


    private String getEmailOrPasswordIsIncorrectMSG()
    {

        return getText(emailOrPasswordIsIncorrectMSG , 5);
    }
    public void verifyEmailOrPasswordIsIncorrectMSG(String emailOrPasswordIsIncorrectMSG)
    {
        myAssertEquals(getEmailOrPasswordIsIncorrectMSG(),emailOrPasswordIsIncorrectMSG);
    }



    

    public String getSignUpText() {
        return driver.findElement(signUpText).getText();

    }

    public void insertName(String Name) {
        sendKeys(name, 30, Name);
    }

    public void insertExistingEmail(String ExistingEmail) {
        sendKeys(email, 30, ExistingEmail);
    }


        public String getEmailExistingText()  {
            click(signUpButton,30);
            isDisplayed(emailExistingText,30);
            return   getText(emailExistingText, 30);
        }

    }

