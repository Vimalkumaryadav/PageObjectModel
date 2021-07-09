package com.test.angular.suite;

import java.util.ArrayList;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.test.angular.excel.Excel_Read;
import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.StageDB;
import com.test.angular.hooks.Wait;

public class Yopmail_Signup extends Hooks {
	@Test
	public void UserRegistration() throws Exception {
		/**
		 * @@ Writing for loop to read multiple sets of input data from Excel Sheet
		 */
		for (int i = Config.Start_Row_Number; i <= Config.End_Row_Number; i++) {
			Excel_Read.read(i);
			options.addArguments("-start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("disable-extension");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver(options);

			/*********** LapaLopa WEBSITE **********/

			driver.get("https://appstg.lapalopa.com");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//button[text()='Register'])[2]")).click();

			/********* USER REGISTRATION **********/

			Wait.wait5Second();
			driver.findElement(By.id("FulName")).sendKeys(Excel_Read.Name);
			driver.findElement(By.id("Email")).sendKeys(Excel_Read.Login_Username);
			driver.findElement(By.id("Password")).sendKeys(Excel_Read.Login_Password);
			driver.findElement(By.xpath("//button[text()='Sign Up Now']")).click();
			Wait.fluentWait(driver.findElement(By.id("ZipCode")));
			driver.findElement(By.id("ZipCode")).sendKeys(Excel_Read.ZipCode);
			driver.findElement(By.xpath("(//button[text()='Next'])[1]")).click();
			Wait.wait5Second();

			/********** NEXT TAB **********/
			if (!(Excel_Read.Login_Username.contains("@lapalopa.com"))) {
				((JavascriptExecutor) driver).executeScript("window.open()");

				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

				driver.switchTo().window(tabs.get(1));

				/********** YOP MAIL **********/

				driver.get("http://www.yopmail.com/en/");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				driver.findElement(By.id("login")).sendKeys(Excel_Read.Login_Username, Keys.ENTER);
				Wait.fluentWait(driver.findElement(By.xpath("//span[@class='slientext']")));
				driver.findElement(By.xpath("//span[@class='slientext']")).click();
				Wait.wait8Second();
				WebElement FrameLocation = driver.findElement(By.xpath("//iframe[@name='ifmail']"));
				driver.switchTo().frame(FrameLocation);
				System.out.println("Entered into Frame");
				driver.findElement(By.xpath("//a[contains(text(),'here')]")).click();
				driver.switchTo().window(tabs.get(1));
				Wait.wait8Second();
				driver.switchTo().defaultContent();
				Wait.wait8Second();
			} else {
				StageDB st = new StageDB();
				st.connectToDB();
				st.confirmEmail();
			}
			Hooks.EndTest();

		}

	}
}