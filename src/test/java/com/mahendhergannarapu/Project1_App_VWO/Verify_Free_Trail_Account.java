package com.mahendhergannarapu.Project1_App_VWO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Verify_Free_Trail_Account {

    @Test
    public void test_Free_trail_account() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://vwo.com/free-trial");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //assertThat(driver.getTitle()).isEqualTo("Get Started with Free Trial | VWO");
        //assertThat(driver.getCurrentUrl()).isEqualTo("https://vwo.com/free-trial");

        WebElement bussines_email = driver.findElement(By.id("page-v1-step1-email"));
        bussines_email.sendKeys("mahendher");

        WebElement check_box_click = driver.findElement(By.name("gdpr_consent_checkbox"));
        check_box_click.click();

        //<button
        // type="submit"
        // class="button W(100%) btn-modal-form-submit button--disabled-primary"
        // data-qa="page-su-submit"
        // disabled="disabled">
        // Create a Free Trial Account
        // </button>

        //Here no id, class name so TagName as "button" using
        List<WebElement> button_list = driver.findElements(By.tagName("button"));
        button_list.get(0).click();

        //<div
        // class="C($color-red) Fz($font-size-12) Trsp($Op) Trsdu(0.15s) Op(0) invalid-input+Op(1) invalid-reason">
        // The email address you entered is incorrect.
        // </div>
        WebElement error_message = driver.findElement(By.className("invalid-reason"));
        assertThat(error_message.getText()).isEqualTo("The email address you entered is incorrect.");

        Thread.sleep(3000);
        driver.quit();





    }

}
