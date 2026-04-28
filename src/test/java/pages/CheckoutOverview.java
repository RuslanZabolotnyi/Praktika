package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverview extends BasePage {
    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By finishBtn = By.cssSelector(DATA_TEST_PATTERN.formatted("finish"));

    public CheckoutOverview(WebDriver driver) {
        super(driver);
    }

    public boolean isPageTitleDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public boolean isFinishBtnDisplayed() {
        return driver.findElement(finishBtn).isDisplayed();
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public String getFinishBtn() {
        return driver.findElement(finishBtn).getText();
    }
    public void clickFinishBtn() {
        driver.findElement(finishBtn).click();
    }
}
