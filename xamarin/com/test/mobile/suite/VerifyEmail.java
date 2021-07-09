package com.test.mobile.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.test.angular.hooks.Hooks;
import com.test.mobile.hooks.App_Hooks;
import com.test.mobile.pages.App_SignUpVerify_Page;

public class VerifyEmail extends App_Hooks
{
	
	@Test
	public void verifyEmailTest() throws Exception
	{
		System.out.println("Test Started");
		App_Hooks.OpenBrowserInMobile();
		App_SignUpVerify_Page vp=new App_SignUpVerify_Page(driver);
		vp.GmailLoginPage();
		System.out.println("Test Ended");
	}

}
