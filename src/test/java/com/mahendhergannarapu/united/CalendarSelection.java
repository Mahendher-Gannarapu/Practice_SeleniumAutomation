package com.mahendhergannarapu.united;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarSelection {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.united.com/en/in");

        driver.manage().window().maximize();

        // Select departure date (14 Nov 2025)
        driver.findElement(By.xpath("//button[@class='rdp-day_button' and contains(@aria-label,'November 14, 2025')]")).click();

        // Select return date (23 Dec 2025)
        driver.findElement(By.xpath("//button[@class='rdp-day_button' and contains(@aria-label,'December 23, 2025')]")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
