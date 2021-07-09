package com.test.angular.suite;

import org.testng.annotations.*;
import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.excel.Excel_Read;
import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.Wait;
import com.test.angular.pages.Register_Page;
import com.test.angular.pages.Verify_Profile_Page;

public class Register_Test extends Hooks {
	@BeforeTest
	public void launchApplication() throws Exception {
		System.out.println("TEST STARTED");
	}

	@Test
	public void UserRegistration() throws Exception {
		/**
		 * @@ Writing for loop to read multiple sets of input data from Excel Sheet
		 */
		for (int i = Config.Start_Row_Number; i <= Config.End_Row_Number; i++) {

			try {

				Excel_Read.read(i);
				System.out.println("Excel Data loaded successfully");

				Hooks.launch();

				// @@USER REGISTRATION
				Register_Page rp = new Register_Page(driver);
				rp.clickOnRegButton();
				rp.enterRegisterDetails();
				rp.Enter_Zip_verifyEmailBox();
				et.log(LogStatus.INFO, "User Successfully Registered");
				System.out.println("User Successfully Registered");

				// @@GMAIL VERIFICATION
				Hooks.GmailLaunch();
				Wait.wait25Second();
				et.log(LogStatus.INFO, "Email Verified");
				System.out.println("Email Verified");
				Wait.wait15Second();

				// @@VERIFYING REGISTRATION
				rp.VerifyReg();

				Verify_Profile_Page eul = new Verify_Profile_Page(driver);
				eul.VerifyProfile();
				eul.VerifyDetails();
				Hooks.LogoutApp();

				Pass_Count = Pass_Count + 1;
				Hooks.EndTest();
			} catch (Exception e) {
				Fail_Count = Fail_Count + 1;
			}
		}
		Hooks.closeReports();
		System.out.println("Pass Count ->" + Pass_Count);
		System.out.println("Fail Count ->" + Fail_Count);
	}

	@AfterTest
	public void CloseTest() throws Exception {
		System.out.println("TEST COMPLETED");
	}

}
