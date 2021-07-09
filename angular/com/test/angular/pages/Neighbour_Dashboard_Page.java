package com.test.angular.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.test.angular.excel.Excel_Read;
import com.test.angular.hooks.Hooks;
import com.test.angular.hooks.Wait;

public class Neighbour_Dashboard_Page extends Hooks {
	public WebDriver driver = null;
	public String PaymentStatus1 = "Completed";
	public String PaymentStatus2 = "Pending";
	public String PaymentStatus3 = "Payment Inprogress";

	public Neighbour_Dashboard_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @@ LOCATORS OF SECTIONS

	@FindBy(xpath = "(//div[@class='col pl-5'])[1]")
	WebElement CleaningSection;

	@FindBy(xpath = "(//div[@class='col pl-5'])[2]")
	WebElement ProfileAndAccountSection;

	@FindBy(xpath = "(//div[@class='col pl-5'])[3]")
	WebElement InviteSection;

	// @@ LOCATORS OF YOUR CLEANING

	@FindBy(xpath = "//h1[text()='Your Cleanings']")
	WebElement YourCleaningTitle;

	@FindBy(xpath = "(//div[@class='handle'])[2]")
	WebElement ShowpreviouscleaningsToggle;

	@FindBy(xpath = "//div[text()=' No previous cleanings ']")
	WebElement Nopreviouscleanings;

	@FindBy(xpath = "//h4[text()='Review and rate']")
	WebElement Reviewandrate;

	@FindBy(xpath = "//h3[@class='mb-4 mt-0 text-white text-center']")
	WebElement YouHaveRated;

	@FindBy(xpath = "(//div[@class='card text-center mt-3 h-100'])[2]")
	WebElement Rateandreview;

	@FindBy(xpath = "(//*[@class='icon icon-ll-icon-star'])[6]")
	WebElement Rating1;

	@FindBy(xpath = "(//*[@class='icon icon-ll-icon-star'])[7]")
	WebElement Rating2;

	@FindBy(xpath = "(//*[@class='icon icon-ll-icon-star'])[8]")
	WebElement Rating3;

	@FindBy(xpath = "(//*[@class='icon icon-ll-icon-star'])[9]")
	WebElement Rating4;

	@FindBy(xpath = "(//*[@class='icon icon-ll-icon-star'])[10]")
	WebElement Rating5;

	@FindBy(xpath = "//*[@class='icon icon-ll-icon-star display-3 text-white']")
	WebElement Rating;

	@FindBy(xpath = "(//button[text()='Microwave'])[2]")
	WebElement MicrowaveTag;

	@FindBy(xpath = "(//button[text()='Sink(s)'])[2]")
	WebElement SinkTag;

	@FindBy(xpath = "(//button[text()='Floors'])[2]")
	WebElement FloorsTag;

	@FindBy(xpath = "(//button[text()='Vaccuming'])[2]")
	WebElement VaccumingTag;

	@FindBy(xpath = "(//button[text()='Shower'])[2]")
	WebElement ShowerTag;

	@FindBy(xpath = "(//button[text()='Next'])[2]")
	WebElement NextButton;

	@FindBy(xpath = "(//textarea[@id='ratingComments'])[2]")
	WebElement AdditionalComments;

	@FindBy(xpath = "(//button[text()='Finish'])[2]")
	WebElement FinishButton;

	@FindBy(xpath = "(//*[@class='icon icon-ll-icon-chev-left'])[4]")
	WebElement Backbutton;

	// @@ LOCATORS OF ADJUST CLEANING

	@FindBy(css = "#desktopAdjustCleanings .col")
	WebElement AdjustCleaningsTab;

	@FindBy(xpath = "//*[text()='Adjust Cleanings']")
	WebElement AdjustCleaningTitle;

	@FindBy(xpath = "(//h3[text()='Next Schedule Not Available'])[2]")
	WebElement NextScheduleNotAvailable;

	// @@ LOCATORS OF SKIP CLEANING

	@FindBy(xpath = "(//button[text()='Skip'])[2]")
	WebElement SkipButton;

