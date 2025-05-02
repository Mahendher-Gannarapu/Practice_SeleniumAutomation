package com.mahendhergannarapu.Project1_App_VWO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VerifyUsername_Password_errorMessage {

    @Test
    public void verifyData() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        WebDriver driver =new ChromeDriver(options);
        driver.get("https://app.vwo.com/#/login");

        WebElement emailAddress = driver.findElement(By.id("login-username"));
        emailAddress.sendKeys("mahendher@gmail.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("Mahendher");

        WebElement clickSigninButton = driver.findElement(By.id("js-login-btn"));
        clickSigninButton.click();

        Thread.sleep(3000);

        //<div class="notification-box-description"
        // id="js-notification-box-msg"
        // data-qa="rixawilomi">
        // Your email, password, IP address or location did not match
        // </div>
        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        assertThat(error_message.getText()).isNotEmpty().isNotBlank().isEqualTo("Your email, password, IP address or location did not match");
        driver.quit();
    }
}
