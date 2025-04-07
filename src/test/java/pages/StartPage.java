package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StartPage extends CommonPage {

    private final By cookieBanner = By.className("ot-sdk-container");
    private final By acceptCookies = By.id("onetrust-accept-btn-handler");
    private final By aboutUsLink = By.xpath("//div[@class='score-center'] //a[contains(text(),'About Us')]");
    private final By careersLink = By.xpath("//h4[contains(text(),'Careers')]/following::a[contains(@class,'score-button btn-clickable-area')][1]");

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCookieBannerPresent() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cookieBanner));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void acceptCookiesIfBannerPresent() {
        if (isCookieBannerPresent()) {
            driver.findElement(acceptCookies).click();
        }
    }

    public void clickAboutUsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(aboutUsLink));
        driver.findElement(aboutUsLink).click();
    }

    public void clickCareersLink() {
        wait.until(ExpectedConditions.elementToBeClickable(careersLink));
        driver.findElement(careersLink).click();
    }
}