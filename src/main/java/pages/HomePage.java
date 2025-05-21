package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private final By signupAndLoginLink=By.linkText("Signup / Login");
    public LoginSignUpPage clickOnSignupAndLogin() {
        click(signupAndLoginLink,5);
        return new LoginSignUpPage(driver);
    }
}
