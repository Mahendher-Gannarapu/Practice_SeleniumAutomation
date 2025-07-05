package com.mahendhergannarapu.DataDrivenTesting;

import org.testng.annotations.Test;

public class TestDataDrivenExcel {

    @Test(dataProvider = "getData", dataProviderClass = TestUtilExcel.class)
    public void test_VWOLogin(String email, String password)
    {
        System.out.println("Email -"+ email);
        System.out.println("Password -"+ password);
    }

}
