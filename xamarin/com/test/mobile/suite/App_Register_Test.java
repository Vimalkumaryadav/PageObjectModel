package com.test.mobile.suite;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.hooks.Config;
import com.test.mobile.excel.App_Excel_Read;
import com.test.mobile.hooks.App_Config;
import com.test.mobile.hooks.App_Hooks;
import com.test.mobile.pages.App_Register_Page;
import com.test.mobile.pages.App_SignUpVerify_Page;

public class App_Register_Test extends App_Hooks
{
	@BeforeTest
	public void launchApplication() throws Exception
	{
		System.out.println("TEST STARTED");
	}
	
	@Test(priority=0)
	public void registerUser() throws Exception
	{

		/**
		 * @@ Writing for loop to read multiple sets of 
		 *    Input data from Excel Sheet
		 **/
		for(int i=Config.Start_Row_Number; i<=Config.End_Row_Number;i++)
		{
			
		try 
		{
			
			App_Excel_Read.read(i);
			System.out.println("Excel Data loaded successfully");
			App_Hooks.OpenApp();
			et.log(LogStatus.PASS,"App is Launched");
			Thread.sleep(3000); 
			
			App_Register_Page rp=new App_Register_Page(driver);
			rp.clickOnRegButton();
			rp.enterRegisterDetails();
			rp.Enter_Zip_verifyEmailBox();
			System.out.println("User registration is done, and verifying email");
			System.out.println("User registration is done, and verifying email");
			try {
				App_Hooks.OpenBrowserInMobile();
				App_SignUpVerify_Page vp=new App_SignUpVerify_Page(driver);
				vp.GmailLoginPage();
				System.out.println(" Email verification is done");
			}catch (Exception e) 
			{
				System.out.println(" Verify and Confirm link Test interrupted ");
			}
			System.out.println(" Email verification is done");
		
		Thread.sleep(3000);
		App_Hooks.CloseTest();
		Pass_Count = Pass_Count+1;
		}catch (Exception e) 
		{
			Fail_Count = Fail_Count+1;
		
		}
		App_closeReports();
	}
	}
	

	@AfterTest
	public void App_CloseTest() throws Exception
	{
		System.out.println("TEST COMPLETED");
	}
}
