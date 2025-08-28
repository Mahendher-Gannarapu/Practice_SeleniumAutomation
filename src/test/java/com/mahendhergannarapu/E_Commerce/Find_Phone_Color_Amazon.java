package com.mahendhergannarapu.E_Commerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Find_Phone_Color_Amazon {

    @Test
    public void verify_Color() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Samsung Galaxy S24 Ultra 5G AI Smartphone with Galaxy AI (Titanium Black, 12GB, 256GB Storage), Snapdragon 8 Gen 3, 200 MP Camera with ProVisual Engine and 5000mAh Battery']")));
        driver.findElement(By.xpath("//span[text()='Samsung Galaxy S24 Ultra 5G AI Smartphone with Galaxy AI (Titanium Black, 12GB, 256GB Storage), Snapdragon 8 Gen 3, 200 MP Camera with ProVisual Engine and 5000mAh Battery']")).click();

        List<WebElement> colorOptions = driver.findElements(By.xpath("//ul[@data-action='a-button-group']/li"));

        //Loop through colors and Yellow
        boolean foundBlack = false;
        for(WebElement colorOption : colorOptions)
        {
            String colorName = colorOption.getText().trim();
            System.out.println("Found Color name: " + colorName);
            if(colorName.equalsIgnoreCase("Black"))
            {
                System.out.println("Found Black color option");
                foundBlack = true;
                break;
            }
        }

        if(!foundBlack)
        {
            System.out.println("Black color not available for this product");
        }
        Thread.sleep(3000);
        driver.quit();


    }
}
