package com.test.angular.suite;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.excel.Excel_Read;
import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.angular.pages.CompanyUsers_Signup_Page;
import com.test.angular.pages.Login_Page;
import com.test.angular.pages.Vendor_SignUp_Page;
import static com.test.angular.hooks.StageDB.*;

public class Vendor_SignUp_Test extends Hooks {
	@BeforeTest
	public void launchApplication() throws Exception

	{
		System.out.println("TEST STARTED");
		connectToDB();
		System.out.println("DB connected");
	}

	@Test
	public void SignUp_Neighbor() throws Exception

	{
		/**
		 * @@ Writing for loop to read multiple sets of input data from Excel Sheet
		 */
		for (int i = Config.Start_Row_Number; i <= Config.End_Row_Number; i++) {

			try {
				Excel_Read.read(i);
				System.out.println("Excel Data loaded successfully");
				Hooks.launch();
				// @@LOGIN
				Login_Page lp = new Login_Page(driver);
				lp.ClickSignInOption();
				lp.EnterUsernameAndPassword();
				lp.SignIn_Now_Button_And_VerifyLogin();
				et.log(LogStatus.INFO, "Logged in as User");
				Vendor_SignUp_Page vsp = new Vendor_SignUp_Page(driver);
				vsp.Click_On_Become_Cleaner_Page();
				vsp.Tell_us_about_yourself_Page();
				vsp.Lapalopa_Cleaning_Page();
				vsp.Take_a_Photo_Of_Yourself_Page();
				vsp.Address_Information_Page();
				vsp.Vendor_Detail_Page();
				vsp.Investigation_Page();
				vsp.updateVendorDeatils();
				vsp.availSetup();
				vsp.agreementSection();
				vsp.submitAgreement();
				vsp.verifyVendorDashboard();
				Hooks.LogoutApp();

				// Pass_Count=Pass_Count+1;
				Hooks.EndTest();
			} catch (Exception e) {
				System.out.println(e);
				Hooks.LogoutApp();
				// Fail_Count = Fail_Count+1;
			}
		}
		Hooks.closeReports();
		System.out.println("Pass Count ->" + Pass_Count);
		System.out.println("Fail Count ->" + Fail_Count);
	}

	@AfterTest
	public void CloseTest() throws Exception {
		System.out.println("TEST COMPLETED");
		closeDB();
		System.out.println("DB Closed");
	}

}