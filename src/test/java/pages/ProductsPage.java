package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private final By pageTitle = By.xpath("//span[@data-test='title']");
    private final By cartLink = By.xpath("//a[@data-test='shopping-cart-link']");
    private final By cartBadge = By.xpath("//span[@data-test='shopping-cart-badge']");
    private final By addToCartBtn = By.xpath("//*[text() ='Add to cart']");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void addToCart() {
        driver.findElements(addToCartBtn).get(2).click();
    }

    public boolean pageTitleDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public String checkCounterValue() {
        return driver.findElement(cartBadge).getText();
    }

    public String checkCounterColor() {
        return driver.findElement(cartBadge).getCssValue("background-color");
    }

    public void clickCart() {
        driver.findElement(cartLink).click();
    }
}
