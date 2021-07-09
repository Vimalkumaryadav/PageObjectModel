package com.test.angular.hooks;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Wait extends Hooks
{
	public static WebDriverWait ww;
	
	public static void wait2Second() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	public static void wait3Second() throws InterruptedException {
		Thread.sleep(3000);
	}

	public static void wait4Second() throws InterruptedException {
		Thread.sleep(4000);
	}
	
	public static void wait5Second() throws InterruptedException {
		Thread.sleep(5000);
	}
	
	public static void wait8Second() throws InterruptedException {
		Thread.sleep(8000);
	}

	public static void wait10Second() throws InterruptedException {
		Thread.sleep(10000);
	}

	public static void wait15Second() throws InterruptedException {
		Thread.sleep(15000);
	}

	public static void wait25Second() throws InterruptedException {
		Thread.sleep(25000);
	}

	public static void wait40Second() throws InterruptedException {
		Thread.sleep(40000);
	}

	public static void wait1min() throws InterruptedException {
		Thread.sleep(60000);
	}

	public static void wait2min() throws InterruptedException {
		Thread.sleep(2000);
	}

	public static void wait12Second() throws InterruptedException {
		Thread.sleep(120000);
		
	}

	public static void wait14Second() throws Exception
	{
		Thread.sleep(140000);
		
	}
	
	public static void expWait(WebDriver driver, By Locator, int time_Seconds)
	{
		ww=new WebDriverWait(driver, time_Seconds);
		ww.until(ExpectedConditions.visibilityOfElementLocated(Locator));
		ww.until(ExpectedConditions.elementToBeClickable(Locator));
		
	}
	
	public static void fluentWait(WebElement element)
	{
	FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
			.withTimeout(30, TimeUnit.SECONDS)
			.pollingEvery(5,TimeUnit.SECONDS)
			.ignoring(NoSuchElementException.class,StaleElementReferenceException.class)
			.ignoring(ElementNotVisibleException.class)
			.ignoring(ElementNotSelectableException.class);
	
	Function< WebDriver, WebElement> function=new Function<WebDriver, WebElement>() 
	{
		public WebElement apply(WebDriver dirver) 
		{
		 					 
		  return element;
		}
	};
	wait.until(function);
	

	}
	
	public static void Fluentwait(By WebElement)
	{
		FluentWait<WebDriver>	waitfl = new FluentWait<WebDriver>(Hooks.driver);
		waitfl.withTimeout(30, TimeUnit.SECONDS);
		waitfl.pollingEvery(5, TimeUnit.SECONDS);
		waitfl.ignoring(NoSuchElementException.class);
		waitfl.ignoring(StaleElementReferenceException.class);
		waitfl.until(ExpectedConditions.elementToBeClickable(WebElement));
		waitfl.until(ExpectedConditions.presenceOfElementLocated(WebElement));
		waitfl.until(ExpectedConditions.visibilityOfElementLocated(WebElement));
		waitfl.until(new Function<WebDriver, WebElement>() 
		{
		public WebElement apply(WebDriver driver) {
		return driver.findElement(WebElement);}
		});
	}

}
