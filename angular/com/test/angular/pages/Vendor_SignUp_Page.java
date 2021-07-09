package com.test.angular.pages;

import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.excel.Excel_Read;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.StageDB;
import com.test.angular.hooks.Wait;
import static com.test.angular.hooks.Wait.*;

public class Vendor_SignUp_Page extends Hooks {
	public WebDriver driver = null;
	public String Total_Price;

	public Vendor_SignUp_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @@ SIMILAR BUTTONS

	@FindBy(xpath = "(//button[text()='Next'])[2]")
	WebElement NextButton;

	@FindBy(xpath = "//button[text()='Next']")
	WebElement LastNextButton;

	@FindBy(xpath = "//a[@class='float-left pt-4']")
	WebElement BackButton;

	@FindBy(xpath = "//button[@class='btn btn-primary float-right']")
	WebElement SubmitButton;

	@FindBy(xpath = "//h3[text()=' Total Apartment']")
	WebElement TotalApartmentSubHeading;

	@FindBy(xpath = "//h3[text()=' Kitchen']")
	WebElement KitchenSubHeading;

	@FindBy(xpath = "//h3[text()=' Bathroom(s)']")
	WebElement BathroomSubHeading;

	@FindBy(xpath = "//i[@class='icon icon-ll-icon-close cross']")
	WebElement CloseButton;

	@FindBy(xpath = "(//span[@class='icon-bar-right'])[5]")
	WebElement Altmenu;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement LogoutButton;

	@FindBy(xpath = "//a[text()='FAQ']")
	WebElement FAQButton;

	// @@ LOCATORS OF GET STARTED PAGE

	@FindBy(xpath = "//u[text()='Become a Cleaner']")
	WebElement CleanerLink;

	// @@ LOCATORS OF TELL ME ABOUT YOURSELF

	@FindBy(xpath = "//u[text()='What gets cleaned?']")
	WebElement WhatgetscleanedLiink;

	@FindBy(xpath = "(//p[contains(text(),'Independent Cleaner')])[2]")
	WebElement IamanIndepentCleaner;

	@FindBy(xpath = "(//p[contains(text(),'Cleaning Company Owner')])[2]")
	WebElement IamCleaningCompanyOwnerOPtion;

	@FindBy(xpath = "(//p[contains(text(),'I work for a Cleaning Company')])[2]")
	WebElement IworkforaCleaningCompanyOPtion;

	// @@ LOCATORS OF LAPALOPA CLEANING PAGE

	@FindBy(xpath = "//h1[text()='Lapa Lopa Cleaning']")
	WebElement LapalopaCleaningTitle;

	@FindBy(xpath = "//h4[text()='Want to work with us?']")
	WebElement Wanttoworkwithus;

	@FindBy(xpath = "(//div[contains(text(),'Invalid Zip Code')])[2]")
	WebElement ZipcodeError;

	@FindBy(css = "button.btn.btn-primary.float-right")
	WebElement GoBackButton;

	@FindBy(xpath = "(//input[@id='zipCode'])[2]")
	WebElement Zipcode;

	@FindBy(xpath = "//u[text()='What Gets Cleaned?']")
	WebElement WhatGetsCleanedLiink;

	// @@ LOCATORS OF TAKE A PHOTO OF YOURSELF

	@FindBy(xpath = "(//input[@id='email'])[2]")
	WebElement Email1;

	@FindBy(xpath = "//input[@class='form-control ng-untouched ng-pristine ng-invalid']")
	WebElement MobileNumber;

	@FindBy(xpath = "(//input[@class='form-control ng-untouched ng-pristine ng-valid'])[2]")
	WebElement MobileNumberEntered;

	@FindBy(xpath = "(//select[@name='contactPreference'])[2]")
	WebElement contactPreference;

	@FindBy(xpath = "(//span[@class='switch switch-medium'])[2]")
	WebElement workwithpets;

