package pages;

import drivers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import utils.JsonDataUtil;

public abstract class BasePage {
    public final String HOME_URL = JsonDataUtil.getValue("testUrl", "homeUrl");
    public WebDriver driver;

    public BasePage() {
        driver = WebDriverManager.getDriver();
    }

    public abstract BasePage openPage();

    public abstract boolean isPageOpened();
}
