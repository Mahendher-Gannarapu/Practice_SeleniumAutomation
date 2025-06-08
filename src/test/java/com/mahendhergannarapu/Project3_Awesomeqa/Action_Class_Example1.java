//Keyboards -> Keydown -> shift ->send key -> key up

package com.mahendhergannarapu.Project3_Awesomeqa;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Action_Class_Example1 {

    @Description("Verify the Action Events")
    @Test

    public void test_Action_Events() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://awesomeqa.com/practice.html");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //assertThat(driver.getTitle()).isEqualTo("awesomeqa.com/practice.html");
        assertThat(driver.getCurrentUrl()).isEqualTo("https://awesomeqa.com/practice.html");

        WebElement firstname = driver.findElement(By.name("firstname"));
        //Keyboards -> Keydown -> shift ->send key -> key up
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(firstname,"mahendher")
                        .keyUp(Keys.SHIFT).build().perform();

        Thread.sleep(3000);
        driver.quit();

    }

}
