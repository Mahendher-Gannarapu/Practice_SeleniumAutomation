package com.mahendhergannarapu.Project2_Katalon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Verify_Appointment_Username_Password {

    @Test
    public void test_apointment() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        WebDriver driver= new ChromeDriver(options);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        assertThat(driver.getTitle()).isEqualTo("CURA Healthcare Service");
        assertThat((driver.getCurrentUrl())).isEqualTo("https://katalon-demo-cura.herokuapp.com/");

        WebElement make_appointment = driver.findElement(By.linkText("Make Appointment"));
        make_appointment.click();

        WebElement user_name = driver.findElement(By.id("txt-username"));
        user_name.sendKeys("John Doe");

        WebElement pass_word = driver.findElement(By.id("txt-password"));
        pass_word.sendKeys("ThisIsNotAPassword");

        WebElement button = driver.findElement(By.id("btn-login"));
        button.click();

        assertThat(driver.getCurrentUrl()).isEqualTo("https://katalon-demo-cura.herokuapp.com/#appointment");
        Thread.sleep(3000);

        driver.quit();
    }
}
