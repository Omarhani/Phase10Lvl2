package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class BaseTests {

    WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() throws FileNotFoundException {
        driver.get(dataModel().URL);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
