package com.daniel.learning;

import com.daniel.utils.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class MultiWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Webdriver.getChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");

        By clickHereLinkTextLocator = By.linkText("Click Here");

        WebElement clickHereLinkText = driver.findElement(clickHereLinkTextLocator);

        clickHereLinkText.click();
        Thread.sleep(1000);

        List<String> listWindows = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(listWindows.get(1));

        System.out.println("New Window URL : " + driver.getCurrentUrl());
        System.out.println("New Window Title : " + driver.getTitle());

        driver.close();

        listWindows = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(listWindows.get(0));

        System.out.println("1st Window URL : " + driver.getCurrentUrl());
        System.out.println("1st Window Title : " + driver.getTitle());

        driver.close();
        driver.quit();
    }
}
