package com.daniel.learning;

import com.daniel.utils.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartChrome {
    public static void main(String[] args) {
        WebDriver driver = Webdriver.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        String log4jConfigPath = System.getProperty("user.res") + "/log4j2.xml";
        System.setProperty("log4j2.configurationFile", log4jConfigPath);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit2']")));
        driver.findElement(By.cssSelector("[type='submit']")).click();


//        driver.close();
//        driver.quit();
    }
}
