import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    protected static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(getInstance(), this);
    }
}
