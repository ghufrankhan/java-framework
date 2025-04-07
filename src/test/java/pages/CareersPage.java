package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CareersPage extends CommonPage {

    private final By searchJobsButton = By.xpath("//*[@class='score-button btn-red' and (text())='Search jobs']");
    private final By searchBox = By.cssSelector(".search-box-input");
    private final By search = By.id("search-box-button");
    private final By searchResults = By.cssSelector("[id^='search-results-'] .ais-hits--item");

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public void clickSearchJobsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchJobsButton));
        driver.findElement(searchJobsButton).click();
    }

    public void searchForJobs(String jobTitle) {
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        driver.findElement(searchBox).sendKeys(jobTitle);
    }

    public void clickSearchButton() {
        driver.findElement(search).click();
    }

    public int searchResultsCount() {
        WebDriverWait shorterWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            shorterWait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
            return driver.findElements(searchResults).size();
        } catch (TimeoutException e) {
            return 0;
        }
    }
}