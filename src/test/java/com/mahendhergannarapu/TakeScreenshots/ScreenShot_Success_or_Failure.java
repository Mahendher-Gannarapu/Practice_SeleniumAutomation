//Capture Screenshot if Test Case Passes or Fails
package com.mahendhergannarapu.TakeScreenshots;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenShot_Success_or_Failure {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testGoogleHomePage() {
        driver.get("https://www.googe.com/");
        // You can force pass/fail for testing like:
        // Assert.assertTrue(false); // for failure
    }

    @AfterMethod
    public void captureScreenshot(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.SUCCESS || result.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            String status = (result.getStatus() == ITestResult.SUCCESS) ? "pass" : "fail";
            File dest = new File("screenshots/" + result.getName() + "_" + status + ".png");

            FileHandler.copy(src, dest);
            System.out.println("Screenshot captured for " + status + "ed test: " + result.getName());
        }

        if (driver != null) {
            driver.quit();
        }
    }
}