// **Example for NoSuchElementException:**
package com.mahendhergannarapu.Project1_App_VWO;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Verify_NoSuchElementException_Example {

    @Test
    public void test_Exception() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://vwo.com/free-trial");
        driver.manage().window().maximize();

        try {
            WebElement username =driver.findElement(By.id("Mahendher"));
            username.sendKeys("Mahendher");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
