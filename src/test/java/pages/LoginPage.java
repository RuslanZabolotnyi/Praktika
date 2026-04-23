package pages;

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

    public void open() {
        driver.get(BASE_URL);
    }
    public void open(final String url) {
        driver.get(BASE_URL + url);
    }
    public void login(User user) {
        fillInLoginField(user.getLogin());
        fillInPassField(user.getPassword());
        driver.findElement(submitButton).click();
    }

    public void fillInLoginField(String login) {
        driver.findElement(userField).sendKeys(login);
    }

    public void fillInPassField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }

    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }
}
