package com.test.angular.pages;

import java.util.ArrayList;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.angular.hooks.Wait;
import com.test.angular.excel.Excel_Read;

public class VerifyEmail_Page
{
	public WebDriver driver=null;

	public VerifyEmail_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="identifierId")
	WebElement EmailId;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(name="q")
	WebElement Search;
	
	@FindBy(xpath="//td[6]/div/div/div[2]/span/span")
	WebElement ConfirmationMail;

	@FindBy(linkText="here")
	WebElement ConfirmationLink;
	
	public void GmailLoginPage() throws Exception
	{
		EmailId.sendKeys(Excel_Read.Login_Username,Keys.ENTER);
		Wait.wait4Second();
		Password.sendKeys(Excel_Read.Email_Password,Keys.ENTER);
		Wait.wait5Second();
		Search.sendKeys("lapalopa",Keys.ENTER);
		Wait.wait5Second();
		ConfirmationMail.click();
		Wait.wait4Second();
		ConfirmationLink.click();
		try {
			driver.getTitle().compareToIgnoreCase("Lapa Lopa");
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(2)); 	
		}catch(Exception e){
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(3)); 
		}
		
		  
	}        
}

