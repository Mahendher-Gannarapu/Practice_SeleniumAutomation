package com.mahendhergannarapu.E_Commerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Verify_Frame_WithIn_Frame {

        public static void main(String[] args) {
            WebDriver driver = new ChromeDriver();
            driver.get("https://example.com"); // Replace with your URL

            // Find all frames on the page
            List<WebElement> frames = driver.findElements(By.tagName("iframe"));

            System.out.println("Total frames on page: " + frames.size());

            boolean found = false;

            // Loop through each frame
            for (int i = 0; i < frames.size(); i++) {
                // Switch to frame by index
                driver.switchTo().frame(i);

                try {
                    // Try to locate the textbox inside this frame
                    WebElement textbox = driver.findElement(By.id("textboxId")); // Replace with actual locator
                    textbox.sendKeys("Hello, Selenium!");
                    System.out.println("Textbox found in frame index: " + i);
                    found = true;
                    break; // Stop once found
                } catch (Exception e) {
                    // If not found in this frame, switch back and continue
                    driver.switchTo().defaultContent();
                }
            }

            if (!found) {
                System.out.println("Textbox not found in any frame.");
            }

            driver.quit();
        }
    }

