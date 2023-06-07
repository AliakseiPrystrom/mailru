package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

import static drivers.WebDriverManager.getDriver;

public class IframeElement extends BaseElement {
    public IframeElement(By xPath, String nameElement) {
        super(xPath, nameElement);
    }

    public WebElement getElement() {
        return getDriver().findElement(xPath);
    }

    public void switchToFrame() {
        WaitUtils.createFluentWaitForPresenceOf(xPath);
        getDriver().switchTo().frame(getElement());
    }

}
