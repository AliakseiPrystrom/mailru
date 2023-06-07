package pages.model;

import elements.Button;
import elements.Input;
import org.openqa.selenium.By;
import pages.BasePage;
import utils.ActionsUtil;

public class LetterWindow extends BasePage {
    Input adressInput = new Input(By.xpath("//div[@class='fields_container--1tuvJ']/descendant::input"), "sendTo");
    Input topicInput = new Input(By.xpath("//div[@class='subject__container--HWnat']/descendant::input"), "topic");
    Input lettertextInput = new Input(By.xpath("//div[@role='textbox']"), "letterInput");
    Button sendMail = new Button(By.xpath("//button[@data-test-id='send']"),"sendMailButton");


    public void setAddress(String address) {
        adressInput.sendKeys(address);
    }

    public void setTopic(String topic) {
        topicInput.sendKeys(topic);
    }

    public void setLetterText(String text) {
        lettertextInput.sendKeys(text);
    }

    public LetterWindow createLetterAndSend(String address, String topic, String text) {
        ActionsUtil.waitActions(2);
        setAddress(address);
        setTopic(topic);
        setLetterText(text);
        sendLetter();
        return this;
    }

    public void sendLetter(){
        sendMail.click();
    }


    @Override
    public LetterWindow openPage() {
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
