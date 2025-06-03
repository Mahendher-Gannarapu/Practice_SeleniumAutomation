package com.mahendhergannarapu.Project4_Idrive360.WithDefaultLocaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Verify_Free_trail_Message_ExplicitWait {

    @Test
    public void Test_Message_After_Login() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.idrive360.com/enterprise/login");
//        Thread.sleep(30000);
        //using Explicit wait

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.titleIs("IDrive 360 account details"));
        wait.until(ExpectedConditions.urlToBe("https://www.idrive360.com/enterprise/login"));
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //Thread.sleep(30000);
        //WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(3000));
        //wait.until(ExpectedConditions.textToBePresentInElement(email_enter,"augtest_040823@idrive.com"));
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
