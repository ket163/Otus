import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

class Unit1_Lesson4_Prepare {


    protected WebDriver driver;

    @BeforeTest
    public void SetupTests() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @AfterTest

    public void AfterTests() {
        if (driver != null) {
            driver.quit();
            driver=null;
        }
    }

}
