package com.test.angular.suite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.excel.Excel_Read;
import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.Wait;
import com.test.angular.pages.ExistingUser_Login_Page;
import com.test.angular.pages.Register_Page;
import com.test.angular.pages.Vendor_SignUp_Page;

public class ExistingUser_Login_Test extends Hooks {

	@BeforeTest
	public void launchApplication() throws Exception {
		System.out.println("TEST STARTED");
	}

	@Test
	public void Login() throws Exception {
		/**
		 * @@ Writing for loop to read multiple sets of input data from Excel Sheet
		 */
		for (int i = Config.Start_Row_Number; i <= Config.End_Row_Number; i++) {

			try {
				Excel_Read.read(i);
				System.out.println("Excel Data loaded successfully");

				Hooks.launch();

				ExistingUser_Login_Page eul = new ExistingUser_Login_Page(driver);
				Register_Page rp = new Register_Page(driver);

				eul.SignInAsCleaner();

				/*
				 * Need to add these once "Forget password link" is being added in angular
				 * eul.ForgetPassword(); Hooks.GmailLaunch(); eul.ResetPassword();
				 */

				eul.EnterCleanerUsernameAndPassword();
				Wait.wait8Second();
				//rp.VerifyReg();
				eul.VerifyProfile();
				eul.VerifyDetails();
				LogoutApp();

				Pass_Count = Pass_Count + 1;
				Hooks.EndTest();

			} catch (Exception e) {

				e.printStackTrace();
				Fail_Count = Fail_Count + 1;
			}
		}

		// Hooks.closeReports();
		System.out.println("Pass Count ->" + Pass_Count);
		System.out.println("Fail Count ->" + Fail_Count);
	}

	@AfterTest
	public void CloseTest() throws Exception {
		System.out.println("TEST COMPLETED");
	}

}
