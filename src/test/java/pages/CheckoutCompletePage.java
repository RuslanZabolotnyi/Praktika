package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By backHome = By.cssSelector(DATA_TEST_PATTERN.formatted("back-to-products"));
    private final By successMsg = By.cssSelector(DATA_TEST_PATTERN.formatted("complete-header"));

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверяем отображение страницы")
    public boolean isPageTitleDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    @Step("Проверяем отображение кнопки Back Home")
    public boolean isBackHomeBtnDisplayed() {
        return driver.findElement(backHome).isDisplayed();
    }

    @Step("Берём текст заголовка страницы")
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    @Step("Берём текст кнопки Back Home")
    public String getBackHomeBtn() {
        return driver.findElement(backHome).getText();
    }

    @Step("Проверяем отображение сообщения об успехе")
    public boolean isMessageDisplayed() {
        return driver.findElement(successMsg).isDisplayed();
    }

    @Step("Берём текст сообщения об успехе")
    public String getSuccessMsg() {
        return driver.findElement(successMsg).getText();
    }
}
