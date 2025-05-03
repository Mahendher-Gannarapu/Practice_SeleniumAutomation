package com.mahendhergannarapu.Project3_Awesomeqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Verify_Application_Form {

    @Test
    public void test_Form() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://awesomeqa.com/practice.html");

        WebElement first_name = driver.findElement(By.name("firstname"));
        first_name.sendKeys("Mahendher");

        WebElement last_name = driver.findElement(By.name("lastname"));
        last_name.sendKeys("Gannarapu");

        WebElement gender_radio_button = driver.findElement(By.id("sex-0"));
        gender_radio_button.click();

        WebElement experience = driver.findElement(By.id("exp-0"));
        experience.click();

        WebElement date_picker = driver.findElement(By.id("datepicker"));
        date_picker.sendKeys("10-10-2024");

        WebElement profession = driver.findElement(By.id("profession-0"));
        profession.click();

        WebElement automation_tools= driver.findElement(By.id("tool-2"));
        automation_tools.click();


        Thread.sleep(3000);
        driver.quit();
    }
}
