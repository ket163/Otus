import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestPrepare;


public class TestXss extends TestPrepare {





        @Test(dataProvider = "xss")
        public void xssTest(String xssQuery) throws InterruptedException {
            TestPrepare.getInstance().get("https://google.com");

            WebElement findField = getInstance().findElement(By.xpath("//*[@id='lst-ib']"));

            Actions actions = new Actions(TestPrepare.getInstance());
            actions.moveToElement(findField).click().perform();
            findField.sendKeys(xssQuery);



            WebElement enterButton = getInstance().findElement(By.xpath("//input[@aria-label = 'Поиск в Google']"));
            enterButton.sendKeys(Keys.ENTER);

            System.out.println(getInstance().getCurrentUrl());
            getInstance().getCurrentUrl().contains(xssQuery);
            



        }


    @DataProvider(name="xss")
        public static Object[] getXssCheatSheet() {
            return TestReader.readFromFile("xss.txt");
             }


}
