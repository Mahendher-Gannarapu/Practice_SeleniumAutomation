package com.mahendhergannarapu.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Test003 {

    @Test
    public void test003() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://www.google.com");

        Thread.sleep(3000);

        driver.quit();
        //driver.close();
    }
}
