package com.mahendhergannarapu.Project1_App_VWO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Verify_Start_A_Free_trail_Anchor_Tag {

    @Test
    public void test_Free_trail() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        WebElement link_option = driver.findElement(By.linkText("Start a free trial"));
        link_option.click();

        Thread.sleep(3000);

        driver.quit();
    }
}
