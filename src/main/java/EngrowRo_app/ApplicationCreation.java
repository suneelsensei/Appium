package EngrowRo_app;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;


public class ApplicationCreation {

	// Collateral required with Product type
	static List<String> alltypes = Arrays.asList("Secured","Quasi","Secured NIP","Surrogate","Quasi NIP","Secured Low LTV");
	
	// Bussiness address
	static String Address = "Cross Road";
	static String Pincode = "847568";
	static String Landmark = "Panruti";
	static String state = "Tamil Nadu";
	static String District = "Chennai";
	static String City = "Chennai";
	static String PropertyOwnership = "Owned";
	
	//Business reference
	static ArrayList<String> type = new ArrayList<String>();
	static {
	type.add("Buyer");
	type.add("Seller");
	// Names
	type.add("ramesh");
	type.add("rishi");
		}
	
	static List<String> app_type =Arrays.asList("Friend","Family","ramesh","riya");
	

	// Applicant details
	static String relationship = "Partner";
	static String first_name = "jenny";
	static String last_name = "s";
	public static String name =first_name+ " " +last_name;
	static String app_mobile_number = "7013797487";
	static String DOB = "25-01-1985";
	static String Email = "suneel.kumar@sen-sei.in";

	// Applicant address
	static String app_Address = "Cross Road";
	static String app_Pincode = "847568";
	static String app_Landmark = "Panruti";
	static String app_state = "Tamil Nadu";
	static String app_District = "Chennai";
	static String app_City = "Chennai";

	// Applicant Bank details
	static String AccountNumber = "754844864";
	static String AccountHolderName = "jenny";
	static String BankName = "Axis";
	static String BranchName = "BLR";
	static String BankYears = "10";

	// Co-applicant details
	static String Coapp_relationship = "Other";
	static String Coapp_first_name = "krishna";
	static String Coapp_last_name = "G";
	static String Coapp_name = Coapp_first_name + " " + Coapp_last_name;
	static String Coapp_DOB = "25-01-1975";
	static String Coapp_Email = "suneel.kumar@sen-sei.in";
	static String Coapp_mobile_number = "7845651258";

	// Co-applicant Address
	static String Coapp_Address = "Cross Road";
	static String Coapp_Pincode = "847568";
	static String Coapp_Landmark = "Panruti";
	static String Coapp_state = "Tamil Nadu";
	static String Coapp_District = "Chennai";
	static String Coapp_City = "Chennai";

	// Collateral
	static String Collateral_Address = "Fruit Market";
	static String collateral_type = "Residential Plan Approved";
	static String collateral_usedfor = "Self";
	static String market_value = "584759";

	
	public static void main(String[] args) throws Exception {
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "realme C3");
		cap.setCapability("udid", "9TUCGYG6F6SSYPSC");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11.0");
		// Conatus Ro app
//		cap.setCapability("appPackage", "com.sensei.engrow.conatus.ro.debug");
//		cap.setCapability("appActivity", "com.sensei.engrow.MainActivity");

		// Ro app
		cap.setCapability("appPackage", "com.sensei.engrow.ro.debug");
		cap.setCapability("appActivity", "com.sensei.engrow.MainActivity");
		cap.setCapability("noReset", "true");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		RO_Lead.driver = new AppiumDriver<MobileElement>(url, cap);
		RO_Lead.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {
			// Enter userName
			RO_Lead.driver.findElement(By.id(RO_Lead.id  + "input_name")).sendKeys("100013");
			// Enter Password
			RO_Lead.driver.findElement(By.id(RO_Lead.id  + "input_password")).sendKeys("Engrow@1");
			// Click on sign in
			RO_Lead.driver.findElement(By.id(RO_Lead.id  + "button_login")).click();
			System.out.println("Login Successful");
		} catch (Exception e) {
			System.out.println("Device already logged in");
		}
		// Creating the Lead
		RO_Lead.leadCreation();
		AfterSaveLead.applicationgeneration();

		// Click on applications
		RO_Lead.driver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']")).click();
		// Click on first application
		RO_Lead.driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[0,367][720,537]']")).click();
		// Click on required application
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

		for (String types : alltypes) {

			if ((RO_Lead.Product_type).equals(types)) {
				Collateral();
			}
		}

