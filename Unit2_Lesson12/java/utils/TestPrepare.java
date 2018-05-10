package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestPrepare {

    static WebDriver driver;

    public static WebDriver getInstance() {
        String browserName = "chrome";
        DesiredCapabilities capability = DesiredCapabilities.chrome();

        if (driver == null)

            switch (browserName) {
                case "chrome": {
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                }

                case "chrome-remote": {
                    try {

                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        return driver;
    }

    public void SetupTests() {
        WebDriverManager.chromedriver().setup();
        getInstance();
        getInstance().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        getInstance().manage().window().maximize();
    }


    public void AfterTests() {
        getInstance().quit();
    }

}