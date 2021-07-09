package com.test.angular.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.Wait;
import com.test.angular.excel.Excel_Read;


public class Verify_Profile_Page extends Hooks
{
	public WebDriver driver=null;

	public Verify_Profile_Page(WebDriver driver)
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
	
	@FindBy(xpath="//u[text()='Explore Profile']")
	WebElement Profile;
	
	@FindBy(id="firstName")
	WebElement FIrstName;
	
	@FindBy(id="lasttName")
	WebElement LastName;
	
	@FindBy(id="email")
	WebElement EmailVerify;
	
	public void ClickSignInOption() throws InterruptedException
	{
		LoginButton.click();
		Wait.wait5Second();
	}
	

	public void EnterUsernameAndPassword() throws InterruptedException
	{
		Username.sendKeys(Excel_Read.Login_Username);
		Password.sendKeys(Excel_Read.Login_Password,Keys.ENTER);	
	}
	
	public void VerifyProfile() throws InterruptedException
	{	
		Wait.wait10Second();
		Profile.click();
		Wait.wait10Second();
	}
	
	public void VerifyDetails() throws InterruptedException
	{
		WebElement VerifyFirstName = driver.findElement(By.id("firstName"));
		String FirstName = VerifyFirstName.getText();
		Wait.wait2Second();
		WebElement VerifyLastName = driver.findElement(By.id("lasttName"));
		String LastName = VerifyLastName.getText();
		Wait.wait2Second();
		WebElement VerifyYourEmail = driver.findElement(By.xpath("//*[@id='email']"));
		String Email = VerifyYourEmail.getText();
		Wait.wait2Second();
		
		if(Excel_Read.Name.contains(FirstName) && Excel_Read.Name.contains(LastName) &&
			Excel_Read.Login_Username.contains(Email)) 
		{
			et.log(LogStatus.PASS,"All the profile details are verified, Test Passed");
			System.out.println("All the profile details are verified, Test Passed");
		}
		else
		{
			et.log(LogStatus.FAIL,"Profile details are not as Expected, Test Failed");
			System.out.println("Profile details are not as Expected, Test Failed");
		}
		}


	
}

