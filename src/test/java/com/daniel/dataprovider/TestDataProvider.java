package com.daniel.dataprovider;

import com.daniel.model.pages.LoginPage;
import com.daniel.utils.URL;
import com.daniel.utils.Webdriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestDataProvider {

    @Test(dataProvider = "loginProvider")
    public void login(String username, String password) {
        WebDriver driver = Webdriver.getEdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        LoginPage loginPage = new LoginPage(wait);

        driver.get(URL.getTestPageURL("LOGIN_PAGE"));

        loginPage.loginWithUsernameAndPassword(username, password);

        driver.quit();
    }

    @DataProvider
    public Object[][] loginProvider() {
        Object[][] data = new Object[2][2];

        data[0][0] = "tomsmith";
        data[0][1] = "SuperSecretPassword!";

        data[1][0] = "tomsmith";
        data[1][1] = "wrong";
        return data;
    }

}
