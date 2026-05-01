package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import utils.AllureUtils;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

public class LoginTest extends BaseTest {
    @Epic("Интернет-магазин")
    @Feature("Страница авторизации пользователя")
    @Story("Ввод данных пользователя")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Заболотный Руслан zabolotnyy-90@mail.ru")
    @TmsLink("Praktika")
    @Issue("Praktika")
    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login(withAdminPermission());

        AllureUtils.takeScreenShot(driver);
        assertEquals(productsPage.getTitle(), "Products");
    }

    @Epic("Интернет-магазин")
    @Feature("Страница авторизации пользователя")
    @Story("Валидация негативных сценариев входа")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Заболотный Руслан zabolotnyy-90@mail.ru")
    @TmsLink("Praktika")
    @Issue("Praktika")
    @Test(dataProvider = "incorrectData")
    public void checkIncorrectLogin(User user, String errorMessage) {
        loginPage.open();
        loginPage.login(user);

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
