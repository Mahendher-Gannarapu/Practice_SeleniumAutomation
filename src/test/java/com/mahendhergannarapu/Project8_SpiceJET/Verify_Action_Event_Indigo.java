package com.mahendhergannarapu.Project8_SpiceJET;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Verify_Action_Event_Indigo {

    @Test
    public void test_Action_Keyboard() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
//      options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.goindigo.in/");
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());

        Thread.sleep(15000);
        WebElement from_input = driver.findElement(By.xpath("//div[@class='journey-row ']/div/div/div/input"));

        Actions actions = new Actions(driver);
        actions.moveToElement(from_input).click().sendKeys("HYD").build().perform();


        Thread.sleep(8000);
        driver.quit();
    }
}
