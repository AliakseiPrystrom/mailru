package pages;

import elements.Button;
import org.openqa.selenium.By;
import pages.model.LogInPage;

public class HomePage extends BasePage {

    private final Button logIn = new Button(By.xpath("//button[@data-click-counter='75068996']"), "logInButton");


    public LogInPage logIn(){
        logIn.click();
        return new LogInPage();
    }

    @Override
    public HomePage openPage() {
        driver.navigate().to(HOME_URL);
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
