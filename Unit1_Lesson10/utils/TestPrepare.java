package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.util.concurrent.TimeUnit;

public class TestPrepare {

    static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = new InternetExplorerDriver();
        }
        return driver;
    }



    @BeforeClass
    public void SetupTests() {
        WebDriverManager.iedriver().setup();
        getInstance();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void AfterTests() {
        if (driver == null) {
            driver.quit();
            driver = null;
        }
    }
}