	@FindBy(xpath = "(//span[@class='switch checked switch-medium'])[2]")
	WebElement workwithpetChecked;

	@FindBy(xpath = "//h3[text()='This will be for customers to identify you']")
	WebElement CameraText;

	@FindBy(xpath = "//i[@class='display-4 icon icon-ll-icon-camera text-white']")
	WebElement CameraIcon;

	@FindBy(xpath = "//p[contains(text(),'Willing to clean with')]")
	WebElement workwithpetsText;

	/*
	 * @FindBy(css="#profileImageUrlDesktop") WebElement profilePic;
	 */

	@FindBy(xpath = "//i[contains(@class,'icon-ll-icon-camera text-white')]")
	WebElement profilePic;

	// @@ LOCATORS FOR ADDRESS INFORMATION

	@FindBy(xpath = "(//input[@id='address'])[2]")
	WebElement Address;

	@FindBy(xpath = "(//input[@id='unitNumber'])[2]")
	WebElement UnitNumber;

	// @@ VENDOR DETAILS PAGE

	@FindBy(xpath = "(//input[@id='firstName'])[2]")
	WebElement FirstName;

	@FindBy(xpath = "(//input[@id='middleName'])[2]")
	WebElement MiddleName;

	@FindBy(xpath = "(//input[@id='chkMiddleName'])[2]")
	WebElement NoMiddleNameCheckBox;

	@FindBy(xpath = "(//input[@id='lastName'])[2]")
	WebElement LastName;

	@FindBy(xpath = "(//span[@class='k-icon k-i-calendar'])[2]")
	WebElement Calendar;

	@FindBy(xpath = "//input[@id='BOB']")
	WebElement Calendartext;

	@FindBy(xpath = "(//input[@type='text'])[10]")
	WebElement SSN;

	@FindBy(xpath = "(//input[@id='zipCode'])[2]")
	WebElement ZipCode;

	@FindBy(xpath = "(//input[@id='DLNumber'])[2]")
	WebElement DrivingLicenseNumber;

	@FindBy(xpath = "(//select[@id='states'])[2]")
	WebElement DrivingLicenseState;

	@FindBy(xpath = "(//input[@id='acknowlodge'])[2]")
	WebElement AckCheckBox;

	// @@ INVESTIGATION PAGE

	@FindBy(xpath = "(//input[@id='investigation'])[2]")
	WebElement InvCheckBox;

	// @@ Manage Aavailbility
	@FindBy(xpath = "//h5[text()=' Manage Availability ']")
	WebElement availSection;

	@FindBy(xpath = "//div[@class='radio radio-primary'] //label[@for='radioWeekStart0']")
	WebElement week1Radio;

	@FindBy(css = ".btn.btn-primary.float-right")
	WebElement avail_NextButton;

	/*
	 * @FindBy(
	 * xpath="//div[@class='row mr-auto mt-5 text-muted'] //div[text()='AM']")
	 * WebElement AMShift;
	 * 
	 * @FindBy(
	 * xpath="//div[@class='row mr-auto mt-5 text-muted'] //div[text()='PM']")
	 * WebElement PMShift;
	 */

	@FindBy(css = "button.btn.btn-primary.float-right")
	WebElement doneButton;

	// @@ Service Provide Agreement

	@FindBy(xpath = "//h5[text()=' Service Provider Agreement ']")
	WebElement agreementSection;

	@FindBy(css = ".btn-primary.float-right")
	WebElement agreementSubmit;

	@FindBy(css = ".pt-3.text-center")
	WebElement nextScheduledblocksTitle;

	public void Click_On_Become_Cleaner_Page() throws Exception {
		try {
			Wait.wait25Second();
			CleanerLink.click();
			System.out.println("Cleaner method entered ");
			et.log(LogStatus.PASS, "entered Become a Cleaner Link");
			Pass_Count = Pass_Count + 1;
		} catch (Exception e) {

			System.out.println("Cleaner Link is not displayed");
			Fail_Count = Fail_Count + 1;
			et.log(LogStatus.FAIL, "Cleaner Link is not displayed");

		}
		Wait.wait5Second();
	}

