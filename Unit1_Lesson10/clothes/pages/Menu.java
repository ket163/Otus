package clothes.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PageObject;

public class Menu extends PageObject {

    public Menu(WebDriver driver) {
        super(driver);
    }

    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);


    @FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
    WebElement womenMenu;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(1) > ul")
    WebElement womenSubMenu;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(1) > ul > li:nth-child(1) > ul > li:nth-child(1) > a")
    public WebElement tShirts;


    public void moveToElementWaitNclick() {

        action.moveToElement(womenMenu).build().perform();
        wait.until(ExpectedConditions.visibilityOf(womenSubMenu));
        tShirts.click();
    }


}
