package pages.utils;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;


public class PrepareClass {

    @BeforeClass
    public void setupTests() {
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();

    }
}
