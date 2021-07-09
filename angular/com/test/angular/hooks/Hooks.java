package com.test.angular.hooks;

import java.net.MalformedURLException;



import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import static com.test.angular.excel.Excel_Read.Login_Username;
import static java.lang.System.out;
import static java.lang.System.err;
import static com.test.angular.hooks.Wait.*;
import static com.test.angular.hooks.Config.*;

public class Hooks 
{
	public static WebDriver driver1;
	public static RemoteWebDriver driver;
	public static ChromeOptions options=new ChromeOptions();
	public static WebDriverWait ww;
	
	public static int Pass_Count=0;
	public static int Fail_Count=0;
	
	public static DateFormat format =new java.text.SimpleDateFormat("_yyyy-MMM-dd_h-mm");
	public static Date date=new Date();
	public static String Execution_Time =format.format(date);
	
	
	public static ExtentReports er=new ExtentReports(System.getProperty("user.dir")+"\\Angular_Test_Reports\\Log_"+Hooks.Execution_Time+".html");
	public static ExtentTest et=er.startTest("Lapa-Lopa Web Automation-Test Reports");

	/**CBT Credentials @MANOJ Account */
	public static String username = "manoj.narra%40tecra.com"; // Your user name
	public static String authkey = "u8f7ce62dfcf0b83";  // Your authkey
	public static String testScore = "unset"; 
	
	/**
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 * 
	 **/
	
