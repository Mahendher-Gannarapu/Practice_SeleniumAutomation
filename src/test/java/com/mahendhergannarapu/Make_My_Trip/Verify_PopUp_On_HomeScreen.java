package com.mahendhergannarapu.Make_My_Trip;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verify_PopUp_On_HomeScreen {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");

        WebElement enter_Mobile_no= driver.findElement(By.xpath("//input[@class='font14 fullWidth']"));
        enter_Mobile_no.sendKeys("34132444");

        WebElement cutton_continue= driver.findElement(By.xpath("//button[@class='capText font16']"));
        cutton_continue.click();

        WebElement error_message = driver.findElement(By.xpath("//span[text()='Invalid phone number']"));
        error_message.getText();

        WebElement close_button = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
        close_button.click();

        Thread.sleep(5000);
        driver.quit();



    }
}
