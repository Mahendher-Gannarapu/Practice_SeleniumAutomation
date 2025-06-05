package com.mahendhergannarapu.Project7_SelectorHub;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollDown_JavaScript_Locator {

    @Test
    public void testMethod() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //JavascriptExecutor is a interface
        //Here doing typecast for JS work on it
        js.executeScript("window.scrollBy(0,500);");

        //There are two methods we are using
        // 1.executeScript and 2.executeAsyncScript
        // 1.executeScript : Have to wait for it
        // 2.executeAsyncScript : Don't have to wait for it

        //For get url of the page
        String url = js.executeScript("return document.URL").toString();
        // JavascriptExecutor give us executeScript as a Object so here we are converting to String
        System.out.println(url);

        String title = js.executeScript("return document.title").toString();
        System.out.println(title);

        Thread.sleep(50000);
        driver.quit();

    }
}
