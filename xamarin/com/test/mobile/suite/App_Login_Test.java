package com.test.mobile.suite;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.mobile.excel.App_Excel_Read;
import com.test.mobile.hooks.App_Config;
import com.test.mobile.hooks.App_Hooks;
import com.test.mobile.pages.App_Login_Page;


public class App_Login_Test extends App_Hooks
{

	@BeforeTest
	public void launchApplication() throws Exception
	{
		System.out.println("TEST STARTED");
	}
	
	
	@Test
	public void testAPP() throws Exception
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
				OpenApp();
				App_Login_Page lp= new App_Login_Page(driver);
				lp.ClickSignInOption();
				lp.EnterUsernameAndPassword();
				lp.SignIn_Now_Button_And_VerifyLogin();
				DO_logout_App();
				CloseTest();
				Pass_Count = Pass_Count+1;
			}catch(Exception e) 
			{
				Fail_Count = Fail_Count+1;
			}
		}
		App_closeReports();
	}
	
	@AfterTest
	public void App_CloseTest() throws Exception
	{
		System.out.println("TEST COMPLETED");
	}
}