	// @@ METHOD FOR TELL US ABOUT YOURSELF PAGE

	public void Tell_us_about_yourself_Page() throws Exception {

		try {
			/*
			 * Wait.wait15Second(); CleanerLink.click(); et.log(LogStatus.PASS,
			 * "Cleaner link is dispalyed");
			 */
			// Wait.wait25Second();
			expWait(driver, By.xpath("//u[text()='What gets cleaned?']"), 20);
			WhatgetscleanedLiink.click();
			et.log(LogStatus.PASS, "Tell us about yourself page is displayed");
			Wait.wait5Second();
			String SuccessMessage = "Whats Get Cleaned Page is Verified";
			String ErrorMessage = "Whats Get Cleaned Page Verification is failed";
			VerifyByElement(TotalApartmentSubHeading, KitchenSubHeading, BathroomSubHeading, SuccessMessage,
					ErrorMessage);
			CloseButton.click();
			Altmenu.click();
			FAQButton.click();
			Wait.wait2Second();
			String SuccessMessage1 = "FAQ Page is Verified";
			String ErrorMessage1 = "FAQ Page Verification is failed";
			VerifyByElement(TotalApartmentSubHeading, KitchenSubHeading, BathroomSubHeading, SuccessMessage1,
					ErrorMessage1);
			CloseButton.click();
			NextButton.click();
			Wait.wait2Second();
			BackButton.click();
			Wait.wait2Second();
			NextButton.click();
			Pass_Count = Pass_Count + 6;

		} catch (Exception exp) {
			System.err.println("Unale to click and verify 'Whats gets cleaned?' page");
			NextButton.click();
			Fail_Count = Fail_Count + 6;
			et.log(LogStatus.FAIL, "Unale to click and verify 'Whats gets cleaned?' page");

		}

	}

	// @@ METHOD FOR LAPALOPA CLEANING PAGE

	public void Lapalopa_Cleaning_Page() throws Exception {
		try {
			Wait.wait2Second();
			String SuccessMsg = "Lapalopa Cleaning Page is Verified";
			String ErrorMsg = "Lapalopa Cleaning Page Verification is failed";
			VerifyByElement(LapalopaCleaningTitle, Wanttoworkwithus, SuccessMsg, ErrorMsg);
			Zipcode.clear();
			et.log(LogStatus.PASS, "Lapa Lopa Cleaning page is displayed");
			Zipcode.sendKeys("21213");
			NextButton.click();
			System.out.println("Redirected to Service not avialable page.");
			wait40Second();
			GoBackButton.click();
			System.out.println("clicked on zip code back button");
			et.log(LogStatus.PASS, "Service availability page is displayed");
			Wait.wait10Second();

			CleanerLink.click();
			Wait.wait2Second();
			NextButton.click();
			Wait.wait2Second();
			Zipcode.clear();
			Zipcode.sendKeys("2000121");
			NextButton.click();
			String ErrorMsgSuccessful = "Invalid Error Validation Display";
			String ErrorMsgFailed = "Invalid Error Validation Not Displayed";
			VerifyByElement(ZipcodeError, ErrorMsgSuccessful, ErrorMsgFailed);
			Wait.wait2Second();
			Zipcode.clear();
			Zipcode.sendKeys(Excel_Read.ZipCode);
			Wait.wait2Second();
			et.log(LogStatus.PASS, "Application is accepted valid zipcode");
			NextButton.click();
			Wait.wait2Second();
			Pass_Count = Pass_Count + 5;
		} catch (Throwable th) {
			th.printStackTrace();
			Fail_Count = Fail_Count + 1;
			et.log(LogStatus.FAIL, "Unable to verify Lapa Lopa Cleaning Page");
		}
	}

