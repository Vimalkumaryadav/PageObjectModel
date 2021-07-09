package com.test.angular.pages;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.excel.Excel_Read;
import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.Wait;

public class Simple_NeighborSignUp_Page extends Hooks
{

	public WebDriver driver=null;
	public String Total_Price;

	public Simple_NeighborSignUp_Page(WebDriver driver)
	{
	this.driver=driver;	
	PageFactory.initElements( driver,this);
	}
	
		@FindBy(xpath="(//button[text()='Get Started'])[2]")
	WebElement GetStarted;
	
	
	//@@ LOCATORS OF What Gets Cleaned Page
	
	@FindBy(xpath="//u[text()='What gets cleaned']")
	WebElement WhatGetsCleanedLink;
	
	@FindBy(xpath="//div[contains(text(),'What gets cleaned?')]")
	WebElement WhatGetsCleanedSection;
	
	@FindBy(xpath="//div[contains(text(),'Frequently Asked Questions')]")
	WebElement FAQSection;
	
	@FindBy(xpath="//*[@class='icon icon-ll-icon-close cross']")
	WebElement CloseButton;
	
	//@@ LOCATORS OF FAQ Page
	@FindBy(id="navbarDropdown")
	WebElement AltMenu;
	
	@FindBy(xpath="//a[text()='FAQ']")
	WebElement FAQ;
	
	@FindBy(xpath="//h3[text()='Who is Lapa Lopa?']")
	WebElement WhoIsLapalopaQuestion;
	
	@FindBy(xpath="//h3[text()='What is a Neighbor?']")
	WebElement WhatIsANeighborQuestion;
	
	@FindBy(xpath="//h3[text()='What is a Service Partner?']")
	WebElement WhatIsAServicePatnerQuestion;
	
	@FindBy(xpath="(//i[@class='icon icon-ll-icon-chev-left'])[3]")
	WebElement BackButtonFromFAQ;
	
	// LOCATORS OF @@LET'S GET YOUR CLEANING SERVICE STARTED PAGE
	
	//LOCATORS OF @@NEGATIVE
	
	@FindBy(xpath="(//div[@class='text-danger'])[3]")
	WebElement AddressErrorMsg;
				
	@FindBy(xpath="(//div[@class='text-danger'])[4]")
	WebElement UnitErrorMsg;
	
	//@@ LOCATORS POSITIVE
	@FindBy(xpath="(//*[@class='nsdicon-angle-down'])[2]")
	WebElement Address_List;
	
	@FindBy(name="search")
	WebElement Address_Search;
	
	@FindBy(xpath="(//input[@id='unitNumber'])[2]")
	WebElement UnitNumber;
	
	@FindBy(xpath="(//input[@placeholder='Special Code'])[2]")
	WebElement Promotion_Code;
	
	@FindBy(xpath="/html/body/app-root/div/neighborlanding/section[2]/div/div/div[2]/div/div[1]/div/div[3]/div/div/span/a[1]")
	WebElement Bathroom_Count_Increment;
	
	@FindBy(xpath="/html/body/app-root/div/neighborlanding/section[2]/div/div/div[2]/div/div[1]/div/div[3]/div/div/span/a[2]")
	WebElement Bathuroom_Count_Decrement;
	
	@FindBy(id="desktopSpinner")
	WebElement Total_Bathroom_Count;
	
	@FindBy(xpath="/html/body/app-root/div/neighborlanding/section[2]/div/div/div[2]/div/div[2]/div[1]/label")
	WebElement TotalPrice;
	
	@FindBy(xpath="(//button[text()='Next'])[2]")
	WebElement Price_next;
	
	@FindBy(xpath="//span[contains(text(),'Back')]")
	WebElement BackButton;
	  
	//@@ LOCATORS OF LEAR HOW WE SCHEDULE PAGE
	
	@FindBy(xpath="(//u[text()='Learn how we schedule'])[2]")
	WebElement LearnHowWeScheduleLink;
	
