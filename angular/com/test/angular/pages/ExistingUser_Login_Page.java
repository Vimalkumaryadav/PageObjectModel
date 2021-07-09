package com.test.angular.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.Wait;
import static com.test.angular.hooks.Wait.*;
import com.test.angular.excel.Excel_Read;

public class ExistingUser_Login_Page extends Hooks {
	public WebDriver driver = null;

	public ExistingUser_Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement Username;

	@FindBy(id = "usernamecleaner")
	WebElement cleanerUsername;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(id = "passwordcleaner")
	WebElement cleanerPassword;

	@FindBy(xpath = "//button[text()='Sign In Now']")
	WebElement SignInButton;

	@FindBy(xpath = "//div[@id='cleaner_body'] //button[text()='Sign In Now']")
	WebElement cleanerSignInButton;

	@FindBy(xpath = "//u[text()='Explore Profile']")
	WebElement Profile;

	@FindBy(id = "firstName")
	WebElement FIrstName;

	@FindBy(id = "lasttName")
	WebElement LastName;

	@FindBy(id = "email")
	WebElement EmailVerify;

	@FindBy(xpath = "(//a[text()='Forgot Password?'])[1]")
	WebElement ForgetPassword;

	@FindBy(id = "EmailOrMobileNumber")
	WebElement EmailorMobileNumber;

	@FindBy(xpath = "//h3[text()='Passwords, we understand.']")
	WebElement ForgetPasswordText;

	@FindBy(xpath = "(//button[text()='Next'])[1]")
	WebElement NextButton;

	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	WebElement ResetPassword;

	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPassword;

	@FindBy(xpath = "//button[text()='Reset']")
	WebElement ResetButton;

	@FindBy(xpath = "//h3[text()='Your password has been reset.']")
	WebElement PasswordReset;

	@FindBy(xpath = "//a[text()='Click here to Sign In']")
	WebElement ResetLogin;

	@FindBy(xpath = "//div[contains(text(),'Profile & Account')]")
	WebElement ProfileAndAccount;

	@FindBy(css = "button#cleaner1")
	WebElement beACleanerButton;
	
	@FindBy(css = "button#neighbor1")
	WebElement beANeighborButton;
	

	public void SignInAsNeighbor() throws InterruptedException {

		beANeighborButton.click();
		wait5Second();
	}
	public void SignInAsCleaner() throws InterruptedException {

			beACleanerButton.click();
			wait5Second();
	}

	public void ForgetPassword() throws InterruptedException {
		ForgetPassword.click();
		EmailorMobileNumber.sendKeys(Excel_Read.Login_Username);
		NextButton.click();
		ForgetPasswordText.isDisplayed();
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	public void ResetPassword() throws InterruptedException {
		Wait.wait5Second();
		ResetPassword.sendKeys(Excel_Read.Login_Password);
		ConfirmPassword.sendKeys(Excel_Read.Login_Password);
		ResetButton.click();
		Wait.wait2Second();
		PasswordReset.isDisplayed();
		ResetLogin.click();
		Wait.wait5Second();
	}

	public void EnterNeighborUsernameAndPassword() throws InterruptedException {
		fluentWait(Username);
		Username.sendKeys(Excel_Read.Login_Username);
		Password.sendKeys(Excel_Read.Login_Password, Keys.ENTER);
	}

	public void EnterCleanerUsernameAndPassword() throws InterruptedException {
		fluentWait(cleanerUsername);
		cleanerUsername.sendKeys(Excel_Read.Login_Username);
		cleanerPassword.sendKeys(Excel_Read.Login_Password);
		Wait.wait3Second();
		cleanerSignInButton.click();

	}

	public void VerifyProfile() throws InterruptedException {
		Wait.wait5Second();
		try {
			Profile.click();
			System.out.println("Profile Veirifed");

		} catch (Exception e) {
			Neighbour_Dashboard_Page np = new Neighbour_Dashboard_Page(driver);
			ProfileAndAccount.click();
			np.overviewPage();
		}
		Wait.wait5Second();
	}

	public void VerifyDetails() throws InterruptedException {
		WebElement VerifyFirstName = driver.findElement(By.xpath("(//input[@id='firstName'])[3]"));
		String FirstName = VerifyFirstName.getText();
		Wait.wait2Second();

		WebElement VerifyLastName = driver.findElement(By.id("lasttName"));
		String LastName = VerifyLastName.getText();
		Wait.wait2Second();

		WebElement VerifyYourEmail = driver.findElement(By.xpath("//input[@id='email']"));
		String Email = VerifyYourEmail.getText();
		Wait.wait2Second();
		
		System.out.println(FirstName);
		
		System.out.println(LastName);
		
		System.out.println(Email);

		if (Excel_Read.Name.contains(FirstName) && (Excel_Read.Name.contains(LastName))
				&& (Excel_Read.Login_Username.contains(Email))) {
			System.out.println("Profile details verified succuessfully");
			et.log(LogStatus.PASS, "Profile details verified succuessfully");
		} else {
			System.out.println("Profile details verification Test Failed");
			et.log(LogStatus.FAIL, "Profile details verification Test Failed");
		}
	}
}
