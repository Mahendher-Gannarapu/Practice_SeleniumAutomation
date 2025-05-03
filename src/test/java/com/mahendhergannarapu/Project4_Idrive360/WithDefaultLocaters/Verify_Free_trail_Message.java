package com.mahendhergannarapu.Project4_Idrive360.WithDefaultLocaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Verify_Free_trail_Message {

    @Test
    public void Test_Message_After_Login() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.idrive360.com/enterprise/login");
        Thread.sleep(30000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        Thread.sleep(30000);
        WebElement email_enter = driver.findElement(By.id("username"));
        email_enter.sendKeys("augtest_040823@idrive.com");

        Thread.sleep(30000);
        WebElement pass_word = driver.findElement(By.id("password"));
        pass_word.sendKeys("123456");

        WebElement signib_button = driver.findElement(By.id("frm-btn"));
        signib_button.click();

        Thread.sleep(30000);
        WebElement message = driver.findElement(By.className("id-plan-name"));
        assertThat(message.getText()).isEqualTo("Free trial");

        Thread.sleep(30000);
        WebElement message_page = driver.findElement(By.className("id-card-title"));
        assertThat(message_page.getText()).isEqualTo("Your free trial has expired");

        Thread.sleep(3000);
        driver.quit();

    }
}
