package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {
    @Test
    public void openCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickCart();
        assertTrue(cartPage.pageTitleDisplayed());
        assertEquals(cartPage.getTitle(), "Your Cart");
    }
}
