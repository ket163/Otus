package login.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;


public class LoginPage extends PageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    Actions action = new Actions(driver);

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    WebElement loginButton;


    public String getSize() {
        String getSizeText = String.valueOf(loginButton.getSize());
        return getSizeText;

    }

    public String moveToElementNgetSizeText() {
        action.moveToElement(loginButton).build().perform();
        String getSizeAfterMoveText = String.valueOf((loginButton.getSize()));
        return getSizeAfterMoveText;

    }

    public String moveToElementNgetColorText() {
        action.moveToElement(loginButton).build().perform();
        String colorText = loginButton.getCssValue("background-color");
        return colorText;

    }


}
