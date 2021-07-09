package com.test.angular.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VendorDashboard_Page {
	
	public WebDriver driver=null;
	
	public VendorDashboard_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	

}