	@FindBy(xpath="(//div[contains(text(),'We group apartments')])[2]")
	WebElement LearnHowWeScheduleText;
	
	//@@ LOCATORS OF CLEANING SCHEDULE PAGE
	
	@FindBy(xpath="(//label[text()=' As soon as Possible '])[2]")
	WebElement Radio_AsSoonAsPossible;
	
	@FindBy(xpath="(//label[text()=' After next week '])[2]")
	WebElement Radio_AfterThisWeek;
	
	@FindBy(xpath="(//button[@class='mat-icon-button'])[2]")
	WebElement DatePicker2;		

	@FindBy(xpath="(//*[contains(@class,'mat-datepicker-toggle-default-icon ng-star-inserted')])[2]")
	WebElement DatePicker;
	
	@FindBy(xpath="//td[@class='mat-calendar-body-cell mat-calendar-body-active ng-star-inserted']")
	WebElement SelectDate;
	
	@FindBy(xpath="(//select[@id='contactPrefered'])[2]")
	WebElement ContactPreferenceDropDown;
	
	@FindBy(xpath="(//option[text()='SMS (Text Message)'])[2]")
	WebElement SMSDropDown;
	
	@FindBy(xpath="(//option[text()='App (Push Notification)'])[2]")
	WebElement AppDropDown;
	
	@FindBy(xpath="(//input[@placeholder='Mobile Number'])[2]")
	WebElement MobileNumber;
	
	@FindBy(xpath="(//span[@class='switch switch-medium'])[2]")
	WebElement DoYouHavePetsButton;
	
	@FindBy(xpath="(//div[contains(@class,'mat-checkbox-inner')])[4]")
	WebElement DogsCheckbox;
	
	@FindBy(xpath="(//div[contains(@class,'mat-checkbox-inner')])[5]")
	WebElement CatsCheckbox;
	
	@FindBy(xpath="(//div[contains(@class,'mat-checkbox-inner')])[6]")
	WebElement OtherCheckbox;
	
	@FindBy(xpath="(//button[text()='Next'])[2]")
	WebElement Clean_Schedule_Next;
	
	//@@ LOCATORS FOR ALMOST FINISHED PAGE
		
	@FindBy(xpath="(//label[contains(text(),'ll be at home ')])[2]")
	WebElement Radio_IwillBeAtHome;
	
	@FindBy(xpath="(//button[text()='Next'])[2]")
	WebElement Finsih_Next;
	
	@FindBy(xpath="/html/body/app-root/div/neighborsummary/section[2]/div/div/div[2]/div/div[2]/div/div[1]/label")
	WebElement Summary_TotalPrice;
	
	@FindBy(xpath="/html/body/app-root/div/neighborsummary/section[2]/div/div/div[2]/div/div[1]/div/div[3]/div/h3")
	WebElement Summary_NumberOfBathroom;
	
	@FindBy(xpath="(//button[text()='Pay Now'])[2]")
	WebElement PayNowButton;
	
	@FindBy(xpath="//input[@placeholder='Card number']")
	WebElement InputCardNumber;
	
	@FindBy(xpath="//input[@placeholder='MM / YY']")
	WebElement InputMonthYear;
	
	@FindBy(xpath="//input[@placeholder='CVC']")
	WebElement Enter_CVC;
	
	@FindBy(xpath="//div[@class='Button-content']")
	WebElement UpdateCardDetailsButton;
	
	@FindBy(xpath="//*[@id=\"container\"]/section/span[2]/div/div/main/form/nav/div/div/div/button")
	WebElement PayAmountButton;
	
	@FindBy(xpath="(//button[text()='Dashboard'])[2]")
	WebElement PayMent_Confirmation_Dashaboard;
	
