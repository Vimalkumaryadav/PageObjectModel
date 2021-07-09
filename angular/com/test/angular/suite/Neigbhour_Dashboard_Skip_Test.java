package com.test.angular.suite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.angular.excel.Excel_Read;
import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.Wait;
import com.test.angular.pages.Login_Page;
import com.test.angular.pages.Neighbour_Dashboard_Skip_Page;

public class Neigbhour_Dashboard_Skip_Test extends Hooks {

	@BeforeTest
	public void launchApplication() throws Exception {
		System.out.println("TEST STARTED");
	}

	@Test
	public void SkipCleaningFlow() throws Exception {
		/**
		 * @@ Writing for loop to read multiple sets of input data from Excel Sheet
		 */
		for (int i = Config.Start_Row_Number; i <= Config.End_Row_Number; i++) {

			try {

				Excel_Read.read(i);
				System.out.println("Exceal Data loaded successfully");
				Hooks.launch();
				// @LOGIN DETAIL
				Login_Page lp = new Login_Page(driver);
				lp.ClickSignInOption();
				lp.EnterUsernameAndPassword();
				Wait.wait5Second();

				// @SKIP CLEANING
				Neighbour_Dashboard_Skip_Page sc = new Neighbour_Dashboard_Skip_Page(driver);
				sc.SkipCleaning();
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
