package com.daniel.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private WebDriverWait wait;


    public DashboardPage(WebDriverWait wait) {
        this.wait = wait;
    }

    public WebElement getFlashMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
    }

    public WebElement getPageHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
    }

    public WebElement getSubHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("subheader")));
    }

    public WebElement getLogoutBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".example a")));
    }

}
