import org.testng.annotations.Test;
import pages.HomePage;
import pages.model.LetterWindow;
import utils.JsonDataUtil;

public class MailRuTest extends BaseTest {

    @Test
    public void test() {
        LetterWindow homePage = new HomePage()
                .openPage()
                .logIn()
                .logIn(
                        JsonDataUtil.getValue("testData", "login"),
                        JsonDataUtil.getValue("testData", "password"))
                .writeLetter()
                .createLetterAndSend(
                        JsonDataUtil.getValue("testData", "sendTo"),
                        JsonDataUtil.getValue("testData", "topic"),
                        JsonDataUtil.getValue("testData", "letter")
                );

    }

}
