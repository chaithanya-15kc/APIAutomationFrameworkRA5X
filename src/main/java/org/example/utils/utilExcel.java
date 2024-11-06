package org.example.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class utilExcel {

    //use workbook, Sheet, Rows and Columns, Cells
    //    Open Stream
//    Understand Workbook
//    Sheet
//    Row, Column
//    Cells
//    Close Stream - give data to the Object[][]

    static Workbook book;//initialize the workbook
    static Sheet sheet;//initialize the sheet
    public static String FILE_NAME = "src/test/resources/TD.xlsx";


    public static Object[][] getTestData(String sheetName){
        //write the logic to read the excel file and convert this to 2D array
        FileInputStream file = null;
        try {
            file = new FileInputStream(FILE_NAME);//checked exception method "throws function added"
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;
    }

    @DataProvider
    public Object[][] getData() {
            return getTestData("Sheet1");
    }
}
