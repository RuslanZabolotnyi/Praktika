package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.UserData;

public class CheckoutYourInformationPage extends BasePage {
    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By cancelBtn = By.cssSelector(DATA_TEST_PATTERN.formatted("cancel"));
    private final By continueBtn = By.cssSelector(DATA_TEST_PATTERN.formatted("continue"));
    private final By firstNameField = By.cssSelector(DATA_TEST_PATTERN.formatted("firstName"));
    private final By lastNameField = By.cssSelector(DATA_TEST_PATTERN.formatted("lastName"));
    private final By postalCodeField = By.cssSelector(DATA_TEST_PATTERN.formatted("postalCode"));
    private final By errorMassage = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверяем отображение страницы")
    public boolean isPageTitleDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    @Step("Проверяем отображение кнопки Cancel")
    public boolean isCancelBtnDisplayed() {
        return driver.findElement(cancelBtn).isDisplayed();
    }

    @Step("Проверяем отображение кнопки Continue")
    public boolean isContinueBtnDisplayed() {
        return driver.findElement(continueBtn).isDisplayed();
    }

    @Step("Проверяем отображение поля Имя")
    public boolean isFirstNameFieldDisplayed() {
        return driver.findElement(firstNameField).isDisplayed();
    }

    @Step("Проверяем отображение поля Фамилия")
    public boolean isLastNameFieldDisplayed() {
        return driver.findElement(lastNameField).isDisplayed();
    }

    @Step("Проверяем отображение поля Postal code")
    public boolean isPostalCodeFieldDisplayed() {
        return driver.findElement(postalCodeField).isDisplayed();
    }

    @Step("Берём текст заголовка страницы")
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    @Step("Берём текст кнопки Cancel")
    public String getCancelBtn() {
        return driver.findElement(cancelBtn).getText();
    }

    @Step("Берём текст кнопки Continue")
    public String getContinueBtn() {
        return driver.findElement(continueBtn).getAttribute("value");
    }

    @Step("Берём текст поля Имя")
    public String getFirstNameField() {
        return driver.findElement(firstNameField).getText();
    }

    @Step("Берём текст поля Фамилия")
    public String getLastNameField() {
        return driver.findElement(lastNameField).getText();
    }

    @Step("Берём текст поля Postal code")
    public String getPostalCodeField() {
        return driver.findElement(postalCodeField).getText();
    }

    @Step("Заполняем поле Имя")
    public void fillInFirstName(String firstname) {
        driver.findElement(firstNameField).sendKeys(firstname);
    }

    @Step("Заполняем поле Фамилия")
    public void fillInLastName(String lastname) {
        driver.findElement(lastNameField).sendKeys(lastname);
    }

    @Step("Заполняем поле Postal code")
    public void fillInPostalCode(String postalCode) {
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    @Step("Отправляем форму с данными пользователя")
    public void sendForm(UserData userData) {
        fillInFirstName(userData.getFirstname());
        fillInLastName(userData.getLastname());
        fillInPostalCode(userData.getPostalCode());
        driver.findElement(continueBtn).click();
    }

    @Step("Берём текст сообщения об ошибке")
    public String getErrorMessage() {
        return driver.findElement(errorMassage).getText();
    }
}