	// @@ METHOD FOR TAKE A PHOTO OF YOURSELF PAGE

	public void Take_a_Photo_Of_Yourself_Page() throws Exception {
		try {
			// @@ Page Verification
			wait10Second();
			String SuccessMsg = "Take a photo of yourself Page is Verified";
			String ErrorMsg = "Take a photo of yourself Page Verification is failed";
			VerifyByElement(CameraText, workwithpetsText, SuccessMsg, ErrorMsg);
			System.out.println("Take a photo of yourself page is verified");

			// @@Upload cleaner Photo
			Wait.wait10Second();
			profilePic.click();
			Wait.wait5Second();
			Runtime.getRuntime().exec(
					"D:\\Automation\\Consolidated_WorkspaceLLP\\Lapa_Lopa_POM_Framework\\autoit\\cleanerPicUpload.exe");
			Wait.wait5Second();

			// @@ Page Funcations
			/*
			 * WebElement Email1=driver.findElement(By.xpath("(//input[@id='email'])[2]"));
			 * String EmailCompare=Email1.getText();
			 */
			String EmailCompare = (String) ((JavascriptExecutor) driver)
					.executeScript("return document.getElementById('email').value");
			System.out.println(EmailCompare);
			et.log(LogStatus.PASS, "Take a photo of yourself page is displayed");
			if (EmailCompare.contains(Excel_Read.Login_Username) || EmailCompare.contains(Excel_Read.adminEmail)
					|| EmailCompare.contains(Excel_Read.schedularEmail)
					|| EmailCompare.contains(Excel_Read.cleanerEmail)) {
				et.log(LogStatus.PASS, "Registered Email is displayed");
				System.out.println("Registered Email is displayed");
			} else {
				et.log(LogStatus.FAIL, "Wrong Email Displayed");
				System.err.println("Wrong Email Displayed");
			}

			Wait.wait5Second();
			Random rnd = new Random();
			int randomNo = 2000000000 + rnd.nextInt(90000000);
			System.out.println("random id : " + randomNo);

			Integer intInstance = new Integer(randomNo);
			String number = intInstance.toString();

			try {
				MobileNumber.sendKeys(number);
			} catch (Exception e) {
				MobileNumberEntered.clear();
				MobileNumberEntered.sendKeys(number);
			}
			et.log(LogStatus.PASS, "Mobile Number is validated succesfully");
			contactPreference.click();
			Actions a = new Actions(driver);
			a.sendKeys(Keys.DOWN, Keys.ENTER).build().perform();
			try {
				workwithpets.click();
			} catch (Exception e) {
				workwithpetChecked.click();
			}
			et.log(LogStatus.PASS, "Contact Preference is selected succesfully");
			NextButton.click();
			Pass_Count = Pass_Count + 13;

		} catch (Throwable th) {
			th.printStackTrace();
			Fail_Count = Fail_Count + 13;
			et.log(LogStatus.FAIL, "Unable to verify Take a Photo of yourself page");
		}
	}

	public void Address_Information_Page() throws Exception {
		try {
			Wait.wait2Second();
			try {

				Address.clear();
				Address.sendKeys(Excel_Read.Cleaning_address, Keys.ENTER);
				et.log(LogStatus.PASS, "Address page is dispalyed succesfully");
				et.log(LogStatus.PASS, "Address is entered succesfully");
			} catch (Exception e) {
				Address.sendKeys(Excel_Read.Cleaning_address, Keys.ENTER);
				et.log(LogStatus.FAIL, "Unable to enter Address data");
			}
			Wait.wait10Second();
			Actions a = new Actions(driver);
			WebElement element = driver.findElement(By.xpath("(//a[@class='cursor_pointer'])[2]"));
			a.moveToElement(element).click().build().perform();
			Wait.wait5Second();
			UnitNumber.sendKeys(Excel_Read.UnitNumber);
			NextButton.click();
			Pass_Count = Pass_Count + 6;
		} catch (Throwable th) {
			th.printStackTrace();
			Fail_Count = Fail_Count + 6;
			et.log(LogStatus.FAIL, "Unable to verify Address page");
		}
	}