	public static void Cloud_Browser() throws MalformedURLException, InterruptedException
	{
			DesiredCapabilities caps = new DesiredCapabilities();      
	        caps.setCapability("name", "LopaLapa Automation Test");
	        caps.setCapability("build", "1.0");
	        caps.setCapability("browserName", "Chrome");
	        caps.setCapability("version", "70x64");
	        caps.setCapability("platform", "Windows 10");
	        caps.setCapability("screenResolution", "1366x768");
	        caps.setCapability("record_video" , "true"); 
	        caps.setCapability("max_duration" , "2400"); 

	        
	        driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);
	        System.out.println(driver.getSessionId()); 
	        et.log(LogStatus.INFO, "Session Id is "+driver.getSessionId()+ " "); 
	        driver.get(Config.URL);
	        driver.manage().window().maximize();
			Wait.wait5Second();
			et.log(LogStatus.INFO," Application has launced");
			
	}
	
	public static void launch() throws Exception
	{	
		String lapaLopa_MarketingURL="http://appstg.lapalopa.com/company-signup";
		options.addArguments("-start-maximized");
		options.addArguments("disable-infobars");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.get(Config.URL);
		Wait.wait5Second();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		et.log(LogStatus.INFO," Application has launced");
	}
	public static void launch(String URL) throws Exception
	{	
		options.addArguments("-start-maximized");
		options.addArguments("disable-infobars");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver(options);
		if(URL.equalsIgnoreCase(Config.URL))
		{
			driver.get(Config.URL);
		}
		else
		{
			driver.get(Config.lapaLopa_MarketingSite);
			//fluentWait(driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']")));	
		}
		Wait.wait5Second();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		et.log(LogStatus.INFO," Lapa Lopa Marketing Site has been launched");
	}
	
	public static void LogoutApp() throws InterruptedException, NoSuchElementException
	{
		try {
			Wait.wait5Second();
			if(driver.findElement(By.id("navbarDropdown")).isDisplayed())
			{
				Wait.wait5Second();
				driver.findElement(By.id("navbarDropdown")).click();
				Wait.wait5Second();
				driver.findElement(By.linkText("Logout")).click();
				Wait.wait5Second();
				System.out.println("Logged Out Successfully");
			}
		}catch (Exception e) 
			{	Wait.wait5Second();
				driver.findElement(By.xpath("//div[contains(text(),'Logout')]")).click();
				Wait.wait5Second();
			}	
	}
	
	
	public static void EndTest() throws InterruptedException
	{
		driver.quit();
		Wait.wait5Second();
		et.log(LogStatus.INFO,"LapaLopa application has Closed");
	
	}
	
	public static void closeReports()
	{

		et.log(LogStatus.PASS,"TOTAL PASS COUNT -->" +Pass_Count);
		et.log(LogStatus.INFO,"TOTAL FAIL COUNT -->" +Fail_Count);
		
		er.flush();
		er.endTest(et);
	}
	

	
	
	public static void GmailLaunch() throws Exception
	{
		
		//@@ NAVIGATING GMAIL FOR SIGNUP EMAIL VERIFICATION
		driver.get("https://www.gmail.com");
		Wait.wait5Second();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	public static void VerifyByElement(WebElement element, String SuccessMessage, String ErrorMessage)
	{
		try 
		{
			if(element.isDisplayed())
			{
				et.log(LogStatus.PASS, SuccessMessage);
				System.out.println(SuccessMessage);
			}
			else
			{
				et.log(LogStatus.FAIL, ErrorMessage);
				System.err.println(ErrorMessage);
			}
		}
		catch (Exception Exception) 
		{
			System.err.println("Test Interrupted, Error is -->" + Exception);
		}
	}
	

	public static void VerifyByElement(WebElement element1, WebElement element2, String SuccessMessage, String ErrorMessage)
	{
		try
		{
			if(element1.isDisplayed() && element2.isDisplayed())
			{
				et.log(LogStatus.PASS, SuccessMessage);
				System.out.println(SuccessMessage);
			}
			else
			{
				et.log(LogStatus.FAIL, ErrorMessage);
				System.err.println(ErrorMessage);
			}
		}
		catch (Exception Exception) 
		{
			System.err.println("Test Interrupted, Error is -->" + Exception);
		}
	}

	public static void VerifyByElement(WebElement element1, WebElement element2, WebElement element3, String SuccessMessage, String ErrorMessage)
	{
		try 
		{
			if(element1.isDisplayed() && element2.isDisplayed() && element2.isDisplayed())
			{
				et.log(LogStatus.PASS, SuccessMessage);
				System.out.println(SuccessMessage);
			}
			else
			{
				et.log(LogStatus.FAIL, ErrorMessage);
				System.err.println(ErrorMessage);
			}
		}
		catch (Exception Exception) 
		{
			System.err.println("Test Interrupted, Error is -->" + Exception);
		}
	}	

	

	public static boolean verify_Default_Count()
	{
		boolean res=false;
		try
		{
		Wait.wait5Second();
		int Sent_Invite_Count=Integer.parseInt(driver.findElement(By.xpath("(//div[@class='col p-5']/div/h4/span)[1]")).getText().substring(0, 1));
		int Subscribed_Count=Integer.parseInt(driver.findElement(By.xpath("(//div[@class='col p-5']/div/h4/span)[2]")).getText().substring(0, 1));
		int Subscribed_Earned_Count=Integer.parseInt(driver.findElement(By.xpath("((//div[@class='col p-5']/div/h4/span)[4]")).getText().substring(0, 1));
		int Cleaner_Count=Integer.parseInt(driver.findElement(By.xpath("(//div[@class='col p-5']/div/h4/span)[4]")).getText().substring(0, 1));
			
		if(Sent_Invite_Count==0 && Subscribed_Count==0 && Subscribed_Earned_Count==0 && Cleaner_Count==0)
		{
			res=true;
		}
		
		}catch(Exception exp)
		{
			System.out.println("Test Interrupted at Verify_Default_Count() method and error is-->"+exp);
		}
		return res;
	
	
	}
	public static void verify_Invite_Count(int invited_user_count)
	{	
		
	try
	{
		Wait.wait5Second();
		int Sent_Invite_Count=Integer.parseInt(driver.findElement(By.xpath("(//div[@class='col p-5']/div/h4/span)[1]")).getText().substring(0, 1));
		if(Sent_Invite_Count==invited_user_count)
		{
			System.out.println("Referral User count("+invited_user_count+") updated successfully");
			et.log(LogStatus.PASS, "Referral User count("+invited_user_count+") updated successfully, Test Passed");
			Pass_Count++;
		}
		else
		{
			System.out.println("Referral User count("+invited_user_count+") update is failed");
			et.log(LogStatus.FAIL, "Referral User("+invited_user_count+") count update is failed, Test Failed");
			Fail_Count = Fail_Count+1;
			
		}
		
	}catch(Exception exp)
		{
			System.err.println("Test Interrupted at Verify_FirstInvite_Count() method and error is-->"+exp);
		}
	}
	
	public static void verify_Invited_Neigh_Earned_Count(int invited_user_count)
	{	
		
	try
	{
		Wait.wait10Second();
		int Subscribed_Earned_Count=Integer.parseInt(driver.findElement(By.xpath("(//div[@class='col p-5']/div/h4/span)[4]")).getText().substring(0, 1));
		
		//System.out.println(Subscribed_Earned_Count);
		//int Sent_Invite_Count=Integer.parseInt(driver.findElement(By.xpath("(//div[@class='col p-5']/div/h4/span)[2]")).getText().substring(0, 1));
		
		if(Subscribed_Earned_Count==1)
		{
			System.err.println("Subscribed Neighbor's Earned count ("+Subscribed_Earned_Count+")updated successfully");
			et.log(LogStatus.PASS, "Subscribed Neighbor's Earned count ("+Subscribed_Earned_Count+")updated successfully, Test Passed");
			Pass_Count++;
		}
		else
		{
			System.err.println("Subscribed Neighbor's Earned count ("+Subscribed_Earned_Count+") update is failed");
			et.log(LogStatus.FAIL, "Subscribed Neighbor's Earned count ("+Subscribed_Earned_Count+") update is failed, Test Failed");
			Fail_Count = Fail_Count+1;
			
		}
		
	}catch(Exception exp)
		{
			System.out.println("Test Interrupted at Verify_Invited Neighbor_Count() method and error is-->"+exp);
			
		}
	}
	
	
	public void gmail_Login_And_VerifyInvite_Mail(String uname,String pwd) throws InterruptedException
	{

		String invite_mail_header="You have been invited to join Lapalopa.";
		driver.findElement(By.cssSelector("input#identifierId")).sendKeys(uname, Keys.ENTER);
		Wait.wait5Second();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd, Keys.ENTER);
		Wait.wait5Second();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(invite_mail_header.substring(0, 21),Keys.ENTER);
		Wait.wait5Second();
		driver.findElement(By.xpath("//table[@class='F cf zt']/tbody/tr[1]/td[6]/div/div/div[2]/span/span")).click();
		
		
		String act_invite_header=driver.findElement(By.xpath("//table[@role='presentation']/tr/td/div/div/div[2]/div/h2")).getText();
		if(invite_mail_header.equalsIgnoreCase(act_invite_header))
		{
			System.out.println("Invite Email received successfully, Test Passed");
			et.log(LogStatus.PASS, "Invite Email received successfully, Test Passed");
			Pass_Count++;
		}
		else
		{
			System.out.println("Invite Email NOT received, Test Failed");
			et.log(LogStatus.FAIL, "Invite Email NOT received, Test Failed");
			Fail_Count = Fail_Count+1;
		}
		
	}
	
	public void gmail_Login(String uname, String pwd) throws InterruptedException
	{
		driver.findElement(By.cssSelector("input#identifierId")).sendKeys(uname, Keys.ENTER);
		Wait.wait5Second();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd, Keys.ENTER);
		Wait.wait5Second();
		
	}
	
	public int getMobileNumber()
	{
		Random rn=new Random();
		int mobile=1000000000+rn.nextInt(1000000000);
		return mobile;
		
	}
	
	
	


}
