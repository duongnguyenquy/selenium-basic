package com.daniel.learning;

import com.daniel.utils.Webdriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHandle {
    public static void main(String[] args) {
        WebDriver driver = Webdriver.getChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        final By jsAlertSelector = By.cssSelector("[onclick='jsAlert()']");
        final By jsAlertConfirmSelector = By.cssSelector("[onclick='jsConfirm()']");
        final By jsAlertPromptSelector = By.cssSelector("[onclick='jsPrompt()']");

        final By txtResult = By.id("result");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement jsAlert = driver.findElement(jsAlertSelector);
        jsAlert.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert content : " + alert.getText());
        alert.accept();
        System.out.println("Result : " + driver.findElement(txtResult).getText());

        driver.findElement(jsAlertConfirmSelector).click();
        Alert alertConfirm = wait.until(ExpectedConditions.alertIsPresent());
        alertConfirm.dismiss();

        System.out.println("Result : " + driver.findElement(txtResult).getText());

    }
}
