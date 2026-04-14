package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By userField = By.xpath("//*[@id='user-name']");
    private final By passwordField = By.xpath("//*[@placeholder='Password']");
    private final By submitButton = By.xpath("//*[@data-test='login-button']");
    private final By errorMsg = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String login, String password) {
        fillInLoginField(login);
        fillInPassField(password);
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
