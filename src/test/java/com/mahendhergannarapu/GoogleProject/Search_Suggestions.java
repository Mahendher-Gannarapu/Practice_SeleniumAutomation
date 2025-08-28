package com.mahendhergannarapu.GoogleProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Search_Suggestions {
    public static void main(String[] args) throws InterruptedException {
            // Launch Chrome
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            // Open Google
            driver.get("https://www.google.com/");

            // Enter text in search box
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("news daily");

            // Wait for suggestions to load
            Thread.sleep(2000);

            // Capture suggestions list
            List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));

            // Print all suggestions
            System.out.println("Suggestions List:");
            for (int i = 0; i < suggestions.size(); i++) {
                System.out.println((i + 1) + ". " + suggestions.get(i).getText());
            }

            // Click on 3rd suggestion (index 2 since list starts from 0)
            if (suggestions.size() >= 3) {
                suggestions.get(2).click();
            } else {
                System.out.println("Less than 3 suggestions found.");
            }

            // Close browser
            Thread.sleep(3000);
            driver.quit();
        }
    }
