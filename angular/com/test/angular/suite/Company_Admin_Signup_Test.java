package com.test.angular.suite;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.google.common.base.Function;
import com.relevantcodes.extentreports.LogStatus;
import static com.test.angular.excel.Excel_Read.*;

import com.test.angular.excel.Excel_Read;
import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.StageDB;

import static com.test.angular.hooks.Wait.*;

import com.test.angular.pages.CompanyUsers_Signup_Page;
import com.test.angular.pages.ExistingUser_Login_Page;
import com.test.angular.pages.Register_Page;
import com.test.angular.pages.Vendor_SignUp_Page;
import static com.test.angular.hooks.StageDB.*;

public class Company_Admin_Signup_Test extends Hooks {

	@SuppressWarnings("deprecation")
	@Test
	public void companyOwnerSignup() throws Exception {

		for (int i = Config.Start_Row_Number; i <= Config.End_Row_Number; i++) {
			try {
				read("CompanyUsers", i);
				System.out.println("Exceal Data loaded successfully");
				launch(Config.URL);

				CompanyUsers_Signup_Page cuser = new CompanyUsers_Signup_Page(driver);

				/*************************
				 * CompanyAdmin Mail Verification thru Yopmail
				 ********************/
				cuser.verifyCompanyUserYopmail(Excel_Read.adminEmail);

				/*
				 * Company mail thru Gmail code commented GmailLaunch();
				 * gmail_Login(Excel_Read.Login_Username, Config.Gmail_Password);
				 * cuser.verifyCompanyEmail();
				 */

				/************ Company Onwer Signup in Lapa Lopa site *****************/

				cuser.enterAdminRegisterDetails();

				/**************************************
				 * Company Owner Login
				 ***********************************/

				cuser.companyUserLogin(Excel_Read.adminEmail, Excel_Read.Login_Password);
				wait10Second();

				Assert.assertTrue(cuser.verifyCompanyAdminRole(), "Company Admin Role verification failed");
				wait10Second();

				/******************* Register as Company Owner vendor ********************/
				// driver.findElement(By.xpath("//section[@class='desktop-section d-none
				// d-md-block'] //button[text()='Next']")).click();
				Vendor_SignUp_Page vsp = new Vendor_SignUp_Page(driver);
				vsp.Tell_us_about_yourself_Page();
				vsp.Lapalopa_Cleaning_Page();
				vsp.Take_a_Photo_Of_Yourself_Page();
				vsp.Address_Information_Page();
				vsp.Vendor_Detail_Page();
				vsp.Investigation_Page();
				StageDB sb = new StageDB();
				sb.DBupdateForCompanyUser(adminEmail);
				cuser.validateAdminDashboard();

				LogoutApp();

				EndTest();

			} catch (Exception e) {
				System.err.println("Test Interrupted----->" + e);
				Fail_Count = Fail_Count + 1;
			}
			closeReports();
			System.out.println("Pass_Count-->" + Pass_Count);
			System.out.println("Fail_Count-->" + Fail_Count);

		}

	}

}
