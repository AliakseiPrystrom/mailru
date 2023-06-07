package elements;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.WaitUtils;

import static drivers.WebDriverManager.getDriver;

@Slf4j
public class BaseElement {
    protected By xPath;
    protected String nameElement;

    public void setXPath(By xPath, String nameElement) {
        this.xPath = xPath;
        this.nameElement = nameElement;
    }

    public By getxPath() {
        return xPath;
    }

    public BaseElement(By xPath, String nameElement) {
        this.xPath = xPath;
        this.nameElement = nameElement;
    }

    public void click() {
        log.info("click on element --> " + nameElement);
        getDriver().findElement(xPath).click();
    }

    public void JSclick() {
        log.info("use JS click on element --> " + nameElement);
        WaitUtils.waitForElementToBePresent(xPath);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", getDriver().findElement(xPath));
    }

    public void JSscroll() {
        log.info("use JS scroll to element --> " + nameElement);
        WaitUtils.waitForElementToBePresent(xPath);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(xPath));
    }

    @Override
    public String toString() {
        return nameElement + xPath;
    }
}
