package com.test.angular.pages;

import static java.lang.System.err;

import static java.lang.System.out;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sound.midi.SysexMessage;

import org.apache.xpath.functions.FuncStringLength;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.excel.Excel_Read;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.StageDB;

import static com.test.angular.hooks.Hooks.driver;
import static com.test.angular.hooks.StageDB.st;

import com.test.angular.hooks.Wait;

import static com.test.angular.excel.Excel_Read.Login_Username;
import static com.test.angular.hooks.Wait.*;

public class CompanyUsers_Signup_Page extends Hooks {
	public WebDriver driver = null;
	public static StageDB stgdb = new StageDB();

	public CompanyUsers_Signup_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Company Legal Name']")
	WebElement companyName;

	@FindBy(xpath = "//input[@placeholder='Company Legal Address']")
	WebElement companyAddress;

	@FindBy(xpath = "//input[@placeholder='Zipcode']")
	WebElement companyZip;

	@FindBy(xpath = "//input[@placeholder='Employer Identification Number (EIN)']")
	WebElement EIN;

	@FindBy(xpath = "//input[@placeholder='Full Name']")
	WebElement fullName;

	@FindBy(xpath = "//input[@placeholder='Mobile Number']")
	WebElement mobileNumber;

	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement email;

	@FindBy(xpath = "//label[@for='lapalopa-radio-email']")
	WebElement emailRadio;

	@FindBy(xpath = "//label[@for='lapalopa-radio-mobile']")
	WebElement mobileRadio;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-block']")
	WebElement submit;

	@FindBy(xpath = "//input[@placeholder='Search mail']")
	WebElement gmailSearch;

	@FindBy(xpath = "//table[@class='F cf zt']/tbody/tr[1]/td[6]/div/div/div[2]/span/span")
	WebElement companyMail;

	@FindBy(xpath = "//table[@role='presentation'] //h2[@tabindex]")
	WebElement companyMailHeader;

	@FindBy(xpath = "//div[@class='adn ads'] //a[contains(@href,'http')]")
	WebElement companyRegisterLink;

	@FindBy(css = "input#ZipCode")
	WebElement zipCode;

	@FindBy(xpath = "//div[@class='col-10 m-auto'] //button[text()='Next']")
	WebElement nextZipCode;

	@FindBy(linkText = "Go Back")
	WebElement goBackLink;

	@FindBy(xpath = "(//label[@for='radio2'])[2]")
	WebElement COwnerRadio;

	@FindBy(xpath = "(//label[@for='radio3'])[2]")
	WebElement CEmpRadio;

	@FindBy(xpath = "(//label[@for='radio1'])[2]")
	WebElement indVendorRadio;

	@FindBy(css = "a.vc_btn3-color-grey")
	WebElement companySubmit;

	@FindBy(xpath = "//body[@class='bodyinbox']/div/div[7]/div/a/span/following-sibling::span")
	WebElement companyYopmail;

	@FindBy(css = "div.row.ml-5 div.mat-checkbox-inner-container-no-side-margin")
	WebElement serviceProviderAgreementCheckbox;

	@FindBy(css = "button.btn.btn-primary.float-right")
	WebElement IAgreebutton;

	@FindBy(css = "div.px-0.pending div.card-header")
	WebElement companyConfirmationsection;

	/**
	 * Company Users Invite Properties
	 **/

	@FindBy(xpath = "//button[text()='Invite Cleaners']")
	WebElement inviteCleanersButton;

	@FindBy(xpath = "//input[@formcontrolname='name1']")
	WebElement Name;

	@FindBy(xpath = "//input[@formcontrolname='mobileNumber1']")
	WebElement Mobile;

	@FindBy(xpath = "//input[@formcontrolname='email1']")
	WebElement Email;

	@FindBy(xpath = "(//div[contains(@class,'radio-primary')])[1]")
	WebElement adminRadio;

	@FindBy(xpath = "(//div[contains(@class,'radio-primary')])[2]")
	WebElement schedularRadio;

	@FindBy(xpath = "(//div[contains(@class,'radio-primary')])[3]")
	WebElement cleanerRadio;

	@FindBy(css = ".cursor_pointer")
	WebElement trashIcon;

	@FindBy(xpath = "//button[text()='Send Invites']")
	WebElement inviteButton;

	@FindBy(css = ".text-danger.pt-2")
	WebElement existEmailValidation;

	/**
	 * Company User Registration Properties
	 *
	 **/
	@FindBy(id = ("FulName"))
	WebElement registerName;

	@FindBy(id = ("Email"))
	WebElement registerEmail;

	@FindBy(id = ("Password"))
	WebElement registerPassword;

	@FindBy(xpath = "//button[text()='Sign Up Now']")
	WebElement SignUpButton;

