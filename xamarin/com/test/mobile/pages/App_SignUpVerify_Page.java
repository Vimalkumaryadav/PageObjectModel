package com.test.mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.mobile.excel.App_Excel_Read;
import com.test.mobile.hooks.App_Config;

public class App_SignUpVerify_Page 
{
	public WebDriver driver;

	public App_SignUpVerify_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="identifierId")
	WebElement EmailId;
	
	@FindBy(name="password")
	WebElement Password;
	

	
	@FindBy(xpath="//*[@placeholder='Search']")
	WebElement Search;
	
	
	@FindBy(xpath="(//div[@role='listitem'])[1]")
	WebElement FirstResultInbox;


	@FindBy(xpath="(//a[contains(text(),'here')])[1]")
	WebElement ConfirmationLink;
	
	public void GmailLoginPage() throws Exception
	{
		EmailId.sendKeys(App_Excel_Read.Login_Username,Keys.ENTER);
		Thread.sleep(3500);
		Password.sendKeys(App_Excel_Read.Login_Password,Keys.ENTER);
		Thread.sleep(15000);
		System.out.println("Page loaded");
		Search.sendKeys("lapalopa",Keys.ENTER);
		Thread.sleep(3500);
		FirstResultInbox.click();
		Thread.sleep(3500);
		ConfirmationLink.click();
		Thread.sleep(6000);
		driver.quit();
	}  
	            

}
