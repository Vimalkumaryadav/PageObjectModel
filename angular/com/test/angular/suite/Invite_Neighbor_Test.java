package com.test.angular.suite;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.test.angular.excel.Excel_Read;
import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.Wait;
import com.test.angular.pages.Invite_Page;
import com.test.angular.pages.Login_Page;

public class Invite_Neighbor_Test extends Hooks {

	@BeforeTest
	public void launchApplication() {
		System.out.println("TEST STARTED");
	}

	@Test
	public void invite_Neighbor_Flow() {
		for (int i = Config.Start_Row_Number; i <= Config.End_Row_Number; i++) {

			try {
				Excel_Read.read(i);
				System.out.println("Exceal Data loaded successfully");
				Wait.wait5Second();
				Hooks.launch();
				Login_Page lp = new Login_Page(driver);
				lp.ClickSignInOption();
				lp.EnterUsernameAndPassword();
				Wait.wait10Second();
				Invite_Page in = new Invite_Page(driver);
				in.invite_Page_Navigate();

				// ---Invited Users Registration Test------
				for (int j = i; j <= Config.total_referral_users; j++)

				{
					Excel_Read.read_Referral_Data(i, j + 6);
					System.out.println("Invite Users data loaded scussessfully");
					in.send_Referral_And_Verify(j);
					in.verify_invite_email();
				}

				// ---------------------------Invited Neighbors Registration
				// Test---------------------------------------
				LogoutApp();
				Wait.wait5Second();
				driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
				Wait.wait5Second();

				for (int k = 1; k <= Config.total_referral_users; k++) {
					Excel_Read.read_Referral_Data(i, k + 6);
					driver.findElement(By.xpath("(//a[@class='h-c-header__nav-li-link '])[4]")).click();
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					System.out.println(tabs.size());
					/*------------------------------Window Size-----------------------------*/
					driver.switchTo().window(tabs.get(1));
					Wait.wait5Second();
					in.invited_neighbor_reg();
				}
				// @@ Referred User Login
				Excel_Read.read(i);
				driver.get(Config.URL);
				Wait.wait2Second();
				lp.ClickSignInOption();
				Wait.wait2Second();
				lp.EnterUsernameAndPassword();
				Wait.wait5Second();

				in.invite_Page_Navigate();

				Wait.wait5Second();
				verify_Invited_Neigh_Earned_Count(Config.total_referral_users);

				// @@ Invited User Delete
				in.delete_invite_user(i);

				// @@ Resend Invite Mail
				Wait.wait5Second();
				in.resend_invite(i);

				// @@ Invalid Data Test
				in.invalid_invite_data();

				LogoutApp();

			} catch (Exception e) {

				System.out.println("Test Interrupted:---->" + e);
			} finally {
				// Hooks.EndTest();
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
