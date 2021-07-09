package com.test.angular.excel;

import java.io.File;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel_Read {
	
	
	public static String Name;
	public static String Login_Username;
	public static String Login_Password;
	public static String ZipCode;
	public static String Cleaning_address;
	public static String UnitNumber;
	public static String BedroomCount;
	public static String BathroomCount;
	public static String PenthouseOrTownhouse;
	public static String GetIntoYourPlace;
	public static String Pets;
	public static double Total_Pricing;
	public static String Referral_Email;
	public static String Email_Password;
	public static String Facebook_Email;
	public static String Facebook_Password;
	public static String Lapalopa_Email;
	public static String Lapalopa_Password;
	public static String Yop_Mail;
	public static String DOB;
	public static String Driving_License;
	public static String Rating;
	public static String Company_Name;
	public static String EIN;
	public static String adminEmail;
	public static String schedularEmail;
	public static String cleanerEmail;
	
	public static void read(int RowNumber) throws Exception
	{
		//File f=new File("./TestData/TestData_Angular.xlsx");
		FileInputStream fi= new FileInputStream("./TestData/TestData_Angular_Vimal.xlsx");
		
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
			BedroomCount=sheet.getRow(i).getCell(6).getStringCellValue();
			BathroomCount= sheet.getRow(i).getCell(7).getStringCellValue();
			PenthouseOrTownhouse= sheet.getRow(i).getCell(8).getStringCellValue();
			GetIntoYourPlace= sheet.getRow(i).getCell(9).getStringCellValue();
			Pets= sheet.getRow(i).getCell(10).getStringCellValue();
			Total_Pricing=sheet.getRow(i).getCell(11).getNumericCellValue();
			
			
			/*
			 * Referral_Email= sheet.getRow(i).getCell(12).getStringCellValue();
			 * Email_Password= sheet.getRow(i).getCell(13).getStringCellValue();
			 * Facebook_Email= sheet.getRow(i).getCell(11).getStringCellValue();
			 * Facebook_Password=sheet.getRow(i).getCell(12).getStringCellValue();
			 * Lapalopa_Email=sheet.getRow(i).getCell(13).getStringCellValue();
			 * Lapalopa_Password=sheet.getRow(i).getCell(14).getStringCellValue();
			 * Yop_Mail=sheet.getRow(i).getCell(15).getStringCellValue();
			 * Driving_License=sheet.getRow(i).getCell(16).getStringCellValue();
			 * DOB=sheet.getRow(i).getCell(17).getStringCellValue();
			 * Rating=sheet.getRow(i).getCell(18).getStringCellValue();
			 * Company_Name=sheet.getRow(i).getCell(19).getStringCellValue();
			 * EIN=sheet.getRow(i).getCell(20).getStringCellValue();
			 */
			//BathroomCount=Float.toString((float)sheet.getRow(i).getCell(6).getNumericCellValue());


			System.out.println("Entering Row -> "+ i +"");
	
		}
	}
		
	
	
	public static void read(String sheetName,int RowNumber) throws Exception
	{
		//File f=new File("./TestData/TestData_Angular.xlsx");
		FileInputStream fi= new FileInputStream("./TestData/TestData_Angular.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		int totalSheetsCount=wb.getNumberOfSheets();
	
		
		for(int i=0;i<totalSheetsCount;i++)
		{
			if(wb.getSheetName(i).equalsIgnoreCase(sheetName))
			{
				XSSFSheet sheet=wb.getSheetAt(i);
				
				for(int j=RowNumber;j<=RowNumber;j++)
				{
					Name=sheet.getRow(i).getCell(0).getStringCellValue();
					Login_Username=sheet.getRow(i).getCell(1).getStringCellValue();
					Login_Password=sheet.getRow(i).getCell(2).getStringCellValue();
					ZipCode=sheet.getRow(i).getCell(3).getStringCellValue();
					Cleaning_address=sheet.getRow(i).getCell(4).getStringCellValue();
					UnitNumber=sheet.getRow(i).getCell(5).getStringCellValue();
					BathroomCount= sheet.getRow(i).getCell(6).getStringCellValue();
					adminEmail= sheet.getRow(i).getCell(7).getStringCellValue();
					schedularEmail=sheet.getRow(i).getCell(8).getStringCellValue();
					cleanerEmail=sheet.getRow(i).getCell(9).getStringCellValue();
					Email_Password= sheet.getRow(i).getCell(10).getStringCellValue();
					Facebook_Email= sheet.getRow(i).getCell(11).getStringCellValue();
					Facebook_Password=sheet.getRow(i).getCell(12).getStringCellValue();
					Lapalopa_Email=sheet.getRow(i).getCell(13).getStringCellValue();
					Lapalopa_Password=sheet.getRow(i).getCell(14).getStringCellValue();
					Yop_Mail=sheet.getRow(i).getCell(15).getStringCellValue();
					Driving_License=sheet.getRow(i).getCell(16).getStringCellValue();
					DOB=sheet.getRow(i).getCell(17).getStringCellValue();
					Rating=sheet.getRow(i).getCell(18).getStringCellValue();
					Company_Name=sheet.getRow(i).getCell(19).getStringCellValue();
					EIN=sheet.getRow(i).getCell(20).getStringCellValue();
					//BathroomCount=Float.toString((float)sheet.getRow(i).getCell(6).getNumericCellValue());


					System.out.println("Entering Row -> "+ i +"");
			
				}
			}
		}
		
	
		
	}
		
		public static void read_Referral_Data(int RowNumber, int ColNumber) throws Exception
		{
			File f=new File("./TestData/TestData_Angular.xlsx");
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
				for(int j=ColNumber;j<=ColNumber;j++)
				{
				Referral_Email= sheet.getRow(i).getCell(j).getStringCellValue();
				}

				//BathroomCount=Float.toString((float)sheet.getRow(i).getCell(6).getNumericCellValue());


				System.out.println("Entering Row -> "+ i +"");
		
			}
		
	}
	
	
	

	
	
	
	
	
	
	
	

}
