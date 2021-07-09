package com.test.angular.suite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.Wait;
import com.test.angular.pages.Verify_Profile_Page;
import com.test.angular.pages.Register_Page;

public class VerifyProfile_Test extends Hooks {
	@BeforeTest
	public void launchApplication() throws Exception {
		launch();
	}

	@Test
	public void Login() throws Exception {
		Verify_Profile_Page eul = new Verify_Profile_Page(driver);
		Register_Page rp = new Register_Page(driver);
		eul.ClickSignInOption();
		eul.EnterUsernameAndPassword();
		Wait.wait8Second();
		rp.VerifyReg();
		eul.VerifyProfile();
		eul.VerifyDetails();
	}

	@AfterTest
	public void CloseTest() throws Exception {
		LogoutApp();
		EndTest();
	}
}
