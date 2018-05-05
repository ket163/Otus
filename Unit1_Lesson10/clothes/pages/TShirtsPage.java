package clothes.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageObject;


public class TShirtsPage extends PageObject {

    public TShirtsPage(WebDriver driver) {
        super(driver);
    }




    public WebElement tShirtElement() {

        WebElement tShirt = driver.findElement(By.xpath("//*[@alt='Faded Short Sleeve T-shirts']"));
        return tShirt;

    }
}
