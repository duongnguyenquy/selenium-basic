package com.daniel.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriverWait wait;

    public LoginPage(WebDriverWait wait) {
        this.wait = wait;
    }

    public WebElement username() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
    }

    public WebElement password() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    }

    public WebElement loginBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']")));
    }

    public void loginWithUsernameAndPassword(String username, String password) {
        username().sendKeys(username);
        password().sendKeys(password);
        loginBtn().click();
    }
}
