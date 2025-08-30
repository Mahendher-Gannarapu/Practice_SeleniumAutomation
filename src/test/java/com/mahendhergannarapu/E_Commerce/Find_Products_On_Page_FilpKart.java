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

public class Find_Products_On_Page_FilpKart {

    @Test
    public void verify_Color() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.flipkart.com/");

        driver.findElement(By.name("q")).sendKeys("mobiles");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Motorola g45 5G (Pantone Dahlia Purple, 128 GB)']")));
        //driver.findElement(By.xpath("//div[text()='Motorola g45 5G (Pantone Dahlia Purple, 128 GB)']")).click();

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));

        //Find product count
        System.out.println("Products count: " + products.size());

        //Print product names
        for(WebElement product : products)
        {
            System.out.println("Product name :" + product.getText());
            System.out.println("------------------------");
        }

        Thread.sleep(3000);
        driver.quit();


    }
}
