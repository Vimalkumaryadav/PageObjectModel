package com.test.ios.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.test.mobile.excel.App_Excel_Read;

import com.test.mobile.hooks.App_Hooks;

import io.appium.java_client.ios.IOSDriver;

public class IOS_UserLogin_Page 
{

	public IOSDriver<WebElement> ios_driver;

	public IOS_UserLogin_Page(IOSDriver<WebElement> ios_driver)
	{
	this.ios_driver=ios_driver;	
	PageFactory.initElements( ios_driver,this);
	}
	
	
	@FindBy(name="Sign in")
	WebElement LoginButton;
	
	@FindBy(xpath="//*[@value='Email']")
	WebElement Username;
	
	@FindBy(xpath="//*[@value='Password']")
	WebElement Password;
	
	@FindBy(name="Sign In Now")
	WebElement SignInButton;
	
	
		
	public void ClickSignInOption() throws InterruptedException
	{
		Thread.sleep(4000);
		LoginButton.click();
		Thread.sleep(4000);
		ios_driver.switchTo().alert().accept();
		App_Hooks.et.log(LogStatus.INFO,"Pop is accepeted, and webpage appeared");
		System.out.println("Pop is accepeted, and webpage appeared");
		Thread.sleep(8000);
		
	}
	

	public void EnterUsernameAndPassword() throws InterruptedException
	{
		Thread.sleep(4000);
		System.out.println("Coming here fine");
		Username.sendKeys("kedarllp3@gmail.com");//App_Excel_Read.Login_Username);
		System.out.println("Üsername entered");
		Password.sendKeys(App_Excel_Read.Login_Password);
		App_Hooks.et.log(LogStatus.INFO,"Successfully Entered Username and Password");
	}
	
	public void SignIn_Now_Button_And_VerifyLogin() throws InterruptedException
	{
		SignInButton.click();
		Thread.sleep(12000);
		String PassMsg = "User logged-In successfully and navigated to Main Dashboard page";
		String FailMsg = "Get Started, Is not displayed";
		try 
		{
		WebElement GetStartedButton = ios_driver.findElement(By.name("Get Started"));	
		App_Hooks.VerifyByElement(GetStartedButton, PassMsg, FailMsg);
		System.out.println("Login test verified, and test passed");
		}catch (Exception e) 
		{
		  System.out.println("Get started not displayed");
		}
		Thread.sleep(5000);
	}
}
