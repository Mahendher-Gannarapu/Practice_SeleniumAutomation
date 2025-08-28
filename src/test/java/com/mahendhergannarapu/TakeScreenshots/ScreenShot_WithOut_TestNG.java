package com.mahendhergannarapu.TakeScreenshots;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot_WithOut_TestNG {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        // Capture screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Define target location
        File target = new File("screenshot.png");
        // Save screenshot
        Files.copy(src.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);

        driver.quit();
        System.out.println("Screenshot captured and saved. You can share the 'screenshot.png' via email to QA Lead.");
    }
}
