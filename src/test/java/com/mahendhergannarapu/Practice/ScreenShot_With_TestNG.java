package com.mahendhergannarapu.Practice;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShot_With_TestNG {

    WebDriver driver; // Declare driver globally to use across methods

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testGoogleHomePage() {
        driver.get("https://www.google.com/");
    }

    @AfterMethod
    public void takeScreenshotOnSuccess(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.SUCCESS) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("screenshots/" + result.getName() + "_success.png");
            FileHandler.copy(src, dest);
            System.out.println("Screenshot taken for successful test: " + result.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }
}