package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CART_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By addToCartBtn = By.xpath("//*[text() ='Add to cart']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Берём текст заголовка страницы")
    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    @Step("Проверяем кнопку Add to cart")
    public void addToCart() {
        driver.findElements(addToCartBtn).get(1).click();
    }

    @Step("Проверяем количество добавленных товаров")
    public int getGoodsQuantity() {
        return driver.findElements(addToCartBtn).size();
    }

    @Step("Добавляем товар в корзину")
    public void addToCart(final String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    @Step("Проверяем отображение страницы")
    public boolean pageTitleDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }
}