	@FindBy(xpath = "//h1[text()='Skip Cleaning']")
	WebElement SkipCleaningTitle;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement SkipThisCleaningButton;

	// @@ LOCATORS OF SUSPEND CLEANING

	@FindBy(id = "suspend1")
	WebElement SuspendButton;

	@FindBy(xpath = "(//*[text()='Extended Travel'])[2]")
	WebElement ExtendedTravelButton;

	@FindBy(xpath = "(//button[@id='orangeSuspendbutton'])[2]")
	WebElement SuspendMyServiceButton;

	@FindBy(xpath = "//button[@id='active1']")
	WebElement ActiveServiceButton;

	// @@ LOCATORS OF NOTIFICATIONS PAGE

	@FindBy(css = "#desktopNotifications .col")
	WebElement NotificationsTab;

	@FindBy(xpath = "//div[@class='row pets ml-1 mr-1']//div[2]//ui-switch[1]//span[1]")
	WebElement CleaningReminderToggle;

	@FindBy(xpath = "//div[@class='col-2 last']//span[@class='switch switch-medium checked']")
	WebElement BeforeandAfterPicturesToggleChecked;

	@FindBy(xpath = "//div[@class='col-2 last']//span[@class='switch switch-medium']")
	WebElement BeforeandAfterPicturesToggleUnchecked;

	// @@ LOCATORS OF BILLING & PAYMENTS

	@FindBy(css = "#desktopNeighborProfile .col")
	WebElement BillingAndPaymentTab;

	@FindBy(xpath = "//h3[text()='We currently take credit cards via Stripe']")
	WebElement Striptitle;

	@FindBy(xpath = "//h4[text()='More options coming soon!']")
	WebElement MoreOptionstitle;

	@FindBy(xpath = "//a[text()='Cleaning Date']")
	WebElement CleanigDateRow;

	@FindBy(xpath = "//a[text()='Payment Date']")
	WebElement PaymentDateRow;

	@FindBy(xpath = "//th[@class='width_5perc']")
	WebElement PriceRow;

	@FindBy(xpath = "(//th[@class='width_8perc'])[1]")
	WebElement PaymentStatusRow;

	@FindBy(xpath = "(//th[@class='width_8perc'])[2]")
	WebElement PaymentTypeRow;

	@FindBy(xpath = "(//th[@class='width_8perc'])[3]")
	WebElement InvoiceRow;

	@FindBy(xpath = "(//th[@class='width_8perc'])[4]")
	WebElement EmailRow;

	@FindBy(xpath = "//tbody//tr[1]//td[4]")
	WebElement PaymentStatus;

	@FindBy(xpath = "//tbody//tr[1]//td[5]//img[1]")
	String StripImg;

	@FindBy(xpath = "//button[text()='Update Billing Method']")
	WebElement UpdateBillingMethodButton;

	@FindBy(xpath = "//button[@class='Button-animationWrapper-child--primary Button']")
	WebElement UpdateCardDetailsButton;

	@FindBy(xpath = "(//a[text()=' Download'])[1]")
	WebElement DownloadInvoice;

	// @@ LOCATORS OF OVERVIEW PAGE

	@FindBy(css = "#neighbordesktopProfileAndAccount .col")
	WebElement OverviewTab;

	@FindBy(css = "#desktopProfileAndAccount .col")
	WebElement OverviewTabCleaner;
	
	@FindBy(xpath = "(//*[contains(text(),'Change')])[2]")
	WebElement ChangePasswordButton;

	@FindBy(xpath = "(//input[@type='password'])[4]")
	WebElement CurrentPassword;

	@FindBy(xpath = "(//input[@type='password'])[5]")
	WebElement NewPassword;

	@FindBy(xpath = "(//input[@type='password'])[6]")
	WebElement ReEnterNewPassword;

	@FindBy(xpath = "(//button[text()='Save'])[1]")
	WebElement PasswordSaveButton;

	@FindBy(xpath = "//div[text()='Password updated successfully.']")
	WebElement Successmessage;
	// UPDATING...

	// @@ LOCATORS OF CLEANING PAGE

	@FindBy(css = "#neighbordesktopCleaningProfile .col")
	WebElement CleaningTab;

