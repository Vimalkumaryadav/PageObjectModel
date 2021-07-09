package com.test.angular.suite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.angular.excel.Excel_Read;
import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.angular.pages.VerifyEmail_Page;

public class Gmail_Test extends Hooks {

	@BeforeTest
	public void launchApplication() throws Exception {
		System.out.println("TEST STARTED");
	}

	@Test
	public void gmailLogin() throws Exception {
		/**
		 * @@ Writing for loop to read multiple sets of input data from Excel Sheet
		 */
		for (int i = Config.Start_Row_Number; i <= Config.End_Row_Number; i++) {

			try {

				Excel_Read.read(i);
				System.out.println("Exceal Data loaded successfully");
				Hooks.launch();

				VerifyEmail_Page gp = new VerifyEmail_Page(driver);
				gp.GmailLoginPage();
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
