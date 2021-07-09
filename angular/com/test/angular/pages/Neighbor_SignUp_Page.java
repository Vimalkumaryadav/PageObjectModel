package com.test.angular.pages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.hooks.Config;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.Wait;
import com.test.angular.excel.Excel_Read;

public class Neighbor_SignUp_Page extends Hooks {

	public WebDriver driver = null;
	public String Total_Price;
	String ScheduleDate = null;
	String Pets = null;

	public Neighbor_SignUp_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h4[text()=' Invite']")
	WebElement Invite;

	@FindBy(xpath = "//h4[text()='Profile']")
	WebElement Profile;

	/********** LOCATORS OF What Gets Cleaned PAGE **********/

	@FindBy(xpath = "//u[text()='What gets cleaned']")
	WebElement WhatGetsCleanedLink;

	@FindBy(xpath = "//div[contains(text(),'What gets cleaned?')]")
	WebElement WhatGetsCleanedSection;

	@FindBy(xpath = "//div[contains(text(),'Frequently Asked Questions')]")
	WebElement FAQSection;

	@FindBy(xpath = "//span[text()='Terms']")
	WebElement TermsSection;

	@FindBy(xpath = "//span[text()='Privacy']")
	WebElement PrivacySection;

	@FindBy(xpath = "//a[@class='TextLink LegalLinks-Child']")
	WebElement PrivacySection2;

	@FindBy(xpath = "//*[@class='icon icon-ll-icon-close cross']")
	WebElement CloseButton;

	@FindBy(xpath = "(//i[@class='icon icon-ll-icon-chev-left'])[3]")
	WebElement backArrow;

	/********** LOCATORS OF FAQ PAGE **********/

	@FindBy(id = "navbarDropdown")
	WebElement AltMenu;

	@FindBy(xpath = "//a[text()='FAQ']")
	WebElement FAQ;

	@FindBy(xpath = "//h3[text()='Who is Lapa Lopa?']")
	WebElement WhoIsLapalopaQuestion;

	@FindBy(xpath = "//h3[text()='What is a Neighbor?']")
	WebElement WhatIsANeighborQuestion;

	@FindBy(xpath = "//h3[text()='What is a Service Partner?']")
	WebElement WhatIsAServicePatnerQuestion;

	@FindBy(xpath = "(//i[@class='icon icon-ll-icon-chev-left'])[3]")
	WebElement BackButtonFromFAQ;

	/**********		* LOCATORS OF SERVICE AVAILABLE IN DC AND SEATTLE METRO AREAS PAGE**********/

	/********** LOCATORS POSITIVE FLOW **********/

	@FindBy(xpath = "//h2[text()='Service Available in DC metro area']")
	WebElement Page1Title;

	@FindBy(xpath = "(//input[@id='userNameSearch'])[2]")
	WebElement addressSearchBox;

	@FindBy(xpath = "//h4[@class='mb-0 text-muted']")
	WebElement address;

	@FindBy(xpath = "//h4[contains(text(),'Service available at:')]")
	WebElement verifyAddress;

	/********** LOCATORS OF ERROR MESSAGES **********/

	@FindBy(xpath = "(//div[@class='text-danger'])[2]")
	WebElement AddressErrorMsg;

	@FindBy(xpath = "//a[@class='float-left pt-4']")
	WebElement BackButton;

	/********** LOCATORS OF QUALITY CLEANING PAGE **********/

	@FindBy(xpath = "//h2[text()='Quality Cleaning']")
	WebElement Page2Title;

	@FindBy(xpath = "(//div[contains(text(),'Unit# is required')])[2]")
	WebElement UnitErrorMsg;

	@FindBy(xpath = "(//input[@id='unitNumber'])[2]")
	WebElement UnitNumber;

	@FindBy(xpath = "(//button[text()='Next'])[2]")
	WebElement Price_next;

	/********** LOCATORS OF CLEANING EVERY 2 WEEKS PAGE **********/

	@FindBy(xpath = "//h2[text()='Cleaning Every 2 Weeks']")
	WebElement Page3Title;

	@FindBy(xpath = "//h4[@class='card-header border-0 background-green']")
	WebElement ServiceAt;

	@FindBy(xpath = "//h3[text()='1']")
	WebElement Bedroomcount1;

	@FindBy(xpath = "//h3[text()='2']")
	WebElement Bedroomcount2;

	@FindBy(xpath = "//h3[text()='3']")
	WebElement Bedroomcount3;

	@FindBy(xpath = "//h3[text()='4']")
	WebElement Bedroomcount4;

	/********** LOCATORS OF SURFACE-FOCUS CLEANING PAGE **********/

	@FindBy(xpath = "//h2[text()='Surface-Focus Cleaning']")
	WebElement Page4Title;

	@FindBy(xpath = "//h3[text()='1']")
	WebElement Bathroomcount1;

	@FindBy(xpath = "//h3[text()='1.5']")
	WebElement Bathroomcount1Half;

	@FindBy(xpath = "//h3[text()='2']")
	WebElement Bathroomcount2;

	@FindBy(xpath = "//h3[text()='2.5']")
	WebElement Bathroomcount2Half;

	@FindBy(xpath = "//h3[text()='3']")
	WebElement Bathroomcount3;

	/********** LOCATORS OF KITCHEN, BATHROOMS, FLOORS & DUSTING PAGE **********/

	@FindBy(xpath = "//h2[text()='Kitchen, Bathrooms, Floors & Dusting']")
	WebElement Page5Title;

	@FindBy(xpath = "(//button[text()='Yes'])[2]")
	WebElement Yes;

	@FindBy(xpath = "(//button[text()='No'])[2]")
	WebElement No;

	/********** LOCATORS OF CLEANING EVERY OTHER WEEK PAGE **********/

	@FindBy(xpath = "//h2[text()='Cleaning Every Other Week']")
	WebElement page6Title;

	@FindBy(xpath = "//img[@class='img-fluid mx-2']")
	WebElement petIcon;

	@FindBy(xpath = "//h2[contains(text(),'Do you have a pet?')]")
	WebElement petText;

	@FindBy(xpath = "(//h4[text()=' Penthouse/Townhouse selected'])[2]")
	WebElement pentHouseOrTownHouseSelected;

	@FindBy(xpath = "(//h4[text()=' Penthouse/Townhouse not selected'])[2]")
	WebElement pentHouseOrTownHouseNotSelected;

