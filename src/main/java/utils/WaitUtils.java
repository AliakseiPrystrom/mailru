package utils;

import drivers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static final Duration WAIT_TIME = Duration.ofMillis(500);
    private static WebDriverWait wait = new WebDriverWait(WebDriverManager.getDriver(), WAIT_TIME);
    private static FluentWait<WebDriver> fluentWait = new FluentWait<>(WebDriverManager.getDriver());

    public static void waitForElementToBePresent(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void createFluentWaitForPresenceOf(By by) {
        fluentWait.withTimeout(Duration.ofMillis(1500)).pollingEvery(Duration.ofMillis(500)).until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public static void createFluentWaitForClickable(WebElement element) {
        fluentWait.withTimeout(Duration.ofMillis(1500)).pollingEvery(Duration.ofMillis(500)).until(ExpectedConditions.elementToBeClickable(element));
    }
}
