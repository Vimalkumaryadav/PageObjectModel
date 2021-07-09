package com.test.angular.suite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivers {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException 
	{
		FileInputStream file = new FileInputStream("DataDriveFromExcelMaven.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		int sizeOfSheet = wb.getNumberOfSheets();
		for (int i = 0; i < sizeOfSheet; i++) 
		{
			if (wb.getSheetName(i).equalsIgnoreCase("Sheet1")) 
			{
				System.out.println("Our matched sheet index number :" + i);
				XSSFSheet sheet = wb.getSheetAt(i);

				Iterator<Row> row = sheet.iterator();// now sheet is collection of row details
				Row firstRow = row.next();// now its focused on first sheet row
				System.out.println(row.next().getRowNum());

				Iterator<Cell> getCells = firstRow.cellIterator();
				int k = 0, columnnumber = 0;
				Cell cellValue = null;
				while (getCells.hasNext()) 
				{
					cellValue = getCells.next();
					if (cellValue.getStringCellValue().equalsIgnoreCase("Test")) 
					{
						columnnumber = k;
					}
					k++;
				}
				System.out.println("Our matched cell name & number :" + cellValue + " & " + columnnumber);

				while (row.hasNext())
				{
					Row rowValue = row.next();
					if (rowValue.getCell(columnnumber).getStringCellValue().equalsIgnoreCase("Purchase")) 
					{
						// System.out.println(rowValue);
						Iterator<Cell> c = rowValue.cellIterator();
						while (c.hasNext())
						{
							System.out.println(c.next().getStringCellValue());
						}
					}

				}

			}
		}

	}

}
