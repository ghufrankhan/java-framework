package steps;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.CommonPage;

public class CommonSteps {

    protected WebDriver driver;
    private final CommonPage commonPage;

    public CommonSteps() {
        this.driver = BaseTest.getDriver();
        this.commonPage = new CommonPage(driver);
    }

    @And("a new tab is opened")
    public void a_new_tab_is_opened() {
        Assertions.assertTrue(driver.getWindowHandles().size() > 1, "No new tab opened");

        String currentWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    @Then("the page title should be {string}")
    public void assert_page_title(String expectedTitle) {
        Assertions.assertEquals(expectedTitle, commonPage.getPageTitle(), "Unexpected page title");
    }
}