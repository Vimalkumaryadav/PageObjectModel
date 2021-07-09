package com.test.angular.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.Wait;
import com.test.angular.excel.Excel_Read;

public class Register_Page extends Hooks
{
	public WebDriver driver=null;
	
	public Register_Page(WebDriver driver)
	{
	this.driver=driver;	
	PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//a[text()=' Sign Up with Facebook']")
	WebElement FacbookRegisterButton;
	
	@FindBy(xpath="//a[text()=' Sign Up with Google']")
	WebElement GoogleRegisterButton;
	
	@FindBy(xpath="(//button[text()='Register'])[2]")
	WebElement RegisterButton;
	
	@FindBy(id=("FulName"))
	WebElement Name;
	
	@FindBy(id=("Email"))
	WebElement Email;
	
	@FindBy(id=("Password"))
	WebElement Password;
	
	@FindBy(xpath="//button[text()='Sign Up Now']")
	WebElement SignUpButton;
	
	@FindBy(id="ZipCode")
	WebElement ZipCode;

	@FindBy(xpath="(//button[text()='Next'])[1]")
	WebElement Next_ZipCode;

	@FindBy(xpath="//*[text()='Please verify your email']")
	WebElement VerifyEmailMessage;
	
	public void clickOnRegButton() throws Exception
	{
			RegisterButton.click();
			Wait.wait3Second();
	}
	
	public void enterRegisterDetails() throws Exception
	{
	Name.sendKeys(Excel_Read.Name);
	Email.sendKeys(Excel_Read.Login_Username);
	Password.sendKeys(Excel_Read.Login_Password);
	SignUpButton.click();
	Wait.wait3Second();
	}

	public void Enter_Zip_verifyEmailBox() throws Exception
	{
		ZipCode.sendKeys(Excel_Read.ZipCode);
		Next_ZipCode.click();
		Wait.wait5Second();
		WebElement VerifyYourEmailPage = driver.findElement(By.xpath("//h4[contains(text(),'We sent a verification email to')]"));	
		String ExpEmail = VerifyYourEmailPage.getText();
		
		if(ExpEmail.contains(com.test.angular.excel.Excel_Read.Login_Username))
		{
			et.log(LogStatus.PASS,"Registered Email displayed");
			System.out.println("Registered Email displayed");
		}
		else
		{
			et.log(LogStatus.FAIL,"Wrong Email Displayed");
			System.err.println("Wrong Email Displayed");
		}
	
	Wait.wait2Second();
	((JavascriptExecutor)driver).executeScript("window.open()");
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(tabs.get(1)); 
	}

	public void VerifyReg() throws Exception
	{
		try {
			WebElement GetStartedButton = driver.findElement(By.xpath("(//button[text()='Get Started'])[2]"));
			WebElement BecomeACleanerLink = driver.findElement(By.xpath("//u"));
			WebElement HowCanWeHelpText = driver.findElement(By.xpath("//h1[text()='How can we help?']"));
			String SuccessMsg="User Main Landing page is verified and Test passed";
			String FailedMsg="User Main Landing page Test is Failed";
			Hooks.VerifyByElement(GetStartedButton, BecomeACleanerLink, HowCanWeHelpText, SuccessMsg, FailedMsg);
			}catch (Exception e) 
			{
				et.log(LogStatus.FAIL, "User signup verification test interrupted");
				System.err.println("User signup verification test interrupted");
			}
	}	
}
