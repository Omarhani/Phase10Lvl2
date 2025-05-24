package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.ScreenRecorderUtil;
import utils.UtilsTests;

import java.lang.reflect.Method;

import static reader.ReadDataFromJson.dataModel;

public class BaseTests {

    WebDriver driver;

    UtilsTests utilsTests;
    protected HomePage homePage;

    public ChromeOptions chromeOptions;

    public FirefoxOptions firefoxOptions;

    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("Chrome") String browser) {
        setUpBrowser(browser);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);

    }

    @Parameters("browser")
    public void setUpBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("headlessChrome")) {
            chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--headless");             // Run Chrome in headless mode (no UI)
            chromeOptions.addArguments("--disable-gpu");          // Recommended for headless mode
            chromeOptions.addArguments("--no-sandbox");           // Required for running as root in some CI environments
            chromeOptions.addArguments("--disable-dev-shm-usage"); // Overcomes resource limitations in /dev/shm in some environments
            chromeOptions.addArguments("--window-size=1920,1080"); // Set a consistent window size
            chromeOptions.addArguments("--remote-debugging-port=9222"); // Can be useful for debugging, though not strictly necessary for running
            chromeOptions.addArguments("--disable-extensions");   // Disable browser extensions
            chromeOptions.addArguments("--disable-setuid-sandbox"); // Another sandbox-related argument for CI
            chromeOptions.addArguments("--verbose");              // Enable verbose logging from Chrome
            chromeOptions.addArguments("--log-path=chromedriver.log"); // Log chromedriver output

            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("headlessfirefox")) {
            firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--no-sandbox"); // Required for running as root in some CI environments
            firefoxOptions.addArguments("--disable-dev-shm-usage"); // Overcomes resource limitations in some environments

//            firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        }
    }

    @BeforeMethod
    public void goHome(Method method) throws Exception {
        utilsTests = new UtilsTests(driver);
        driver.get(dataModel().URL);
        ScreenRecorderUtil.startRecord(method.getName());
        utilsTests.createTestCaseInReport(method);
    }

    @AfterMethod
    public void afterMethod(Method method, ITestResult result) throws Exception {
        utilsTests = new UtilsTests(driver);
        utilsTests.takeScreenShot(method);
        ScreenRecorderUtil.stopRecord();
        utilsTests.setStatus(method,result);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @BeforeSuite
    public void beforeSuite(){
        utilsTests = new UtilsTests(driver);
        utilsTests.createReport();
    }

    @AfterSuite
    public void afterSuite(){
        utilsTests = new UtilsTests(driver);
        utilsTests.flushReport();
    }

}
