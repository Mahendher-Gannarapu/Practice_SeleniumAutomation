package com.mahendhergannarapu.TakeScreenshots;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Test001 {

    @Test
    public void test()
    {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        driver.quit();
    }
}
