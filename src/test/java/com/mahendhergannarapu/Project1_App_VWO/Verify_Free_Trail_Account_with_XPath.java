package com.mahendhergannarapu.Project1_App_VWO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Verify_Free_Trail_Account_with_XPath {

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

        //<input class="W(100%) Py(14px) input-text"
        // placeholder="name@yourcompany.com" type="email"
        // id="page-v1-step1-email"
        // name="email"
        // data-qa="page-su-step1-v1-email"
        // required="">
        WebElement bussines_email = driver.findElement(By.xpath("//input[@id='page-v1-step1-email']"));
        bussines_email.sendKeys("mahendher");

        //<input
        // class="Cur(p) Flxs(0) M(0) Pos(r) T(2px)"
        // type="checkbox"
        // name="gdpr_consent_checkbox"
        // id="page-331cu-gdpr-consent-checkbox"
        // value="true" data-qa="page-gdpr-consent-checkbox"
        // data-gtm-form-interact-field-id="1">
        WebElement check_box_click = driver.findElement(By.xpath("//input[@name='gdpr_consent_checkbox']"));
        check_box_click.click();

        //<button
        // type="submit"
        // class="button W(100%) btn-modal-form-submit button--disabled-primary"
        // data-qa="page-su-submit"
        // disabled="disabled">
        // Create a Free Trial Account
        // </button>

        //Here no id, class name so TagName as "button" using
        //List<WebElement> button_list = driver.findElements(By.tagName("button"));
        //button_list.get(0).click();
        WebElement button_option = driver.findElement(By.xpath("//button[text()='Create a Free Trial Account']"));
        button_option.click();

        //<div
        // class="C($color-red) Fz($font-size-12) Trsp($Op) Trsdu(0.15s) Op(0) invalid-input+Op(1) invalid-reason">
        // The email address you entered is incorrect.
        // </div>
        //WebElement error_message = driver.findElement(By.className("invalid-reason"));
        //div[text()='The email address you entered is incorrect.']
        WebElement error_message =driver.findElement(By.xpath("//div[contains(text(),'The email address')]"));
        assertThat(error_message.getText()).isEqualTo("The email address you entered is incorrect.");

        Thread.sleep(3000);
        driver.quit();





    }

}
