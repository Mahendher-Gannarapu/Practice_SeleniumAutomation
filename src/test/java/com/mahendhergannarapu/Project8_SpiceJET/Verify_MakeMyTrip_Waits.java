package com.mahendhergannarapu.Project8_SpiceJET;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Verify_MakeMyTrip_Waits {

    @Test
    public void test_PopUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.makemytrip.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Wait until the element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
        driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();

        Thread.sleep(3000);
        WebElement fromCity = driver.findElement(By.id("fromCity"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("del").build().perform();

        actions.moveToElement(fromCity).contextClick();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        actions.moveToElement(fromCity).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();


        Thread.sleep(3000);
        driver.quit();
    }
}
