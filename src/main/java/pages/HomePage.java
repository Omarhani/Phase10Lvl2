package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MethodHandles;

public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {
        super(driver);
    }
 
    //locators
    private final By signupAndLoginLink=By.linkText("Signup / Login");
    private final By signUpAndLogin = By.linkText("Signup / Login");
    private final By homeLink = By.xpath("//a[contains(., 'Home')]");
    private final By loginUser  = By.tagName("b");
    private final By logOut = By.linkText("Logout");
    private final By signUpLogin = By.linkText("Signup / Login");
    private final By homePageAssertion = By.xpath("(//h2[@class='title text-center'])[1]");

    private final By contactUsLink=By.linkText("Contact us");

    private final By products = By.xpath("//a[contains(text(), \"Products\")]");


    //methods
    public void verifyHomeLinkIsOrange(String homeColor) {
        WebElement homeElement = webElement(homeLink); // Replaces driver.findElement(homeLink)
        String color = homeElement.getCssValue("color");
        myAssertEquals(color, homeColor);
    }
    public LoginPage clickOnSignUpAndLoginButton()
    {
        click(signUpAndLogin,5);
        return new LoginPage(driver);
    }
    public LoginPage clickOnLogOutButton()
    {
        click(logOut,5);
        return new LoginPage(driver);
    }
    private String getUserName()
    {

        return getText(loginUser , 5);
    }
    public void verifyUserName(String userName)
    {
        myAssertEquals(getUserName(),userName);
    }

    public LoginSignUpPage clickOnSignupAndLogin() {
        click(signupAndLoginLink,5);
        return new LoginSignUpPage(driver);
    }
    public LoginPage clickOnSignUpLoginButton() {

        click(signUpLogin, 30);
        return new LoginPage(driver);
    }

    public String getHomePageMsg() {
        return driver.findElement(homePageAssertion).getText();

    }
    public ContactUsPage clickContactUsLink(){
        click(contactUsLink,7);
        return new ContactUsPage(driver);


    public ProductsPage clickOnProducts()
    {
        click(products,5);
        return new ProductsPage(driver);

    }
}

