package com.test.mobile.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.test.angular.hooks.Config;

public class App_Excel_Read {
	
	public static String Name;
	public static String Login_Username;
	public static String Login_Password;
	public static String ZipCode;
	public static String Cleaning_address;
	public static String UnitNumber;
	public static String  BathroomCount;
	
	public static void read(int RowNumber) throws Exception
	{
		File f=new File("./TestData/TestData_Xamarin.xlsx");
		FileInputStream fi= new FileInputStream(f);
		
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sheet=wb.getSheetAt(0);
	
		for(int i=RowNumber;i<=RowNumber;i++)
		{
			Name=sheet.getRow(i).getCell(0).getStringCellValue();
			Login_Username=sheet.getRow(i).getCell(1).getStringCellValue();
			Login_Password=sheet.getRow(i).getCell(2).getStringCellValue();
			ZipCode=sheet.getRow(i).getCell(3).getStringCellValue();
			Cleaning_address=sheet.getRow(i).getCell(4).getStringCellValue();
			UnitNumber=sheet.getRow(i).getCell(5).getStringCellValue();
			BathroomCount= sheet.getRow(i).getCell(6).getStringCellValue();
			System.out.println("Row Number: "+ i +"");	
		}
		
	}
	
	
	

	
	
	
	
	
	
	
	

}
