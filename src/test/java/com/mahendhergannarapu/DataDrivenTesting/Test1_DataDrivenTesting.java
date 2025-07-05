package com.mahendhergannarapu.DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test1_DataDrivenTesting {
    
    @DataProvider
    public Object[][] getData()
    {
        return new Object[][]{
                new Object[]{"admin@gmail.com", "pass123"},
                new Object[]{"admin12@gamil.com", "p123"}
        };
    }


    @Test(dataProvider = "getData")
    public void loginTest(String email, String password)
    {
        System.out.println(email + " | " +password);
    }
}
