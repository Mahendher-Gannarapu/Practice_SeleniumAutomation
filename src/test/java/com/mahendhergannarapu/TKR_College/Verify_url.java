package com.mahendhergannarapu.TKR_College;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Verify_url {

    @Test
    public void verify_Url_Test() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://tkrec.ac.in/");

        Thread.sleep(6000);
        driver.quit();
    }
}
