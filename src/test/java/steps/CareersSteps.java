package steps;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.CareersPage;

public class CareersSteps {

    private final WebDriver driver;
    private CareersPage careersPage;

    public CareersSteps() {
        this.driver = BaseTest.getDriver();
    }

    @When("I click on the Search jobs button")
    public void i_click_on_the_search_jobs_button() {
        careersPage = new CareersPage(driver);

        careersPage.clickSearchJobsButton();
    }

    @When("I search for {string}")
    public void search_for_job(String jobTitle) {
        careersPage.searchForJobs(jobTitle);
        careersPage.clickSearchButton();
    }

    @Then("I should see more than or equal to {string} results")
    public void assert_results_count(String expectedResultsCount) {
        int actualResultsCount = careersPage.searchResultsCount();
        Assertions.assertTrue(actualResultsCount >= Integer.parseInt(expectedResultsCount),
                "Expected: " + expectedResultsCount + " or more results, but found: " + actualResultsCount + " results");
    }
}