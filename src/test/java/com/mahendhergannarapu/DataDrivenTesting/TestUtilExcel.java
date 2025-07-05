package com.mahendhergannarapu.DataDrivenTesting;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtilExcel {


    //Here Workbook,Sheet both are interfaces and book,sheet are instance variable
    static Workbook book;
    static Sheet sheet;

    //created path where is sheet location
    public static String SHEET_PATH = System.getProperty("user.dir")+
            "/src/test/resources/Test_Data.xlsx";

    public static Object[][] getTestDataFromExcel(String sheetName) throws IOException {

        // step1: created FileInputStream
        FileInputStream file = null;
        try {
            file = new FileInputStream(SHEET_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // step2: which is used to read the data
        book = WorkbookFactory.create(file);
        sheet  = book.getSheet(sheetName);

        // Create empty data
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        // 5x2
        for (int i = 0; i < sheet.getLastRowNum() ; i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }

//    If we want use read from sql
//    public static Object[][] getTestDataFromSQL(String sheetName){
//        return null;
//    }


    //created two functions getTestDataFromExcel and getData()
    //This is first function -getData function call the getTestDataFromExcel
    //and which sheet want to get the data here is sheet1
    @DataProvider
    public Object[][] getData() throws IOException {
        return getTestDataFromExcel("Sheet1");
//        return getTestDataFromSQL("Sheet1");
    }
}

