package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CommonPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private final By[] pageTitleSelectors = {
            By.cssSelector("#large-left-padding h2"),
            By.cssSelector(".score-center h1")
    };

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageTitle() {
        wait.until(driver -> {
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        });

        for (By selector : pageTitleSelectors) {
            List<WebElement> elements = driver.findElements(selector);
            if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
                return elements.get(0).getText();
            }
        }
        throw new RuntimeException("Page title not found after DOM ready");
    }
}