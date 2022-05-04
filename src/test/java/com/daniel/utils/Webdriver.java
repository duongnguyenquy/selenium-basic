package com.daniel.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class Webdriver {
    public static WebDriver getChromeDriver() {
        String chromePath = System.getProperty("user.dir") + "/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        return driver;
    }

    public static WebDriver getEdgeDriver() {
        String edgePath = System.getProperty("user.dir") + "/msedgedriver.exe";
        System.setProperty("webdriver.edge.driver", edgePath);

        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-dev-shm-usage");
        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        return driver;
    }

}