		Syncapplication();
		OTPverification();
	}

	public static void businessdetails() {

		// Click on Business
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='BUSINESS']")).click();
		// Select on DateOfIncorporation
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etDateOfIncorporation")).click();
		RO_Lead.driver.findElement(By.id("android:id/button1")).click();
		// click on FORM 60/61
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "rbForm60")).click();
		// Scroll upto annual turnover
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"ANNUAL TURNOVER\"));"));

		// Select IndustryType
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spIndustryType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Trading']")).click();
		// Select Constitution
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spConstitution")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Individual']")).click();
		// Select AnnualTurnover
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spAnnualTurnover")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='10-25 Lakhs']")).click();
		// Scroll upto working day per week
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"WORKING HOUR PER WEEK\"));"));

		// Enter NoOfEmployees
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etNoOfEmployees")).sendKeys("5");
		// Select BusinessStructure
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spBusinessStructure")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Fixed Shop']")).click();
		// Click on YES
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "rbYes")).click();
		// click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();
	}

	public static void businesskyc() {

		// Click on Business
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='BUSINESS']")).click();
		// Click on Kyc proof
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvKycProofs")).click();
		// Select Document Proof
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spKycProof")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Bank Statement']")).click();
		// click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();
		// Click on Kyc proof
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Bank Statement']")).click();
		// Scroll down and click on camera
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"KYC DOCUMENT PICTURE\"));"))
				.click();
		// saving image
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "imgCapture")).click();
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "crop_image_menu_crop")).click();
		// click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();
	}

	public static void businessaddress() {

		// Click on Address
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvAddresss")).click();
		// Select address type
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spAddressType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Business Address']")).click();
		// Enter the Address
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etAddressLine1")).sendKeys(Address);
		// Enter the Pin Code
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etPinCode")).sendKeys(Pincode);
		// Enter the Land Mark
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etLandMark")).sendKeys(Landmark);
		// Scroll upto district
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"DISTRICT\"));"));
		// Select the Country
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spCountry")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		// Select State
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spState")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + state + "']")).click();
		// Select District
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spDistrict")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + District + "']")).click();
		// Select City
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spCity")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + City + "']")).click();
		// Scroll down
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"PROPERTY OWNERSHIP\"));"));
		// Click on DurationOfStay
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spDurationOfStay")).sendKeys("10");
		// Select Property Ownership
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spPropertyOwnership")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + PropertyOwnership + "']")).click();
		// Click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();
	}

	public static void businessdocuments() {

		// Scroll down
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
		// Click on documents
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvDocumentss")).click();
		// Select document
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spDocumentsType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Business Premise Photo']")).click();
		// Click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();
		// Scroll down
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
		// Click on documents
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvDocumentType")).click();
		// Capture the image
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvDocumentPicture")).click();
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "imgCapture")).click();
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "crop_image_menu_crop")).click();
		// Click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();
	}

	public static void businessreference() throws Exception {

		for (int i = 0; i < 2; i++) {
			// Scroll down
			RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
			Thread.sleep(5000);
			// Click on Reference
			RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvReferences")).click();


			// select Reference type
			RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spReferenceType")).click();
			RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + type.get(i) + "']")).click();

			// Enter the name
			RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etName")).sendKeys(type.get(i + 2));
			// Enter the mobile number
			RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etMobileNumber")).sendKeys("9584751568");
			// Click on save
			RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();
		}
		// Click on Back Page
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "backArrow")).click();
	}

	public static void applicantdetails() {

		// Click on Application
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvApplicant")).click();
		try {
			// Click on name and contact
			RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvNameAndContact")).click();
		} catch (Exception e) {
		}
		// Select the Relationship type
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spinnerApplicantType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + relationship + "']")).click();
		// Capture the image
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvClickImage")).click();
		// saving image
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "imgCapture")).click();
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveImage")).click();
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "crop_image_menu_crop")).click();
		// Select Title
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spinnerTitle")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Mr']")).click();
		// Enter Name
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etName")).sendKeys(name);
		// Enter first name
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etFirstName")).sendKeys(first_name);
		// Scroll upto Gender
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"GENDER\"));"));
		// Enter last name
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etLastName")).sendKeys(last_name);
		// Select DOB
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etDOB")).sendKeys(DOB);

		// select Gender
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spinnerGender")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Male']")).click();

		// Scroll upto Email
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"EMAIL\"));"));
		// Enter the Mobile number
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etPhoneNumber")).sendKeys(app_mobile_number);
		// Enter the Email
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etEmail")).sendKeys(Email);
		// Click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();

	}

	public static void applicantkyc() {
		try {
			// Click on Application
			RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvApplicant")).click();
		} catch (Exception e) {
		}
		// Scroll upto Reference
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
		// Click on Kyc proof
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvKycProofs")).click();
		// Select Document Proof
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spKycProof")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Passport']")).click();
		// click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();
		// Click on Kyc proof
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Passport']")).click();
		// Scroll down and click on camera
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"KYC DOCUMENT PICTURE\"));"))
				.click();
		// saving image
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "imgCapture")).click();
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "crop_image_menu_crop")).click();
		// click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();
	}

	public static void applicantaddress() {

		// Scroll upto Reference
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));

		// Click on Address
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvAddress")).click();
		// Select address type
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spAddressType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Permanent']")).click();
		// Enter the Address
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etAddressLine1")).sendKeys(app_Address);
		// Enter the Pin Code
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etPinCode")).sendKeys(app_Pincode);
		// Enter the Land Mark
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etLandMark")).sendKeys(app_Landmark);
		// Scroll upto district
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"DISTRICT\"));"));
		// Select the Country
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spCountry")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		// Select State
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spState")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + app_state + "']")).click();
		// Select District
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spDistrict")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + app_District + "']")).click();
		// Select City
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spCity")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + app_City + "']")).click();
		// Click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();
	}

	public static void applicantBankAccount() {

		// Scroll upto Reference
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
		// Click on Bank Accounts
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvBankAccounts")).click();
		// Scroll last
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"BANKING SINCE (YEARS)\"));"));
		// Select Account Type
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spAccountType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Savings']")).click();
		// Enter Account number
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etAccountNumber")).sendKeys(AccountNumber);
		// Enter Account Holder Name
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etAccountHolderName")).sendKeys(AccountHolderName);
		// Enter Bank Name
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etBankName")).sendKeys(BankName);
		// Enter Branch Name
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etBranchName")).sendKeys(BranchName);
		// Enter Bank since years
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spBankingSince")).sendKeys(BankYears);
		// Click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();

	}

	public static void applicantdocuments() {

		// Scroll down
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
		// Click on documents
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvDocuments")).click();
		// Select document
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spDocumentsType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='House Photo']")).click();
		// Click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();

		// Scroll down
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
		// Click on documents
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='House Photo']")).click();
		// Capture the image
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvDocumentPicture")).click();
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "imgCapture")).click();
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "crop_image_menu_crop")).click();
		// Click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();
	}

	public static void applicantreference() throws Exception {

		for (int i = 0; i < 2; i++) {
			// Scroll down
			RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
			Thread.sleep(5000);
			// Click on Reference
			RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvReferences")).click();

			
			// select Reference type
			RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spReferenceType")).click();
			RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + app_type.get(i) + "']")).click();

			// Enter the name
			RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etName")).sendKeys(app_type.get(i + 2));
			// Enter the mobile number
			RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etMobileNumber")).sendKeys("9584751568");
			// Click on save
			RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();
		}
		// Click on Back Page
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "backArrow")).click();
	}

	public static void Coapplicantdetails() {

		// Click on Co-Application
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvCoApplicant")).click();
		// Select the Relationship type to applicant
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spinnerApplicantType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + Coapp_relationship + "']")).click();
		// Capture the image
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvClickImage")).click();
		// saving image
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "imgCapture")).click();
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveImage")).click();
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "crop_image_menu_crop")).click();
		// Select Title
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spinnerTitle")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Ms']")).click();
		// Enter Name
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etName")).sendKeys(Coapp_name);
		// Enter first name
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etFirstName")).sendKeys(Coapp_first_name);
		// Scroll upto Gender
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"GENDER\"));"));
		// Enter last name
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etLastName")).sendKeys(Coapp_last_name);
		// Select DOB
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etDOB")).sendKeys(Coapp_DOB);

		// select Gender
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spinnerGender")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Female']")).click();

		// Scroll upto Email
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"EMAIL\"));"));
		// Enter the Mobile number
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etPhoneNumber")).sendKeys(Coapp_mobile_number);
		// Enter the Email
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etEmail")).sendKeys(Coapp_Email);
		// Click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();

	}

	public static void Coapplicantkyc() {

		// Scroll upto check and sync
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"CHECK & SYNC\"));"));
		// Click on 1st Co-Application
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + Coapp_mobile_number + "']")).click();
		// Scroll upto Reference
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));
		// Click on Kyc proof
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvKycProofs")).click();
		// Select Document Proof
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spKycProof")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Driving Licence']")).click();
		// click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();
		// Click on Kyc proof
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Driving Licence']")).click();
		// Scroll down and click on camera
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"KYC DOCUMENT PICTURE\"));"))
				.click();
		// saving image
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "imgCapture")).click();
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "crop_image_menu_crop")).click();
		// click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();
	}

	public static void Coapplicantaddress() {

		// Scroll upto Reference
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"REFERENCES\"));"));

		// Click on Address
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvAddress")).click();
		// Select address type
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spAddressType")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='Permanent']")).click();
		// Enter the Address
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etAddressLine1")).sendKeys(Coapp_Address);
		// Enter the Pin Code
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etPinCode")).sendKeys(Coapp_Pincode);
		// Enter the Land Mark
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etLandMark")).sendKeys(Coapp_Landmark);
		// Scroll upto district
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"DISTRICT\"));"));
		// Select the Country
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spCountry")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		// Select State
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spState")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + Coapp_state + "']")).click();
		// Select District
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spDistrict")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + Coapp_District + "']")).click();
		// Select City
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "spCity")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + Coapp_City + "']")).click();
		// Click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();
		// Click on Back Page
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "backArrow")).click();
	}

	public static void Collateral() {

		// Scroll to last
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"CHECK & SYNC\"));"));
		// Click on Collateral
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "tvCollaterals")).click();
		// Select collateral type
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "collateralTypeSpinner")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + collateral_type + "']")).click();
		// Select collateral used for
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "collateralUsedForSpinner")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.TextView[@text='" + collateral_usedfor + "']")).click();
		// Collateral address
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etAddressLine1")).sendKeys(Collateral_Address);
		// Select Collateral owned by
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "collateralOwnedBySpinner")).click();
		RO_Lead.driver.findElement(By.xpath("//android.widget.CheckedTextView[@index='1']")).click();
		// Scroll fair market value
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"FAIR MARKET VALUE\"));"));
		// Enter fair market value
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "etFairMarketValue")).sendKeys(market_value);
		// Click on save
		RO_Lead.driver.findElement(By.id(RO_Lead.id  + "saveButton")).click();
	}

	public static void Syncapplication() throws Exception {
		// Scroll to last and click sync
		RO_Lead.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"CHECK & SYNC\"));"))
				.click();
		// Click on File verification
		RO_Lead.driver.findElement(By.id(RO_Lead.id + "fileVerification")).click();
		// Click on Sync Application
		RO_Lead.driver.findElement(By.id(RO_Lead.id + "syncApplication")).click();
		RO_Lead.driver.findElement(By.id(RO_Lead.id + "syncApplicationButton")).click();
		Thread.sleep(5000);
		// Click on OTP verification
		RO_Lead.driver.findElement(By.id(RO_Lead.id + "otpVerification")).click();

	}

	public static void OTPverification() throws Exception {
		Thread.sleep(2000);
		//click on Get OTP
		RO_Lead.driver.findElement(By.id( RO_Lead.id+"sendOTP")).click();
		
		OTP.otp();
		
		Thread.sleep(5000);
		// Click on applications
		RO_Lead.driver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']")).click();
		Thread.sleep(2000);
		// Click on first application
		RO_Lead.driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[0,367][720,537]']")).click();
		
		RO_Lead.driver.findElement(By.id(RO_Lead.id+"etOTP")).sendKeys(OTP.OTP);
		            				
		//Confirm OTP
		RO_Lead.driver.findElement(By.id(RO_Lead.id+"confirmBtn")).click();
		
	}

	
	
	
	// RO_Lead.driver.findElement(By.id("")).click();

}