	@FindBy(id = "ZipCode")
	WebElement ZipCode;

	/**
	 * 
	 * Company Users Signin
	 */

	@FindBy(id = "username")
	WebElement Username;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(xpath = "//button[text()='Sign In Now']")
	WebElement SignInButton;

	public void company_Register() throws InterruptedException {

		/*************** Entering company info *************/

		companyName.sendKeys(Excel_Read.Company_Name);
		companyAddress.sendKeys(Excel_Read.Cleaning_address);
		wait5Second();
		// Actions ao=new Actions(driver);
		// ao.moveToElement(driver.findElement(By.xpath("//li[@class='pb-2']"))).click().build().perform();
		companyZip.sendKeys(Excel_Read.ZipCode);
		EIN.sendKeys(Excel_Read.EIN);

		/*************** Entering company owner personal info *************/
		fullName.sendKeys(Excel_Read.Login_Username);

		/*************** Random Mobile# Generation **********************/
		Random rn = new Random();
		int num = 1000000000 + rn.nextInt(1000000000);
		Integer obj = new Integer(num);
		String USNumber = obj.toString();
		mobileNumber.sendKeys(USNumber);
		email.sendKeys(Excel_Read.Login_Username);

		if (!(emailRadio.isSelected() || mobileRadio.isSelected())) {
			emailRadio.click();
		} else {
			et.log(LogStatus.FAIL, "Radio opiton is already selected");
			System.err.println("Radio option is already selected");
		}

		wait2Second();
		submit.click();
		wait10Second();
	}

	public void verifyCompanyEmail() throws InterruptedException {
		wait25Second();
		String companyMailtext = "Cleaning Company Registration";
		wait5Second();
		gmailSearch.sendKeys("Company Registration", Keys.ENTER);
		wait5Second();
		boolean res = companyMail.getText().contains(companyMailtext);
		Assert.assertTrue(res, "Company Owner Registraion mail not received");
		et.log(LogStatus.PASS, "Company Owner Registration mail received successully");
		System.out.println("Company Owner Registration mail received successully");
		companyMail.click();
		Wait.wait5Second();
		companyRegisterLink.click();
	}

	public void enterZipCode() throws InterruptedException {
		fluentWait(nextZipCode);
		zipCode.sendKeys(Excel_Read.ZipCode);
		nextZipCode.click();
		et.log(LogStatus.PASS, "Company user Singed up successfully");
		out.println("Company user Singed up successfully");
	}

	public void verifyCompanyUserYopmail(String email) throws InterruptedException {

		wait10Second();
		String companyMainSub = null;
		int time = 0, count = 0;
		driver.get("http://www.yopmail.com/en/");
		driver.findElement(By.cssSelector("input#login")).clear();

		driver.findElement(By.cssSelector("input#login")).sendKeys(email);
		driver.findElement(By.cssSelector("input.sbut")).click();
		Wait.wait5Second();

		while (time <= 12) {

			driver.switchTo().frame(driver.findElement(By.cssSelector("#ifinbox")));
			List<WebElement> list = driver
					.findElements(By.xpath("//body[@class='bodyinbox']/div/div[7]/div/a/span/following-sibling::span"));
			// System.out.println(list.size());

			if (list.size() > 0) {
				companyMainSub = companyYopmail.getText();

				driver.switchTo().defaultContent();
				driver.findElement(By.cssSelector(".slientext")).click();
				wait5Second();
				break;
			} else {
				driver.switchTo().defaultContent();
				driver.findElement(By.cssSelector(".slientext")).click();
				wait5Second();
				time++;
			}
		}

		Assert.assertTrue(companyMainSub != null, "Company Email not recieved Test failed");
		if (companyMainSub.contains("Cleaning Company Registration")) {
			out.println("Company mail received successfully");
			et.log(LogStatus.PASS, "Company mail received successfully, Test Passed");
		}

		driver.switchTo().frame(driver.findElement(By.cssSelector("#ifmail")));
		fluentWait(driver.findElement(By.xpath("//div[@id='mailmillieu']/div[2]/p[3]/a")));

		driver.findElement(By.xpath("//div[@id='mailmillieu']/div[2]/p[3]/a")).click();
		et.log(LogStatus.PASS, "Company Registration mail verifed successully");
		out.println("Company Registration mail verifed successully");
	}

	public void cuserSignup() throws Exception {
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		// System.out.println("Total windows:"+tabs.size());
		driver.switchTo().window(tabs.get(1));
		fluentWait(driver.findElement(By.id("FulName")));
		driver.findElement(By.id("FulName")).clear();
		driver.findElement(By.id("Email")).clear();
		Register_Page rp = new Register_Page(driver);
		rp.enterRegisterDetails();
		enterZipCode();

	}

