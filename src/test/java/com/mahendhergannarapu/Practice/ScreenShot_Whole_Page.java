// Capture screenshot for whole page using javaprogram
package com.mahendhergannarapu.Practice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot_Whole_Page {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();

        //Full Page screenshot
//        TakesScreenshot ts = (TakesScreenshot)driver;
//        File src = ts.getScreenshotAs(OutputType.FILE);// capture screenshot save somewhere in memory and copy this file to our location
//        File target = new File(".\\screenshots\\homepage.png");// create our location
//        FileUtils.copyFile(src,target);

        //Screenshot of section and portion of the page
        WebElement section = driver.findElement(By.xpath("//div[@class='product-info Mih(60vh) Mih(100vh)--md Px(20px) Pb(40px) Px(50px)--md Pt(20px) Pt(80px)--lg Pt(50px)--md Pt(30px)--sm Bxz(bb) Bgr(nr) Bgz(cv) Bgp(c_t) Bgc(color-gray-10) product-info--light']"));
        File src = section.getScreenshotAs(OutputType.FILE);
        File target = new File(".\\screenshot\\sectionpage.png");
        FileUtils.copyFile(src,target);
        driver.quit();

    }
}
