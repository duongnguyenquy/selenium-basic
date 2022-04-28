package com.daniel.learning;

import com.daniel.driver.DriverBase;
import com.daniel.model.pages.LoginPage;
import com.daniel.utils.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class Login extends DriverBase {

    @BeforeTest
    public void setUp() {
        System.out.println("Setup");
    }

    @AfterTest
    public void teardown() {
        System.out.println("Teardown");
    }

    @BeforeMethod
    public void runBeforeMethod() {
        System.out.println("Before run method");
    }

    @AfterMethod
    public void runAfterMethod() {
        System.out.println("After run method");
    }

    @Test
    public void loginWithIncorrectCredentials() {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        LoginPage loginPage = new LoginPage(wait);

        driver.manage().window().maximize();
        driver.get(URL.getTestPageURL("LOGIN"));
        loginPage.loginWithUsernameAndPassword("My username", "My Password");
    }

    @Test
    public void loginWithCorrectCredentials() {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        LoginPage loginPage = new LoginPage(wait);

        driver.manage().window().maximize();
        driver.get(URL.getTestPageURL("LOGIN"));
        loginPage.loginWithUsernameAndPassword("tomsmith", "SuperSecretPassword!");
    }


}
