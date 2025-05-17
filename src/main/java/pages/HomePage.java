package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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


}
