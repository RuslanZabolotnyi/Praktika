package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;
import static user.UserFactory.withCorrectUser;

public class CheckoutOverviewTest extends BaseTest {

    @Test
    public void checkoutGoOverview() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.navigationPanel.clickCart();
        cartPage.clickCheckoutBtn();
        checkoutYIPage.sendForm(withCorrectUser());

        assertTrue(checkoutOverview.isPageTitleDisplayed(), "Checkout Overview page title is missing");
        assertEquals(checkoutOverview.getPageTitle(), "Checkout: Overview");
        assertTrue(checkoutOverview.isFinishBtnDisplayed(), "Checkout finish button is not visible");
        assertEquals(checkoutOverview.getFinishBtn(), "Finish");
    }
}
