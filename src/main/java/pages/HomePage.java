package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By signUpAndLogin = By.linkText("Signup / Login");


    public LoginPage clickOnSignUpAndLoginButton(){
        click(signUpAndLogin,5);
        return new LoginPage(driver);
    }
}
