package UIAutomation.CommonUtilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelPOIReadWriteUtility
{
    public void readExcelData(String testDataExcelPath,String testDataFileName,String testDataSheetName) throws IOException {
    //Step 1 Create an object to open xlsx file
        File file=new File(testDataExcelPath+"\\"+testDataFileName);
        //Step 2 Create an Input Stream object for read the excel file
        System.out.println("t1"+testDataExcelPath);
        System.out.println("t2"+testDataFileName);
        FileInputStream fileinput=new FileInputStream(file);
        System.out.println("t3"+fileinput);
        //Step 3 Assign workbook as null
        Workbook readExcelTestData = null;
        //Step 4 Find the file extension by splitting the file name
        String filenameExtension=testDataFileName.substring(testDataFileName.indexOf("."));
        System.out.println("t4"+filenameExtension);
        //Step 5 Check the File Extension condition
        if(filenameExtension.equalsIgnoreCase(".xlsx"))
        {
            //Step 6 if it is XLSX then create an object for XSSFWorkbook
            readExcelTestData=new XSSFWorkbook(fileinput);
        }
        //Step 7 Read the Sheet inside workbook my its name
        assert readExcelTestData != null;
        Sheet addEmployeeSheet=readExcelTestData.getSheet("readExcelTestData");
        System.out.println("Total Rows"+addEmployeeSheet.getSheetName());
        //Step 8 Find the Number of Rows in the Excel
        int getrows=addEmployeeSheet.getLastRowNum()-addEmployeeSheet.getFirstRowNum();
        System.out.println("Total Rows"+getrows);
        //Step 9 Create a loop to iterate all rows values
        for(int i=0;i<getrows;i++)
        {
            Row row=addEmployeeSheet.getRow(i);
            //Step 10 Create a loop to extract the column value
            for(int j=0;j<row.getLastCellNum();j++)
            {
                System.out.println(row.getCell(j).getStringCellValue());
            }
            System.out.println();
        }






    }
}
