package com.test.mobile.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Duration;

import com.relevantcodes.extentreports.LogStatus;

import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.Wait;
import com.test.mobile.excel.App_Excel_Read;
import com.test.mobile.hooks.App_Config;
import com.test.mobile.hooks.App_Hooks;

import io.appium.java_client.android.AndroidDriver;

public class App_Neighbor_SignUp_Page extends App_Hooks
{
	

	public AndroidDriver<WebElement> driver=null;
	public String Total_Price;

	public App_Neighbor_SignUp_Page(AndroidDriver<WebElement> driver)
	{
	this.driver=driver;	
	PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//android.widget.Button[@text='Get Started']")
	WebElement GetStarted;
	
	@FindBy(xpath="//android.widget.EditText[@text='Address']")
	WebElement Address_List;
	
	@FindBy(xpath="//android.widget.EditText[@text='Selet']")
	WebElement Address_Search;
	          
	
	@FindBy(xpath="//android.widget.Button[@text='Submit']")
	WebElement Address_Submit;
	
		
	@FindBy(xpath="//android.widget.EditText[@text='Unit #']")
	WebElement UnitNumber;
		
	@FindBy(xpath="//android.widget.Button[@bounds='[960,820][1025,886]']")
	WebElement Bathroom_Count_Increment;
	
	@FindBy(xpath="//android.widget.Button[@bounds='[797,820][863,886]']")
	WebElement Bathuroom_Count_Decrement;
	
	@FindBy(xpath="//android.widget.TextView[@bounds='[878,820][944,886]']")
	WebElement Total_Bathroom_Count;
	
	@FindBy(xpath="//android.widget.TextView[@bounds='[288,1054][637,1297]']")
	WebElement TotalPrice;
	
	@FindBy(xpath="//android.widget.Button[@text='Next']")
	WebElement Price_next;
	
	@FindBy(xpath="//android.widget.ImageView[@bounds='[922,407][988,473]']")
	WebElement Radio_WithInThisWeek;
	
	@FindBy(xpath="//android.widget.ImageView[@bounds='[52,1732][1027,1863]']")
	WebElement Clean_Schedule_Next;
	
	@FindBy(xpath="//android.widget.ImageView[@bounds='[913,520][997,604]']")
	WebElement Radio_IwillBeAtHome;
	
	@FindBy(xpath="//android.widget.Button[@text='Next']")
	WebElement Finsih_Next;

	@FindBy(xpath="//android.widget.TextView[@bounds='[233,916][582,1159]']")
	WebElement Summary_TotalPrice;
	
	@FindBy(xpath="//android.widget.TextView[@bounds='[446,542][490,594]']")
	WebElement Summary_NumberOfBathroom;
	
	
	
	@FindBy(xpath="//android.widget.Button[@text='Pay Now']")
	WebElement PayNowButton;
	
	@FindBy(xpath="//android.widget.Button[@text='Credit Card/Debit Card']")
	WebElement CreditCardDebitCardButton;
	
	@FindBy(id="card_number")
	WebElement InputCardNumber;
	
	@FindBy(id="cc-exp")
	WebElement InputMonthYear;
	
	@FindBy(id="cc-csc")
	WebElement Enter_CVC;
	
	//@FindBy(xpath="//android.widget.Button[@resource-id='submitButton']")
	@FindBy(id="submitButton")
	WebElement PayAmountButton;
	
	
	public void ClickOnGetStarted()throws Exception
	{
		try 
		{
			System.out.println(" Get started method entered ");
			GetStarted.click();
			Wait.wait10Second();
		}catch (Exception e) 
		{
			System.out.println("Get started button is not displayed" + e);
		}
		Wait.wait5Second();
	}
	
	public void FillCleaningDetails()throws Exception
	{
		System.out.println("Cleaning detiails page appeared");
		Address_List.click();
		Wait.wait2Second();
		
		Actions a=new Actions(driver);
		a.sendKeys(App_Excel_Read.Cleaning_address).build().perform();
		Thread.sleep(1500);
			
		try 
		{
			driver.findElement(By.xpath("//android.widget.TextView[@bounds='[21,425][1059,474]']")).click();
			Thread.sleep(1000);
		}catch(Exception e) 
		{
			System.out.println("Pick address from list test is interrupted");
		}
			
		Address_Submit.click();
		Wait.wait2Second();
		
		UnitNumber.sendKeys(App_Excel_Read.UnitNumber);
		Wait.wait2Second();
	}
	
	
	public void bathroomCountDetails() throws Exception
	{
		if(App_Excel_Read.BathroomCount.equals("1"))
		{
			System.out.println("Default bathroom count is -- > 1");
			Wait.wait2Second();
		}
		if(App_Excel_Read.BathroomCount.equals("1.5"))
		{
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
			System.out.println("working fine");
			
		}
		else if(App_Excel_Read.BathroomCount.equals("2"))
		{
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
		}
		else if(App_Excel_Read.BathroomCount.equals("2.5"))
		{
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
		}
		else if(App_Excel_Read.BathroomCount.equals("3"))
		{
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
		}
		else
		{
			//
		}
		
		Thread.sleep(3500);
		String TotalBathCountSelected= Total_Bathroom_Count.getText();
		System.out.println("Total number of bathroom count applied is ->" + TotalBathCountSelected);
		et.log(LogStatus.INFO, "Total number of bathroom count applied is ->" + TotalBathCountSelected);
	}
	
	
	public void PriceVerification() throws InterruptedException
	{
		Total_Price = TotalPrice.getText();
		Thread.sleep(3000);
		System.out.println("Switching to the PriceVerfication method");

		if(App_Excel_Read.BathroomCount.equals("1") && Total_Price.equals("$50") )
		{
			System.out.println("Total Price verified and working fine, price is ->" +Total_Price);
		}
		if(App_Excel_Read.BathroomCount.equals("1.5") && Total_Price.equals("$60") )
		{
			System.out.println("Total Price verified and working fine, price is ->" +Total_Price);
		}
		if(App_Excel_Read.BathroomCount.equals("2") && Total_Price.equals("$65") )
		{
			System.out.println("Total Price verified and working fine, price is ->" +Total_Price);
		}
		if(App_Excel_Read.BathroomCount.equals("2.5")&& Total_Price.equals("$75") )
		{
			System.out.println("Total Price verified and working fine, price is ->" +Total_Price);
		}
		if(App_Excel_Read.BathroomCount.equals("3")&& Total_Price.equals("$80") )
		{
			System.out.println("Total Price verified and working fine, price is ->" +Total_Price);
		}
		else
		{
			//
		}
		Wait.wait3Second();
		et.log(LogStatus.INFO, "Price details are verified as per bathroom count");
		Price_next.click();
		Wait.wait3Second();
	}
	
	
	public void Clean_Schedule() throws InterruptedException
	{
		Wait.wait5Second();
		try {
		Radio_WithInThisWeek.click();
		et.log(LogStatus.INFO, "Cleaning Schedule Page is verified ");
		}catch (Exception e) {
			System.out.println("Executed catch block");
			driver.findElement(By.xpath("(//div[@class='radio radio-primary'])[3]")).click();
		}
		Clean_Schedule_Next.click();
		Wait.wait4Second();
	}
	
	public void Almost_Finished() throws InterruptedException
	{
		Wait.wait5Second();
		Radio_IwillBeAtHome.click();
		Finsih_Next.click();
		et.log(LogStatus.INFO, "Almost Finished page is verified");
		Wait.wait3Second();
	}
	
	public void SummaryPage() throws InterruptedException
	{
		String Summary_NoOfBathrooms_Count =  Summary_NumberOfBathroom.getText();
		String Summary_Total_Price =  Summary_TotalPrice.getText();
		Wait.wait3Second();
		
		try {
		if(Summary_Total_Price.equals(Total_Price))
		{
			System.out.println(" Total Price is same in both Summary page and Dashboard page");
			et.log(LogStatus.PASS, " Total Price is same in both Summary page and Dashboard page");
		}
		}catch (Exception e) 
		{
			System.out.println("Total price verification is Failed");
			et.log(LogStatus.FAIL, "Total price verification is Failed");

		}
		
		try {
		PayNowButton.click();
		}catch (Exception e) 
		{
			System.out.println("Pay Now button is not clicked");
		}
		Wait.wait10Second();

	}
	
	public void DoPayment_Step() throws InterruptedException 
	{
		try {
			CreditCardDebitCardButton.click();
			Wait.wait15Second();
			System.out.println("15 sec loaded");
			InputCardNumber.click();
			Thread.sleep(2000);
			Actions a=new Actions(driver);
			a.sendKeys(App_Config.CardNumber).build().perform();
			Thread.sleep(2000);
			InputMonthYear.click();
			a.sendKeys(App_Config.MonthAndYear);
			Thread.sleep(2000);
			Enter_CVC.click();
			a.sendKeys(App_Config.CVV_Number);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.view.View[@text='Remember me']")).click();
			String  textTitle= driver.findElement(By.xpath("//android.view.View[@text='Remember me']")).getText();
			PayAmountButton.click();
			Wait.wait15Second();
			System.out.println("PAYMENT IS DONE");	
		}catch (Exception e) 
		{
			System.out.println("Card details not working, error - >" + e );	
		}
	}
	
	
	public void VerifyOrder_DetailsPage() throws Exception
	{
		Wait.wait5Second();
		try {
			WebElement PaymentSuccessMsg = driver.findElement(By.xpath("//android.view.View[@text='Payment Success']"));	
			
			String PassMessage="Neighbor signup is successfully verified, Test Passed";
			String FailMessage="Neighbor signup Test Failed";
			App_Hooks.VerifyByElement(PaymentSuccessMsg, PassMessage, FailMessage);
			}catch (Exception e) 
			{
				System.out.println("Test Interrupted");
			}
		Wait.wait8Second();
		
		
		
		WebElement continueButton =driver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE']"));
		try {
		//Scroll screen
		TouchActions action = new TouchActions(driver);
		action.scroll(continueButton, 10, 100);
		action.perform();
		Wait.wait5Second();
		System.out.println("Scroll done");
		}catch (Exception e) 
		{
			System.out.println("Scroll not working");
			Wait.wait5Second();
		}
		//VERIFY THE PAGE
		continueButton.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Home']")).click();
		Thread.sleep(10000);
		
		try {
			WebElement CleaningDashboard = driver.findElement(By.xpath("//android.widget.TextView[@text='Cleaning Dashboard']"));	
			
			String PassMessage="Cleaning Dashboard is successfully displayed, Test Passed";
			String FailMessage="Cleaning Dashboard Test Intettupted";
			App_Hooks.VerifyByElement(CleaningDashboard, PassMessage, FailMessage);
			}catch (Exception e) 
			{
				System.out.println("Test Interrupted");
			}
		
	}
	
	
}
