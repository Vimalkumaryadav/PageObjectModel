package com.test.mobile.hooks;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;


public class App_Hooks 
{
	public static AndroidDriver driver=null;
	public static IOSDriver<WebElement> ios_driver;
	public static WebDriverWait ww;
	public static DateFormat format =new java.text.SimpleDateFormat("_yyyy-MMM-dd_h-mm");
	public static Date date=new Date();
	public static DesiredCapabilities dc;
	public static String Execution_Time =format.format(date);
	
	
	
	public static ExtentReports er=new ExtentReports(System.getProperty("user.dir")+"/Mobile_Test_Reports/Log_"+App_Hooks.Execution_Time+".html");
	public static ExtentTest et=er.startTest("Lapa-Lopa Xamarin Automation-Test Reports");

	
	public static int Pass_Count =0;
	public static int Fail_Count =0;
	
	public static void OpenApp() throws Exception
	{
		try {
			dc=new DesiredCapabilities();
			dc.setCapability("deviceName", "ae42f684");
			dc.setCapability("platformVersion", "7.1.1");
			dc.setCapability("platformName", "Android");
			System.out.println("** Connecting to ARD ***");
			dc.setCapability("noReset", "true");
			dc.setCapability("appPackage", "com.lapalopa.app");
			dc.setCapability("appActivity", "md5499dc9343f64085b0f2db4a798277ca5.MainActivity");
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),dc); 
			Thread.sleep(10000);
			et.log(LogStatus.INFO,"App is launched");
		}catch (Exception e) 
		{
			System.out.println("Error is ->" + e);
		}
	}


	public static void iOS_Device_OpenApp() throws Exception
	{
		try {
			
			dc=new DesiredCapabilities();
			dc.setCapability("deviceName", "iPhone 7");
			dc.setCapability("platformVersion", "12.1.2");
			dc.setCapability("platformName", "iOS");
			dc.setCapability("noReset", "true");
			dc.setCapability("bundleId", "com.lapalopa.app");
			dc.setCapability("automationName", "XCUITest");
			dc.setCapability("app", App_Config.IOS_IPA_FilePath);
			dc.setCapability("udid", App_Config.UDID_Iphone);
			dc.setCapability("unicodeKeyboard", true);
			
			System.out.println("** Connecting to IOS Real Device ***");
			ios_driver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),dc); 
			Thread.sleep(10000);
			et.log(LogStatus.INFO,"App is launched in IOS Mobile");
		}catch (Exception e) 
		{
			System.out.println("Error is ->" + e);
		}
	}
	
	public static void App_closeReports()
	{

		et.log(LogStatus.PASS,"TOTAL PASS COUNT -->" +Pass_Count);
		et.log(LogStatus.INFO,"TOTAL FAIL COUNT -->" +Fail_Count);
		
		er.flush();
		er.endTest(et);
	}
	
	public static void OpenBrowserInMobile() throws Exception
	{
		//Set the Desired Capabilities
		dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "ae42f684");
		dc.setCapability("platformVersion", "7.1.1");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset",true);
		dc.setCapability("browserName", "Chrome");
		System.out.println("** Connecting Browser on Mobile ***");
		
		//Set ChromeDriver location
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		Thread.sleep(5000);

		try 
		{
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		} 
		catch (MalformedURLException e) 
		{
			System.out.println(e.getMessage());
		}
						
		//Open URL in Chrome Browser
		driver.get("https://mail.google.com/mail/?tab=mm#inbox");
		Thread.sleep(8000);	
	}
	
	
	public static void DO_logout_App() throws Exception
	{
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Options']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
		Thread.sleep(3000);
		et.log(LogStatus.INFO, "User logout is Successfully Done");
	}
	public static void logout_IOS_App() throws Exception
	{	
		/**
		 * @Logout code here
		 */
		Thread.sleep(2000);
		/*try {
		ios_driver.findElement
		(By.xpath("//XCUIElementTypeNavigationBar[@name=\"Xamarin_Forms_Platform_iOS_NavigationRenderer_ParentingView\"]/XCUIElementTypeButton[2]")).click();
		Thread.sleep(2000);
		}catch (Exception e) {
			System.out.println("Unable to perform click on Logout menu");
		}*/
	}
	
	
	
	public static void CloseTest() throws InterruptedException
	{
		driver.closeApp();
		Thread.sleep(2000);
		et.log(LogStatus.INFO," App is closed, and Test reports are saved successfully ");
		er.flush();
		er.endTest(et);
	}

	public static void Close_IOS_Test() throws InterruptedException
	{
		Thread.sleep(2000);
		ios_driver.closeApp();
		Thread.sleep(2000);
		et.log(LogStatus.INFO," App is closed, and Test reports are saved successfully ");
		System.out.println("App closing  done");
	}
	
	
	public static void VerifyByElement(WebElement element, String SuccessMessage, String ErrorMessage)
	{
		try {
		if(element.isDisplayed())
		{
			et.log(LogStatus.PASS, SuccessMessage);
		}
		else
		{
			et.log(LogStatus.FAIL, ErrorMessage);
		}}catch (Exception Exception) {
			System.out.println("Test Interrupted, Error is -->" + Exception);
		}
	}

	public static void VerifyBy_Two_Element(WebElement element1, WebElement element2, String SuccessMessage, String ErrorMessage)
	{
		try {
		if(element1.isDisplayed() && element2.isDisplayed())
		{
			et.log(LogStatus.PASS, SuccessMessage);
		}
		else
		{
			et.log(LogStatus.FAIL, ErrorMessage);
		}}catch (Exception Exception) {
			System.out.println("Test Interrupted, Error is -->" + Exception);
		}
	}

}
