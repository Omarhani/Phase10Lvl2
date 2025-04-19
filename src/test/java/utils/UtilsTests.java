package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import static utils.MethodHandles.extent;
import static utils.MethodHandles.test;

public class UtilsTests {

    WebDriver driver;


    public UtilsTests(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenShot(Method method) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("report/" + method.getName() + ".png"));
    }

    public void createReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("report/report.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("My Report");
        extent.attachReporter(spark);
    }

    public void createTestCaseInReport(Method method){
        test = extent.createTest(method.getName());
        test.info(MarkupHelper.createLabel("----------------- Steps To Reproduce -----------------", ExtentColor.TEAL));
    }

    public void setStatus(Method method, ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass(MarkupHelper.createLabel("Test Pass", ExtentColor.GREEN));
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));

        }
        addAttachment(method);
    }

    public void addAttachment(Method method) {
        test.addScreenCaptureFromPath(method.getName() + ".png");
        test.log(Status.INFO, "<a href='" + method.getName() + ".avi'> Download Video</a>");
    }

    public void flushReport() {
        extent.flush();
    }


}