	public void ClickOnGetStarted()throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			System.out.println("Get started method entered ");
			GetStarted.click();
		}catch (Exception e) 
		{
			System.out.println("Get started button is not displayed");
		}
	Wait.wait5Second();
	Pass_Count=Pass_Count+1;
	}
	
	public void FillCleaningDetails()throws Exception
	{
		System.out.println("Cleaning detiails page appreared");
		et.log(LogStatus.INFO,"Cleaning detiails page appreared");
		
		//@@ METHOD OF LET'S GET YOUR CLEANING SERVICE STARTED PAGE
		Wait.wait2Second();
		Address_List.click();
		Wait.wait2Second();
		Address_Search.sendKeys(Excel_Read.Cleaning_address);
		Wait.wait2Second();
		Actions a=new Actions(driver);
		a.sendKeys(Keys.DOWN,Keys.ENTER).build().perform();
		Wait.wait2Second();
		UnitNumber.sendKeys(Excel_Read.UnitNumber);
		Pass_Count=Pass_Count+1;
		
	}
	
	public void bathroomCountDetails() throws Exception
	{
		if(Excel_Read.BathroomCount.equals("1"))
		{
			System.out.println("Default bathroom count is -- > 1");
			Wait.wait2Second();
		}
		if(Excel_Read.BathroomCount.equals("1.5"))
		{
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
		}
		else if(Excel_Read.BathroomCount.equals("2"))
		{
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
		}
		else if(Excel_Read.BathroomCount.equals("2.5"))
		{
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
			Bathroom_Count_Increment.click();
			Wait.wait2Second();
		}
		else if(Excel_Read.BathroomCount.equals("3"))
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

		String TotalBathCountSelected= Total_Bathroom_Count.getAttribute("aria-valuenow");
		System.out.println("Total number of bathroom count applied is ->" + TotalBathCountSelected);
		et.log(LogStatus.INFO, "Total number of bathroom count applied is ->" + TotalBathCountSelected);
		Pass_Count=Pass_Count+1;
	}
	
	public void PriceVerification() throws InterruptedException
	{
		Total_Price = TotalPrice.getText();


		if(Excel_Read.BathroomCount.equals("1") && Total_Price.equals("$50") )
		{
			System.out.println("Total Price verified ->" +Total_Price);
		}
		if(Excel_Read.BathroomCount.equals("1.5") && Total_Price.equals("$60") )
		{
			System.out.println("Total Price verified ->" +Total_Price);
		}
		if(Excel_Read.BathroomCount.equals("2") && Total_Price.equals("$65") )
		{
			System.out.println("Total Price verified ->" +Total_Price);
		}
		if(Excel_Read.BathroomCount.equals("2.5")&& Total_Price.equals("$75") )
		{
			System.out.println("Total Price verified ->" +Total_Price);
		}
		if(Excel_Read.BathroomCount.equals("3")&& Total_Price.equals("$80") )
		{
			System.out.println("Total Price verified ->" +Total_Price);
		}
		else
		{
			//
		}
		
		Price_next.click();
		Wait.wait3Second();
		Pass_Count=Pass_Count+1;
	}
	
	
	
	public void Clean_Schedule_AsSoonAsPossible() throws InterruptedException
	{
		Wait.wait5Second();
		try {
			Radio_AsSoonAsPossible.click();
		}catch (Exception e) {
			System.out.println("Execute catch block");
			driver.findElement(By.xpath("(//div[@class='radio radio-primary'])[3]")).click();
		}
		Clean_Schedule_Next.click();
		Wait.wait5Second();
		Pass_Count=Pass_Count+1;
	}
	
	public void Clean_Schedule_AfterNextWeek() throws InterruptedException
	{
		Wait.wait5Second();
		Radio_AfterThisWeek.click();
		try {
		Select s=new Select(driver.findElement(By.xpath("(//select[@aria-placeholder='Select Prefered Contact'])[3]")));
		s.selectByIndex(1);
		System.out.println("Select work");
		}catch (Exception e) {
			DatePicker.click();
			SelectDate.click();
		}
		Wait.wait5Second();
		ContactPreferenceDropDown.click();
		Wait.wait2Second();
		SMSDropDown.click();
		Wait.wait2Second();
		
		//@@ RANDOM NUMBER GENERATOR FOR MOBILE NUMBER
		
		Random rnd = new Random();
		int randomNo = 2000000000 + rnd.nextInt(90000000);
		System.out.println("random id : " + randomNo);
		
		Integer intInstance = new Integer(randomNo);
		String number=intInstance.toString();
		
		MobileNumber.sendKeys(number);
		DoYouHavePetsButton.click();
		Wait.wait2Second();
		DogsCheckbox.click();
		CatsCheckbox.click();
		OtherCheckbox.click();
		
		Clean_Schedule_Next.click();
		Wait.wait5Second();
		Pass_Count=Pass_Count+1;
	}
	
	public void Almost_Finished() throws InterruptedException
	{
		Wait.wait5Second();
		Radio_IwillBeAtHome.click();
		Finsih_Next.click();
		Wait.wait3Second();
		Pass_Count=Pass_Count+1;	
	}
	
	public void SummaryPage() throws InterruptedException
	{
		PayNowButton.click();
		Wait.wait5Second();
		Pass_Count=Pass_Count+1;
	}
	
	public void DoPayment_Step() throws InterruptedException 
	{
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement FrameLocation =driver.findElement(By.xpath("//iframe[@name='stripe_checkout_app']"));
			driver.switchTo().frame(FrameLocation);	
			System.out.println("Entered into Frame");
			Wait.wait3Second();
			Pass_Count=Pass_Count+1;
			
			//@@Email Verification
			
			WebElement VerifyEmail = driver.findElement(By.xpath("//*[@class='Header-loggedInEmail']"));
			String Email=VerifyEmail.getText();
			System.out.println(" Email --> " + Email);
			
			if(Email.contains(Excel_Read.Login_Username))
			{
				et.log(LogStatus.PASS, " Email is Verified on Payment Popup");
				System.out.println(" Email is Verified on Payment Popup");
				System.out.println(" Email --> " + Email);
				
			}
			else
			{
				et.log(LogStatus.FAIL, " Expected email is not displayed on Payment Popup ");
				System.out.println(" Wrong Email ");	
			}
			Pass_Count=Pass_Count+1;
			
			
			//@@Entering Card Details
			InputCardNumber.sendKeys(Config.CardNumber);
			InputMonthYear.sendKeys(Config.MonthAndYear);
			Enter_CVC.sendKeys(Config.CVC_Number);
			try {
				PayAmountButton.click();
				}catch(Exception e) {
				UpdateCardDetailsButton.click();
				}
			Wait.wait15Second();
			System.out.println("PAYMENT IS DONE");
			}catch (Exception e) 
			{
				System.out.println("Card details not working, error - >" + e );	
			}
		Wait.wait2Second();
		Pass_Count=Pass_Count+1;
		
		//@@ REMOVED FROM THE APPLICATION
		
		/*PayMent_Confirmation_Dashaboard.click();
		Wait.wait3Second();*/
	}
	
	public void VerifyOrder_DetailsPage() throws Exception
	{	
		try {
			WebElement VerifyLoginPage = driver.findElement(By.xpath("//h1[text()='Your Cleanings']"));
			String Login_Page=VerifyLoginPage.getText();
			if(Login_Page.contains("Your Cleanings"))
			{
				et.log(LogStatus.PASS, "Home Page is Displayed");
				System.out.println("Home Page is Displayed");
				
			}
			else
			{
				et.log(LogStatus.FAIL, "Home Page is not Displayed");
				System.err.println("Home Page is not Displayed");	
			}
			}catch (Exception e) {
				System.err.println("Your cleanings is not displayed");
			}
		Wait.wait5Second();
		Pass_Count=Pass_Count+1;
	}
	
	
}