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

public class Neighbor_SignUp_Test extends Hooks {
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
				// lp.ClickSignInOption();
				lp.EnterUsernameAndPassword();
				// lp.SignIn_Now_Button_And_VerifyLogin();
				et.log(LogStatus.INFO, "Logged in as Neighbor role");

				// @@NEIGHBHOR SIGNUP FLOW
				Neighbor_SignUp_Page ns = new Neighbor_SignUp_Page(driver);
				ns.Metro_Area_Address();
				ns.Quality_Cleaning();
				ns.Cleaning_Every_2_Weeks();
				ns.Surface_Focus_Cleaning();
				ns.Kitchen_Bathrooms_FloorsAndDusting();
				ns.Cleaning_Every_Other_Week();
				ns.Dont_forget_to_secure_your_pet_before_the_cleaner();
				ns.When_should_we_start_cleaning();

				/*
				 * ns.FillCleaningDetails(); ns.bathroomCountDetails();
				 * et.log(LogStatus.INFO,"Updated Cleaning details"); ns.PriceVerification();
				 * ns.Clean_Schedule_AsSoonAsPossible(); ns.Almost_Finished(); ns.SummaryPage();
				 * ns.DoPayment_Step(); ns.VerifyOrder_DetailsPage();
				 */
				LogoutApp();
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
