package EngrowRo_app;

import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Conatusro_app {


	public static void main(String[] args) throws Exception {

		
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "realme C3");
		cap.setCapability("udid", "9TUCGYG6F6SSYPSC");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11.0");
		//Conatus Ro app
		cap.setCapability("appPackage", "com.sensei.engrow.conatus.ro.debug");
		cap.setCapability("appActivity", "com.sensei.engrow.MainActivity");
		cap.setCapability("noReset", "true");
		
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		RO_Lead.driver = new AppiumDriver<MobileElement>(url, cap);
		RO_Lead.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		try {
			// Enter userName
			RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/input_name")).sendKeys("cfs1234");
			// Enter Password
			RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/input_password")).sendKeys("Engrow@1");
			// Click on sign in
			RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/button_login")).click();
			System.out.println("Login Successful");
		} catch (Exception e) {
			System.out.println("Device already logged in");
		}
				
		// Click on applications
		RO_Lead.driver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']")).click();
		// Click on first application
		RO_Lead.driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[0,367][720,537]']")).click();
		//Click on required application
//		RO_Lead.driver.findElement(By.xpath("//android.widget.FrameLayout[@index='5']")).click();
//		 Business
	businessdetails();	
	businesskyc();
	businessaddress();
	businessdocuments();
	businessreference();
//		 Application
		applicantdetails();
		applicantkyc();
		applicantaddress();
		applicantBankAccount();
		applicantdocuments();
		applicantreference();
		Coapplicantdetails();
		Coapplicantkyc();
		Coapplicantaddress();
		Collateral();
		Syncapplication();
	}

	public static void businessdetails() {

		// Click on Business
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='BUSINESS']")).click();
		// Select on DateOfIncorporation
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etDateOfIncorporation")).click();
		RO_Lead.driver.findElement(By.id("android:id/button1")).click();
		// click on FORM 60/61
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/rbForm60")).click();
		// Scroll upto annual turnover
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"ANNUAL TURNOVER\"));"));

		// Select IndustryType
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spIndustryType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Trading']")).click();
		// Select Constitution
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spConstitution")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Individual']")).click();
		// Select AnnualTurnover
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spAnnualTurnover")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='10-25 Lakhs']")).click();
		// Scroll upto working day per week
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"WORKING HOUR PER WEEK\"));"));

		// Enter NoOfEmployees
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etNoOfEmployees")).sendKeys("5");
		// Select BusinessStructure
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spBusinessStructure")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Fixed Shop']")).click();
		// Click on YES
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/rbYes")).click();
		// click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
	}

	public static void businesskyc() {

		// Click on Business
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='BUSINESS']")).click();
		// Click on Kyc proof
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvKycProofs")).click();
		// Select Document Proof
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spKycProof")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Bank Statement']")).click();
		// click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
		// Click on Kyc proof
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Bank Statement']")).click();
		// Scroll down and click on camera
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"KYC DOCUMENT PICTURE\"));"))
				.click();
		// saving image
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/imgCapture")).click();
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/crop_image_menu_crop")).click();
		// click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
	}

	public static void businessaddress() {
		String Address = "Cross Road";
		String Pincode = "847568";
		String Landmark = "Panruti";

		String state = "Tamilnadu";
		String District = "Chennai";
		String City = "Chennai";

		String PropertyOwnership = "Owned";

		// Click on Address
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvAddresss")).click();
		// Select address type
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spAddressType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Business Address']")).click();
		// Enter the Address
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etAddressLine1")).sendKeys(Address);
		// Enter the Pin Code
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etPinCode")).sendKeys(Pincode);
		// Enter the Land Mark
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etLandMark")).sendKeys(Landmark);
		// Scroll upto district
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"DISTRICT\"));"));
		// Select the Country
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spCountry")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		// Select State
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spState")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + state + "']")).click();
		// Select District
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spDistrict")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + District + "']")).click();
		// Select City
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spCity")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + City + "']")).click();
		// Scroll down
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"PROPERTY OWNERSHIP\"));"));
		// Click on DurationOfStay
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spDurationOfStay")).sendKeys("10");
		// Select Property Ownership
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spPropertyOwnership")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + PropertyOwnership + "']")).click();
		// Click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
	}

	public static void businessdocuments() {
		
		// Scroll down
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
		// Click on documents
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvDocumentss")).click();
		// Select document
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spDocumentsType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Business Premise Photo']")).click();
		// Click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
		// Scroll down
				RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
		// Click on documents
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvDocumentType")).click();
		// Capture the image
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvDocumentPicture")).click();
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/imgCapture")).click();
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/crop_image_menu_crop")).click();
		// Click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
	}

	public static void businessreference() throws Exception {

		

		for (int i = 0; i < 2; i++) {
			// Scroll down
			RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
			Thread.sleep(5000);
			// Click on Reference
			RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvReferences")).click();

			ArrayList<String> type = new ArrayList<String>();
			type.add("Buyer");
			type.add("Seller");
			// Names
			type.add("ramesh");
			type.add("rishi");
			// select Reference type
			RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spReferenceType")).click();
			RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + type.get(i) + "']")).click();

			// Enter the name
			RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etName")).sendKeys(type.get(i + 2));
			// Enter the mobile number
			RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etMobileNumber")).sendKeys("9584751568");
			// Click on save
			RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
		}
		//Click on Back Page
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/backArrow")).click();
	}

	public static void applicantdetails() {
		String relationship = "Partner";
		String first_name = "Vimal";
		String last_name = "s";
		String name = first_name+" " + last_name;
		String mobile_number = "7013797487";
		String DOB = "25-01-1985";
		String Email = "suneel.kumar@sen-sei.in";

		// Click on Application
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvApplicant")).click();
		try {
		// Click on name and contact
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvNameAndContact")).click();
		}catch (Exception e) {
			}
		// Select the Relationship type
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spinnerApplicantType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + relationship + "']")).click();
		// Capture the image
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvClickImage")).click();
		// saving image
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/imgCapture")).click();
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveImage")).click();
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/crop_image_menu_crop")).click();
		// Select Title
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spinnerTitle")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Mr']")).click();
		// Enter Name
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etName")).sendKeys(name);
		// Enter first name
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etFirstName")).sendKeys(first_name);
		// Scroll upto Gender
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"GENDER\"));"));
		// Enter last name
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etLastName")).sendKeys(last_name);
		// Select DOB
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etDOB")).sendKeys(DOB);

		// select Gender
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spinnerGender")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Male']")).click();

		// Scroll upto Email
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"EMAIL\"));"));
		// Enter the Mobile number
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etPhoneNumber")).sendKeys(mobile_number);
		// Enter the Email
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etEmail")).sendKeys(Email);
		// Click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();

	}

	public static void applicantkyc() {
		try {
		// Click on Application
				RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvApplicant")).click();
		}catch (Exception e) {}
		// Scroll upto Reference
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
		// Click on Kyc proof
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvKycProofs")).click();
		// Select Document Proof
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spKycProof")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Passport']")).click();
		// click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
		// Click on Kyc proof
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Passport']")).click();
		// Scroll down and click on camera
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"KYC DOCUMENT PICTURE\"));"))
				.click();
		// saving image
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/imgCapture")).click();
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/crop_image_menu_crop")).click();
		// click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
	}

	public static void applicantaddress() {
		String Address = "Cross Road";
		String Pincode = "847568";
		String Landmark = "Panruti";

		String state = "Tamil Nadu";
		String District = "Chennai";
		String City = "Chennai";

		
		// Scroll upto Reference
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));

		// Click on Address
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvAddress")).click();
		// Select address type
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spAddressType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Permanent']")).click();
		// Enter the Address
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etAddressLine1")).sendKeys(Address);
		// Enter the Pin Code
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etPinCode")).sendKeys(Pincode);
		// Enter the Land Mark
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etLandMark")).sendKeys(Landmark);
		// Scroll upto district
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"DISTRICT\"));"));
		// Select the Country
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spCountry")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		// Select State
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spState")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + state + "']")).click();
		// Select District
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spDistrict")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + District + "']")).click();
		// Select City
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spCity")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + City + "']")).click();
		// Click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
	}

	public static void applicantBankAccount() {
		String AccountNumber = "754844864";
		String AccountHolderName = "Mahesh";
		String BankName = "Axis";
		String BranchName = "BLR";
		String BankYears = "10";

		
		// Scroll upto Reference
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
		// Click on Bank Accounts
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvBankAccounts")).click();
		// Scroll last
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"BANKING SINCE (YEARS)\"));"));
		// Select Account Type
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spAccountType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Savings']")).click();
		// Enter Account number
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etAccountNumber")).sendKeys(AccountNumber);
		// Enter Account Holder Name
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etAccountHolderName"))
				.sendKeys(AccountHolderName);
		// Enter Bank Name
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etBankName")).sendKeys(BankName);
		// Enter Branch Name
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etBranchName")).sendKeys(BranchName);
		// Enter Bank since years
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spBankingSince")).sendKeys(BankYears);
		// Click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();

	}

	public static void applicantdocuments() {
		
		// Scroll down
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
		// Click on documents
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvDocuments")).click();
		// Select document
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spDocumentsType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='House Photo']")).click();
		// Click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
		
		// Scroll down
				RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
		// Click on documents
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='House Photo']")).click();
		// Capture the image
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvDocumentPicture")).click();
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/imgCapture")).click();
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/crop_image_menu_crop")).click();
		// Click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
	}

	public static void applicantreference() throws Exception {

		

		for (int i = 0; i < 2; i++) {
			// Scroll down
			RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
			Thread.sleep(5000);
			// Click on Reference
			RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvReferences")).click();

			ArrayList<String> type = new ArrayList<String>();
			type.add("Friend");
			type.add("Family");
			// Names
			type.add("ramesh");
			type.add("riya");
			// select Reference type
			RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spReferenceType")).click();
			RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + type.get(i) + "']")).click();

			// Enter the name
			RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etName")).sendKeys(type.get(i + 2));
			// Enter the mobile number
			RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etMobileNumber")).sendKeys("9584751568");
			// Click on save
			RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
		}
		//Click on Back Page
				RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/backArrow")).click();
	}
	//co-applicant mobile number
	static String mobile_number = "7845651258";

	public static void Coapplicantdetails() {
		String relationship = "Son";
		String first_name = "shri";
		String last_name = "G";
		String name = first_name + " " + last_name;

		String DOB = "25-01-1975";
		String Email = "suneel.kumar@sen-sei.in";

		// Click on Co-Application
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvCoApplicant")).click();
		// Select the Relationship type to applicant
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spinnerApplicantType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + relationship + "']")).click();
		// Capture the image
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvClickImage")).click();
		// saving image
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/imgCapture")).click();
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveImage")).click();
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/crop_image_menu_crop")).click();
		// Select Title
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spinnerTitle")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Ms']")).click();
		// Enter Name
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etName")).sendKeys(name);
		// Enter first name
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etFirstName")).sendKeys(first_name);
		// Scroll upto Gender
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"GENDER\"));"));
		// Enter last name
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etLastName")).sendKeys(last_name);
		// Select DOB
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etDOB")).sendKeys(DOB);

		// select Gender
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spinnerGender")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Female']")).click();

		// Scroll upto Email
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"EMAIL\"));"));
		// Enter the Mobile number
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etPhoneNumber")).sendKeys(mobile_number);
		// Enter the Email
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etEmail")).sendKeys(Email);
		// Click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();

	}

	public static void Coapplicantkyc() {
		
		// Scroll upto check and sync
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"CHECK & SYNC\"));"));
		// Click on 1st Co-Application
				RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + mobile_number + "']")).click();
		// Scroll upto Reference
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
		// Click on Kyc proof
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvKycProofs")).click();
		// Select Document Proof
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spKycProof")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Driving Licence']")).click();
		// click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
		// Click on Kyc proof
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Driving Licence']")).click();
		// Scroll down and click on camera
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"KYC DOCUMENT PICTURE\"));"))
				.click();
		// saving image
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/imgCapture")).click();
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/crop_image_menu_crop")).click();
		// click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
	}

	public static void Coapplicantaddress() {
		String Address = "Cross Road";
		String Pincode = "847568";
		String Landmark = "Panruti";

		String state = "Tamil Nadu";
		String District = "Chennai";
		String City = "Chennai";

		
		// Scroll upto Reference
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));

		// Click on Address
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvAddress")).click();
		// Select address type
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spAddressType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Permanent']")).click();
		// Enter the Address
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etAddressLine1")).sendKeys(Address);
		// Enter the Pin Code
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etPinCode")).sendKeys(Pincode);
		// Enter the Land Mark
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etLandMark")).sendKeys(Landmark);
		// Scroll upto district
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"DISTRICT\"));"));
		// Select the Country
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spCountry")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		// Select State
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spState")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + state + "']")).click();
		// Select District
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spDistrict")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + District + "']")).click();
		// Select City
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/spCity")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + City + "']")).click();
		// Click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
		//Click on Back Page
				RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/backArrow")).click();
	}

	public static void Collateral() {
		String Address = "Fruit Market";
		String collateral_type = "SOCP Non RCC roofing";
		String collateral_usedfor = "Self";
		String market_value = "584759";
		// Scroll to last
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"CHECK & SYNC\"));"));
		// Click on Collateral
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/tvCollaterals")).click();
		// Select collateral type
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/collateralTypeSpinner")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + collateral_type + "']")).click();
		// Select collateral used for
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/collateralUsedForSpinner")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + collateral_usedfor + "']")).click();
		// Collateral address
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etAddressLine1")).sendKeys(Address);
		// Select Collateral owned by
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/collateralOwnedBySpinner")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.CheckedTextView[@index='1']")).click();
		// Scroll fair market value
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"FAIR MARKET VALUE\"));"));
		// Enter fair market value
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/etFairMarketValue")).sendKeys(market_value);
		// Click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/saveButton")).click();
	}

	public static void Syncapplication() throws Exception {
		// Scroll to last and click sync
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"CHECK & SYNC\"));")).click();
		//Click on File verification
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/fileVerification")).click();
		//Click on Sync Application
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/syncApplication")).click();
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/syncApplicationButton")).click();
		Thread.sleep(5000);
		//Click on OTP verification
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.conatus.ro.debug:id/otpVerification")).click();
		
	
	
	}
	
	// RO_Lead.driver.findElement(By.id("")).click();

}