	@FindBy(xpath = "(//*[@class='row align-items-center'])[2]")
	WebElement ProfileAndAccountTab;

	@FindBy(xpath = "//*[@class='pt-3 text-center']")
	WebElement CleaningPageTitle;

	@FindBy(xpath = "(//span[@class='switch switch-medium'])[2]")
	WebElement DoYouHavePetsButtonUnchecked;

	@FindBy(xpath = "(//span[@class='switch checked switch-medium'])[2]")
	WebElement DoYouHavePetsButtonChecked;

	@FindBy(xpath = "(//*[@name='deskdogs'])[3]")
	WebElement DogsCheckbox;

	@FindBy(xpath = "(//*[@name='deskcats'])[3]")
	WebElement CatsCheckbox;

	@FindBy(xpath = "(//*[@name='deskothers'])[3]")
	WebElement OtherCheckbox;

	@FindBy(xpath = "(//label[contains(text(),'Leave Key /Key Fob at Front Desk ')])[2]")
	WebElement Radio_LeaveKey;

	@FindBy(xpath = "(//button[text()='Save'])[2]")
	WebElement SaveButton;

	@FindBy(xpath = "//*[text()='Thank You']")
	WebElement ThankYouPage;

	@FindBy(xpath = "(//*[text()='Go Back'])[2]")
	WebElement GoBackButton;

	// @@ METHOD FOR VERIFICATION OF SECTIONS

	public void Sections() throws InterruptedException {
		CleaningSection.isDisplayed();
		ProfileAndAccountSection.isDisplayed();
		InviteSection.isDisplayed();
	}

	// @@ METHOD FOR YOUR CLEANING

	public void YourCleaningPage() throws InterruptedException {
		Wait.wait2Second();
		YourCleaningTitle.isDisplayed();
		System.out.println("Your Title displayed");
		ShowpreviouscleaningsToggle.click();
		System.out.println("Toggle Moved");
		Wait.wait3Second();
		ShowpreviouscleaningsToggle.click();
		Wait.wait3Second();
		try {
			if (Reviewandrate.isDisplayed()) {
				Wait.wait2Second();
				System.out.println("Review And Rate is Displayed");
				et.log(LogStatus.PASS, "Review And Rate is Displayed");
				Rating.click();
				System.out.println("Rate Clicked");
				Rating4.click();
				Wait.wait3Second();
				Wait.fluentWait(MicrowaveTag);

				// NEED TO UPDATE TAGS CODE WITH RESPECT TO CORE

				if (MicrowaveTag.isDisplayed()) {
					MicrowaveTag.click();
				} else if (SinkTag.isDisplayed()) {
					SinkTag.click();
				} else if (FloorsTag.isDisplayed()) {
					FloorsTag.click();
				} else if (VaccumingTag.isDisplayed()) {
					VaccumingTag.click();
				} else if (ShowerTag.isDisplayed()) {
					ShowerTag.click();
				}
				Wait.wait2Second();
				NextButton.click();
				Wait.wait2Second();
				AdditionalComments.sendKeys("Automation Test");
				Wait.wait2Second();
				FinishButton.click();
				Wait.wait5Second();
			}
		} catch (Exception e) {
			System.out.println("Review and rate is not working");
		}

		try {
			if (YouHaveRated.isDisplayed()) {
				System.out.println("You've Rated is Displayed");
				et.log(LogStatus.PASS, "You've Rated is Displayed");
			}
		} catch (Exception e) {
			System.out.println("You've rated is not working");
		}
		try {
			if (Nopreviouscleanings.isDisplayed()) {
				System.out.println("NO Previous Cleaning");
				et.log(LogStatus.PASS, "NO Previous Cleaning");
			}
		} catch (Exception e) {
			System.out.println("No Previous Cleanings is not working");
		}

		// UPDATING..(Comparing Rating)
	}

	// @@ METHOD FOR ADJUST CLEANING

	public void AdjustCLeaningPage() throws InterruptedException {
		AdjustCleaningsTab.click();
		Wait.wait2Second();
		AdjustCleaningTitle.isDisplayed();
	}

