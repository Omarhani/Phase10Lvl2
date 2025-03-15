package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By email = By.name("email");

    public void insertEmail(String text){
        sendKeys(email, 10,text);
    }
}
