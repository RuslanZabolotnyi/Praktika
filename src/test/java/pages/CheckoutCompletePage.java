package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By backHome = By.cssSelector(DATA_TEST_PATTERN.formatted("back-to-products"));
    private final By successMsg = By.cssSelector(DATA_TEST_PATTERN.formatted("complete-header"));

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageTitleDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public boolean isBackHomeBtnDisplayed() {
        return driver.findElement(backHome).isDisplayed();
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public String getBackHomeBtn() {
        return driver.findElement(backHome).getText();
    }

    public boolean isMessageDisplayed() {
        return driver.findElement(successMsg).isDisplayed();
    }

    public String getSuccessMsg() {
        return driver.findElement(successMsg).getText();
    }
}
