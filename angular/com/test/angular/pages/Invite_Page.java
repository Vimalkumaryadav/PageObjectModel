package com.test.angular.pages;

import org.openqa.selenium.NoSuchElementException;



import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.excel.Excel_Read;
import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.Wait;

public class Invite_Page extends Hooks 
{
	public WebDriver driver;
	public Invite_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	String invite_mail_header="You have been invited to join Lapalopa.";
	
	@FindBy(css="a#desktopInvite")
	WebElement neighbor_Invite_main;
	
	@FindBy(xpath="//h3[@class='pt-3 text-center']")
	WebElement Invite_Page_header;
	
	@FindBy(xpath="//button[@class='btn btn-inactive btn-block mt-4']")
	WebElement send_invite_button;
	
	@FindBy(xpath="//button[@class='btn btn-inactive float-right mt-2']")
	WebElement viewsent_invite_button;
	
	@FindBy(xpath="//div[@class='col pt-5'] //input[@placeholder='Name']")
	WebElement referral_name;
	
	@FindBy(xpath="//div[@class='col pt-5'] //input[@placeholder='Email or Mobile']")
	WebElement referral_email;
	
	@FindBy(xpath="//div[@class='col-lg-9 col-md-8 col-8 px-0']/h3/following-sibling::p")
	WebElement referral_email_content;
	
	@FindBy(xpath="//div[@class='col-lg-3 col-md-4 col-4 px-0']/h3")
	WebElement invitaion_status;
	
	@FindBy(css="input#Password")
	WebElement signup_pwd_textbox;
	
	@FindBy(xpath="//button[text()='Sign Up Now']")
	WebElement signup_button;
	
	@FindBy(xpath="//input[@name='ZipCode']")
	WebElement zipcode_textbox;
	
	@FindBy(xpath="//div[@class='col-10 m-auto']/button")
	WebElement zipcode_next_button;
	
	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(xpath="//button[text()='Sign In Now']")
	WebElement SignInButton;
	
	@FindBy(xpath="(//div[@class='col-lg-8 col-10  mx-auto']/div/div[2]/div)[1]")
	WebElement Alt_menu_invite;
	
	@FindBy(xpath="//a[@class='float-left py-2 pl-4']/u")
	WebElement Backbutton_ReferralInfo_Page;
	
	@FindBy(xpath="")
	WebElement Gmail_section;
	
	@FindBy(xpath="(//div[@class='text-danger'])[3]")
	WebElement name_validation;
	
	@FindBy(xpath="(//div[@class='text-danger'])[4]")
	WebElement email_validation;
	
	@FindBy(linkText="Explore With Others")
	WebElement newuser_invite_link;
	
	
	
