package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import user.UserData;

import static enums.PageTitle.CHECKOUT_OV;
import static enums.PageTitle.CHECKOUT_YI;
import static org.testng.Assert.assertEquals;
import static user.UserFactory.*;

@Epic("Интернет-магазин")
@Feature("Оформление заказа")
@Owner("Заболотный Руслан zabolotnyy-90@mail.ru")
public class CheckoutYourInformationTest extends BaseTest {

    @Story("Ввод данных заказа")
    @Severity(SeverityLevel.BLOCKER)
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
        soft.assertEquals(checkoutYIPage.getPageTitle(), CHECKOUT_YI.getDisplayName());
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

    @Story("Ввод пользовательских данных")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("Praktika")
    @Issue("Praktika")
    @Test
    public void checkCorrectUserData() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.navigationPanel.clickCart();
        cartPage.clickCheckoutBtn();
        checkoutYIPage.sendForm(withCorrectUser());

        assertEquals(checkoutYIPage.getPageTitle(), CHECKOUT_OV.getDisplayName());
    }

    @Story("Валидация негативных сценариев ввода данных")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("Praktika")
    @Issue("Praktika")
    @Test(dataProvider = "incorrectData")
    public void checkIncorrectUserData(UserData userData, String errorMessage) {
        loginPage
                .open()
                .login(withAdminPermission());
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