	@FindBy(xpath = "//u[text()='Learn more about Our Pet Policy']")
	WebElement petPolicyLink;

	/**********
	 * LOCATORS OF DON'T FORGET TO SECURE YOUR PET BEFORE THE CLEANER PAGE
	 **********/

	@FindBy(xpath = "//h2[text()=\"Don't forget to secure your pet before the cleaner\"]")
	WebElement page7Title;

	@FindBy(xpath = "(//u[text()='Learn more about Our Pet Policy'])[2]")
	WebElement learnMoreAboutOurPetPolicyLink;

	@FindBy(xpath = "(//span[text()='Please select any one in above.'])[2]")
	WebElement selectPetErrorMsg;

	/********** LOCATORS OF WHEN SHOULD WE START CLEANING? PAGE **********/

	@FindBy(xpath = "//h2[text()='When should we start cleaning?']")
	WebElement page8Title;

	@FindBy(xpath = "(//u[text()='Learn how we schedule'])[2]")
	WebElement LearnHowWeScheduleLink;

	@FindBy(xpath = "//button[@class='animated btn btn-block btn-inactive fadeInUp']")
	WebElement scheduleDate;

	/********** LOCATORS OF LEAR HOW WE SCHEDULE PAGE **********/

	@FindBy(xpath = "(//h3[contains(text(),' We group apartments')])[2]")
	WebElement LearnHowWeScheduleText;

	/********** LOCATORS OF ALMOST FINISHED! PAGE **********/

	/********** LOCATORS OF ERROR MESSAGES **********/

	@FindBy(xpath = "//span[text()='Please select any one in above.']")
	WebElement petsErrorMsg;

	@FindBy(xpath = "(//div[contains(text(),'Additional Information')])[2]")
	WebElement AdditionalInfoErrorMsg;

	@FindBy(xpath = "(//div[contains(text(),'Select how we get into your place.')])[2]")
	WebElement howToGetIntoYourPlaceErrorMsg;

	/********** LOCATORS POSITIVE FLOW **********/

	@FindBy(xpath = "(//label[contains(text(),'ll be at home ')])[2]")
	WebElement Radio_IwillBeAtHome;

	@FindBy(xpath = "(//label[contains(text(),'Leave Key / Fob at Front Desk')])[2]")
	WebElement Radio_LeaveKey_FobatFrontDesk;

	@FindBy(xpath = "(//label[contains(text(),'Keypad/Passcode')])[2]")
	WebElement Radio_Keypad_Passcode;

	@FindBy(xpath = "(//input[@id='additonalInstructions'])[2]")
	WebElement additonalInstructions;

	@FindBy(xpath = "(//label[contains(text(),'Concierge')])[2]")
	WebElement Radio_Concierge;

	@FindBy(xpath = "(//button[text()='Next'])[2]")
	WebElement Finish_Next;

	@FindBy(xpath = "//span[@class='switch checked switch-medium' or @class='switch switch-medium' or @class='switch switch-medium checked']")
	WebElement DoYouHavePetsButton;

	@FindBy(xpath = "(//div[contains(@class,'mat-checkbox-inner-container')])[4]")
	WebElement DogCheckbox;

	@FindBy(xpath = "(//div[contains(@class,'mat-checkbox-inner-container')])[5]")
	WebElement CatCheckbox;

	@FindBy(xpath = "(//div[contains(@class,'mat-checkbox-inner-container')])[6]")
	WebElement OtherCheckbox;

	/********** LOCATORS OF CLEANING EVERY 2 WEEKS PAGE **********/

	@FindBy(xpath = "//label[@class='btn btn-payment btn-primary mt-4 p-0']")
	WebElement Summary_TotalPrice;

	@FindBy(xpath = "(//div[1]/div/h3)[1]")
	WebElement SummaryAddressAndUnitNumber;

	@FindBy(xpath = "//div[2]/div/h3")
	WebElement SummaryBed_Bath;

	@FindBy(xpath = "//div/div[3]/div/h3")
	WebElement Summary_Ph_Th;

	@FindBy(xpath = "//div[4]/div/div/div/h3")
	WebElement TentativeDate;

	@FindBy(xpath = "//div[5]/div/h3")
	WebElement Access;

	@FindBy(xpath = "//h3[text()='Have Pets']")
	WebElement HavePets;

	@FindBy(xpath = "//h3[text()='No Pets']")
	WebElement NoPets;

	@FindBy(xpath = "//u[text()='Terms of Service']")
	WebElement termsOfService;

	@FindBy(xpath = "//button[@class='btn btn-primary float-right']")
	WebElement PayNowButton;

	@FindBy(xpath = "//input[@placeholder='Card number']")
	WebElement InputCardNumber;

	@FindBy(xpath = "//input[@placeholder='MM / YY']")
	WebElement InputMonthYear;

	@FindBy(xpath = "//input[@placeholder='CVC']")
	WebElement Enter_CVC;

	@FindBy(xpath = "//div[@class='Button-content']")
	WebElement UpdateCardDetailsButton;

	@FindBy(xpath = "//div[@class='Checkbox-tick' or @class='Checkbox-tick is-checked']")
	WebElement RememberMeCheckBox;

	@FindBy(xpath = "//*[@id=\"container\"]/section/span[2]/div/div/main/form/nav/div/div/div/button")
	WebElement PayAmountButton;

	@FindBy(xpath = "(//button[text()='Dashboard'])[2]")
	WebElement PayMent_Confirmation_Dashaboard;

