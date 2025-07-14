package com.mahendhergannarapu.CAP_GEMINI_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VerifyHeaderEx {

    @Test
    public void test1() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        //Verify url and title using assertJ
        assertThat(driver.getCurrentUrl()).isEqualTo("https://awesomeqa.com/hr/web/index.php/auth/login").isNotEmpty().isNotBlank();
        assertThat(driver.getTitle()).isEqualTo("OrangeHRM");

        if(driver.getPageSource().contains("Login"))
        {
            Assert.assertTrue(true);
        }
        else {
            throw new Exception("Heading Not Found");
        }






        Thread.sleep(3000);
        driver.quit();


    }
}
