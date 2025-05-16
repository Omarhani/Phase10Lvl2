package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    private final By signUpLogin = By.linkText("Signup / Login");
    private final By homePageAssertion = By.xpath("(//h2[@class='title text-center'])[1]");

    public LoginPage clickOnSignUpLoginButton() {

        click(signUpLogin, 30);
        return new LoginPage(driver);
    }

    public String getHomePageMsg() {
        return driver.findElement(homePageAssertion).getText();

    }
}