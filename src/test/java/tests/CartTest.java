package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static enums.PageTitle.CART;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class CartTest extends BaseTest {
    final String goodsName = "Test.allTheThings() T-Shirt (Red)";

    @Epic("Интернет-магазин")
    @Feature("Корзина товаров")
    @Story("Навигация корзины")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Заболотный Руслан zabolotnyy-90@mail.ru")
    @TmsLink("Praktika")
    @Issue("Praktika")
    @Test
    public void openCart() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.navigationPanel.clickCart();
        assertTrue(cartPage.pageTitleDisplayed());
        assertEquals(cartPage.getTitle(), CART.getDisplayName());
    }

    @Epic("Интернет-магазин")
    @Feature("Корзина товаров")
    @Story("Добавление товара")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Заболотный Руслан zabolotnyy-90@mail.ru")
    @TmsLink("Praktika")
    @Issue("Praktika")
    @Test
    public void checkGoodsInCart() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.addToCart(goodsName);
        productsPage.navigationPanel.clickCart();

        assertFalse(cartPage.getProductsNames().isEmpty());
        assertEquals(cartPage.getProductsNames().size(), 1);
        assertTrue(cartPage.getProductsNames().contains(goodsName));
    }
}
