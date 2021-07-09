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
import com.test.angular.pages.Neighbour_Dashboard_Page;
import com.test.angular.pages.Verify_Profile_Page;

public class Neighbour_Dashboard_Test extends Hooks {
	@BeforeTest
	public void launchApplication() throws Exception {
		System.out.println("TEST STARTED");
	}

	@Test
	public void YourCleaning() throws Exception {
		/**
		 * @@ Writing for loop to read multiple sets of input data from Excel Sheet
		 */
		for (int i = Config.Start_Row_Number; i <= Config.End_Row_Number; i++) {
			try {
				Excel_Read.read(i);
				System.out.println("Excel Data loaded successfully");
				Hooks.launch();

				// @LOGIN DETAIL

				Login_Page lp = new Login_Page(driver);
				// lp.ClickSignInOption();
				lp.EnterUsernameAndPassword();
				Wait.wait5Second();
				et.log(LogStatus.INFO, "Login Successfull");
				System.out.println("Login Successfull");

				// @VERIFICATION OF SECTIONS
				Neighbour_Dashboard_Page nd = new Neighbour_Dashboard_Page(driver);
				nd.Sections();
				et.log(LogStatus.INFO, "All Sections are Present");
				System.out.println("All Sections are Present");

				// @YOUR CLEANING PAGE
				nd.YourCleaningPage();
				et.log(LogStatus.INFO, "Your Cleaning Page Done");
				System.out.println("Your Cleaning Page Done");

				Neighbor_SignUp_Page ns = new Neighbor_SignUp_Page(driver);
				// @ADJUST CLEANING

				// @SUSPEND CLEANING

				nd.AdjustCLeaningPage();
				nd.SuspendCleaning();
				et.log(LogStatus.INFO, "Suspended Worked");
				System.out.println("Suspended Worked");

				// @ACTIVATE SUSPENDED SERVICE

				/*
				 * ns.FillCleaningDetails(); ns.bathroomCountDetails();
				 */

				ns.Metro_Area_Address();
				ns.Quality_Cleaning();
				ns.Cleaning_Every_2_Weeks();
				ns.Surface_Focus_Cleaning();
				ns.Kitchen_Bathrooms_FloorsAndDusting();
				ns.Cleaning_Every_Other_Week();
				ns.Dont_forget_to_secure_your_pet_before_the_cleaner();
				ns.When_should_we_start_cleaning();
				et.log(LogStatus.INFO, "Updated Cleaning details");
				System.out.println("Updated Cleaning details");

				/*
				 * ns.PriceVerification(); ns.Clean_Schedule_AsSoonAsPossible();
				 */

				ns.Almost_Finished();
				ns.SummaryPage();
				et.log(LogStatus.INFO, "Summary page is updated");
				System.out.println("Summary page is updated");
				Wait.wait10Second();
				ns.DoPayment_Step();
				et.log(LogStatus.INFO, "Suspended Service Activated");
				System.out.println("Suspended Service Activated");

				// @SKIP CLEANING

				nd.AdjustCLeaningPage();
				nd.SkipCleaning();
				et.log(LogStatus.INFO, "Skiped Worked");
				System.out.println("Skiped Worked");

				et.log(LogStatus.INFO, "Adjust Cleaning Page Done");
				System.out.println("Adjust Cleaning Page Done");
				// @NOTIFICATIONS

				nd.NotificationsPage();
				et.log(LogStatus.INFO, "Notifications Page Done");
				System.out.println("Notifications Page Done");

				// @BILLING & PAYMENT PAGE

				nd.BillingAndPaymentPage();
				ns.DoPayment_Step();
				et.log(LogStatus.INFO, "Billing & Payment Page Done");
				System.out.println("Billing & Payment Page Done");

				// @OVERVIEW PAGE

				nd.overviewPage();
				Verify_Profile_Page pg = new Verify_Profile_Page(driver);
				pg.VerifyDetails();
				et.log(LogStatus.INFO, "Overview Page Done");
				System.out.println("Overview Page Done");

				// @CHANGE PASSWORD

				nd.ChangePasswordPage();
				et.log(LogStatus.INFO, "Password Changed");
				System.out.println("Password Changed");

				// @CLEANING PAGE

				nd.CleaningProfile();
				et.log(LogStatus.INFO, "Cleaning Page Done");
				System.out.println("Cleaning Page Done");
				Pass_Count = Pass_Count + 1;

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
