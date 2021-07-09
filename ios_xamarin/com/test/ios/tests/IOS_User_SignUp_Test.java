package com.test.ios.tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;

public class IOS_User_SignUp_Test {
	
	@Test
	public void UserRegTest() throws Exception
	{
		  DesiredCapabilities dc;
		  IOSDriver<WebElement> driver;
		
		System.out.println(" TEST STARTED ");
	
		
			
			dc=new DesiredCapabilities();
			dc.setCapability("deviceName", "iPhone 7");
			dc.setCapability("platformVersion", "12.1.2");
			dc.setCapability("platformName", "iOS");
			
			dc.setCapability("noReset", "true");
			dc.setCapability("bundleId", "com.lapalopa.app");
			dc.setCapability("automationName", "XCUITest");
			dc.setCapability("app", "/Users/macpro/Desktop/LapaLopa.App.iOS.ipa");
			
			//ed2040031f98c61aee80d7808dfb4963e9b75117
			
			
			dc.setCapability("udid", "ed2040031f98c61aee80d7808dfb4963e9b75117");
			
			System.out.println("** Connecting to IOS REAL DEVICE ***");
			driver = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc); 
			Thread.sleep(10000);
		
			/**
			 * @@ WRITE SCRIPT HERE
			 */
			driver.findElementByName("Register").click();
			Thread.sleep(12000);
			System.out.println("Register button Click perform");
		
			//Name
			driver.findElement(By.xpath("//*[@value='Name']")).click();
			driver.hideKeyboard();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@value='Name']")).sendKeys("Rajesh");
			Thread.sleep(1000);

			
			
			
			driver.findElement(By.xpath("//*[@value='Email']")).click();
			driver.hideKeyboard();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@value='Email']")).sendKeys("automationtest8301996@gmail.com");
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//*[@value='Password']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@value='Password']")).sendKeys("welcomeuser1");
			Thread.sleep(2000);
			
			driver.findElementByAccessibilityId("Sign Up Now").click();
			Thread.sleep(10000);
			System.out.println("Sign Up Now is clicked");
			try {
			driver.findElement(By.xpath("//XCUIElementTypeTextField[@value='Zipcode - Where you live']")).sendKeys("20003");
			Thread.sleep(1000);
			}catch (Exception e) {
				System.out.println("Above xpath not working");
				driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"LapaLopa\"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField")).sendKeys("20003");
				System.out.println("Working xpath");
			}
			driver.hideKeyboard();
			System.out.println("Enter next");
			Thread.sleep(2000);
			driver.findElementByName("Next").click();
			Thread.sleep(8000);
		
			try {
			if(driver.findElement(By.name("Go Back")).isDisplayed())
			{
				System.out.println(" Verify Email link displayed test passed");
			}
			}catch (Exception e) {
				System.out.println("Expected emaill verification text is not displayed");
			}
			Thread.sleep(5000);	
			driver.close();
		System.out.println("App closed");

		
	}

}
