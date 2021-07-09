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
import com.test.angular.pages.Simple_NeighborSignUp_Page;

public class Simple_NeigborSignUp extends Hooks {

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
				Simple_NeighborSignUp_Page sns = new Simple_NeighborSignUp_Page(driver);

				sns.ClickOnGetStarted();
				sns.FillCleaningDetails();
				sns.bathroomCountDetails();
				et.log(LogStatus.INFO, "Updated Cleaning details");
				sns.PriceVerification();
				sns.Clean_Schedule_AsSoonAsPossible();
				sns.Almost_Finished();
				sns.SummaryPage();
				et.log(LogStatus.INFO, "Summary page is updated");
				Wait.wait10Second();
				sns.DoPayment_Step();
				sns.VerifyOrder_DetailsPage();
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