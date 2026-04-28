package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.UserData;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

public class CheckoutYourInformationTest extends BaseTest {

    @Test
    public void checkGoToCheckout() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.navigationPanel.clickCart();
        cartPage.clickCheckoutBtn();

        assertTrue(checkoutYIPage.isPageTitleDisplayed(), "Checkout page title is missing");
        assertEquals(checkoutYIPage.getPageTitle(), "Checkout: Your Information");
        assertTrue(checkoutYIPage.isCancelBtnDisplayed(), "Checkout cancel button is not visible");
        assertEquals(checkoutYIPage.getCancelBtn(), "Cancel");
        assertTrue(checkoutYIPage.isContinueBtnDisplayed(), "Checkout continue button is not visible");
        assertEquals(checkoutYIPage.getContinueBtn(), "Continue");
        assertTrue(checkoutYIPage.isFirstNameFieldDisplayed(), "First name field should be empty");
        assertEquals(checkoutYIPage.getFirstNameField(), "", "First name field should be empty");
        assertTrue(checkoutYIPage.isLastNameFieldDisplayed(), "Last name field should be empty");
        assertEquals(checkoutYIPage.getLastNameField(), "", "Last name field should be empty");
        assertTrue(checkoutYIPage.isPostalCodeFieldDisplayed(), "Postal code field should be empty");
        assertEquals(checkoutYIPage.getPostalCodeField(), "", "Postal code field should be empty");
    }

    @Test
    public void checkCorrectUserData() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.navigationPanel.clickCart();
        cartPage.clickCheckoutBtn();
        checkoutYIPage.sendForm(withCorrectUser());

        assertEquals(checkoutYIPage.getPageTitle(), "Checkout: Overview");
    }

    @Test(dataProvider = "incorrectData")
    public void checkIncorrectUserData(UserData userData, String errorMessage) {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.navigationPanel.clickCart();
        cartPage.clickCheckoutBtn();
        checkoutYIPage.sendForm(userData);

        assertEquals(checkoutYIPage.getErrorMessage(), errorMessage);
    }

    @DataProvider(name = "incorrectData")
    public Object[][] userData() {
        return new Object[][]{
                {infoEmptyUserData(), "Error: First Name is required"},
                {infoEmptyFirstNameUserData(), "Error: First Name is required"}
        };
    }
}
