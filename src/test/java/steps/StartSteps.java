package steps;

import base.BaseTest;
import config.ConfigLoader;
import org.openqa.selenium.WebDriver;
import pages.StartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;

public class StartSteps {

    private final WebDriver driver;
    private StartPage startPage;

    public StartSteps() {
        this.driver = BaseTest.getDriver();
    }

    @Given("the user is on the LexisNexis homepage")
    public void the_user_is_on_the_lexisnexis_homepage() {
        startPage = new StartPage(driver);

        String baseUrl = ConfigLoader.getBaseUrl();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(baseUrl, currentUrl, "User is not on the LexisNexis homepage. Current URL: " + currentUrl);
    }

    @And("I click on the Accept All Cookies button if the banner is present")
    public void i_click_on_the_accept_all_cookies_button_if_the_banner_is_present() {
        startPage.acceptCookiesIfBannerPresent();
    }

    @When("I navigate to the Careers page")
    public void i_navigate_to_the_careers_page() {
        startPage.clickAboutUsLink();
        startPage.clickCareersLink();
    }
}