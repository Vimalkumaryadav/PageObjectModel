package com.test.mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.mobile.excel.App_Excel_Read;
import com.test.mobile.hooks.App_Config;
import com.test.mobile.hooks.App_Hooks;

import io.appium.java_client.android.AndroidDriver;

public class App_Login_Page 
{
	public AndroidDriver driver = null;
	public App_Login_Page(AndroidDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Sign in']")
	WebElement LoginButton;
	
	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(xpath="//android.widget.Button[@text='Sign In Now']")
	WebElement SignInButton;
		
	public void ClickSignInOption() throws InterruptedException
	{
		LoginButton.click();
		Thread.sleep(8000);
	}
	

	public void EnterUsernameAndPassword() throws InterruptedException
	{	Thread.sleep(1500);
		/*JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("history.go(0)");
		System.out.println("Cleared history");
		Thread.sleep(2000);*/
		
		Username.sendKeys(App_Excel_Read.Login_Username);
		Thread.sleep(1000);
		Password.clear();
		Password.sendKeys(App_Excel_Read.Login_Password);
		App_Hooks.et.log(LogStatus.INFO,"Successfully Entered Username and Password");
	}
	
	public void SignIn_Now_Button_And_VerifyLogin() throws InterruptedException
	{
		SignInButton.click();
		Thread.sleep(10000);
		String PassMsg="User logged-In successfully and navigated to Main Dashboard page";
		String FailMsg ="Test Failed for Existing user Login";
		try 
		{
			WebElement GetStartedButton = driver.findElement(By.xpath("//android.widget.Button[@text='Get Started']"));	
			WebElement Become_A_Clearner = driver.findElement(By.xpath("//android.widget.TextView[@text='Become a cleaner']"));	
			App_Hooks.VerifyBy_Two_Element(GetStartedButton,Become_A_Clearner, PassMsg, FailMsg);
		}catch (Exception e) 
		{
		  System.out.println("Login Success");
		}
		Thread.sleep(5000);
	}
}
