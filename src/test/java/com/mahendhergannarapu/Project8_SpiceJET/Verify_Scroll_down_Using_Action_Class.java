package com.mahendhergannarapu.Project8_SpiceJET;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.image.Kernel;
import java.time.Duration;

public class Verify_Scroll_down_Using_Action_Class {

    @Test
    public void test_Scrolling_using_Action_class() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://thetestingacademy.com/");
        driver.manage().window().maximize();
//        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""));
        //Wait until the element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        System.out.println("ScrollDown");

        Thread.sleep(5000);
        driver.quit();

        //WebElement elt = driver.findElement(By.id(""));
    }
}

