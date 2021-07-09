package com.test.angular.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.angular.hooks.Wait;

public class Neighbour_Dashboard_Skip_Page
{
	public WebDriver driver=null;

	public Neighbour_Dashboard_Skip_Page(WebDriver driver)
	{
	this.driver=driver;	
	PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//h1")
	WebElement YourCleaningsTitle;
	
	@FindBy(css="#desktopAdjustCleanings .col")
	WebElement AdjustCleaningsTab;
	
	@FindBy(xpath="//h1")
	WebElement AdjustCleaningTitle;
	
	@FindBy(xpath="(//button[text()='Skip'])[2]")
	WebElement SkipButton;
	
	@FindBy(xpath="//h1[text()='Skip Cleaning']")
	WebElement SkipCleaningTitle;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement SkipThisCleaningButton;
	
	public void SkipCleaning() throws InterruptedException
	{
		YourCleaningsTitle.isDisplayed();
		AdjustCleaningsTab.click();
		Wait.wait2Second();
		AdjustCleaningTitle.isDisplayed();
		SkipButton.click();
		Wait.wait2Second();
		SkipCleaningTitle.isDisplayed();
		SkipThisCleaningButton.click();
		Wait.wait2Second();
		AdjustCleaningTitle.isDisplayed();
		
		

	}
}
