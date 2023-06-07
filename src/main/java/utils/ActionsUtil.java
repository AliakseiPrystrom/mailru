package utils;

import drivers.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsUtil {
    private static final Actions actions = new Actions(WebDriverManager.getDriver());

    public static void goToAndClickElement(WebElement element) {
        actions.moveToElement(element).click().build().perform();
    }

    public static void waitActions(int seconds) {
        actions.pause(Duration.ofSeconds(seconds)).build().perform();
    }
}
