package Collections_Demo;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import io.appium.java_client.touch.offset.PointOption;

public class DemoApp {

	static AppiumDriver<MobileElement> driver;

	static String id = "com.sensei.encore.collections.demo:id/";
	static String username = "pant12";
//	static String name = "Siva Krishna";
	static String name = android_web_workflow.customername;
	static int amount = (int) (Math.random() * 100);
	static String Pannumber = "FDGBH"+random_num.random(4)+"E";

	static String mode = "cash"; // (for cash,for cheque_dd)
	// CHEQUE OR DD
	static String mode1 = "cheque"; // (For CHEQUE --> "cheque", DD --> "dd")
	static String Refnum = ""+random_num.random(6);
	static String Holdername = name;
	static String IFSC = "wuej0"+random_num.random(6);
	static String Bankname = "State Bank of India";
	static String mobileno = "7013797487";

	public static void main(String[] args) throws Exception {
		androidworkflow();
	}

	public static void androidworkflow() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "realme C3");
		cap.setCapability("udid", "9TUCGYG6F6SSYPSC");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11.0");

		// Ro app
		cap.setCapability("appPackage", "com.sensei.encore.collections.demo");
		cap.setCapability("appActivity", "com.sensei.encore.collections.activity.AgentActivity");
		cap.setCapability("noReset", "true");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Login to the app
		try {
			// Enter userName
			driver.findElement(By.id("" + id + "username_text_view")).sendKeys(username);
			// Enter Password
			driver.findElement(By.id("" + id + "password_text_view")).sendKeys("Admin@123");
			// Click on sign in
			driver.findElement(By.id("" + id + "sign_in")).click();
			System.out.println("Login Successful");
		} catch (Exception e) {
			System.out.println("Device already logged in");
		}

		receiptbundle();
		submittedbundle();

		driver.quit();
	}

	public static void receiptbundle() throws Exception {
		int amt = amount;
		int r2000 = 0, r500 = 0, r200 = 0, r100 = 0, r50 = 0, r20 = 0, r10 = 0, r1 = 0;
		// Denominations
		while (amt >= 2000) {
			r2000 = amt / 2000;
			amt = amt % 2000;
			break;
		}
		while (amt >= 500) {
			r500 = amt / 500;
			amt = amt % 500;
			break;
		}

		while (amt >= 200) {
			r200 = amt / 200;
			amt = amt % 200;
			break;
		}

		while (amt >= 100) {
			r100 = amt / 100;
			amt = amt % 100;
			break;
		}
		while (amt >= 50) {
			r50 = amt / 50;
			amt = amt % 50;
			break;
		}
		while (amt >= 20) {
			r20 = amt / 20;
			amt = amt % 20;
			break;
		}
		while (amt >= 10) {
			r10 = amt / 10;
			amt = amt % 10;
			break;
		}
		while (amt >= 1) {
			r1 = amt / 1;
			amt = amt % 1;
			break;
		}

		// Click on Collection Items
		driver.findElement(By.id("" + id + "btn_pending_tasks")).click();

		// Click on Refresh
		driver.findElement(By.id("" + id + "option_refresh")).click();

		// Select required account with name
		try {
			try {
				driver.findElement(By.xpath("//android.widget.TextView[@text='" + name + "']")).click();
			} catch (Exception e) {
				driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
								+ name + "\"));"))
						.click();
			}
		} catch (Exception e) {
			System.out.println(name + " account is not there in collection trail");
			System.exit(0);
		}

		// Click on Pay
		driver.findElement(By.id("" + id + "payment_layout")).click();

		// Unselect the check and Enter the amount
		driver.findElement(By.id("" + id + "cb_full_payment")).click();
		driver.findElement(By.id("" + id + "et_amount_paid")).sendKeys("" + amount);

		// Pay by CASH/CHEQUE/DD
		MobileElement radiobutton = driver.findElement(By.id("" + id + "rb_" + mode));
		radiobutton.click();
		String radiotext = radiobutton.getText();
		// Click on Pay
		driver.findElement(By.id("" + id + "button_pay")).click();

		if (radiotext.equals("CASH")) {

			// Enter Denomination
			driver.findElement(By.id("" + id + "et_denom_2000")).sendKeys("" + r2000);
			driver.findElement(By.id("" + id + "et_denom_500")).sendKeys("" + r500);
			driver.findElement(By.id("" + id + "et_denom_200")).sendKeys("" + r200);
			driver.findElement(By.id("" + id + "et_denom_100")).sendKeys("" + r100);
			driver.findElement(By.id("" + id + "et_denom_50")).sendKeys("" + r50);
			driver.findElement(By.id("" + id + "et_denom_20")).sendKeys("" + r20);
			driver.findElement(By.id("" + id + "et_denom_10")).sendKeys("" + r10);
			driver.findElement(By.id("" + id + "et_denom_1")).sendKeys("" + r1);

			// Enter PAN Payment is more than 50000
			if (amount >= 50000) {
				driver.findElement(By.id("" + id + "et_pan_card")).sendKeys(Pannumber);
			}
		}

		// Cheque/DD
		if (radiotext.equals("CHEQUE / DD")) {

			driver.findElement(By.id("" + id + "rb_" + mode1 + "")).click();
			// Enter Cheque/DD number
			driver.findElement(By.id("" + id + "et_cheque_dd_number")).sendKeys(Refnum);
			// Enter Account holder name
			driver.findElement(By.id("" + id + "et_bank_account_holder_name")).sendKeys(Holdername);
			// Enter IFS Code
			driver.findElement(By.id("" + id + "et_ifsc_code")).sendKeys(IFSC);
			// Enter Bank name
			driver.findElement(By.id("" + id + "et_bank_name")).sendKeys(Bankname);
		}

		// Scroll Upto Proceed and click
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"PROCEED\"));"))
				.click();

		// Select Relationship
		driver.findElement(By.id("" + id + "tv_relation_with_borrower")).click();

		Thread.sleep(2000);
		// Click on Self
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(108, 725)).release().perform();

		// Select the Picture
		driver.findElement(By.id("" + id + "image_button")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Capture photo']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.oppo.camera:id/shutter_button")).click();

		driver.findElement(By.id("com.oppo.camera:id/done_button")).click();

		Thread.sleep(3000);
		// Clear E-Receipt number
		driver.findElement(By.id("" + id + "et_customer_mob_num")).clear();
//		driver.findElement(By.id(""));

		// Enter the number
		driver.findElement(By.id("" + id + "et_customer_mob_num")).sendKeys(mobileno);

		// Click on Confirm
		driver.findElement(By.id("" + id + "issue_receipt_btn")).click();

		// Click on YES
		driver.findElement(By.id("android:id/button1")).click();

		// Click on Back button
		for (int i = 0; i < 2; i++) {
			driver.findElement(By.className("android.widget.ImageButton")).click();
		}

	}

	public static void submittedbundle() throws Exception {
		// Click on Batches
		driver.findElement(By.id("" + id + "btn_batches")).click();
		// Click on ADD Batch
		driver.findElement(By.id("" + id + "add_bundle_btn")).click();
		// Select Receipts
		List<MobileElement> receipts = driver.findElements(By.id("" + id + "tv_customer_name"));
//		System.out.println(receipts.size());

		List<MobileElement> checkbox = driver.findElements(By.id("" + id + "receipt_checkbox"));
//		System.out.println(checkbox.size());

		// Click on checkbox based on name
		for (int i = 0; i < receipts.size(); i++) {

			if (((receipts.get(i)).getText()).equals(name)) {
				((checkbox.get(i))).click();
			}
		}

		// Click on Create Batch
		driver.findElement(By.id("" + id + "add_receipt_to_bundle_btn")).click();
		// Click on batch status is open
		driver.findElement(By.xpath("//android.widget.TextView[@text='Open']")).click();
		// Click on Submit
		driver.findElement(By.id("" + id + "summit_bundle_btn")).click();
		// Click on Yes
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(3000);
	}
}

//driver.findElement(By.id(""));
