package com.test.angular.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.Wait;
import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.excel.Excel_Read;

public class Login_Page extends Hooks
{
	public WebDriver driver=null;

	public Login_Page(WebDriver driver)
	{
	this.driver=driver;	
	PageFactory.initElements( driver,this);
	}
	
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement LoginButton;
	
	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(xpath="//button[text()='Sign In Now']")
	WebElement SignInButton;
	
	
	
	public void ClickSignInOption() throws InterruptedException
	{
		LoginButton.click();
		Wait.wait5Second();
	}
	

	public void EnterUsernameAndPassword() throws InterruptedException
	{
		Username.sendKeys(Excel_Read.Login_Username);
		Password.sendKeys(Excel_Read.Login_Password);
		Thread.sleep(2000);
		SignInButton.click();
		Wait.wait5Second();
		et.log(LogStatus.PASS, "User Logged into the Application succesfully");
	}
	
	public void SignIn_Now_Button_And_VerifyLogin() throws InterruptedException
	{
		
	
	
		String SuccessMsg="User Main Landing page is verified and Test passed";
		String FailedMsg ="User Main Landing page Test is Failed";
		try {
		WebElement GetStartedButton = driver.findElement(By.xpath("(//button[text()='Get Started'])[2]"));
		
		Hooks.VerifyByElement(GetStartedButton, SuccessMsg, FailedMsg);
	
		}catch (Exception e) {
			et.log(LogStatus.FAIL, "Application is not redirected to Main Landing page");
			System.err.println("Application is not redirected to Main Landing page" + e);
		}
		
	}
		
}