	public void Metro_Area_Address() throws Exception {

		Wait.Fluentwait(By.xpath("//h4[@class='mb-0 text-muted']"));

		try {
			/*********** PAGE INFO ***********/

			System.out.println("Service Available in DC Metro Area Page Appreared");
			et.log(LogStatus.INFO, "Service Available in DC Metro Area Page Appreared");

			/***********
			 * VERIFYING DETAILS IN SERVICE AVAILABLE IN DC AND SEATTLE METRO AREAS PAGE
			 ************/

			Hooks.VerifyByElement(Page1Title, WhatGetsCleanedLink, "SignUp Page 1 Details Verified",
					"SignUp Page 1 Details Differ");

			/********** VERIFYING WHAT GETS CLEANED PAGE **********/

			Wait.Fluentwait(By.xpath("//u[text()='What gets cleaned']"));
			WhatGetsCleanedLink.click();
			Hooks.VerifyByElement(WhatGetsCleanedSection, FAQSection, "What's Get Cleaned Page Verified",
					"What's Get Cleaned Page Verification Failed");
			Wait.wait2Second();
			CloseButton.click();

			/********** VERIFYING THE ADDRESS **********/

			Wait.Fluentwait(By.xpath("//h4[@class='mb-0 text-muted']"));

			addressSearchBox.sendKeys(Excel_Read.Cleaning_address);
			address.click();

			Wait.Fluentwait(By.xpath("(//input[@id='unitNumber'])[2]"));

			try {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", BackButton);
			} catch (Exception e) {
				System.out.println(e);
			}

			Wait.Fluentwait(By.xpath("//h4[@class='mb-0 text-muted']"));

			String verifyAddress = addressSearchBox.getText();
			if (verifyAddress.contains(Excel_Read.Cleaning_address)) {
				System.out.println("Address is verified");
			} else {
				System.out.println("Address Differed");
			}

			addressSearchBox.clear();
			addressSearchBox.sendKeys(Excel_Read.Cleaning_address);
			address.click();

			/************* PAGE VERIFIED ************/

			System.out.println("Service Available in DC Metro Area Page is Verified");
			et.log(LogStatus.INFO, "Service Available in DC Metro Area Page is Verified");

			/************ PASS COUNT ***********/

			Pass_Count = Pass_Count + 18;
		} catch (Exception e) {
			System.err.println(
					"Test Interrupted at Service Available in DC and Seattle Metro Areas Page, Error is -->" + e);
		}
	}

	public void Quality_Cleaning() throws InterruptedException {
		try {
			/*********** PAGE INFO ***********/

			System.out.println("Quality Cleaning Page Appreared");
			et.log(LogStatus.INFO, "Quality Cleaning Page Appreared");

			/*********** VERIFYING DETAILS IN QUALITY CLEANING PAGE ************/

			Hooks.VerifyByElement(Page2Title, "SignUp Page 2 Details Verified", "SignUp Page 2 Details Differ");

			/*********** VERIFYING ADDRESS **********/

			String Address = verifyAddress.getText();
			System.out.println(Address);

			if (Address.contains(Excel_Read.Cleaning_address)) {
				System.out.println("Selected Address is Displayed");
				et.log(LogStatus.PASS, "Selected Address is Displayed");
			} else {
				System.err.println("Different Address is Displayed");
				et.log(LogStatus.FAIL, "Different Address is Displayed");
				Fail_Count = Fail_Count + 1;
			}

			/********** VERFYING FAQ PAGE(IN ELLIPSIS) **********/

			Wait.wait3Second();
			try {
				AltMenu.click();
				System.out.println("ELLIPSIS WORKED");
				et.log(LogStatus.PASS, "ELLIPSIS WORKED");
				FAQ.click();
			} catch (Exception e) {
				System.err.println("ELLIPSIS is not displayed");
				et.log(LogStatus.FAIL, "ELLIPSIS is not displayed");
				Fail_Count = Fail_Count + 1;
			}
			Wait.wait3Second();
			backArrow.click();

			/********** VERIFYING UNIT NUMBER **********/

			Wait.Fluentwait(By.xpath("(//input[@id='unitNumber'])[2]"));

			UnitNumber.sendKeys(Excel_Read.UnitNumber);

			Wait.wait2Second();

			Price_next.click();

			try {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", BackButton);
			} catch (Exception e) {
				System.out.println(e);
			}

			Wait.wait2Second();

			String unitNumber = UnitNumber.getAttribute("value").toString();
			System.out.println(unitNumber);

			if (unitNumber.contains(Excel_Read.UnitNumber)) {
				System.out.println("Unit Number is verified");
				et.log(LogStatus.PASS, "Unit Number is verified");
			} else {
				System.out.println("Unit Number Verification Failed");
				et.log(LogStatus.FAIL, "Unit Number Verification Failed");
			}

			Wait.Fluentwait(By.xpath("(//button[text()='Next'])[2]"));

			Price_next.click();

		} catch (Exception e) {
			System.err.println("Test Interrupted at Quality Cleaning Page, Error is -->" + e);
		}
	}

	public void Cleaning_Every_2_Weeks() throws InterruptedException {
		Wait.Fluentwait(By.xpath("//h5[@class='border-0 card-header text-center text-white']"));
		try {
			/*********** PAGE INFO ***********/

			System.out.println("Cleaning Every 2 Weeks Page Appreared");
			et.log(LogStatus.INFO, "Cleaning Every 2 Weeks Page Appreared");

			/*********** VERIFYING DETAILS IN CLEANING EVERY 2 WEEKS PAGE ************/

			Hooks.VerifyByElement(Page3Title, "SignUp Page 3 Details Verified", "SignUp Page 3 Details Differ");

			Wait.wait2Second();

			Bedroomcount1.click();

			try {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", BackButton);
			} catch (Exception e) {
				System.out.println(e);
			}

			/*********** VERFYING BACK BUTTON AND SELECTED COUNT **********/

			Wait.Fluentwait(By.xpath("(//i[@class='icon icon-ll-icon-chev-left'])[3]"));

			if (Bedroomcount1.isEnabled() || Bedroomcount2.isEnabled() || Bedroomcount3.isEnabled()
					|| Bedroomcount4.isEnabled()) {
				System.out.println("Bedroom Count displayed");
				et.log(LogStatus.PASS, "Bedroom Count displayed");
			} else {
				System.err.println("Bedroom Count is not displayed");
				et.log(LogStatus.FAIL, "Bedroom Count is not displayed");
				Fail_Count = Fail_Count + 1;
			}

			/*********** SELECTING BEDROOM COUNT **********/

			Wait.Fluentwait(By.xpath("//h3[text()='1']"));

			switch (Excel_Read.BedroomCount) {
			case "1":
				Bedroomcount1.click();
				System.out.println("One Bedroom Selected");
				et.log(LogStatus.PASS, "One Bedroom Selected");
				break;
			case "2":
				Bedroomcount2.click();
				System.out.println("Two Bedrooms Selected");
				et.log(LogStatus.PASS, "Two Bedrooms Selected");
				break;
			case "3":
				Bedroomcount3.click();
				System.out.println("Three Bedrooms Selected");
				et.log(LogStatus.PASS, "Three Bedrooms Selected");
				break;
			case "4":
				Bedroomcount4.click();
				System.out.println("Four Bedrooms Selected");
				et.log(LogStatus.PASS, "Fourth Bedrooms Selected");
				break;
			default:
				System.err.println("Bedroom count not selected");
				et.log(LogStatus.FAIL, "Bedroom count not selected");
				Fail_Count = Fail_Count + 1;
			}

			/************* PAGE VERIFIED ************/

			System.out.println("Cleaning Every 2 Weeks Page is Verified");
			et.log(LogStatus.INFO, "Cleaning Every 2 Weeks Page is Verified");

			/************ PASS COUNT ***********/

			Pass_Count = Pass_Count + 4;
		} catch (Exception e) {
			System.err.println("Test Interrupted at Cleaning Every 2 Weeks Page, Error is -->" + e);
		}

	}