	public void invite_Page_Navigate() throws InterruptedException 
	{
		Wait.wait5Second();
		try 
		{
			neighbor_Invite_main.click();
			
		} catch (org.openqa.selenium.NoSuchElementException ne) 
		
		{
			try
			{
				newuser_invite_link.click();
				
			} catch (org.openqa.selenium.NoSuchElementException ne1)
			
			{
				System.err.println("Unable to find Invite section in Main Landing page");

			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	
			
		}
		Wait.wait5Second();
		try
		{
			if(Invite_Page_header.getText().equals("Invite your friends and get rewards"))
			{
				System.out.println("Successfully navigated to Invite page");
				
				
			}
			else
			{
				System.out.println("Not redirected to Invited page, Test Failed");
				
			}
			
		}catch(Exception exp)
		{
			System.out.println("Test Interrupted at Invite_Page_Verify() method and error is--->:"+ exp);
		}
	}
	
	public void invite_Page_Verify()
	{
		try 
		{
			Wait.wait5Second();
			//System.out.println(verify_Default_Count());
			if(send_invite_button.isDisplayed() && viewsent_invite_button.isDisplayed() && verify_Default_Count())
			{
				System.out.println("Invite page verified sucssfully");
				et.log(LogStatus.PASS,"Invite page verified successfully, Test Passed");
				Pass_Count++;
			}
			else
			{
				System.out.println("Invite page verification failed");
				et.log(LogStatus.FAIL,"Invite page verification failed, Test Failed");
				Fail_Count = Fail_Count+1;
			}
		}catch(NoSuchElementException nsx)
		{
			System.err.println("Unable to find Invite / View Sent Invite button");
		}catch(Exception exp)
		{
			System.err.println("Test Interrupted at invite_Page_Verify() method and error--->"+exp);
		}
	}
	
	public void send_Referral_And_Verify(int invited_user_count) throws InterruptedException
	{
		try 
		{
			referral_name.sendKeys(Excel_Read.Name);
			referral_email.sendKeys(Excel_Read.Referral_Email);
			Wait.wait2Second();
			send_invite_button.click();
			Wait.wait5Second();
			verify_Invite_Count(invited_user_count);
			viewsent_invite_button.click();
			Wait.wait5Second();
			try {
				if(referral_email_content.isDisplayed() && referral_email_content.isDisplayed())
				{
					String Referral_Email=referral_email_content.getText();
					String Invitation_Status=invitaion_status.getText();
					if((Referral_Email.equals(Excel_Read.Referral_Email)) && (Invitation_Status.equalsIgnoreCase("Invitation Sent")))
					{
						System.out.println("Referral User("+invited_user_count+") Information is verified successfully");
						et.log(LogStatus.PASS, "Referral User("+invited_user_count+") Information verified successfully, Test Passed");
						Pass_Count++;
					}
					else
					{
						System.out.println("Referral User("+invited_user_count+") Information verification is failed");
						et.log(LogStatus.FAIL, "Referral User("+invited_user_count+") Information verification failed, Test is Failed");
						Fail_Count = Fail_Count+1;
					}
				}
				else
				{
					System.out.println("Referral User("+invited_user_count+") Information is not getting updated in the Information Page");
					et.log(LogStatus.FAIL, "Referral User("+invited_user_count+") Information is not getting updated in the Information Page, Test Failed");
					Fail_Count = Fail_Count+1;
				}
			}catch(NoSuchElementException ne)
			{
			   System.err.println("Given referral email id is already Registered");
			   driver.quit();
			   //System.exit(0);
		 	}
			 
		}catch(Throwable t)
		{
			t.printStackTrace();
		}
	}

	public void verify_invite_email() throws InterruptedException
	{
		try 
		{
			
			//String invite_mail_header="You have been invited to join Lapalopa.";
			//int invited_user_number=invited_user_count;
			
			/*********Opening New Tab in ChromeBrowser using Robot class************/
			
			/*Robot robot=new Robot();
			Thread.sleep(10000);
			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(5000);
			Thread.sleep(10000);*/
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.open()");
			
						
			ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
			String parent_window=tabs.get(0);
			driver.switchTo().window(tabs.get(1));
			Wait.wait2Second();
			driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
			Wait.wait5Second();
			
			/****************Login into the Gmail Login and verify Invite Email*********************/			
			
						
			driver.findElement(By.xpath("(//a[@class='h-c-header__nav-li-link '])[4]")).click();
			ArrayList<String> tabs2=new ArrayList<String>(driver.getWindowHandles());
			
			//System.out.println(tabs2.size()); ---->Total windows count
			
			driver.switchTo().window(tabs2.get(2));
			Wait.wait5Second();
			
			if(driver.getCurrentUrl().contains("https://accounts.google.com/AccountChooser/signinchooser?"))
			{
				driver.findElement(By.xpath("//div[@class='BHzsHc']")).click();
				Wait.wait5Second();
				gmail_Login_And_VerifyInvite_Mail(Excel_Read.Referral_Email, Config.Gmail_Password);
				Wait.wait5Second();
				int i=2;
			do {	
					driver.close();
					i--;
					driver.switchTo().window(tabs.get(i));
					Wait.wait5Second();
		
				}while(i>=1);
			}
			else
			{
				Wait.wait5Second();
				gmail_Login_And_VerifyInvite_Mail(Excel_Read.Referral_Email, Config.Gmail_Password);
				Wait.wait5Second();
				int i=2;
				do {	
						driver.close();
						i--;
						driver.switchTo().window(tabs.get(i));
						Wait.wait5Second();
			
					}while(i>=1);
			}
			
			/*
			driver.findElement(By.cssSelector("input#identifierId")).sendKeys(Excel_Read.Referral_Email, Keys.ENTER);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Config.Gmail_Password, Keys.ENTER);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@name='q']")).sendKeys(invite_mail_header.substring(0, 21),Keys.ENTER);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//tr[1]/td[6]/div/div/div[2]/span/span")).click();;
			Thread.sleep(5000);
			String act_invite_header=driver.findElement(By.xpath("//table[@role='presentation']/tr/td/div/div/div[2]/div/h2")).getText();
			if(invite_mail_header.equalsIgnoreCase(act_invite_header))
			{
				System.out.println("Invite Email received successfully, Test Passed");
				et.log(LogStatus.PASS, "Invite Email received successfully, Test Passed");
			}
			else
			{
				System.out.println("Invite Email NOT received, Test Failed");
				et.log(LogStatus.FAIL, "Invite Email NOT received, Test Failed");
			}
			*/
			/*---------------Redirect back to LapaLopa Invite page-------------------*/		
			Backbutton_ReferralInfo_Page.click();
			Wait.wait5Second();
			
			
			
		} catch (Exception exp) 
		{
			System.err.println(exp);
			exp.printStackTrace();
			System.exit(0);
		}
		
		
	}
	
	public void invited_neighbor_reg() throws Exception
	{	
		//@@ Log in to Gmail and click on Invite link
		if(driver.getCurrentUrl().contains("https://accounts.google.com/AccountChooser/signinchooser?"))
		{
			driver.findElement(By.xpath("//div[@class='BHzsHc']")).click();
			Wait.wait5Second();
			gmail_Login_And_VerifyInvite_Mail(Excel_Read.Referral_Email, Config.Gmail_Password);
			Wait.wait5Second();
		}
		else
		{
			gmail_Login_And_VerifyInvite_Mail(Excel_Read.Referral_Email, Config.Gmail_Password);
			Wait.wait5Second();
		}
		
		driver.findElement(By.xpath("//div[@class='adn ads']/div[2]/div[3]/div/div/div/div/following-sibling::p[2]/span/a")).click();
		ArrayList<String> tabs2=new ArrayList<String>(driver.getWindowHandles());
		//System.out.println("Size of the google windows:"+tabs2.size());/*-------------------------Size of the Google Windows-----------------------*/
		
		//@@New User Signup
		driver.switchTo().window(tabs2.get(2));
		Wait.wait5Second();
		signup_pwd_textbox.clear();
		signup_pwd_textbox.sendKeys(Excel_Read.Login_Password);
		Wait.wait2Second();
		signup_button.click();
		Wait.wait2Second();
		zipcode_textbox.sendKeys(Excel_Read.ZipCode);
		zipcode_next_button.click();
		Wait.wait10Second();
		
		Username.clear();
		Username.sendKeys(Excel_Read.Referral_Email);
		Password.clear();
		Password.sendKeys(Excel_Read.Login_Password,Keys.ENTER);
		Wait.wait10Second();
		Register_Page rp=new Register_Page(driver);
		rp.VerifyReg();
		
		//@@Neighbor Registration
		Neighbor_SignUp_Page ns=new  Neighbor_SignUp_Page(driver);
		/*
		 * ns.ClickOnGetStarted(); ns.FillCleaningDetails(); ns.bathroomCountDetails();
		 */
		et.log(LogStatus.INFO,"Updated Cleaning details");
		/*
		 * ns.PriceVerification(); ns.Clean_Schedule_AsSoonAsPossible();
		 */
		ns.Almost_Finished();
		ns.SummaryPage();
		et.log(LogStatus.INFO,"Summary page is updated");
		Wait.wait10Second();
		ns.DoPayment_Step();
		ns.VerifyOrder_DetailsPage();
		LogoutApp();
		Wait.wait10Second();
		
		int i=2;
		do {	
				driver.close();
				i--;
				driver.switchTo().window(tabs2.get(i));
				Wait.wait5Second();
	
			}while(i>=1);
		}
	public void delete_invite_user(int rowNumber) throws Exception
	{
		
		Excel_Read.read_Referral_Data(rowNumber, (Config.total_referral_users+1)+6);
		
		//System.out.println("Entered into Delete flow");
		
		//@@ Sending an invite to new user
		referral_name.sendKeys(Excel_Read.Name);
		referral_email.sendKeys(Excel_Read.Referral_Email);
		send_invite_button.click();
		Wait.wait5Second();
		
		viewsent_invite_button.click();
		//driver.findElement(By.xpath("(//div[@class='col-lg-8 col-10  mx-auto']/div/div[2]/div)[1]")).click();
		Wait.wait5Second();
		
		Actions ac=new Actions(driver);
		ac.moveToElement(Alt_menu_invite).build().perform();
		driver.findElement(By.xpath("(//div[@class='tooltiptext tooltip-right']/p[2])[1]")).click();
		driver.switchTo().alert().accept();
		Wait.wait5Second();
		String act_refer_email=referral_email_content.getText();
		System.out.println("Actual_Refer_Email:"+act_refer_email);
		System.out.println("Expeced from Excel:"+Excel_Read.Referral_Email);
		
		if (act_refer_email.equalsIgnoreCase(Excel_Read.Referral_Email))
		{
			
			System.out.println("Invited User Deletion failed");
			et.log(LogStatus.FAIL, "Invited User Deletion failed, Test Failed");
			Fail_Count = Fail_Count+1;
		}
		else 
		{
			
			
			System.out.println("Invited User Deleted successfully");
			et.log(LogStatus.PASS, "Invited User Deleted successfully, Test Passed");
			Pass_Count++;
		}
		Wait.wait2Second();
		Backbutton_ReferralInfo_Page.click();
		
		
		
	}
	
	public void resend_invite(int rowNumber) throws Exception
	{
		Excel_Read.read_Referral_Data(rowNumber, (Config.total_referral_users+1)+6);
		
		//System.out.println("Entered into Rsend Invite flow");
		
		//@@ Sending an invite to new user
		referral_name.sendKeys(Excel_Read.Name);
		referral_email.sendKeys(Excel_Read.Referral_Email);
		send_invite_button.click();
		Wait.wait5Second();
		
		viewsent_invite_button.click();
		//driver.findElement(By.xpath("(//div[@class='col-lg-8 col-10  mx-auto']/div/div[2]/div)[1]")).click();
		Wait.wait5Second();
		
		Actions ac=new Actions(driver);
		ac.moveToElement(Alt_menu_invite).build().perform();
		driver.findElement(By.xpath("(//div[@class='tooltiptext tooltip-right']/p[1])[1]")).click();
		driver.switchTo().alert().accept();
		Wait.wait5Second();
	
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.open()");
		
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		//String parent_window=tabs.get(0);
		driver.switchTo().window(tabs.get(1));
		Wait.wait2Second();
		driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
		Wait.wait5Second();
		
		/****************Login into the Gmail Login and verify Invite Email*********************/			
		
					
		driver.findElement(By.xpath("(//a[@class='h-c-header__nav-li-link '])[4]")).click();
		ArrayList<String> tabs2=new ArrayList<String>(driver.getWindowHandles());
		
		//System.out.println(tabs2.size());-------------------------> Total Windows opend count
		
		driver.switchTo().window(tabs2.get(2));
		Wait.wait5Second();
		
		if(driver.getCurrentUrl().contains("https://accounts.google.com/AccountChooser/signinchooser?"))
		{
		
			driver.findElement(By.xpath("//div[@class='BHzsHc']")).click();
			Wait.wait5Second();
			gmail_Login(Excel_Read.Referral_Email, Config.Gmail_Password);
			Wait.wait5Second();
			driver.findElement(By.xpath("//input[@name='q']")).sendKeys(invite_mail_header.substring(0, 21),Keys.ENTER);
			Wait.wait5Second();
			Gmail_section.click();
			Wait.wait5Second();
			int invite_resend_mails_count=driver.findElements(By.xpath("//img[@jid='donotreply@lapalopa.com']")).size();
			if(invite_resend_mails_count>1)
			{
				System.out.println("Invite resent successfully, Test Passed");
				et.log(LogStatus.PASS, "Invite resent successfully, Test Passed");
				Pass_Count++;
			}
			else
			{
				System.out.println("Invite mail resend is failed, Test Failed");
				et.log(LogStatus.FAIL, "Invite mail resend is failed, Test Failed");
				Fail_Count = Fail_Count+1;
			}
			int i=2;
			do {	
				driver.close();
				i--;
				driver.switchTo().window(tabs.get(i));
				Wait.wait5Second();
			}while(i>=1);
		}
		else
		{
			Wait.wait5Second();
			gmail_Login(Excel_Read.Referral_Email, Config.Gmail_Password);
			Wait.wait5Second();
			driver.findElement(By.xpath("//input[@name='q']")).sendKeys(invite_mail_header.substring(0, 21),Keys.ENTER);
			Wait.wait5Second();
			Gmail_section.click();
			Wait.wait5Second();
			int invite_resend_mails_count=driver.findElements(By.xpath("//img[@jid='donotreply@lapalopa.com']")).size();
			//invited Emails count
			System.out.println("Invited Emails count:"+invite_resend_mails_count);
			if(invite_resend_mails_count>1)
			{
				System.out.println("Invite resent successfully, Test Passed");
				et.log(LogStatus.PASS, "Invite resent successfully, Test Passed");
				Pass_Count++;
			}
			else
			{
				System.out.println("Invite mail resend is failed, Test Failed");
				et.log(LogStatus.FAIL, "Invite mail resend is failed, Test Failed");
				Fail_Count = Fail_Count+1;
			}	
			Wait.wait5Second();
			int i=2;
			do {	
					driver.close();
					i--;
					driver.switchTo().window(tabs.get(i));
					Wait.wait5Second();
		
				}while(i>=1);
			
		}
		Backbutton_ReferralInfo_Page.click();
		Wait.wait5Second();	
	}
	public void invalid_invite_data() throws InterruptedException
	{
		send_invite_button.click();
		Wait.wait5Second();
				
		String name_validation_msg=name_validation.getText();
		String email_validation_msg=email_validation.getText();
		if(name_validation_msg.contains("Name is required")&&email_validation_msg.contains("Email or Mobile is required"))
		{
			System.out.println("Invalid invite data verification passed, Test Passed");
			et.log(LogStatus.PASS, "Invalid invite data verification passed, Test Passed");
			Pass_Count++;
		}
		else
		{
			System.out.println("Invalid invite data verification failed, Test Failed");
			et.log(LogStatus.FAIL, "Invalid invite data verification failed, Test Failed");
			Fail_Count++;
		}	
	}		
}