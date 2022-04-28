package com.daniel.driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverBase {

    private static List<DriverFactory> webdriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    private static ThreadLocal<DriverFactory> driverThread;

    @BeforeSuite(alwaysRun = true)
    public static void initDriverThreadPool() {
        driverThread = ThreadLocal.withInitial(() -> {
            DriverFactory webdriverThread = new DriverFactory();
            webdriverThreadPool.add(webdriverThread);
            return webdriverThread;
        });
    }

    public static WebDriver getDriver() {
        return driverThread.get().getDriver();
    }

    @AfterSuite(alwaysRun = true)
    public static void afterMethod() {
        for (DriverFactory driver : webdriverThreadPool) {
            driver.getDriver().quit();
        }
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {

            String methodName = result.getName();

            String fileLocation = System.getProperty("user.dir") + "/screenshots" + methodName + ".png";

            File screenshot = ((TakesScreenshot) driverThread.get().getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File(fileLocation));
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