	public boolean verifyCompanyOwnerRole() throws InterruptedException {
		wait15Second();

		Screen sr = new Screen();

		Match mr = sr.exists("./TestData/Company_Owner_Role.png");

		if (mr != null) {
			et.log(LogStatus.PASS, "Company Owner Role verified successully");
			System.out.println("Company Owner Role verified successully");
			return true;
		} else {
			et.log(LogStatus.FAIL, "Company owner role vefication failed");
			return false;
		}

	}

	public boolean verifyCompanyAdminRole() throws InterruptedException {
		wait15Second();
		Screen sr = new Screen();
		Match mr = sr.exists("./TestData/CompanyUserRole.png");

		if (mr != null) {
			et.log(LogStatus.PASS, "Company Admin Role verified successully");
			System.out.println("Company Admin Role verified successully");
			return true;
		} else {
			et.log(LogStatus.FAIL, "Company Admin role vefication failed");
			return false;
		}

	}

	public void updateCompanyOwnerDBDetails() throws SQLException, InterruptedException {
		StageDB stgdb = new StageDB();
		stgdb.vendorDBUpdates(StageDB.st, Login_Username);

	}

	public void ownerSetupPage() throws InterruptedException, SQLException {
		Actions ao = new Actions(driver);
		driver.navigate().refresh();
		wait10Second();
		driver.findElement(By.cssSelector("div.col-2.text-right.my-2")).click();
		wait5Second();
		WebElement scroll = driver.findElement(By.cssSelector("p.mt-5.p-3"));

		ao.moveToElement(scroll, 400, 30).click().build().perform();

		for (int i = 1; i <= 20; i++) {
			ao.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).build().perform();
		}
		Wait.wait2Second();

		if (!serviceProviderAgreementCheckbox.isSelected()) {
			serviceProviderAgreementCheckbox.click();
			et.log(LogStatus.PASS, "Service Provider Agreement checkbox validation passed");

		} else {
			et.log(LogStatus.FAIL, "Service Provider Agreement checkbox validation failed");
			System.err.println("Service Provider Agreement checkbox validation failed");
		}
		IAgreebutton.click();
		fluentWait(companyConfirmationsection);

		if (companyConfirmationsection.getText().contains("Lapa Lopa Confirmation")) {
			et.log(LogStatus.PASS, "Company Onwer succussfuly aggreed for the Service Provider Agreement");
			System.out.println("Company Onwer succussfuly aggreed for the Service Provider Agreement");
		} else {
			et.log(LogStatus.FAIL, "After Service Provider Agreement Owner navigated to wrong page");
			System.err.println("After Service Provider Agreement Owner navigated to wrong page");
		}