	// @@ METHOD FOR SUSPEND CLEANING

	public void SuspendCleaning() throws InterruptedException {
		SuspendButton.click();
		Wait.wait2Second();
		ExtendedTravelButton.click();
		SuspendMyServiceButton.click();
		Wait.wait5Second();
		ActiveServiceButton.click();
		Wait.wait3Second();
	}

	// @@ METHOD FOR SKIP CLEANING

	public void SkipCleaning() throws InterruptedException {
		try {
			if (NextScheduleNotAvailable.isDisplayed()) {
				System.out.println("Next Schedule Not Available is displayed");
			}
		} catch (Exception e) {
			Wait.wait2Second();
			SkipButton.click();
			Wait.wait2Second();
			SkipCleaningTitle.isDisplayed();
			SkipThisCleaningButton.click();
			Wait.wait2Second();
			AdjustCleaningTitle.isDisplayed();
		}

	}

	// @@ METHOD FOR NOTIFICATIONS PAGE

	public void NotificationsPage() throws InterruptedException {
		NotificationsTab.click();
		Wait.wait2Second();
		CleaningReminderToggle.click();
		Wait.wait2Second();
	}

	// @@ METHOD FOR BILLING & PAYMENTS PAGE

	public void BillingAndPaymentPage() throws InterruptedException {
		BillingAndPaymentTab.click();
		Wait.wait2Second();
		if (Striptitle.isDisplayed() && MoreOptionstitle.isDisplayed() && CleanigDateRow.isDisplayed()
				&& PaymentDateRow.isDisplayed() && PriceRow.isDisplayed() && PaymentStatusRow.isDisplayed()
				&& PaymentTypeRow.isDisplayed() && InvoiceRow.isDisplayed() && EmailRow.isDisplayed()) {
			System.out.println("Billing & Payment Page Verified");
			et.log(LogStatus.PASS, "Billing & Payment Page is Verified");
		} else {
			System.err.println("Billing & Payment Page Verification Failed");
			et.log(LogStatus.FAIL, "Billing & Payment Page Verification Failed");
		}

		String PaymentStatusStr = PaymentStatus.getText();
		System.out.println(PaymentStatusStr);
		if (PaymentStatusStr.contains(PaymentStatus1) || PaymentStatusStr.contains(PaymentStatus2)
				|| PaymentStatusStr.contains(PaymentStatus3)) {
			System.out.println("Payment Status is : " + PaymentStatusStr);
		}
		UpdateBillingMethodButton.click();
		// UPDATING.. (SUCCESS MESSAGE)
	}

	// @@ METHOD FOR OVERVIEW PAGE

	public void overviewPage() throws InterruptedException {
		try {
			OverviewTab.click();	
		} catch (Exception e) {
			OverviewTabCleaner.click();
		}
		
	}

	// @@ METHOD FOR CHANGE PASSWORD

	public void ChangePasswordPage() throws InterruptedException {
		ChangePasswordButton.click();
		CurrentPassword.sendKeys(Excel_Read.Login_Password);
		NewPassword.sendKeys(Excel_Read.Login_Password);
		ReEnterNewPassword.sendKeys(Excel_Read.Login_Password);
		PasswordSaveButton.click();
		// UPDATING....(Success Message)
	}

	// @@ METHOD FOR CLEANING PAGE

	public void CleaningProfile() throws InterruptedException {
		try {
			Wait.wait2Second();
			ProfileAndAccountTab.click();
			CleaningTab.click();
		} catch (Exception e) {
			Wait.wait2Second();
			CleaningTab.click();
		}
		Wait.wait2Second();
		try {
			DoYouHavePetsButtonUnchecked.click();
			Wait.wait2Second();
			DogsCheckbox.click();
			CatsCheckbox.click();
			OtherCheckbox.click();
		} catch (Exception e) {
			DoYouHavePetsButtonChecked.click();
		}

		Radio_LeaveKey.click();
		SaveButton.click();
		Wait.wait2Second();
		ThankYouPage.isDisplayed();
		GoBackButton.click();
		YourCleaningTitle.isDisplayed();
	}
}
