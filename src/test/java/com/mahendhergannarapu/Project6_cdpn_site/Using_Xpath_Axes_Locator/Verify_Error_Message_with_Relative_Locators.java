package com.mahendhergannarapu.Project6_cdpn_site.Using_Xpath_Axes_Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Verify_Error_Message_with_Relative_Locators {

    @Test
    public void test_all_prices_titles() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(("https://cdpn.io/abdullashSajjad/fullpage/LYGVRgK?anon=true&view=fullpage"));
        driver.manage().window().maximize();

        driver.switchTo().frame("result");

        WebElement button = driver.findElement(By.xpath("//form[@id='form']/button"));
        button.click();

        // after Error will come verify the siblings
        WebElement input_field = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement error_small_tag = driver.findElement(with(By.tagName("small")).below(input_field));
        WebElement error_label_tag = driver.findElement(with(By.tagName("label")).above(input_field));

        assertThat(error_small_tag.getText()).isEqualTo("Username must be at least 3 characters");
        assertThat(error_label_tag.getText()).isEqualTo("Username");
        Thread.sleep(3000);
        driver.quit();
    }

}