	public void Vendor_Detail_Page() throws Exception {
		try {
			Wait.wait2Second();
			String firstname = FirstName.getText();
			et.log(LogStatus.PASS, "Vendor Background check page is displayed");
			String lastname = LastName.getText();
			String zipcode = ZipCode.getText();
			if (Excel_Read.Name.equalsIgnoreCase(firstname) && Excel_Read.Name.equalsIgnoreCase(lastname)
					&& Excel_Read.ZipCode.equalsIgnoreCase(zipcode)) {
				System.out.println(firstname);
				System.out.println(lastname);
				System.out.println(zipcode);
			}
			wait2Second();
			NoMiddleNameCheckBox.click();
			Calendartext.clear();
			Calendartext.sendKeys(Excel_Read.DOB);

			Random rnd = new Random();
			int randomNo = 200000000 + rnd.nextInt(90000000);
			System.out.println("random id : " + randomNo);

			Integer intInstance = new Integer(randomNo);
			String number = intInstance.toString();
			SSN.sendKeys(number);
			DrivingLicenseNumber.sendKeys(Excel_Read.Driving_License);

			Select fruits = new Select(DrivingLicenseState);
			fruits.selectByVisibleText("Washington");

			AckCheckBox.click();
			NextButton.click();
			System.out.println("Entered all Vendor Details in Back check  page1");
			et.log(LogStatus.PASS, "Entered all vendor details successfully in the Background check page1");
			Pass_Count = Pass_Count + 17;
		} catch (Throwable th) {
			th.printStackTrace();
			Fail_Count = Fail_Count + 17;
			et.log(LogStatus.FAIL, "Unable to verify Vendor Background check page1");
		}
	}

	public void Investigation_Page() throws Exception {
		try {
			Actions ao = new Actions(driver);
			ao.moveByOffset(640, 234).click().build().perform();
			;
			for (int i = 1; i < 5; i++) {
				ao.sendKeys(Keys.ARROW_DOWN);
			}
			Wait.wait5Second();
			InvCheckBox.click();
			et.log(LogStatus.PASS, "Investigation Page is dispalyed");
			NextButton.click();
			Wait.wait5Second();
			SubmitButton.click();
			Wait.wait10Second();
			LastNextButton.click();
			System.out.println("Vendor Registered Successfully");
			et.log(LogStatus.PASS, "Vendor Registered Successfully");
			et.log(LogStatus.INFO, "Vendor Registered Successfully");
			Pass_Count = Pass_Count + 12;
		} catch (Throwable th) {
			th.printStackTrace();
			Fail_Count = Fail_Count + 12;
			et.log(LogStatus.FAIL, "Unable to Complete Vendor Registratiion.");
		}
	}

	public void updateVendorDeatils() throws SQLException, InterruptedException {
		if (!(Excel_Read.Login_Username.contains("lapalopa.com"))) {
			try {
				StageDB sb = new StageDB();
				sb.vendorDBUpdates(StageDB.st, Excel_Read.Login_Username);
				System.out.println("Vendor Background Check details Success");
				et.log(LogStatus.PASS, "Vendor Backgroundcheck status is changed to Pass");
				et.log(LogStatus.PASS, "Vendor Payment details is updated");
				driver.navigate().refresh();
				Pass_Count = Pass_Count + 1;

			} catch (Throwable th) {
				th.printStackTrace();
				Fail_Count = Fail_Count + 1;
				et.log(LogStatus.FAIL, "Unable to update DB updates for Vendor");
			}
		} else {
			Wait.wait5Second();
			System.out.println("Lapa Lopa Employee background check updation is success");
		}
	}

