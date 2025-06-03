package com.mahendhergannarapu.Project2_Katalon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Verify_InValidUN_PW_ErrorMessage {

    @Test
    public void test() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        Thread.sleep(3000);
        WebElement menu = driver.findElement(By.id("menu-toggle"));
        menu.click();

        Thread.sleep(3000);
        WebElement login_option = driver.findElement(By.linkText("Login"));
        login_option.click();

        Thread.sleep(3000);
        WebElement user_name = driver.findElement(By.id("txt-username"));
        user_name.sendKeys("Mahendher");

        Thread.sleep(3000);
        WebElement pass_word = driver.findElement(By.id("txt-password"));
        pass_word.sendKeys("Mahendher");

        Thread.sleep(3000);
        WebElement login_button = driver.findElement(By.id("btn-login"));
        login_button.click();

        //WebElement error_message1 = driver.findElement(By.className("invalid-reason"));
        //assertThat(error_message1.getText()).isEqualTo("The email address you entered is incorrect.");
        Thread.sleep(3000);
        //WebElement error_message = driver.findElement(By.className("lead text-danger"));
        WebElement error_message = driver.findElement(By.xpath("//p[contains(@class, 'lead') and contains(@class, 'text-danger')]"));
        assertThat(error_message.getText()).isEqualTo("Login failed! Please ensure the username and password are valid.");

        Thread.sleep(3000);
        driver.quit();

    }
}
