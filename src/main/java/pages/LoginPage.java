package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By signUpText = By.xpath("(//div[@class='signup-form']/h2)");
    private final By name = By.xpath("//input[@name='name']");
    private final By email = By.xpath("(//input[@name='email'])[2]");
    private final By emailExistingText = By.xpath("//div[@class='signup-form']//p[text()='Email Address already exist!']");
    private final By signUpButton =By.xpath("(//button[@class='btn btn-default'])[2]");

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
