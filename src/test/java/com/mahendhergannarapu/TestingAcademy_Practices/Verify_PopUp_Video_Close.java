package com.mahendhergannarapu.TestingAcademy_Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Verify_PopUp_Video_Close {

    WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
    @Test
    public void test_PopUp_Close()
    {
        driver.get("https://thetestingacademy.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='NFDGdflt26_SbOfrtBNNR42t_0_63a3173be4968000133addcd']//div[@id='NFDGdflt26_Sb42Ofr_rMOvE2']//*[name()='svg']")));

        WebElement close_button = driver.findElement(By.xpath("//div[@id='NFDGdflt26_SbOfrtBNNR42t_0_63a3173be4968000133addcd']//div[@id='NFDGdflt26_Sb42Ofr_rMOvE2']//*[name()='svg']"));
        close_button.click();

        boolean isPopupClosed = driver.findElements(By.xpath("//div[@id='NFDGdflt26_SbOfrtBNNR42t_0_63a3173be4968000133addcd']//div[@id='NFDGdflt26_Sb42Ofr_rMOvE2']//*[name()='svg']")).isEmpty();
        Assert.assertTrue(isPopupClosed, "Popup is not closed successfully.");
    }

    @AfterMethod
    public void close()
    {
        if (driver != null) {
            driver.quit();
        }
    }
}
