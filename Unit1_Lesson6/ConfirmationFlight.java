import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationFlight extends PageObject {

    public ConfirmationFlight(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "body > div.container > div > table > tbody > tr:nth-child(1) > td:nth-child(2)")
    WebElement id;
    @FindBy(css = "body > div.container > div > table > tbody > tr:nth-child(2) > td:nth-child(2)")
    WebElement status;
    @FindBy(css = "body > div.container > div > table > tbody > tr:nth-child(3) > td:nth-child(2)")
    WebElement usd;
    @FindBy(css = "body > div.container > div > table > tbody > tr:nth-child(4) > td:nth-child(2)")
    WebElement card;
    @FindBy(css = "body > div.container > div > table > tbody > tr:nth-child(5) > td:nth-child(2)")
    WebElement expirationDate;
    @FindBy(css = "body > div.container > div > table > tbody > tr:nth-child(6) > td:nth-child(2)")
    WebElement authCode;

    public void getIdCheck() {
        String idCheck = id.getText();
        if (idCheck == null) {
            throw new NullPointerException("Поле id не заполнено");
        }
    }

    public void getStatusCheck() {
        String statusTextCheck = status.getText();
        if (statusTextCheck == null) {
            throw new NullPointerException("Поле status не заполнено");
        }
    }

    public String getUsd() {
        String getUsdText = usd.getText();
        return getUsdText;
    }

    public String getCardLastFourNumbers() {
        String cardText = card.getText();
        String cardLastFourNumbers = cardText.substring(cardText.length() - 4);
        return cardLastFourNumbers;
    }

    public String getExpirationDateText() {
        String expirationDateText = expirationDate.getText();
        return expirationDateText;
    }

    public void checkAuthCode() {
        String authCodetext = authCode.getText();
        if (authCodetext == null) {
            throw new NullPointerException("Поле authCode не заполнено");
        }
    }
}
