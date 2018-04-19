import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseFlight extends PageObject {

    public PurchaseFlight(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "body > div.container > p:nth-child(2)")
    private WebElement airline;

    public String getAirlineText() {
        String airlineText = airline.getText();
        return airlineText;
    }

    @FindBy(css = "body > div.container > p:nth-child(3)")
    private WebElement flight;

    public String getFlightText() {
        String flightText = flight.getText();
        return flightText;
    }


    @FindBy(css = "body > div.container > p:nth-child(4)")
    private WebElement price1;

    public String getPriceText() {
        String priceText = price1.getText();
        return priceText;
    }

    @FindBy(css = "body > div.container > p:nth-child(7) > em")
    WebElement totalCost;

    public String getTotalCost() {
        String totalCostText = totalCost.getText();
        return totalCostText;
    }

    @FindBy(xpath = "/html/body/div[2]/p[4]")
    WebElement regTaxes;

    public String getSumTotalCost() {
        String[] regTaxesText = regTaxes.getText().split(":");
        String[] regPriceText = price1.getText().split(":");
        double priceAndTaxesValue = Double.parseDouble(regPriceText[1]) + Double.parseDouble(regTaxesText[1]);
        String priceAndTaxesValueToString = String.valueOf(priceAndTaxesValue);
        return priceAndTaxesValueToString;
    }


    @FindBy(css = "#inputName")
    WebElement inputName;
    @FindBy(css = "#address")
    WebElement address;
    @FindBy(css = "#city")
    WebElement city;
    @FindBy(css = "#zipCode")
    WebElement zipCode;
    @FindBy(css = "#creditCardNumber")
    WebElement creditCardNumber;
    @FindBy(css = "#creditCardMonth")
    WebElement creditCardMonth;
    @FindBy(css = "#creditCardYear")
    WebElement creditCardYear;
    @FindBy(css = "#nameOnCard")
    WebElement nameOnCard;





    public void fillUpForm(String inputName, String address, String city,
                           String zipCode, String creditCardNumber, String creditCardMonth,
                           String creditCardYear, String nameOnCard) {

        this.inputName.clear();
        this.inputName.sendKeys(inputName);

        this.address.clear();
        this.address.sendKeys(address);

        this.city.clear();
        this.city.sendKeys(city);

        this.zipCode.clear();
        this.zipCode.sendKeys(zipCode);

        this.creditCardNumber.clear();
        this.creditCardNumber.sendKeys(creditCardNumber);

        this.creditCardMonth.clear();
        this.creditCardMonth.sendKeys(creditCardMonth);

        this.creditCardYear.clear();
        this.creditCardYear.sendKeys(creditCardYear);
    }

    @FindBy(css = "body > div.container > form > div:nth-child(12) > div > input")
    WebElement purchaseButton;

    public ConfirmationFlight clickButton(){
        purchaseButton.click();
        return new ConfirmationFlight(driver);
    }


}
