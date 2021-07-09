package com.test.angular.suite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.excel.Excel_Read;
import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.Wait;
import com.test.angular.pages.Login_Page;
import com.test.angular.pages.Neighbor_SignUp_Page;

public class Neighbor_SignUp_AfterNextWeek_Test extends Hooks {
	@BeforeTest
	public void launchApplication() throws Exception {
		System.out.println("TEST STARTED");
	}

	@Test
	public void SignUp_Neighbor() throws Exception {
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
				et.log(LogStatus.INFO, "Logged in as Neighbor role");

				// @@NEIGHBHOR SIGNUP FLOW
				Neighbor_SignUp_Page ns = new Neighbor_SignUp_Page(driver);

				/*
				 * ns.ClickOnGetStarted(); ns.FillCleaningDetails(); ns.bathroomCountDetails();
				 */
				et.log(LogStatus.INFO, "Updated Cleaning details");
				/*
				 * ns.PriceVerification(); ns.Clean_Schedule_AfterNextWeek();
				 */
				ns.Almost_Finished();
				ns.SummaryPage();
				et.log(LogStatus.INFO, "Summary page is updated");
				Wait.wait10Second();
				ns.DoPayment_Step();
				ns.VerifyOrder_DetailsPage();
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