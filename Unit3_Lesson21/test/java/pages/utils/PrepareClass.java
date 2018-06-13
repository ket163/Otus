package pages.utils;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import java.util.logging.Level;


public class PrepareClass {

    @BeforeClass
    public  void setupTests() {

        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
        BasicConfigurator.configure();

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.PERFORMANCE, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logs);










    }
}
