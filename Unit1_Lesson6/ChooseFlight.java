import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ChooseFlight extends PageObject {

    public ChooseFlight(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = "body > div.container > form > select:nth-child(1)")
    private  WebElement departureCity;
     String departureCityText = departureCity.getText();
    @FindBy(css = "body > div.container > form > select:nth-child(4)")
    private WebElement destinationCity;
    String destinationCityText = destinationCity.getText();
    @FindBy(css = "body > div.container > form > div > input")
    private WebElement findFlightsButton;


    public void selectDeparture() {
        Select selectDeparture = new Select(departureCity);
        selectDeparture.selectByValue("Boston");

    }

    public String selectDepartureText() {
        Select selectDeparture = new Select(departureCity);
        selectDeparture.selectByValue("Boston");
        String text = selectDeparture.getFirstSelectedOption().getText();
        return text;

    }

    public void selectDestination() {
        Select selectDestination = new Select(destinationCity);
        selectDestination.selectByValue("Berlin");

    }

    public String selectDestinationText() {
        Select selectDestination = new Select(destinationCity);
        selectDestination.selectByValue("Berlin");
        String text = selectDestination.getFirstSelectedOption().getText();
        return text;

    }

    public ReserveFlight clickFindFlightsButton() {
        findFlightsButton.click();
        return new ReserveFlight(driver);
    }



}