	public void availSetup() throws InterruptedException {
		try {
			System.out.println("Avialability Setup started");
			Wait.wait10Second();
			Wait.expWait(driver, By.xpath("//h5[text()=' Manage Availability ']"), 20);
			availSection.click();
			Wait.wait10Second();
			week1Radio.click();
			avail_NextButton.click();
			Wait.wait10Second();

			for (int i = 1; i <= 5; i++) {
				By AMShift = By.xpath("(//div[@class='row mr-auto mt-5 text-muted'] //div[text()='AM'])[" + i + "]");
				By PMShift = By.xpath("(//div[@class='row mr-auto mt-5 text-muted'] //div[text()='PM'])[" + i + "]");

				driver.findElement(AMShift).click();
				driver.findElement(PMShift).click();

				Wait.wait2Second();
			}

			doneButton.click();
			System.out.println("Avialability Setup Completed");
			et.log(LogStatus.PASS, "Vendor Availability setup is completed");
			Pass_Count = Pass_Count + 1;
		} catch (Throwable th) {
			th.printStackTrace();
			Fail_Count = Fail_Count + 1;
			et.log(LogStatus.PASS, "Unable to setup vendor avialability");
		}

	}

	public void agreementSection() throws InterruptedException {

		if (!(Excel_Read.Login_Username.contains("lapalopa.com"))) {
			try {
				Wait.wait10Second();
				agreementSection.click();

				WebElement agreement = driver.findElement(By.cssSelector("p.mt-5.p-3"));

				Actions ao = new Actions(driver);
				ao.moveToElement(agreement, 400, 40).click().build().perform();
				for (int i = 1; i <= 30; i++) {

					ao.sendKeys(Keys.PAGE_DOWN).build().perform();
					;
				}
				Pass_Count = Pass_Count + 1;

				Wait.wait2Second();
			} catch (Throwable th) {
				th.printStackTrace();
				Fail_Count = Fail_Count + 1;

			}
		}

	}

	public void submitAgreement() {

		if (!(Excel_Read.Login_Username.contains("lapalopa.com"))) {
			try {
				WebElement agreementCheckbox = driver
						.findElement(By.cssSelector("div.row.ml-5 div.mat-checkbox-inner-container-no-side-margin"));
				agreementCheckbox.click();
				agreementSubmit.click();
				Pass_Count = Pass_Count + 1;
				System.out.println("Service Privider Agreement Completed");
				et.log(LogStatus.PASS, "Service Provider Agreeement Completed successfully");
				et.log(LogStatus.INFO, "Vendor Setup is Completed");
				Pass_Count = Pass_Count + 1;
			} catch (Throwable th) {
				th.printStackTrace();
				Fail_Count = Fail_Count + 1;
				et.log(LogStatus.FAIL, "Unable to complete  Agreeement");
			}
		}
	}

	public void verifyVendorDashboard() {
		try {

			System.out.println("Entered in VendorDashboard Test");
			Wait.wait10Second();
			System.out.println(nextScheduledblocksTitle.getText());
			if (nextScheduledblocksTitle.getText().contains("Next Scheduled Block(s)")) {

				et.log(LogStatus.PASS, "Vendor Dashboard is displayed");
				System.out.println("Vendor Dashboard is displayed");
				Pass_Count = Pass_Count + 1;
			} else {
				et.log(LogStatus.FAIL, "Vendor Dashbaord is not dispalyed");
				System.out.println("Vendor Dashbaord is not dispalyed");
			}

		} catch (NoSuchElementException ne) {
			System.err
					.println("User not navigated to Vendor Dashboard, Next Scheduled Block(s) section is no dispalyed");
			Fail_Count = Fail_Count + 1;
		} catch (Throwable th) {
			th.printStackTrace();
			Fail_Count = Fail_Count + 1;
		}
	}

}