import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReserveFlight extends PageObject {

    public ReserveFlight(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "body > div.container > h3")
    private WebElement titleText;



    @FindBy(css = "body > div.container > table > tbody > tr:nth-child(3) > td:nth-child(4)")
    private WebElement airline;
    public String getAirlineText() {
        String AirlineText = airline.getText();
        return AirlineText;
    }

    @FindBy(css = "body > div.container > table > tbody > tr:nth-child(3) > td:nth-child(3)")
    private WebElement flightNumber;
    public String getFlightNumberText() {
        String chooseFlightNumberText = flightNumber.getText();
        return chooseFlightNumberText;
    }

    @FindBy(css = "body > div.container > table > tbody > tr:nth-child(3) > td:nth-child(7)")
    private WebElement price;
    public String getPriceText() {
        String priceText = price.getText().substring(1);
        return priceText;
    }

    public String getTitle() {
        return titleText.getText();
    }

    @FindBy(css = "body > div.container > table > tbody > tr:nth-child(3) > td:nth-child(2) > input")
    WebElement chooseFlightButton;
    public ReserveFlight clickChooseFlightButton() {
        chooseFlightButton.click();
        return new ReserveFlight(driver);
    }


}
