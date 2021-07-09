package com.test.angular.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Act {

	public static void main(String[] args) 
	{   
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://partnerportal.actcorp.in/login");
        
        WebElement username=driver.findElement(By.xpath("//div[@class='limiter']//div[2]"));
        
        Actions actions = new Actions(driver);
        actions.moveToElement(username);
        actions.click();
        actions.sendKeys("SOME DATA");
        actions.build().perform();
	}

}
