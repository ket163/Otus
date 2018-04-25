import login.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestPrepare;


public class BlazeDemoLoginTest extends TestPrepare {

    public final String BUTTON_COLOR = "rgba(37, 121, 169, 1)";

    @Test
    public void loginTest() {

        TestPrepare.getInstance().get("http://blazedemo.com/login");

        LoginPage loginPage = new LoginPage(getInstance());

        //Проверка размера кнопки
        Assert.assertEquals(loginPage.getSize(), loginPage.moveToElementNgetSizeText());
        //Проверка цвета при наведении на кнопку.
        Assert.assertEquals(loginPage.moveToElementNgetColorText(), BUTTON_COLOR);

    }

}
