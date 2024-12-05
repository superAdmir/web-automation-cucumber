package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pages.GoogleSearchPage;
import helper.BaseClass;

public class GoogleSearchPageSteps {

    private WebDriver driver = BaseClass.driver;
    private GoogleSearchPage googleSearchPage;

    @Given("browser is open")
    public void browser_is_open() {
        googleSearchPage = new GoogleSearchPage(driver);
    }

    @And("User is on google search page")
    public void user_is_on_google_search_page() {
        googleSearchPage.navigateToGoogle();
    }

    @When("User enters {string} in the search box")
    public void user_enters_a_text_in_a_search_box(String searchText) {
        googleSearchPage.enterSearchText(searchText);
    }

    @And("hits Enter")
    public void hits_enter() {
        googleSearchPage.submitSearch();
    }

    @Then("User is navigated to the search results page containing {string}")
    public void user_is_navigated_to_search_feature(String expectedText) {
        boolean isPresent = googleSearchPage.isResultPageContainsText(expectedText);
        Assert.assertTrue("Expected text not found in search results!", isPresent);
    }
}

