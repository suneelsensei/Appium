package EngrowBcm_app;

import java.net.URL;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import EngrowRo_app.ApplicationCreation;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class bcmsync_application {
	static AppiumDriver<MobileElement> driver;
	static String id = "com.sensei.engrow.bcm.debug:id/";
	// Application name
	static String Application_name = "Mr. "+ ApplicationCreation.name;

	public static void main(String[] args) throws Exception {

		bcm_workflow();
	}

	public static void bcm_workflow() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "realme C3");
		cap.setCapability("udid", "9TUCGYG6F6SSYPSC");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11.0");

		// Ro app
		cap.setCapability("appPackage", "com.sensei.engrow.bcm.debug");
		cap.setCapability("appActivity", "com.sensei.engrow.MainActivity");
		cap.setCapability("noReset", "true");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {

			// Enter userName
			driver.findElement(By.id(id + "input_name")).sendKeys("100066");
			// Enter Password
			driver.findElement(By.id(id + "input_password")).sendKeys("Engrow@1");
			// Click on sign in
			driver.findElement(By.id(id + "button_login")).click();
			System.out.println("Login Successful");
		} catch (Exception e) {
			System.out.println("Device already logged in");
		}

		//Click on 3 Menu
				driver.findElement(By.id(id+"menuImage")).click();
				//Click on download 
				driver.findElement(By.xpath("//android.widget.TextView[@text='Download Application']")).click();
				Thread.sleep(3000);
				//Click on Refresh
				driver.findElement(By.id(id+"refreshButton")).click();
				Thread.sleep(3000);
				
		// Click on Application
		try {
			driver.findElement(By.xpath("//android.widget.TextView[@text='" + Application_name + "']")).click();
		} catch (Exception e) {
			driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
							+ Application_name + "\"));"))
					.click();
		}
		
		// Click on Loan Proposed
		driver.findElement(By.id(id + "tvLoanProposed")).click();
		// SAVE
		driver.findElement(By.id(id + "ivSave")).click();

		// Click on KYC VERIFICATION
		driver.findElement(By.id(id + "tvDocVerificationHeader")).click();

		List<String> kyc = Arrays.asList("UnVerifiedValue", "DocUnverified", "tvKycNumber", "tvDocumentNumber",
				"KYC PROOFS", "DOCUMENT PROOF");

		for (int k = 0; k < 2; k++) {
			List<MobileElement> size = driver.findElements(By.id(id + "tv" + kyc.get(k)));
			for (int j = 0; j < size.size(); j++) {
				List<MobileElement> size1 = driver.findElements(By.id(id + "tv" + kyc.get(k)));
				// Click on KYCs and DOCs
				if (Integer.parseInt(size1.get(j).getText()) > 0) {
					size1.get(j).click();

					// Multiple Proofs
					List<MobileElement> verified = driver.findElements(By.id(id + kyc.get(k + 2)));
					for (int i = 0; i < verified.size(); i++) {
						verified.get(i).click();
						// Scroll and click Verified
						driver.findElement(MobileBy.AndroidUIAutomator(
								"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"VERIFIED\"));"))
								.click();
						// Scroll KYC PROOFS
						driver.findElement(MobileBy.AndroidUIAutomator(
								"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
										+ kyc.get(k + 4) + "\"));"));
					}

					// Click on Back button
					driver.findElement(By.id(id + "backArrow")).click();
				}
			}
		}

		// Click on Back button
		driver.findElement(By.id(id + "backArrow")).click();

		// Scroll upto Financial and click
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"FINANCIAL\"));"))
				.click();

		// Click on GST RETURNS
		driver.findElement(By.xpath("//android.widget.TextView[@text='GST RETURN']")).click();

		// Enter for 1st month
		driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).clear();
		driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).sendKeys("25000");

		// Click on save
		driver.findElement(By.id(id + "ivSave")).click();

		for (int i = 0; i < 2; i++) {
			// Click on Back button
			driver.findElement(By.id(id + "backArrow")).click();
		}

		// Scroll and sync
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"CHECK & SYNC\"));"))
				.click();

		// Sync Application
		// Click on File verification
		driver.findElement(By.id(id + "fileVerification")).click();
		Thread.sleep(2000);
		// Click on Sync Application
		driver.findElement(By.id(id + "syncApplication")).click();
		driver.findElement(By.id(id + "syncApplicationButton")).click();

	}

}
//	driver.findElement(By.id("")).click();