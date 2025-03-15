package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {

    protected WebDriver driver;

    WebDriverWait wait;

    public MethodHandles(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement webElement(By locator){
        return driver.findElement(locator);
    }
    private void explicitWait(int time, By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(webElement(locator)),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.presenceOfElementLocated(locator)
        ));
    }

    protected void click(By locator, int time){
        explicitWait(time,locator);
        webElement(locator).click();
    }

    protected void sendKeys(By locator, int time, String text){
        explicitWait(time,locator);
        webElement(locator).sendKeys(text);
    }


}
