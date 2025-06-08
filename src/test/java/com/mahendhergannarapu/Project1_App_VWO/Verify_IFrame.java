package com.mahendhergannarapu.Project1_App_VWO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class Verify_IFrame {

    @Test
    public void test_IFrame_Windows() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        //Storing the parent window becoz we will be using it
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("Parent -> " + parentWindowHandle);

        // Now here Parent window
        List<WebElement> list_heatmaps = driver.findElements(By.cssSelector("[data-qa=\"yedexafobi\"]"));

        //Over and click done.
        Actions actions = new Actions(driver);
        actions.moveToElement(list_heatmaps.get(2)).click().build().perform();


//        Thread.sleep(13000);
//        // Ignore parent window in child window. In Child window waited 13 seconds Switch to IFrame
//        Set<String> allHandles = driver.getWindowHandles();
//        System.out.println("All Window Handles: " + allHandles);
//
//        for (String handle : allHandles) {
//            if (!handle.equals(parentWindowHandle)) {
//                driver.switchTo().window(handle);
//                System.out.println("Child Window Title: " + driver.getTitle());
//                driver.switchTo().frame("heatmap-iframe");
//                //After switched IFrame clicked on CLICKMAP
//                WebElement clickmap = driver.findElement(By.cssSelector("[data-qa='liqokuxuba']"));
//                clickmap.click();
//
//            }
//        }
//
//
//        driver.switchTo().window(parentWindowHandle);

        Thread.sleep(5000);
        driver.quit();
    }
}
