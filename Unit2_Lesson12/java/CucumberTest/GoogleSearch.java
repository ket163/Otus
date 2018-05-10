package CucumberTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.TestPrepare;

/**
 * Created by qa on 10.05.18.
 */
public class GoogleSearch extends TestPrepare {

    TestPrepare testPrepare = new TestPrepare();

@Given("^Open a search page at ya.ru$")
    public void open_a_search_page_at_ya() {
        testPrepare.SetupTests();
        getInstance().get("https://ya.ru/");

    }

    @When("^I search for \"([^\"]*)\"$")
    public void when_i_search_for_cars(String ourQuery) {
        testPrepare.SetupTests();
        WebElement search = getInstance().findElement(By.cssSelector("#text"));
        search.sendKeys(ourQuery);
        WebElement findButton = getInstance().findElement(By.cssSelector("body > table > tbody > tr.b-table__row.layout__search > td > form > div.search2__button > button"));
        findButton.click();

    }

    @Then("The page title contains \"([^\"]*)\"$")
    public void the_page_title_contains(String word) {
        testPrepare.SetupTests();
        WebDriverWait webDriverWait = new WebDriverWait(getInstance(), 10);
        WebElement searchArea = getInstance().findElement(By.xpath("//*[@class='input__control']"));
        webDriverWait.until(ExpectedConditions.visibilityOf(searchArea));
        Assert.assertTrue(getInstance().getTitle().contains(word));

    }

}