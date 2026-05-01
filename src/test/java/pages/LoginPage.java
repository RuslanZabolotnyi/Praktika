package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    private final By userField = By.xpath("//*[@id='user-name']");
    private final By passwordField = By.xpath("//*[@placeholder='Password']");
    private final By submitButton = By.cssSelector(DATA_TEST_PATTERN.formatted("login-button"));
    private final By errorMsg = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие сайта")
    public void open() {
        driver.get(BASE_URL);
    }

    public void open(final String url) {
        driver.get(BASE_URL + url);
    }

    @Step("Авторизуемся с данными пользователя")
    public void login(User user) {
        fillInLoginField(user.getLogin());
        fillInPassField(user.getPassword());
        driver.findElement(submitButton).click();
    }

    @Step("Заполняем поле ввода логина")
    public void fillInLoginField(String login) {
        driver.findElement(userField).sendKeys(login);
    }

    @Step("Заполняем поле ввода пароля")
    public void fillInPassField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Проверяем отображение сообщения об ошибке")
    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }

    @Step("Берём текст из сообщения об ошибке")
    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }
}
