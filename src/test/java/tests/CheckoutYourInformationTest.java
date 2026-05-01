package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import user.UserData;
import static org.testng.Assert.assertEquals;
import static user.UserFactory.*;

public class CheckoutYourInformationTest extends BaseTest {
    @Epic("Интернет-магазин")
    @Feature("Оформление заказа")
    @Story("Ввод данных заказа")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Заболотный Руслан zabolotnyy-90@mail.ru")
    @TmsLink("Praktika")
    @Issue("Praktika")
    @Test
    public void checkGoToCheckout() {
        SoftAssert soft = new SoftAssert();
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.navigationPanel.clickCart();
        cartPage.clickCheckoutBtn();

        soft.assertTrue(checkoutYIPage.isPageTitleDisplayed(), "Checkout page title is missing");
        soft.assertEquals(checkoutYIPage.getPageTitle(), "Checkout: Your Information");
        soft.assertTrue(checkoutYIPage.isCancelBtnDisplayed(), "Checkout cancel button is not visible");
        soft.assertEquals(checkoutYIPage.getCancelBtn(), "Cancel");
        soft.assertTrue(checkoutYIPage.isContinueBtnDisplayed(), "Checkout continue button is not visible");
        soft.assertEquals(checkoutYIPage.getContinueBtn(), "Continue");
        soft.assertTrue(checkoutYIPage.isFirstNameFieldDisplayed(), "First name field should be empty");
        soft.assertEquals(checkoutYIPage.getFirstNameField(), "", "First name field should be empty");
        soft.assertTrue(checkoutYIPage.isLastNameFieldDisplayed(), "Last name field should be empty");
        soft.assertEquals(checkoutYIPage.getLastNameField(), "", "Last name field should be empty");
        soft.assertTrue(checkoutYIPage.isPostalCodeFieldDisplayed(), "Postal code field should be empty");
        soft.assertEquals(checkoutYIPage.getPostalCodeField(), "", "Postal code field should be empty");

        soft.assertAll();
    }

    @Epic("Интернет-магазин")
    @Feature("Оформление заказа")
    @Story("Ввод пользовательских данных")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Заболотный Руслан zabolotnyy-90@mail.ru")
    @TmsLink("Praktika")
    @Issue("Praktika")
    @Test
    public void checkCorrectUserData() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.navigationPanel.clickCart();
        cartPage.clickCheckoutBtn();
        checkoutYIPage.sendForm(withCorrectUser());

        assertEquals(checkoutYIPage.getPageTitle(), "Checkout: Overview");
    }

    @Epic("Интернет-магазин")
    @Feature("Оформление заказа")
    @Story("Валидация негативных сценариев ввода данных")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Заболотный Руслан zabolotnyy-90@mail.ru")
    @TmsLink("Praktika")
    @Issue("Praktika")
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