		stgdb.companyStatusUpdate(st, Login_Username);
		driver.navigate().refresh();
	}

	public void validateOwnerDashboard() throws InterruptedException {
		wait10Second();
		if (driver.getCurrentUrl().contains("companyDashboard")) {
			et.log(LogStatus.PASS, "Company Owner successfully reigstered and navigated to Dashboard");
			System.out.println("Company Owner successfully reigstered and navigated to Dashboard");
		} else {
			et.log(LogStatus.FAIL, "Company Owner navigated to wrong Dashboard");
			System.err.println("Company Owner navigated to wrong Dashboard");
		}

		inviteCleanersButton.click();
		// wait5Second();
		Wait.expWait(driver, By.cssSelector(".cursor_pointer"), 20);
		trashIcon.click();
	}

	public void inviteAdminUser() throws InterruptedException {

		try {

			Name.sendKeys(Excel_Read.Name + "Admin");
			Mobile.sendKeys(String.valueOf(getMobileNumber()));
			Email.sendKeys(Excel_Read.adminEmail);
			Wait.fluentWait(adminRadio);
			adminRadio.click();
			inviteButton.click();
			wait10Second();
			if (driver.findElements(By.cssSelector(".text-danger.pt-2")).size() != 0) {
				System.err.println("Admin Email already exists");
			} else {
				System.out.println("Admin invited successfully");
			}
		} catch (Throwable th) {
			th.printStackTrace();
		}

	}

	public void inviteSchedularUser() throws InterruptedException {

		try {
			Name.clear();
			Name.sendKeys(Excel_Read.Name + "Schedular");
			Mobile.clear();
			Mobile.sendKeys(String.valueOf(getMobileNumber()));
			Email.clear();
			Email.sendKeys(Excel_Read.schedularEmail);
			Wait.fluentWait(schedularRadio);
			schedularRadio.click();
			inviteButton.click();
			wait10Second();
			if (driver.findElements(By.cssSelector(".text-danger.pt-2")).size() != 0) {
				System.err.println("Schedular Email already exists");
			} else {
				System.out.println("Schedular invited successfully");
			}
		} catch (Throwable th) {
			th.printStackTrace();

		}

	}

	public void inviteCleanerUser() throws InterruptedException {

		try {
			Name.clear();
			Name.sendKeys(Excel_Read.Name + "Cleaner");
			Mobile.clear();
			Mobile.sendKeys(String.valueOf(getMobileNumber()));
			Email.clear();
			Email.sendKeys(Excel_Read.cleanerEmail);
			Wait.fluentWait(cleanerRadio);
			cleanerRadio.click();
			inviteButton.click();
			wait10Second();
			if (driver.findElements(By.cssSelector(".text-danger.pt-2")).size() != 0) {
				System.err.println("Cleaner Email already exists");
			} else {
				System.out.println("Cleaner invited successfully");
			}
		} catch (Throwable th) {
			th.printStackTrace();
		}

	}

	public void enterAdminRegisterDetails() throws Exception {
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		// System.out.println("Total windows:"+tabs.size());
		driver.switchTo().window(tabs.get(1));
		fluentWait(driver.findElement(By.id("FulName")));
		driver.findElement(By.id("FulName")).clear();
		driver.findElement(By.id("Email")).clear();
		registerName.sendKeys(Excel_Read.Name + "Admin");
		registerEmail.sendKeys(Excel_Read.adminEmail);
		registerPassword.sendKeys(Excel_Read.Login_Password);
		SignUpButton.click();
		Wait.wait3Second();
		enterZipCode();
	}

	public void enterSchedularRegisterDetails() throws Exception {
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		// System.out.println("Total windows:"+tabs.size());
		driver.switchTo().window(tabs.get(1));
		fluentWait(driver.findElement(By.id("FulName")));
		driver.findElement(By.id("FulName")).clear();
		driver.findElement(By.id("Email")).clear();
		registerName.sendKeys(Excel_Read.Name + "Schedular");
		registerEmail.sendKeys(Excel_Read.schedularEmail);
		registerPassword.sendKeys(Excel_Read.Login_Password);
		SignUpButton.click();
		Wait.wait3Second();
		enterZipCode();
	}

	public void enterCleanerRegisterDetails() throws Exception {
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		// System.out.println("Total windows:"+tabs.size());
		driver.switchTo().window(tabs.get(1));
		fluentWait(driver.findElement(By.id("FulName")));
		driver.findElement(By.id("FulName")).clear();
		driver.findElement(By.id("Email")).clear();
		registerName.sendKeys(Excel_Read.Name + "Cleaner");
		registerEmail.sendKeys(Excel_Read.cleanerEmail);
		registerPassword.sendKeys(Excel_Read.Login_Password);
		SignUpButton.click();
		Wait.wait3Second();
		enterZipCode();
	}

	public void companyUserLogin(String username, String pass) throws InterruptedException {
		fluentWait(SignInButton);
		Username.sendKeys(username);
		Password.sendKeys(pass, Keys.ENTER);
	}

	public void validateAdminDashboard() throws InterruptedException {
		driver.navigate().refresh();
		wait10Second();
		if (driver.getCurrentUrl().contains("companyDashboard")) {
			et.log(LogStatus.PASS, "Company Admin successfully reigstered and navigated to Dashboard");
			System.out.println("Company Admin successfully reigstered and navigated to Dashboard");
		} else {
			et.log(LogStatus.FAIL, "Company Admin navigated to wrong Dashboard");
			System.err.println("Company Admin navigated to wrong Dashboard");
		}

	}

	public void validateSchedularDashboard() throws InterruptedException {
		driver.navigate().refresh();
		wait10Second();
		if (driver.getCurrentUrl().contains("companyDashboard")) {
			et.log(LogStatus.PASS, "Company Schedular successfully reigstered and navigated to Dashboard");
			System.out.println("Company Schedular successfully reigstered and navigated to Dashboard");
		} else {
			et.log(LogStatus.FAIL, "Company Schedular navigated to wrong Dashboard");
			System.err.println("Company Schedular navigated to wrong Dashboard");
		}

	}

	public void validateCleanerDashboard() throws InterruptedException {
		driver.navigate().refresh();
		wait10Second();
		if (driver.getCurrentUrl().contains("vendorDashboard")) {
			et.log(LogStatus.PASS, "Company Cleaenr successfully reigstered and navigated to Dashboard");
			System.out.println("Company Cleaner successfully reigstered and navigated to Dashboard");
		} else {
			et.log(LogStatus.FAIL, "Company Cleaner navigated to wrong Dashboard");
			System.err.println("Company Cleaner navigated to wrong Dashboard");
		}

	}

}
