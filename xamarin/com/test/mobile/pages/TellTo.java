package com.test.mobile.pages;

import org.testng.annotations.Test;

import com.test.mobile.excel.App_Excel_Read;
import com.test.mobile.hooks.App_Config;
import com.test.mobile.hooks.App_Hooks;

public class TellTo extends App_Hooks
{
	
	@Test
	public  void Tell() 
	{
		/**
		 * @@ Writing for loop to read multiple sets of 
		 *    Input data from Excel Sheet
		 **/
		for(int i=App_Config.Start_Row_Number; i<=App_Config.End_Row_Number;i++)
		{				
			try 
			{
				App_Excel_Read.read(i);
				System.out.println("Excel Data loaded successfully");
			
				System.out.println(" Username: " + App_Excel_Read.Login_Username);
				System.out.println(" Password: " + App_Excel_Read.Login_Password);
				System.out.println(" Name: " + App_Excel_Read.Name);
				Pass_Count = Pass_Count+1;
			}
			catch (Exception e) 
			{
				Fail_Count = Fail_Count+1;
			}
		}
		
		System.out.println("PASS COUNT IS:" + Pass_Count);
		System.out.println("FAIL COUNT IS:" + Fail_Count);
	}
}
