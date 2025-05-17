package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MethodHandles;

public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    By TestCaseButton =By.xpath("//*[contains(text(),'Test Cases')]");
    By TestCaseTitle = By.xpath("//*[contains(text(),'Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:')]");

    public void assertTestCasesExists() {
        myAssertEquals(getText(TestCaseButton, 2), "Test Cases");
        click(TestCaseButton, 5);
        myAssertEquals(getText(TestCaseTitle, 2), "Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:");
    }




    //locators
    private final By signUpAndLogin = By.linkText("Signup / Login");
    private final By homeLink = By.xpath("//a[contains(., 'Home')]");
    private final By loginUser  = By.tagName("b");
    private final By logOut = By.linkText("Logout");
    private final By signUpLogin = By.linkText("Signup / Login");
    private final By homePageAssertion = By.xpath("(//h2[@class='title text-center'])[1]");

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




    public LoginPage clickOnSignUpLoginButton() {

        click(signUpLogin, 30);
        return new LoginPage(driver);
    }

    public String getHomePageMsg() {
        return driver.findElement(homePageAssertion).getText();

    }
}

