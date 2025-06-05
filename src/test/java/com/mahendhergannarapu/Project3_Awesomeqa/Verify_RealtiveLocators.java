package com.mahendhergannarapu.Project3_Awesomeqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Verify_RealtiveLocators {

    @Test
    public void testRelativeLocators() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/practice.html");

        WebElement span_element= driver.findElement(By.xpath("//span[normalize-space()='Years of Experience']"));
        //driver.findElement(with(By.id("exp-2")).toRightOf(span_element)).click();
        driver.findElement(with(By.id("exp-2")).toRightOf(span_element)).click();

        Thread.sleep(3000);
        driver.quit();


    }
}
