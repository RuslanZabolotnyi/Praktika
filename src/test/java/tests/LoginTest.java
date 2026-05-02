package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static enums.PageTitle.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

@Epic("Интернет-магазин")
@Feature("Страница авторизации пользователя")
@Owner("Заболотный Руслан zabolotnyy-90@mail.ru")
public class LoginTest extends BaseTest {

    @Story("Ввод данных пользователя")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("Praktika")
    @Issue("Praktika")
    @Test
    public void checkLogin() {
        loginPage
                .open()
                .login(withAdminPermission());

        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName());
    }

    @Story("Валидация негативных сценариев входа")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("Praktika")
    @Issue("Praktika")
    @Test(dataProvider = "incorrectData")
    public void checkIncorrectLogin(User user, String errorMessage) {
        loginPage
                .open()
                .login(user);

        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails to appear");
        assertEquals(loginPage.getErrorMsg(), errorMessage, "Epic sadface: Sorry, this user has been locked out.");
    }

    @DataProvider(name = "incorrectData")
    public Object[][] loginData() {
        return new Object[][]{
                {withLockedPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {withEmptyUserPermission(), "Epic sadface: Username is required"},
                {withEmptyPassPermission(), "Epic sadface: Password is required"},
                {withIncorrectPermission(), "Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
