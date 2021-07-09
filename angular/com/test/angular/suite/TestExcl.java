package com.test.angular.suite;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.mobile.excel.App_Excel_Read;

public class TestExcl extends Hooks
{
	@Test
	public void testInd() throws Exception
	{
		for(int i=Config.Start_Row_Number; i<=Config.End_Row_Number;i++)
		{
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(Config.URL);
		Thread.sleep(2500);
		App_Excel_Read.read(i);
		System.out.println(""+ App_Excel_Read.Name +"" + App_Excel_Read.BathroomCount+"");
		driver.quit();
		}
	}
	@AfterTest
	public void ind()
	{		
		System.out.println("Ended ");
	}
}
