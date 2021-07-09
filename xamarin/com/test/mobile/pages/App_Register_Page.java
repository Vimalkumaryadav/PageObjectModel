package com.test.mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.mobile.excel.App_Excel_Read;
import com.test.mobile.hooks.App_Config;

import io.appium.java_client.android.AndroidDriver;

public class App_Register_Page 
{

	public AndroidDriver driver=null;

	public App_Register_Page(AndroidDriver driver)
	{
	this.driver=driver;	
	PageFactory.initElements( driver,this);
	}
	
	
	@FindBy(className="android.widget.Button")  
	WebElement RegisterButton;
	
	@FindBy(id="FulName")
	WebElement Name;
	
	@FindBy(id="Email")
	WebElement Email;
	
	@FindBy(id="Password")
	WebElement Password;
	
	@FindBy(className="android.widget.Button")  
	WebElement SignUpButton;
	
	@FindBy(id="ZipCode")
	WebElement ZipCode;
	
	@FindBy(className="android.widget.Button")  
	WebElement Next_ZipCode;
	
	@FindBy(className="android.view.View")
	WebElement VerifyEmailMessage;

	public void clickOnRegButton() throws InterruptedException
	{
		RegisterButton.click();
		Thread.sleep(5000);	
	}

	public void enterRegisterDetails() throws Exception
	{
		
		Name.sendKeys(App_Excel_Read.Name);
		Email.sendKeys(App_Excel_Read.Login_Username);
		Password.sendKeys(App_Excel_Read.Login_Password);
		SignUpButton.click();
		Thread.sleep(3000);
		
	}
	
	public void Enter_Zip_verifyEmailBox() throws Exception
	{
		ZipCode.clear();
		ZipCode.sendKeys(App_Excel_Read.ZipCode);
		Next_ZipCode.click();
		Thread.sleep(8000);
		String PassMessage="Email verification box is displayed and Test Passed";
		String FailedMessage ="Expected Values is not displayed, Test Failed";
		Hooks.VerifyByElement(VerifyEmailMessage, PassMessage, FailedMessage);
		Thread.sleep(2000);
	}
	
	
	
	
	
	
	
	
	
	
}
