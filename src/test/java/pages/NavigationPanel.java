package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPanel {
    WebDriver driver;
    private final By cartLink = By.xpath("//a[@data-test='shopping-cart-link']");
    private final By cartBadge = By.xpath("//span[@data-test='shopping-cart-badge']");

    public NavigationPanel(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCart() {
        driver.findElement(cartLink).click();
    }

    public String checkCounterValue() {
        return driver.findElement(cartBadge).getText();
    }

    public String checkCounterColor() {
        return driver.findElement(cartBadge).getCssValue("background-color");
    }
}
