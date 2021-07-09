package com.test.mobile.suite;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.mobile.hooks.App_Hooks;
import com.test.mobile.pages.App_Login_Page;
import com.test.mobile.pages.App_Neighbor_SignUp_Page;
import com.test.mobile.excel.App_Excel_Read;
import com.test.mobile.hooks.App_Config;

public class App_Neighbor_SignUp_Test extends App_Hooks
{
	
	@BeforeTest
	public void launchApplication() throws Exception
	{
		System.out.println("TEST STARTED");
	}
	
	@Test
	public void SignUp_Neighbor() throws Exception
	{
		/**
		 *
		 * Writing for loop to read multiple sets of 
		 * Input data from Excel Sheet
		 *
		 **/
		
		for(int i=App_Config.Start_Row_Number; i<=App_Config.End_Row_Number;i++)
		{
		try 
		{
			App_Excel_Read.read(i);
			System.out.println("Excel Data loaded successfully");
			OpenApp();
			
			//@@LOGIN
			App_Login_Page lp=new App_Login_Page(driver);
			lp.ClickSignInOption();
			Thread.sleep(8000);
			lp.EnterUsernameAndPassword();
			lp.SignIn_Now_Button_And_VerifyLogin();
			et.log(LogStatus.INFO,"Logged in as Neighbor role");
			Thread.sleep(8000);
			
			//@@NEIGHBHOR SIGNUP FLOW
			App_Neighbor_SignUp_Page ns=new  App_Neighbor_SignUp_Page(driver);
		
			
			ns.ClickOnGetStarted();
			et.log(LogStatus.INFO,"Get Started page is verified");
			ns.FillCleaningDetails();
			ns.bathroomCountDetails();
			et.log(LogStatus.INFO," Updated Cleaning details");
			ns.PriceVerification();
			ns.Clean_Schedule();
			ns.Almost_Finished();
			ns.SummaryPage();   
			et.log(LogStatus.INFO," Summary page is updated");
			
			
			Thread.sleep(5000);
			ns.DoPayment_Step();
			ns.VerifyOrder_DetailsPage();
			DO_logout_App();
			CloseTest();
			Pass_Count = Pass_Count+1;  
		
	}catch (Exception e) 	
	{
		Fail_Count = Fail_Count+1;
		System.out.println("Error at ->" + e);
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