	public void Surface_Focus_Cleaning() throws InterruptedException {
		Wait.Fluentwait(By.xpath("//h2[text()='Surface-Focus Cleaning']"));

		try {
			/*********** PAGE INFO ***********/

			System.out.println("SURFACE FOCUS CLEANING Page Appreared");
			et.log(LogStatus.INFO, "SURFACE FOCUS CLEANING Page Appreared");

			/*********** VERIFYING DETAILS IN SURFACE FOCUS CLEANING PAGE ************/

			Hooks.VerifyByElement(Page4Title, "SignUp Page 4 Details Verified", "SignUp Page 4 Details Differ");
			Wait.wait2Second();

			Bathroomcount1.click();

			/*********** VERFYING BACK BUTTON AND SELECTED COUNT **********/

			try {
				Wait.Fluentwait(By.xpath("//h2[text()='Surface-Focus Cleaning']"));
				try {
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", BackButton);
				} catch (Exception e) {
					System.out.println(e);
				}
			} catch (Exception e) {
				Wait.Fluentwait(By.xpath("//h2[text()='Kitchen, Bathrooms, Floors & Dusting']"));
				try {
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", BackButton);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}

			if (Bathroomcount1.isEnabled() || Bathroomcount1Half.isEnabled() || Bathroomcount2.isEnabled()
					|| Bathroomcount2Half.isEnabled() || Bathroomcount3.isEnabled()) {
				System.out.println("Bathroom Count displayed");
				et.log(LogStatus.PASS, "Bathroom Count displayed");
			} else {
				System.out.println("Bathroom Count is not displayed");
				et.log(LogStatus.FAIL, "Bathroom Count is not displayed");
				Fail_Count = Fail_Count + 1;
			}

			/*********** SELECTING BATHROOM COUNT **********/

			Wait.Fluentwait(By.xpath("//h3[text()='1']"));

			switch (Excel_Read.BathroomCount) {
			case "1":
				Bathroomcount1.click();
				System.out.println("1 Bathroom Selected");
				et.log(LogStatus.PASS, "1 Bathroom Selected");
				break;
			case "1.5":
				Bathroomcount1Half.click();
				System.out.println("1.5 Bathrooms Selected");
				et.log(LogStatus.PASS, "1.5 Bathrooms Selected");
				break;
			case "2":
				Bathroomcount2.click();
				System.out.println("2 Bathrooms Selected");
				et.log(LogStatus.PASS, "2 Bathrooms Selected");
				break;
			case "2.5":
				Bathroomcount2Half.click();
				System.out.println("2.5 Bathrooms Selected");
				et.log(LogStatus.PASS, "2.5 Bathrooms Selected");
				break;
			case "3":
				Bathroomcount3.click();
				System.out.println("3 Bathrooms Selected");
				et.log(LogStatus.PASS, "3 Bathrooms Selected");
				break;
			default:
				System.err.println("Bathroom count not selected");
				et.log(LogStatus.FAIL, "Bathroom count not selected");
				Fail_Count = Fail_Count + 1;

			}

			/************* PAGE VERIFIED ************/

			System.out.println("SURFACE FOCUS CLEANING Page is Verified");
			et.log(LogStatus.INFO, "SURFACE FOCUS CLEANING Page is Verified");

			/************ PASS COUNT ***********/

			Pass_Count = Pass_Count + 4;

		} catch (Exception e) {
			System.err.println("Test Interrupted at SURFACE FOCUS CLEANING Page, Error is -->" + e);
		}

	}

	public void Kitchen_Bathrooms_FloorsAndDusting() throws InterruptedException {
		try {
			try {
				Wait.Fluentwait(By.xpath("//h2[text()='Kitchen, Bathrooms, Floors & Dusting']"));

				/*********** PAGE INFO ***********/

				System.out.println("KITCHEN, BATHROOM, FLOORS AND DUSING Page Appreared");
				et.log(LogStatus.INFO, "KITCHEN, BATHROOM, FLOORS AND DUSING Page Appreared");

				/***********
				 * VERIFYING DETAILS IN KITCHEN, BATHROOM, FLOORS AND DUSING PAGE
				 ************/

				Hooks.VerifyByElement(Page5Title, "SignUp Page 5 Title Verified", "SignUp Page 5 Details Differ");
				Wait.wait2Second();

				Yes.click();

				/*********** VERFYING BACK BUTTON AND SELECTING YES/NO **********/

				// Wait.Fluentwait(By.xpath("//button[@class='animated btn btn-block
				// btn-inactive fadeInUp']"));
				Wait.wait3Second();
				try {
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", BackButton);
				} catch (Exception ex) {
					System.out.println(ex);
				}

				if (Yes.isEnabled() || No.isEnabled()) {
					System.out.println("Townhouse or penthouse is displayed");
					et.log(LogStatus.PASS, "Townhouse or penthouse is displayed");
				} else {
					System.err.println("Townhouse or penthouse is not displayed");
					et.log(LogStatus.FAIL, "Townhouse or penthouse is not displayed");
					Fail_Count = Fail_Count + 1;
				}

				/*********** SELECTING PENTHOUSE YES OR NO **********/

				Wait.Fluentwait(By.xpath("(//button[text()='Yes'])[2]"));
				switch (Excel_Read.PenthouseOrTownhouse) {
				case "Yes":
					Yes.click();
					System.out.println("Penthouse or Townhouse is Yes");
					et.log(LogStatus.PASS, "Penthouse or Townhouse is Yes");
					break;
				case "No":
					No.click();
					System.out.println("Penthouse or Townhouse is No");
					et.log(LogStatus.PASS, "Penthouse or Townhouse is No");
					break;
				default:
					System.err.println("Penthouse or Townhouse not selected");
					et.log(LogStatus.FAIL, "Penthouse or Townhouse not selected");
					Fail_Count = Fail_Count + 1;
				}

				/************* PAGE VERIFIED ************/

				System.out.println("KITCHEN, BATHROOM, FLOORS AND DUSING PAGE is Verified");
				et.log(LogStatus.INFO, "KITCHEN, BATHROOM, FLOORS AND DUSING PAGE is Verified");

				/************ PASS COUNT ***********/

				Pass_Count = Pass_Count + 5;

			} catch (Exception e) {
				/*********** VERIFYING SKIPPED PAGE **********/

				if (Excel_Read.UnitNumber.equalsIgnoreCase("penthouse")
						|| Excel_Read.UnitNumber.equalsIgnoreCase("townhouse")
						|| Excel_Read.UnitNumber.equalsIgnoreCase("townhome")
						|| Excel_Read.UnitNumber.equalsIgnoreCase("th")
						|| Excel_Read.UnitNumber.equalsIgnoreCase("ph")) {
					// Wait.Fluentwait(By.xpath("//button[@class='animated btn btn-block
					// btn-inactive fadeInUp']"));
					Wait.wait3Second();
					Hooks.VerifyByElement(Page5Title, "Penthouse/Townhouse successfully Skipped","Penthouse/Townhouse not Skipped");
				}

				/************ PASS COUNT ***********/

				Pass_Count = Pass_Count + 1;
			}
		} catch (Exception e) {
			System.err.println("Test Interrupted at KITCHEN, BATHROOM, FLOORS AND DUSING Page, Error is -->" + e);
		}

	}

	public void Cleaning_Every_Other_Week() throws InterruptedException {
		try {
			// Wait.Fluentwait(By.xpath("(//button[@type='button' and text()='Yes'])[2]"));
			Wait.wait3Second();

			/*********** PAGE INFO ***********/

			System.out.println("CLEANING EVERY OTHER WEEK Page Appreared");
			et.log(LogStatus.INFO, "CLEANING EVERY OTHER WEEK Page Appreared");

			/***********
			 * VERIFYING DETAILS IN WHEN SHOULD WE START CLEANING PAGE
			 ************/

			Hooks.VerifyByElement(page6Title, LearnHowWeScheduleLink, "SignUp Page 6 Details Verified","SignUp Page 6 Details Differ");
			Wait.wait2Second();

			Yes.click();

			/*********** VERFYING BACK BUTTON AND SELECTING YES/NO **********/

			Wait.wait3Second();
			try {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", BackButton);
			} catch (Exception ex) {
				System.out.println(ex);
			}

			if (Yes.isEnabled() || No.isEnabled()) {
				System.out.println("Do you have a pet is displayed");
				et.log(LogStatus.PASS, "Do you have a pet is displayed");
			} else {
				System.err.println("Do you have a pet is not displayed");
				et.log(LogStatus.FAIL, "Do you have a pet is not displayed");
				Fail_Count = Fail_Count + 1;
			}

			/*********** SELECTING PENTHOUSE YES OR NO **********/

			Wait.Fluentwait(By.xpath("(//button[text()='Yes'])[2]"));
			switch (Excel_Read.Pets) {
			case "dog":
			case "cat":
			case "other":
			case "dog&cat":
			case "dog&other":
			case "cat&other":
			case "dog&cat&other":
				Yes.click();
				System.out.println("Do you have a pet is Yes");
				et.log(LogStatus.PASS, "Do you have a pet is Yes");
				break;
			case "NA":
				No.click();
				System.out.println("Do you have a pete is No");
				et.log(LogStatus.PASS, "Do you have a pet is No");
				break;
			default:
				System.err.println("Do you have a pet not selected");
				et.log(LogStatus.FAIL, "Do you have a pet not selected");
				Fail_Count = Fail_Count + 1;
			}

		} catch (Exception e) {
			System.err.println("Test Interrupted at CLEANING EVERY OTHER WEEK Page, Error is -->" + e);
		}
	}

	public void Dont_forget_to_secure_your_pet_before_the_cleaner() throws InterruptedException {
		try {
			Wait.Fluentwait(By.xpath("(//button[@type='button' and text()='Yes'])[2]"));

			/*********** PAGE INFO ***********/

			System.out.println("DON'T FORGET TO SECURE YOUR PET BEFORE THE CLEANER Page Appreared");
			et.log(LogStatus.INFO, "DON'T FORGET TO SECURE YOUR PET BEFORE THE CLEANER Page Appreared");

			/***********
			 * VERIFYING DETAILS IN WHEN SHOULD WE START CLEANING PAGE
			 ************/

			Hooks.VerifyByElement(page7Title, learnMoreAboutOurPetPolicyLink, "SignUp Page 7 Details Verified",
					"SignUp Page 7 Details Differ");
			Wait.wait2Second();

			Price_next.click();

			Hooks.VerifyByElement(selectPetErrorMsg, "Select Pet Error Message Verified",
					"Select Pet Error Message Differ");
			Wait.wait2Second();

			switch (Excel_Read.Pets.toLowerCase()) {
			case "dog":
				DogCheckbox.click();
				System.out.println("Dog is Selected");
				et.log(LogStatus.PASS, "Dog is Selected");
				break;
			case "cat":
				CatCheckbox.click();
				System.out.println("Cat is Selected");
				et.log(LogStatus.PASS, "Cat is Selected");
				break;
			case "other":
				OtherCheckbox.click();
				System.out.println("Other is Selected");
				et.log(LogStatus.PASS, "Other is Selected");
				break;
			case "cat&dog":
			case "dog&cat":
				DogCheckbox.click();
				CatCheckbox.click();
				System.out.println("Dog And Cat are Selected");
				et.log(LogStatus.PASS, "Dog And Cat are Selected");
				break;
			case "other&cat":
			case "cat&other":
				CatCheckbox.click();
				OtherCheckbox.click();
				System.out.println("Cat And Other are Selected");
				et.log(LogStatus.PASS, "Cat And Other are Selected");
				break;
			case "dog&other":
			case "other&dog":
				DogCheckbox.click();
				OtherCheckbox.click();
				System.out.println("Dog And Other are Selected");
				et.log(LogStatus.PASS, "Dog And Other are Selected");
				break;
			case "dog&cat&other":
			case "dog&other&cat":
			case "cat&other&dog":
			case "cat&dog&other":
			case "other&dog&cat":
			case "other&cat&dog":
				DogCheckbox.click();
				CatCheckbox.click();
				OtherCheckbox.click();
				System.out.println("Dog, Cat And Other are Selected");
				et.log(LogStatus.PASS, "Dog, Cat And Other are Selected");
				break;
			default:
				System.err.println("No Pets were selected");
				et.log(LogStatus.FAIL, "No Pets were selected");
				Fail_Count = Fail_Count + 1;
			}

			Price_next.click();

			/*********** VERFYING BACK BUTTON AND VERIFYING SELECTED PETS **********/

			Wait.wait3Second();
			try {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", BackButton);
			} catch (Exception ex) {
				System.out.println(ex);
			}

			/********** Need to Improve the code **********/

			if (DogCheckbox.isSelected() || CatCheckbox.isSelected() || OtherCheckbox.isSelected()) {
				System.out.println("Selected pets are displayed");
				et.log(LogStatus.PASS, "Selected pets are displayed");
			} else {
				System.err.println("Selected pets are not displayed");
				et.log(LogStatus.FAIL, "Selected pets are not displayed");
				Fail_Count = Fail_Count + 1;
			}

			Price_next.click();

		} catch (Exception e) {
			System.err.println(
					"Test Interrupted at DON'T FORGET TO SECURE YOUR PET BEFORE THE CLEANER Page, Error is -->" + e);
		}
	}

	public void When_should_we_start_cleaning() throws InterruptedException {
		try {
			// Wait.Fluentwait(By.xpath("//button[@class='animated btn btn-block
			// btn-inactive fadeInUp']"));
			Wait.wait3Second();

			/*********** PAGE INFO ***********/

			System.out.println("WHEN SHOULD WE START CLEANING Page Appreared");
			et.log(LogStatus.INFO, "WHEN SHOULD WE START CLEANING Page Appreared");

			/***********
			 * VERIFYING DETAILS IN WHEN SHOULD WE START CLEANING PAGE
			 ************/

			Hooks.VerifyByElement(page6Title, LearnHowWeScheduleLink, "SignUp Page 6 Details Verified",
					"SignUp Page 6 Details Differ");
			Wait.wait2Second();

			/*********** VERIFYING LEARN HOW WE SCHEDULE PAGE **********/

			LearnHowWeScheduleLink.click();
			Wait.Fluentwait(By.xpath("(//h3[contains(text(),' We group apartments')])[2]"));
			Hooks.VerifyByElement(LearnHowWeScheduleText, "Learn How We Schedule Text is Verified",
					"Learn How We Schedule Text is not Displayed");
			CloseButton.click();

			/*********** SELECTING SCHEDULE DATE **********/

			Wait.wait2Second();
			try {
				scheduleDate.click();
				System.out.println("Schedule date is selected");
				et.log(LogStatus.PASS, "Schedule date is selected");
			} catch (Exception e) {
				System.err.println("Schedule date is not selected");
				et.log(LogStatus.FAIL, "Schedule date is not selected");
				Fail_Count = Fail_Count + 1;
			}

			ScheduleDate = scheduleDate.getText();

			/************* PAGE VERIFIED ************/

			System.out.println("WHEN SHOULD WE START CLEANING Page is Verified");
			et.log(LogStatus.INFO, "WHEN SHOULD WE START CLEANING Page is Verified");

			/************ PASS COUNT ***********/

			Pass_Count = Pass_Count + 5;

		} catch (Exception e) {
			System.err.println("Test Interrupted at WHEN SHOULD WE START CLEANING Page, Error is -->" + e);
		}

	}

	public void Almost_Finished() throws InterruptedException {
		try {
			Wait.Fluentwait(By.xpath("(//label[contains(text(),'ll be at home ')])[2]"));

			/*********** PAGE INFO ***********/

			System.out.println("ALMOST FINISHED Page Appreared");
			et.log(LogStatus.INFO, "ALMOST FINISHED Page Appreared");

			/**********
			 * VERIFYING NEGATIVE TC'S(CLICKING NEXT BUTTON WITHOUT SELECTING OPTIONS)
			 **********/

			DoYouHavePetsButton.click();

			Finish_Next.click();

			Hooks.VerifyByElement(petsErrorMsg, "Pets Error Message Displayed", "Pets Error Message not Displayed");

			Hooks.VerifyByElement(howToGetIntoYourPlaceErrorMsg, "How To Get Into Your Place Error Message Displayed",
					"How To Get Into Your Place Error Message not Displayed");

			/********** SELECTING GET INTO YOUR PLACE OPTION **********/

			switch (Excel_Read.GetIntoYourPlace) {
			case "I'll be at home":
				Radio_IwillBeAtHome.click();
				System.out.println("I'll be at home is Selected");
				et.log(LogStatus.PASS, "I'll be at home is Selected");
				break;
			case "Leave Key / Fob at Front Desk":
				Radio_LeaveKey_FobatFrontDesk.click();
				System.out.println("Leave Key / Fob at Front Desk is Selected");
				et.log(LogStatus.PASS, "Leave Key / Fob at Front Desk is Selected");
				break;
			case "Keypad/Passcode":
				Radio_Keypad_Passcode.click();
				Finish_Next.click();
				Hooks.VerifyByElement(AdditionalInfoErrorMsg, "Passcode Error Message Displayed",
						"Passcode Error Message not Displayed");
				additonalInstructions.sendKeys("213546");
				System.out.println("Keypad/Passcode is Selected");
				et.log(LogStatus.PASS, "Keypad/Passcode is Selected");
				Pass_Count = Pass_Count + 1;
				break;
			case "Concierge":
				Radio_Concierge.click();
				System.out.println("Concierge is Selected");
				et.log(LogStatus.PASS, "Concierge is Selected");
				break;
			default:
				System.err.println("Any option in 'How to get into your place to clean?' is not selected");
				et.log(LogStatus.FAIL, "Any option in 'How to get into your place to clean?' is not selected");
				Fail_Count = Fail_Count + 1;
			}

			Wait.Fluentwait(By.xpath("(//div[contains(@class,'mat-checkbox-inner')])[1]"));

			/********** SELECTING PET(S) **********/

			switch (Excel_Read.Pets.toLowerCase()) {
			case "dog":
				DogCheckbox.click();
				System.out.println("Dog is Selected");
				et.log(LogStatus.PASS, "Dog is Selected");
				break;
			case "cat":
				CatCheckbox.click();
				System.out.println("Cat is Selected");
				et.log(LogStatus.PASS, "Cat is Selected");
				break;
			case "other":
				OtherCheckbox.click();
				System.out.println("Other is Selected");
				et.log(LogStatus.PASS, "Other is Selected");
				break;
			case "cat&dog":
			case "dog&cat":
				DogCheckbox.click();
				CatCheckbox.click();
				System.out.println("Dog And Cat are Selected");
				et.log(LogStatus.PASS, "Dog And Cat are Selected");
				break;
			case "other&cat":
			case "cat&other":
				CatCheckbox.click();
				OtherCheckbox.click();
				System.out.println("Cat And Other are Selected");
				et.log(LogStatus.PASS, "Cat And Other are Selected");
				break;
			case "dog&other":
			case "other&dog":
				DogCheckbox.click();
				OtherCheckbox.click();
				System.out.println("Dog And Other are Selected");
				et.log(LogStatus.PASS, "Dog And Other are Selected");
				break;
			case "dog&cat&other":
			case "dog&other&cat":
			case "cat&other&dog":
			case "cat&dog&other":
			case "other&dog&cat":
			case "other&cat&dog":
				DogCheckbox.click();
				CatCheckbox.click();
				OtherCheckbox.click();
				System.out.println("Dog, Cat And Other are Selected");
				et.log(LogStatus.PASS, "Dog, Cat And Other are Selected");
				break;
			default:
				System.err.println("No Pets were selected");
				et.log(LogStatus.FAIL, "No Pets were selected");
				Fail_Count = Fail_Count + 1;
			}

			/********** COMPARING PETS IN SUMMARY PAGE **********/

			if (DoYouHavePetsButton.isEnabled() && DogCheckbox.isEnabled()) {
				Pets = "Have Pets";
				System.out.println("Pets are selected");
				et.log(LogStatus.PASS, "Pets are selected");
			} else if (!DoYouHavePetsButton.isEnabled()) {
				Pets = "No Pets";
				System.out.println("No Pets were selected");
				et.log(LogStatus.PASS, "Pets have been selected");
			} else {
				System.err.println("Pets Toggle button Not Worked");
				et.log(LogStatus.FAIL, "Pets Toggle button is not Working");
				Fail_Count = Fail_Count + 1;
			}

			Finish_Next.click();

			/************* PAGE VERIFIED ************/

			System.out.println("ALMOST FINISHED Page is Verified");
			et.log(LogStatus.INFO, "ALMOST FINISHED Page is Verified");

			/************ PASS COUNT ***********/

			Pass_Count = Pass_Count + 16;

		} catch (Exception e) {
			System.err.println("Test Interrupted at WHEN SHOULD WE START CLEANING Page, Error is -->" + e);
		}

	}

	public void SummaryPage() throws InterruptedException {
		Wait.wait5Second();

		try {
			/************* PAGE INFO ************/

			System.out.println("SUMMARY Page Appreared");
			et.log(LogStatus.INFO, "SUMMARY Page Appreared");

			/********** COMPAREING AMOUNT/PRICE **********/

			String ActualPrice = Summary_TotalPrice.getText();
			long ExpectedPriceLong = Math.round(Excel_Read.Total_Pricing);

			String ExpectedPrice = Long.toString(ExpectedPriceLong);

			System.out.println("Actual Price :" + ActualPrice.replace("$", ""));
			System.out.println("Expected Price:" + ExpectedPrice);

			if (ActualPrice.replace("$", "").equals(ExpectedPrice)) {
				System.out.println("Amount Verified");
				et.log(LogStatus.PASS, "Amount Verified");
			} else {
				System.err.println("Amount Differ");
				et.log(LogStatus.FAIL, "Amount Differ");
				Fail_Count = Fail_Count + 1;
			}

			/**********
			 * COMPAREING ADDRESS, UNIT NUMBER, BATHROOM COUNT AND BEDROOM COUNT
			 **********/

			String Address_UnitNumber = SummaryAddressAndUnitNumber.getText();
			String Bedroom_Bathroom = SummaryBed_Bath.getText();

			String[] arr = Address_UnitNumber.split("#");
			String[] arr1 = Bedroom_Bathroom.split("/");

			if (arr[0].contains(Excel_Read.Cleaning_address) && arr[1].equals(Excel_Read.UnitNumber)) {
				System.out.println("Same Address and Unit Number");
			} else {
				System.err.println("Different Address and Unit Number");
			}
			if (arr1[0].contains(Excel_Read.BedroomCount) && arr1[1].equals(Excel_Read.BathroomCount)) {
				System.out.println("Bedroom and Bathroom Count are Same");
			} else {
				System.err.println("Different Bedroom and Bathroom Count");
			}

			/********** COMPARE PENTHOUSE OR TOWNHOUSE **********/

			String ph_Th = Summary_Ph_Th.getText();

			if (Excel_Read.PenthouseOrTownhouse.equals(ph_Th)) {
				if (ph_Th.equals("Yes")) {
					System.out.println("Penthouse or Townhouse is Selected is Yes");
				} else if (ph_Th.equals("No")) {
					System.out.println("Penthouse or Townhouse is Selected is No");
				}
			} else {
				System.err.println("Nothing Displayed");
			}

			/********** COMPAREING TENTATIVE DATE **********/

			String Date = ScheduleDate;
			String[] arr2 = Date.split(",");
			String SummaryDate = TentativeDate.getText();
			String FinalDate = arr2[1].trim();
			String Final_Month = FinalDate.substring(0, 3);
			String Final_Date = FinalDate.substring(FinalDate.length() - 2, FinalDate.length());

			if (SummaryDate.contains(Final_Month) && SummaryDate.contains(Final_Date)) {
				System.out.println("Same Date");
			} else {
				System.err.println("Different Date");
			}

			/********** COMPAREING ACCESS **********/

			String GetIntoPlace = Access.getText();
			if (Excel_Read.GetIntoYourPlace.equals(GetIntoPlace)) {
				System.out.println("Access is same");
			} else {
				System.err.println("Access is Different");
			}

			/********** COMPAREING PET(S) **********/

			String havepets = HavePets.getText();
			if (Pets.equals(havepets)) {
				if (havepets.equals("Have Pets")) {
					System.out.println("Pets are selected");
				} else if (havepets.equals("No Pets")) {
					System.out.println("No Pets were selected");
				}
			} else {
				System.err.println("Pets is not displayed");
			}

			/********** VERIFYING TERMS OF SERVICE **********/

			termsOfService.click();
			Wait.wait5Second();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			String termsOfServiceUrl = driver.getCurrentUrl();
			System.out.println(termsOfServiceUrl);
			if (termsOfServiceUrl.equals("https://www.lapalopa.com/terms-of-service/")) {
				System.out.println("Terms of Service Page Verified");
			} else {
				System.out.println("Did not worked");
				Fail_Count = Fail_Count + 1;
			}
			driver.close();
			driver.switchTo().window(tabs.get(0));
			Wait.wait5Second();
			PayNowButton.click();
			Wait.wait5Second();

			/************* PAGE VERIFIED ************/

			System.out.println("SUMMARY Page is Verified");
			et.log(LogStatus.INFO, "SUMMARY Page is Verified");

			/************ PASS COUNT ***********/

			Pass_Count = Pass_Count + 11;
		} catch (Exception e) {
			System.err.println("Test Interrupted at SUMMARY Page, Error is -->" + e);
		}

	}

	public void DoPayment_Step() throws InterruptedException {
		try {
			try {
				/************* PAGE INFO ************/

				System.out.println("PAYMENT Page Appreared");
				et.log(LogStatus.INFO, "PAYMENT Page Appreared");

				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement FrameLocation = driver.findElement(By.xpath("//iframe[@name='stripe_checkout_app']"));
				driver.switchTo().frame(FrameLocation);
				System.out.println("Entered into Frame");
				Wait.wait3Second();

				/********** Email Verification *********/

				WebElement VerifyEmail = driver.findElement(By.xpath("//span[@class='Header-loggedInEmail']"));
				String Email = VerifyEmail.getText();
				System.out.println(" Email --> " + Email);

				if (Email.contains(Excel_Read.Login_Username)) {
					et.log(LogStatus.PASS, " Email is Verified on Payment Popup");
					System.out.println(" Email is Verified on Payment Popup");
					System.out.println(" Email --> " + Email);

				} else {
					et.log(LogStatus.FAIL, " Expected email is not displayed on Payment Popup ");
					System.err.println(" Wrong Email ");
					Fail_Count = Fail_Count + 1;
				}

				/********** Entering Card Details *********/

				InputCardNumber.sendKeys(Config.CardNumber);
				InputMonthYear.sendKeys(Config.MonthAndYear);
				Enter_CVC.sendKeys(Config.CVC_Number);
				/*
				 * RememberMeCheckBox.click();
				 * Wait.Fluentwait(By.xpath("//span[text()='Terms']"));
				 * 
				 *//************ LOGIC TO VERIFY TERMS **********/
				/*
				 * 
				 * TermsSection.click(); Wait.wait5Second();
				 * 
				 * ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
				 * 
				 * driver.switchTo().window(tabs.get(1)); String
				 * termsUrl=driver.getCurrentUrl(); System.out.println(termsUrl); if
				 * (termsUrl.equals("https://stripe.com/checkout/legal")) {
				 * System.out.println("Terms Page Verified"); } else {
				 * System.out.println("Did not worked"); Fail_Count=Fail_Count+1; }
				 * 
				 * driver.close(); driver.switchTo().window(tabs.get(0)); Wait.wait5Second();
				 * driver.switchTo().frame(FrameLocation);
				 * 
				 *//************ LOGIC TO VERIFY PRIVACY **********/
				/*
				 * 
				 * PrivacySection.click(); Wait.wait5Second();
				 * driver.switchTo().defaultContent(); ArrayList<String> tabs1 = new
				 * ArrayList<String> (driver.getWindowHandles());
				 * driver.switchTo().window(tabs1.get(1)); Wait.wait10Second(); String
				 * privacyUrl=driver.getCurrentUrl(); System.out.println(privacyUrl); if
				 * (privacyUrl.equals("https://stripe.com/privacy")) {
				 * System.out.println("privacy Page Verified"); } else {
				 * System.err.println("Did not worked"); Fail_Count=Fail_Count+1; }
				 * driver.close(); driver.switchTo().window(tabs1.get(0)); Wait.wait5Second();
				 * driver.switchTo().frame(FrameLocation); Wait.wait5Second();
				 * RememberMeCheckBox.click();
				 */
				Wait.wait3Second();
				try {
					UpdateCardDetailsButton.click();
					System.out.println("Update card Detail Worked");
				} catch (Exception e) {
					PayAmountButton.click();
					System.out.println("Paynow Button Worked");
				}
				Wait.wait15Second();
				System.out.println("PAYMENT IS DONE");
			} catch (Exception e) {
				System.out.println("Card details not working, error - >" + e);
				Fail_Count = Fail_Count + 1;
			}
			Wait.wait2Second();

			/********** REMOVED FROM THE APPLICATION *********/

			/*
			 * PayMent_Confirmation_Dashaboard.click(); Wait.wait3Second();
			 */

			/************* PAGE VERIFIED ************/

			System.out.println("PAYMENT Page is Verified");
			et.log(LogStatus.INFO, "PAYMENT Page is Verified");

			/************ PASS COUNT ***********/

			Pass_Count = Pass_Count + 19;
		} catch (Exception e) {
			System.err.println("Test Interrupted at SUMMARY Page, Error is -->" + e);
		}

	}

	public void VerifyOrder_DetailsPage() throws Exception {
		try {
			WebElement VerifyLoginPage = driver.findElement(By.xpath("//h1[text()='Your Cleanings']"));
			String Login_Page = VerifyLoginPage.getText();
			if (Login_Page.contains("Your Cleanings")) {
				et.log(LogStatus.PASS, "Home Page is Displayed");
				System.out.println("Home Page is Displayed");

			} else {
				et.log(LogStatus.FAIL, "Home Page is not Displayed");
				System.err.println("Home Page is not Displayed");
			}
		} catch (Exception e) {
			System.err.println("Your cleanings is not displayed");
		}
		Wait.wait5Second();
		Pass_Count = Pass_Count + 1;
	}

}
