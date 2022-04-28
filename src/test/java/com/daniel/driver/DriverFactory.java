package com.daniel.driver;

import com.daniel.utils.Webdriver;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private WebDriver driver;

    WebDriver getDriver() {
        if (driver == null) {
            driver = Webdriver.getChromeDriver();
        }

        return driver;
    }
}
