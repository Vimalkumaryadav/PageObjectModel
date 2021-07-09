package com.test.ios.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.test.mobile.hooks.App_Config;

import io.appium.java_client.ios.IOSDriver;

public class IOS_Mail_Verify_Test 
{
	public static DesiredCapabilities dc;
	public static IOSDriver<WebElement> driver;
	@Test
	public void VerifyEmail() throws Exception
	{

		System.out.println("TEST STARTED");
		

		System.out.println("LAUNCHING CHROME BROWSER ON MOBILE");
		

		dc=new DesiredCapabilities();
		dc.setCapability("app", "com.google.chrome.ios");
		dc.setCapability("deviceName", "iPhone 7");
		dc.setCapability("platformVersion", "12.1.2");
		dc.setCapability("platformName", "iOS");
		dc.setCapability("noReset", "true");
		dc.setCapability("udid", "ed2040031f98c61aee80d7808dfb4963e9b75117");
		dc.setCapability("browserName", "Chrome");
		//dc.setCapability("autoWebview", "true");
		System.out.println("** Connecting to Browser on IOS REAL DEVICE ***");
		Thread.sleep(8000);
		//System.setProperty("webdriver.chrome.driver",
				//"/Users/macpro/Documents/Automation_Workspace/Lapa_Lopa_POM_Framework/chromedriver");
		Thread.sleep(5000);

		try {
				driver = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		} catch (MalformedURLException e) 
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Till here fine");
						
					//Open URL in Chrome Browser
					Thread.sleep(2000);
					driver.get("https://mail.google.com");
					Thread.sleep(6000);
					System.out.println("Gmail login page opened");
					Thread.sleep(2000);
				
					

					//Switching to web view
					Set<String> ContextHandles = driver.getContextHandles();
					
					for (String s : ContextHandles) 
					{
					    System.out.println("Context name "+s); 
					    if(s.contains("WEBVIEW"))
					    {
					    	driver.context(s);
					    	System.out.println("Context name inside Loop "+s); 
					    }
					    
					}
					
					
					//driver.context("NATIVE_APP");
					 

					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@value='Email or phone']")).sendKeys("automationtest8301996@gmail.com",Keys.ENTER);
					
					/*try { identifierId
					driver.findElement(By.xpath("//*[@value='Email or phone']")).click();
					driver.findElement(By.xpath("//*[@value='Email or phone']")).sendKeys("automationtest8301996@gmail.com",Keys.ENTER);
					System.out.println("Worked here");
					}catch (Exception e) 
					{System.out.println("Entered into Catch block");
						driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Sign in - Google Accounts\"]/XCUIElementTypeTextField")).sendKeys("automationtest8301996@gmail.com",Keys.ENTER);
						System.out.println("Catch worked");
					}*/
					Thread.sleep(3500);
					driver.findElement(By.name("password")).sendKeys(App_Config.Gmail_password,Keys.ENTER);
					Thread.sleep(15000);
					System.out.println("Page loaded");
					driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys("lapalopa",Keys.ENTER);
					Thread.sleep(3500);
					driver.findElement(By.xpath("(//div[@role='listitem'])[1]")).click();
					Thread.sleep(3500);
					driver.findElement(By.xpath("(//a[contains(text(),'here')])[1]")).click();
					Thread.sleep(8000);
					System.out.println("Gmail logged in and clicks on verification link");
					
					
					
					
					
					driver.quit();
					System.out.println("Closing browser");
					
				
		System.out.println("TEST ENDED");
		


	}

}
