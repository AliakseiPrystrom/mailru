package pages;

import elements.Button;
import org.openqa.selenium.By;
import pages.model.LetterWindow;
import utils.ActionsUtil;

public class MailRoom extends BasePage{
    Button writeLetter = new Button(By.xpath("//span[@class='compose-button__txt']"),"writeLetterButton");

    public LetterWindow writeLetter(){
        ActionsUtil.waitActions(4);
        writeLetter.click();
        return new LetterWindow();
    }

    @Override
    public MailRoom openPage() {
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
