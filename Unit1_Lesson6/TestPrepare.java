import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.util.concurrent.TimeUnit;

public class TestPrepare {

    static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    @BeforeClass
    public void SetupTests() {
        WebDriverManager.chromedriver().setup();
        getInstance();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void AfterTests() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
