package pages;

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

    public boolean isPageTitleDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public boolean isCancelBtnDisplayed() {
        return driver.findElement(cancelBtn).isDisplayed();
    }

    public boolean isContinueBtnDisplayed() {
        return driver.findElement(continueBtn).isDisplayed();
    }

    public boolean isFirstNameFieldDisplayed() {
        return driver.findElement(firstNameField).isDisplayed();
    }

    public boolean isLastNameFieldDisplayed() {
        return driver.findElement(lastNameField).isDisplayed();
    }

    public boolean isPostalCodeFieldDisplayed() {
        return driver.findElement(postalCodeField).isDisplayed();
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public String getCancelBtn() {
        return driver.findElement(cancelBtn).getText();
    }

    public String getContinueBtn() {
        return driver.findElement(continueBtn).getAttribute("value");
    }

    public String getFirstNameField() {
        return driver.findElement(firstNameField).getText();
    }

    public String getLastNameField() {
        return driver.findElement(lastNameField).getText();
    }

    public String getPostalCodeField() {
        return driver.findElement(postalCodeField).getText();
    }

    public void fillInFirstName(String firstname) {
        driver.findElement(firstNameField).sendKeys(firstname);
    }

    public void fillInLastName(String lastname) {
        driver.findElement(lastNameField).sendKeys(lastname);
    }

    public void fillInPostalCode(String postalCode) {
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void sendForm(UserData userData) {
        fillInFirstName(userData.getFirstname());
        fillInLastName(userData.getLastname());
        fillInPostalCode(userData.getPostalCode());
        driver.findElement(continueBtn).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMassage).getText();
    }
}
