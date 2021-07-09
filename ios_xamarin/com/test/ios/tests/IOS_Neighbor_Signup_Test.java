package com.test.ios.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.ios.pages.IOS_NeighborSingUp_Page;
import com.test.ios.pages.IOS_UserLogin_Page;
import com.test.mobile.excel.App_Excel_Read;
import com.test.mobile.hooks.App_Config;
import com.test.mobile.hooks.App_Hooks;

public class IOS_Neighbor_Signup_Test extends App_Hooks
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
	*@Writing for loop to read multiple sets of 
	*@Input data from Excel Sheet
	*
	**/

	for(int i=App_Config.Start_Row_Number; i<=App_Config.End_Row_Number;i++)
	{
			try 
			{
				App_Excel_Read.read(i);
				System.out.println("Excel Data loaded successfully");
				App_Hooks.iOS_Device_OpenApp();
				IOS_UserLogin_Page ios_lp= new IOS_UserLogin_Page(ios_driver);
				ios_lp.ClickSignInOption();
				ios_lp.EnterUsernameAndPassword();
				ios_lp.SignIn_Now_Button_And_VerifyLogin();
				Thread.sleep(2000);
				App_Hooks.et.log(LogStatus.INFO,"Logged-in as Neighbor role");
			
				/**
				 * @NEIGHBHOR SIGNUP FLOW
				 */
				
				IOS_NeighborSingUp_Page ios_ns=new IOS_NeighborSingUp_Page(ios_driver);
				System.out.println("Entered into neighbor sign-up page class");
				ios_ns.ClickOnGetStarted();
				App_Hooks.et.log(LogStatus.INFO,"Get Started page is verified");
				ios_ns.FillCleaningDetails();
				//ios_ns.bathroomCountDetails();
				App_Hooks.et.log(LogStatus.INFO," Updated Cleaning details ");
				//ios_ns.PriceVerification();
				ios_ns.Clean_Schedule();
				ios_ns.Almost_Finished();
				ios_ns.SummaryPage();
				App_Hooks.et.log(LogStatus.INFO," Summary page is updated ");
				Thread.sleep(10000);
				ios_ns.DoPayment_Step();
				ios_ns.VerifyOrder_DetailsPage();
				Thread.sleep(2000);
				logout_IOS_App();
				Close_IOS_Test();
				Pass_Count = Pass_Count+1;
			
			}
			catch (Exception e) 
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
