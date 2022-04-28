package com.daniel.learning;

import com.daniel.utils.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandle {
    public static void main(String[] args) {
        WebDriver driver = Webdriver.getChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select ddlist = new Select(driver.findElement(By.id("dropdown")));

        ddlist.selectByVisibleText("Option 1");

        try {
            Thread.sleep(2000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ddlist.selectByValue("2");



    }
}
