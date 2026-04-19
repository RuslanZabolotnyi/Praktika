package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CartTest extends BaseTest {
    final String goodsName = "Test.allTheThings() T-Shirt (Red)";

    @Test
    public void openCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.navigationPanel.clickCart();
        assertTrue(cartPage.pageTitleDisplayed());
        assertEquals(cartPage.getTitle(), "Your Cart");
    }

    @Test
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(goodsName);
        productsPage.navigationPanel.clickCart();

        assertFalse(cartPage.getProductsNames().isEmpty());
        assertEquals(cartPage.getProductsNames().size(), 1);
        assertTrue(cartPage.getProductsNames().contains(goodsName));
    }
}
