import clothes.pages.Menu;
import clothes.pages.TShirtsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestPrepare;


public class AutomationPracticeTest extends TestPrepare {


    @Test
    public void tShirtTest() {

        TestPrepare.getInstance().get("http://automationpractice.com/index.php");
        Menu menu = new Menu(getInstance());
        TShirtsPage tShirtsPage = new TShirtsPage(getInstance());

        menu.moveToElementWaitNclick();
        Assert.assertTrue(tShirtsPage.tShirtElement().isDisplayed());


    }


}
