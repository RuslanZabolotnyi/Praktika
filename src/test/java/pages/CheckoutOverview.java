package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverview extends BasePage {
    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By finishBtn = By.cssSelector(DATA_TEST_PATTERN.formatted("finish"));

    public CheckoutOverview(WebDriver driver) {
        super(driver);
    }

    @Step("Проверяем отображение страницы")
    public boolean isPageTitleDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    @Step("Проверяем отображение кнопки Finish")
    public boolean isFinishBtnDisplayed() {
        return driver.findElement(finishBtn).isDisplayed();
    }

    @Step("Берём текст заголовка страницы")
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    @Step("Берём текст кнопки Finish")
    public String getFinishBtn() {
        return driver.findElement(finishBtn).getText();
    }

    @Step("Нажимаем на кнопку Finish")
    public void clickFinishBtn() {
        driver.findElement(finishBtn).click();
    }
}
