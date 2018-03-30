import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BlazeDemo {

    private WebDriver driver;

    @BeforeClass

    //Автоматическая настройка пути для Chromedriver.exe

    public static void SetupChrome() {
        WebDriverManager.chromedriver().setup();
    }

    @Before

    public void SetupTest() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void Test() {

        //Открываем страницу
        driver.get("http://blazedemo.com/index.php");

        //Ищем кнопку Find Flights
        WebElement findFlights = driver.findElement(By.className("btn-primary"));
        //Нажимаем на неё
        findFlights.click();

        //Псевдо-проверка загрузки страницы результатов поиска
        WebElement thisFlight = driver.findElement(By.className("btn-small"));
        Assert.assertEquals(thisFlight.isDisplayed(), true);
    }

    @After
    public void CloseDriver() {
        //Закрываем полнлстью браузер

        if (driver != null) {
            driver.quit();
        }
    }
}

