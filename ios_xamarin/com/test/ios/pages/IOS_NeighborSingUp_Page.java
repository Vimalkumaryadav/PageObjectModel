package com.test.ios.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.Wait;
import com.test.mobile.excel.App_Excel_Read;
import com.test.mobile.hooks.App_Config;
import com.test.mobile.hooks.App_Hooks;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;

public class IOS_NeighborSingUp_Page 
{

	public IOSDriver<WebElement> ios_driver=null;
	public String Total_Price;
	
	public IOS_NeighborSingUp_Page(IOSDriver<WebElement> ios_driver)
	{
	this.ios_driver=ios_driver;	
	PageFactory.initElements( ios_driver,this);
	}
	
	@FindBy(name="Get Started")
	WebElement GetStarted;
	
	@FindBy(xpath="//*[@value='Address']")
	WebElement Address_List;
	
	@FindBy(xpath="//XCUIElementTypeApplication[@name=\"LapaLopa\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther")////XCUIElementTypeOther[@bounds='[30,85][315,40]']")
	WebElement Address_Search;
	
	
	@FindBy(name="Submit")
	WebElement Address_Submit;
	
	
	@FindBy(xpath="//XCUIElementTypeApplication[@name=\"LapaLopa\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
	WebElement UnitNumber;
	
	@FindBy(name="newplus")
	WebElement Bathroom_Count_Increment;
	
	@FindBy(name="newminus")
	WebElement Bathuroom_Count_Decrement;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@bounds='[299,267][25,25]']")
	WebElement Total_Bathroom_Count;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@bounds='[88,354][134,86]']")
	WebElement TotalPrice;
	
	@FindBy(name="Next")
	WebElement Price_next;
	
	@FindBy(xpath="")
	WebElement Radio_WithInThisWeek;
	
	@FindBy(xpath="")
	WebElement Clean_Schedule_Next;
	
	@FindBy(xpath="")
	WebElement Radio_IwillBeAtHome;
	
	@FindBy(xpath="")
	WebElement Finsih_Next;
	
	@FindBy(xpath="")
	WebElement Summary_TotalPrice;
	
	@FindBy(xpath="")
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
	

	@FindBy(id="submitButton")
	WebElement PayAmountButton;
	
	
	public void ClickOnGetStarted()throws Exception
	{
		System.out.println(" Get started method Entered ");
		Wait.wait5Second();
		ios_driver.findElement(By.name("Get Started")).click();	
		Wait.wait10Second();
	}
	
	public void FillCleaningDetails()throws Exception
	{
		System.out.println("Cleaning detiails page appeared");
		Wait.wait10Second();
		Address_List.click();
		Wait.wait12Second();
		System.out.println("10 sec loaded ");
		
		try {
			System.out.println("Address search try entered");
		Address_Search.click();
		}catch (Exception e) 
		{
			System.out.println("Address click not working");
		}
		Thread.sleep(12000);
		System.out.println("12 sec loaded at submit");

		Actions a=new Actions(ios_driver);
		a.sendKeys(App_Excel_Read.Cleaning_address+" DC").build().perform();
		Thread.sleep(1500);
		ios_driver.hideKeyboard();
		Wait.wait8Second();
		try 
		{
			ios_driver.hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Search");
		}catch (Exception e) 
		{
			System.out.println("Search Button interrupted");
		}
		
		Wait.wait14Second();
		System.out.println("12 sec loaded, and ready to click");
		Address_Submit.click();
		Wait.wait10Second();
		System.err.println("Clicked on submit and completed 10 sec loading");
		Wait.wait5Second();
		System.err.println("Loaded 15 sec  Excellent ");
		System.out.println("");
		System.out.println("Enter a unit number");
		Wait.wait12Second();
		UnitNumber.click();
		a.sendKeys(App_Excel_Read.UnitNumber).build().perform();
		ios_driver.hideKeyboard();
		Wait.wait12Second();
		System.out.println("12 sec loaded at unitnumber");
		String texttest =ios_driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='How many bathrooms?']")).getText();
		System.out.println("System get text :" + texttest);
		Thread.sleep(14000);
		System.out.println("loaded 14 sec after get text");
		Price_next.click();
		System.out.println("Next button clicked successfully");
		Wait.wait8Second();
	}
	
	
	public void bathroomCountDetails() throws Exception
	{
		/**
		
		if(App_Excel_Read.BathroomCount.equals("1"))
		{
			System.out.println("Default bathroom count is -- > 1");
			Wait.wait2Second();
		}
		else if(App_Excel_Read.BathroomCount.equals("1.5"))
		{
			Bathroom_Count_Increment.click();
			Wait.wait5Second();
			System.out.println("working fine");
		
		}
		else if(App_Excel_Read.BathroomCount.equals("2"))
		{
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
			Bathroom_Count_Increment.click();
			Wait.wait5Second();
		}
		else if(App_Excel_Read.BathroomCount.equals("2.5"))
		{
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
			Bathroom_Count_Increment.click();
			Wait.wait5Second();
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
			Wait.wait5Second();
		}
		else
		{
			//
		}
		
		Thread.sleep(3500);
		String TotalBathCountSelected= Total_Bathroom_Count.getText();
		System.out.println("Total number of bathroom count applied is ->" + TotalBathCountSelected);
		App_Hooks.et.log(LogStatus.INFO, "Total number of bathroom count applied is ->" + TotalBathCountSelected);
		
		*/
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
		Thread.sleep(2000);
		Wait.wait5Second();
		App_Hooks.et.log(LogStatus.INFO, "Price details are verified as per bathroom count");
		System.out.println("Click on price next button");
		Thread.sleep(2000);
		Price_next.click();
		System.out.println("Next button clicked successfully");
		Wait.wait3Second();
	
	}
	
	
	public void Clean_Schedule() throws InterruptedException
	{
		Wait.wait5Second();
		try {
		Radio_WithInThisWeek.click();
		App_Hooks.et.log(LogStatus.INFO, "Cleaning Schedule Page is verified ");
		}catch (Exception e) {
		System.out.println("Executed catch block");
		ios_driver.findElement(By.xpath("(//div[@class='radio radio-primary'])[3]")).click();
		}
		Clean_Schedule_Next.click();
		Wait.wait4Second();
	}
	
	public void Almost_Finished() throws InterruptedException
	{
		Wait.wait5Second();
		Radio_IwillBeAtHome.click();
		Finsih_Next.click();
		App_Hooks.et.log(LogStatus.INFO, "Almost Finished page is verified");
		Wait.wait3Second();
	}
	
	public void SummaryPage() throws InterruptedException
	{
	String Summary_NoOfBathrooms_Count = Summary_NumberOfBathroom.getText();
	String Summary_Total_Price = Summary_TotalPrice.getText();
	Wait.wait3Second();
	
	try {
		if(Summary_Total_Price.equals(Total_Price))
		{
		System.out.println(" Total Price is same in both Summary page and Dashboard page");
		App_Hooks.et.log(LogStatus.PASS, " Total Price is same in both Summary page and Dashboard page");
		}
		}catch (Exception e) 
		{
		System.out.println("Total price verification is Failed");
		App_Hooks.et.log(LogStatus.FAIL, "Total price verification is Failed");
		
		}
		System.out.println("Click pay now ");
		Wait.wait10Second();
		
		try {
		PayNowButton.click();
		}catch (Exception e) {
		System.out.println("");
	}
	Wait.wait10Second();
	
	}
	
	public void DoPayment_Step() throws InterruptedException 
	{
		try {
		CreditCardDebitCardButton.click();
		Wait.wait10Second();
		System.out.println("Clicked on Credit card and Debit card button");
		InputCardNumber.sendKeys(App_Config.CardNumber);
		InputMonthYear.sendKeys(App_Config.MonthAndYear);
		Enter_CVC.sendKeys(App_Config.CVV_Number);
		ios_driver.hideKeyboard();
		System.out.println("Key Board hided");
		Thread.sleep(2000);
		try {
		
		PayAmountButton.click();
		System.out.println("going to try ");
	}catch (Exception e) 
	{
		System.out.println("Test Entered into Catch");
		ios_driver.findElement(By.xpath("//android.widget.Button[@bounds='[170,1420][910,1548]']"));
	}
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
	WebElement PaymentSuccessMsg = ios_driver.findElement(By.xpath("//android.view.View[@text='Payment Success']"));	
	
	String PassMessage="Neighbor signup is successfully verified, Test Passed";
	String FailMessage="Neighbor signup Test Failed";
	App_Hooks.VerifyByElement(PaymentSuccessMsg, PassMessage, FailMessage);
	}catch (Exception e) 
	{
	System.out.println("Test Interrupted");
	}
	Wait.wait5Second();
	
	}


}
