
//Using Xpath locator
package com.mahendhergannarapu.Project5_ebay_Ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Verify_all_titles_and_prices {

    @Test
    public void test_all_prices_titles() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(("https://www.ebay.com/"));
        driver.manage().window().maximize();

        WebElement search_field = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        search_field.sendKeys("macmini");

        WebElement search_button = driver.findElement(By.xpath("//span[@class='gh-search-button__label']"));
        search_button.click();

        List<WebElement> titles = driver.findElements(By.xpath("//span[@role='heading']"));
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='s-item__price']"));

        int size=Math.min(titles.size(),prices.size());

        for(int i=0;i<size;i++)
        {
            System.out.println("Title : " + titles.get(i).getText() + "||" + "Price : " +prices.get(i).getText());
        }

        Thread.sleep(3000);
        driver.quit();

    }
}
