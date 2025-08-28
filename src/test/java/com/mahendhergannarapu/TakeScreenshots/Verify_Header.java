package com.mahendhergannarapu.TakeScreenshots;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//Verify the title and string on the page source
public class Verify_Header {

    @Test
    public void test() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        //Using AssertJ Assertions
        assertThat(driver.getTitle()).isNotEmpty().isNotBlank().isEqualTo("OrangeHRM");
        assertThat(driver.getCurrentUrl()).isEqualTo("https://awesomeqa.com/hr/web/index.php/auth/login");

        if(driver.getPageSource().contains("Login"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            throw new Exception("Heading Not Found");
        }
        Thread.sleep(4000);
        driver.quit();
    }
}
