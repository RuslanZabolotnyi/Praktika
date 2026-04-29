package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;
import static user.UserFactory.withCorrectUser;

public class CheckoutCompleteTest extends BaseTest {
    @Epic("Интернет-магазин")
    @Feature("Оформление заказа")
    @Story("Завершение заказа")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Заболотный Руслан zabolotnyy-90@mail.ru")
    @TmsLink("Praktika")
    @Issue("Praktika")
    @Test
    public void checkoutGoComplete() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.navigationPanel.clickCart();
        cartPage.clickCheckoutBtn();
        checkoutYIPage.sendForm(withCorrectUser());
        checkoutOverview.clickFinishBtn();

        assertTrue(checkoutCompletePage.isPageTitleDisplayed(), "Checkout Complete page title is missing");
        assertEquals(checkoutCompletePage.getPageTitle(), "Checkout: Complete!");
        assertTrue(checkoutCompletePage.isBackHomeBtnDisplayed(), "Checkout back home button is not visible");
        assertEquals(checkoutCompletePage.getSuccessMsg(), "Thank you for your order!");
        assertEquals(checkoutCompletePage.getBackHomeBtn(), "Back Home");
        assertTrue(checkoutCompletePage.isMessageDisplayed(), "The error message did not appear");
    }
}
