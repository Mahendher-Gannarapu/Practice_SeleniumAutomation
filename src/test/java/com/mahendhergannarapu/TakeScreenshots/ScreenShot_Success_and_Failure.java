//Capture Screenshot Test Case Passes and Fails
package com.mahendhergannarapu.TakeScreenshots;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

    public class ScreenShot_Success_and_Failure {

        WebDriver driver;

        @BeforeMethod
        public void setup() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }

        @Test
        public void testGooglePass() {
            driver.get("https://www.google.com/");
//            String title = driver.getTitle();
//            assert title.contains("Google"); // This will pass
        }

        @Test
        public void testGoogleFail() {
            driver.get("https://www.goog.com/");
//            String title = driver.getTitle();
//            assert title.contains("Yahoo"); // This will fail
        }

        @AfterMethod
        public void takeScreenshot(ITestResult result) throws IOException {
            if (ITestResult.SUCCESS == result.getStatus() || ITestResult.FAILURE == result.getStatus()) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File src = ts.getScreenshotAs(OutputType.FILE);
                String status = (result.getStatus() == ITestResult.SUCCESS) ? "success" : "failure";
                File dest = new File("screenshots/" + result.getName() + "_" + status + ".png");
                FileHandler.copy(src, dest);
                System.out.println("Screenshot taken for " + status + " test: " + result.getName());
            }
            driver.quit();
        }
    }
