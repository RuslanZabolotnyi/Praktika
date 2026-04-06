package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestOpenSite extends BaseTest {

    @Test
    public void checkLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@data-test='login-button']")).click();
        String title = driver.findElement(By.xpath("//span[@data-test='title']")).getText();
        assertEquals(title, "Products");
    }

    @Test
    public void checkIncorrectLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("locked_out_user");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@data-test='login-button']")).click();
        boolean isErrorMsgDisplayed = driver.findElement(By.xpath("//*[@data-test='error']")).isDisplayed();
        assertTrue(isErrorMsgDisplayed, "The error message fails to appear");
        String title = driver.findElement(By.xpath("//*[@data-test='error']")).getText();
        assertEquals(title, "Epic sadface: Sorry, this user has been locked out.");
    }
}
