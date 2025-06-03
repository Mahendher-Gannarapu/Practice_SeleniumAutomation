package com.mahendhergannarapu.Project6_cdpn_site.Using_Xpath_Axes_Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Verify_Error_Message {

    @Test
    public void test_all_prices_titles() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(("https://cdpn.io/abdullashSajjad/fullpage/LYGVRgK?anon=true&view=fullpage"));
        driver.manage().window().maximize();

        driver.switchTo().frame("result");

        WebElement button = driver.findElement(By.xpath("//button[text()='Submit']"));
        button.click();

        // after Error will come verify the siblings
        String input_box_path = "//input[@id='username']";
        String label_path = input_box_path+"/preceding-sibling::label";
        String small_path = input_box_path+"/following-sibling::small";

        WebElement error_small_tag = driver.findElement(By.xpath(small_path));
        WebElement error_label_tag = driver.findElement(By.xpath(label_path));

        assertThat(error_small_tag.getText()).isEqualTo("Username must be at least 3 characters");

        Thread.sleep(3000);
        driver.quit();
    }

}
