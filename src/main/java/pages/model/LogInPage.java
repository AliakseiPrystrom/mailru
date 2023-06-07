package pages.model;

import elements.Button;
import elements.IframeElement;
import elements.Input;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.MailRoom;
import utils.ActionsUtil;

public class LogInPage extends BasePage {
    private final Input loginInput = new Input(By.xpath("//input[@name='username']"),"loginInput");
    private final Input passwordInput = new Input(By.xpath("//input[@name='password']"),"passwordInput");
    private final Button submitLoginAndGoToPassword = new Button(By.xpath("//button[@data-test-id='next-button']"),"submitLoginButton");
    private final Button submitPassword = new Button(By.xpath("//button[@data-test-id='submit-button']"),"submitPasswordButton");
    private final IframeElement loginIframeFirst = new IframeElement(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']"),"loginIframeFirst");


    public LogInPage enterLogin(String login){
        loginInput.sendKeys(login);
        submitLoginAndGoToPassword.click();
        return this;
    }

    public LogInPage enterPassword(String password){
        passwordInput.sendKeys(password);
        submitPassword.click();
        return this;
    }

    public MailRoom logIn(String login, String password){
        ActionsUtil.waitActions(2);
        loginIframeFirst.switchToFrame();
        enterLogin(login);
        enterPassword(password);
        return new MailRoom();
    }

    @Override
    public BasePage openPage() {
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
