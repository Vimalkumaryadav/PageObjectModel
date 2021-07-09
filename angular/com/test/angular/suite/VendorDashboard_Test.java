package com.test.angular.suite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.angular.pages.ExistingUser_Login_Page;

import static com.test.angular.hooks.StageDB.*;
import static com.test.angular.excel.Excel_Read.*;

import java.sql.SQLException;

public class VendorDashboard_Test extends Hooks {

	@BeforeTest
	public void launchApplication() throws SQLException {
		System.out.println("TEST STARTED");
		connectToDB();
		System.out.println("!!Database Connection Success!!");

	}

	@Test
	public void vendorDashboardFlow() throws Exception {
		for (int i = Config.Start_Row_Number; i <= Config.End_Row_Number; i++) {
			try {
				read(i);
				System.out.println("Excel Data Loaded Successfully");

				Hooks.launch(Config.URL);
				ExistingUser_Login_Page elp = new ExistingUser_Login_Page(driver);
				elp.SignInAsCleaner();
				elp.EnterCleanerUsernameAndPassword();

			} catch (Throwable th) {

				System.err.print("Test Interrupted----->");
				th.printStackTrace();

			}

		}
	}

	@AfterTest
	public void closeTest() throws SQLException {
		closeDB();
		System.out.println("!!Test Completed!!");
	}

}
