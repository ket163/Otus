


import com.sun.istack.internal.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Unit1_Lesson4 extends Unit1_Lesson4_Prepare {


    @Test
    public void Test() {
        /** Работа со страницей поиска полётов */

        //Открываем страницу
        driver.get("http://blazedemo.com/index.php");
        //Выбираем Boston как город отправления
        WebElement selectElementFrom = driver.findElement(By.cssSelector("body > div.container > form > select:nth-child(1)"));
        Select selectFrom = new Select(selectElementFrom);
        selectFrom.selectByValue("Boston");
        //Выбираем Berlin как город приземления
        WebElement selectElementTo = driver.findElement(By.cssSelector("body > div.container > form > select:nth-child(4)"));
        Select selectTo = new Select(selectElementTo);
        selectTo.selectByValue("Berlin");
        //Ищем кнопку Find Flights
        WebElement findFlights = driver.findElement(By.cssSelector("body > div.container > form > div > input"));
        //Нажимаем на неё
        findFlights.click();

        /** Работа со страницей выбора рейса */

        //Проверка соответсвий найденных рейсов запросу
        String titleText = driver.findElement(By.cssSelector("body > div.container > h3")).getText();
        Assert.assertEquals(titleText, "Flights from Boston to Berlin:");

        //Подготавливаем данные для проверки полёта №9696 Flight,Airline,Price
        String flightText = driver.findElement(By.cssSelector("body > div.container > table > tbody > tr:nth-child(3) > td:nth-child(3)"))
                .getText();
        String airlineText = driver.findElement(By.cssSelector("body > div.container > table > tbody > tr:nth-child(3) > td:nth-child(4)"))
                .getText();
        String priceText = driver.findElement(By.cssSelector("body > div.container > table > tbody > tr:nth-child(3) > td:nth-child(7)"))
                .getText().substring(1);

        //Выбираём полёт №9696

        WebElement chooseFlight = driver.findElement(By.cssSelector("body > div.container > table > tbody > tr:nth-child(3) > td:nth-child(2) > input"));
        chooseFlight.click();

        //Проверяем тот ли рейс выбрался

        String airlineCheck = driver.findElement(By.cssSelector("body > div.container > p:nth-child(2)")).getText();
        Assert.assertTrue(airlineCheck.contains(airlineText));

        String flightCheck = driver.findElement(By.cssSelector("body > div.container > p:nth-child(3)")).getText();
        Assert.assertTrue(flightCheck.contains(flightText));

        String priceCheck = driver.findElement(By.cssSelector("body > div.container > p:nth-child(4)")).getText();
        Assert.assertTrue(priceCheck.contains(priceText));

        //Проверка TotalCost

        String totalCost = driver.findElement(By.cssSelector("body > div.container > p:nth-child(7) > em")).getText();
        String price[] = driver.findElement(By.cssSelector("body > div.container > p:nth-child(4)")).getText().split(":");
        String taxes[] = driver.findElement(By.cssSelector("body > div.container > p:nth-child(5)")).getText().split(":");

        double priceAndTaxes = Double.parseDouble(price[1]) + Double.parseDouble(taxes[1]);
        String priceAndTaxesToString = String.valueOf(priceAndTaxes);
        //Проверка
        Assert.assertEquals(totalCost, priceAndTaxesToString);


        //Заполнение полей на странице
        String cardNumber = "1111222233334444";
        String cardMonth = "12";
        String cardYear = "2018";
        driver.findElement(By.cssSelector("#inputName")).sendKeys("Igor");
        driver.findElement(By.cssSelector("#address")).sendKeys("Russia");
        driver.findElement(By.cssSelector("#city")).sendKeys("Moscow");
        driver.findElement(By.cssSelector("#zipCode")).sendKeys("127585");
        driver.findElement(By.cssSelector("#creditCardNumber")).sendKeys(cardNumber);
        driver.findElement(By.cssSelector("#creditCardMonth")).clear();
        driver.findElement(By.cssSelector("#creditCardMonth")).sendKeys(cardMonth);
        driver.findElement(By.cssSelector("#creditCardYear")).clear();
        driver.findElement(By.cssSelector("#creditCardYear")).sendKeys(cardYear);
        driver.findElement(By.cssSelector("#nameOnCard")).sendKeys("Igor Test");

        //Нажимаем "Purchase"

        WebElement purchase = driver.findElement(By.cssSelector("body > div.container > form > div:nth-child(12) > div > input"));
        purchase.click();

        /** Финальная страница покупки билета */

        //Проверка наличия Id билета
        String id = driver.findElement(By.cssSelector("body > div.container > div > table > tbody > tr:nth-child(1) > td:nth-child(2)"))
                .getText();
        if (id == null) {
            throw new NullPointerException("Поле Id не заполнено");
        }
        //Проверка наличия статуса
        String status = driver.findElement(By.cssSelector("body > div.container > div > table > tbody > tr:nth-child(2) > td:nth-child(2)"))
                .getText();
        if (status == null) {
            throw new NullPointerException("Поле status не заполнено");
        }

        //Проверка USD

        String usd = driver.findElement(By.cssSelector("body > div.container > div > table > tbody > tr:nth-child(3) > td:nth-child(2)"))
                .getText();
        Assert.assertEquals(usd, "USD");


        //Проверка Карты

        WebElement card = driver.findElement(By.cssSelector("body > div.container > div > table > tbody > tr:nth-child(4) > td:nth-child(2)"));
        String cardText = card.getText();
        String cardLastFourNumbers = cardText.substring(cardText.length() - 4);
        Assert.assertEquals(cardLastFourNumbers, cardNumber.substring(cardNumber.length() - 4));

        //Проверка срока карты

        String cardExpire = cardMonth + " /" + cardYear;
        String expiration = driver.findElement(By.cssSelector("body > div.container > div > table > tbody > tr:nth-child(5) > td:nth-child(2)"))
                .getText();
        Assert.assertEquals(expiration, cardExpire);

        //Проверка authCode

        String authCode = driver.findElement(By.cssSelector("body > div.container > div > table > tbody > tr:nth-child(6) > td:nth-child(2)"))
                .getText();
        if (authCode == null) {
            throw new NullPointerException("Поле authCode не заполнено");
        }


    }


}
