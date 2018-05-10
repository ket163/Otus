package CucumberTest;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.TestPrepare;

public class SearchTickets extends TestPrepare {

    TestPrepare testPrepare = new TestPrepare();

    @Given("^Open a search page at http://blazedemo.com/index.php$")
    public void open_a_search_page_at_blazedemo() {
        testPrepare.SetupTests();
        getInstance().get("http://blazedemo.com/index.php");

    }

    @When("^I choose a departure City")
    public void when_i_choose_a_departure() {
        testPrepare.SetupTests();
        WebElement departureCity = getInstance().findElement(By.cssSelector("body > div.container > form > select:nth-child(1)"));
        Select selectDeparture = new Select(departureCity);
        selectDeparture.selectByValue("Boston");
    }

    @And("^I choose a destination City")
    public void when_i_choose_for_destination() {
        testPrepare.SetupTests();
        WebElement destinationCity = getInstance().findElement(By.cssSelector("body > div.container > form > select:nth-child(4)"));
        Select selectDestination = new Select(destinationCity);
        selectDestination.selectByValue("Berlin");
    }

    @And("Click at Find Flights")
    public void click_at_find_flights() {
        testPrepare.SetupTests();
        WebElement findFlightsButton = getInstance().findElement(By.cssSelector("body > div.container > form > div > input"));
        findFlightsButton.click();
    }

    @Then("^The page title contains MyCities")
    public void the_page_title_contains_Cities() {
        testPrepare.SetupTests();
        WebElement titleText = getInstance().findElement(By.cssSelector("body > div.container > h3"));
        String getTitleText = titleText.getText();
        Assert.assertEquals(getTitleText,"Flights from Boston to Berlin:");
        testPrepare.AfterTests();
    }




}
