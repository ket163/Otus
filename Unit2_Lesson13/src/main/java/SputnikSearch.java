
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.sputnik.ru/")


public class SputnikSearch extends PageObject {


    @Given("Open a search page on sputnik.ru")
    public void open_a_search_page() {
        open();

    }

    @FindBy(id = "js-search-input")
    WebElementFacade searchField;

    @When("^User type a \"([^\"]*)\"$")
    public void user_enter_text(String text) {
        searchField.type(text);


    }

    @FindBy(xpath = "//*[@class='b-search-form__bt']")
    WebElementFacade searchButton;
    @And("Press Enter")
    public void press_enter() {
        searchButton.click();

    }
    @FindBy(xpath = "//*[@class='b-cover js_device']")
    WebElementFacade resultCollection;
    @Then("^The answer page contains Спутник")
    public void matchResults() {
        Assert.assertTrue(getDriver().getTitle().contains("Спутник"));
        Assert.assertTrue(resultCollection.containsText("Спутник"));
    }


}



