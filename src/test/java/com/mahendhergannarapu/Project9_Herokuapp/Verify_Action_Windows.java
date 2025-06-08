package com.mahendhergannarapu.Project9_Herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.Set;

public class Verify_Action_Windows {

    @Test
    public void test_Windows() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/windows");

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window Handle "+ parentWindow);

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandles =driver.getWindowHandles();
        System.out.println("Window Handles: " + windowHandles);

        for (String handle:windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getPageSource().contains("New Window")) {
                System.out.println("Testcase Passed!!");
                break;
            }
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
