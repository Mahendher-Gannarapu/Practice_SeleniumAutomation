package com.mahendhergannarapu.Project8_SpiceJET;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.image.Kernel;

public class Verify_Scroll_down_Using_Action_Class {

    @Test
    public void test_Scrolling_using_Action_class() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://thetestingacademy.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        System.out.println("ScrollDown");

        Thread.sleep(5000);
        driver.quit();
    }
}
