package com.daniel.learning;

import com.daniel.utils.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.sound.midi.Soundbank;
import java.util.List;

public class Checkboxes {

    public static void main(String[] args) {
        WebDriver driver = Webdriver.getChromeDriver();

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();

        List<WebElement> list = driver.findElements(By.cssSelector("[type='checkbox']"));

        final int FIRST_CHK = 0;
        final int SECOND_CHK = 1;

        WebElement chkbox1 = list.get(FIRST_CHK);
        WebElement chkbox2 = list.get(SECOND_CHK);

        System.out.println("Checkbox 1 is " + chkbox1.isSelected());
        System.out.println("Checkbox 2 is " + chkbox2.isSelected());

        chkbox1.click();

        System.out.println("Checkbox 1 is " + chkbox1.isSelected());
        System.out.println("Checkbox 2 is " + chkbox2.isSelected());

        chkbox2.click();

        System.out.println("Checkbox 1 is " + chkbox1.isSelected());
        System.out.println("Checkbox 2 is " + chkbox2.isSelected());



        driver.close();
        driver.quit();

    }
}
