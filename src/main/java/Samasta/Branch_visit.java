package Samasta;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Branch_visit {
	static AppiumDriver<MobileElement> driver;
	static String id = "com.sensei.samasta.marc:id/";
	static String username = "newtall";
	static String password = "Admin@123";

	public static void main(String[] args) throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "realme C3");
		cap.setCapability("udid", "9TUCGYG6F6SSYPSC");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11.0");

		// Ro app
		cap.setCapability("appPackage", "com.sensei.samasta.marc");
		cap.setCapability("appActivity", "com.sensei.samasta.marc.activities.AuthenticatorActivity");
		cap.setCapability("noReset", "true");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {
			// Enter userName
			driver.findElement(By.id(id + "email")).sendKeys(username);
			// Enter Password
			driver.findElement(By.id(id + "accountPassword")).sendKeys(password);
			// Click on sign in
			driver.findElement(By.id(id + "submit")).click();
			System.out.println("Login Successful");
		} catch (Exception e) {
			System.out.println("Device already logged in");
		}

		// bulk submit
		try {
			driver.findElement(By.id(id + "isBackDatedEntry")).click();
			driver.findElement(By.id(id + "isBulkUpdate")).click();
			driver.findElement(By.id(id + "spinner_reason_selector")).click();
			driver.findElement(By.id(id + "checkbox")).click();
			TouchAction coord = new TouchAction(driver);
			coord.press(PointOption.point(150, 200)).release().perform();
			driver.findElement(By.id("android:id/button1")).click();
		} catch (Exception e) {
		}
//		// Click on Add
//		driver.findElement(By.id(id + "fab")).click();
//		// Click on Mandatory Activity
//		driver.findElement(By.id(id + "toggle_button_section")).click();
//
//		List<MobileElement> count = driver.findElements(By.id(id + "plan_task"));
//		count.get(0).click();
//		Thread.sleep(2000);
//		// Proceed
//		driver.findElement(By.id("android:id/button1")).click();
		// Select date
//		driver.findElement(By.id(id + "select_branch_layout")).click();
//		driver.findElement(By.id("android:id/button1")).click();
		// Select checkbox
//		List<MobileElement> size = driver.findElements(By.id(id + "branch_visit_name_text"));
//		System.out.println(size.size());
//		ArrayList<String> d = new ArrayList<String>();
//		{
//			d.add("Aduthurai");
//			d.add("Ahmedpur");
//		}
//		for (int i = 0; i < size.size(); i++) {
//			String branch = size.get(i).getText();
//
//			for (String branch1 : d) {
//				if (branch.equals(": " + branch1)) {
//					driver.findElements(By.id(id + "select_branch")).get(i).click();
//				}
//			}
//		}

//		driver.findElement(By.id(id + "select_branch")).click();
//		// Add to Plan
//		driver.findElement(By.id(id + "add_to_plan")).click();

		driver.findElement(By.id(id + "task_list_item_layout")).click();		
		driver.findElement(By.xpath("//android.widget.TextView[@text='1']")).click();

		int j = 0;
		for (int i = 0; i >= 0; i++) {
			try {
				driver.findElements(By.id(id + "option_selector")).get(i).click();
				driver.findElements(By.xpath("//android.widget.CheckedTextView")).get(1).click();
			} catch (Exception e) {

				if (j < 1) {
					Thread.sleep(3000);
					TouchAction touch = new TouchAction(driver);
					touch.press(PointOption.point(150, 1400)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
							.moveTo(PointOption.point(200, 200)).release().perform();
					i = -1;
					j += 1;
				} else {
					break;
				}

			}
		}

		driver.findElement(By.xpath("//android.widget.TextView[@text='2']")).click();
		for (int i = 0; i <= 5; i++) {
			try {
				driver.findElements(By.id(id + "option_selector")).get(i).click();
				driver.findElements(By.xpath("//android.widget.CheckedTextView")).get(1).click();
			} catch (Exception e) {
				break;
			}
		}

		driver.findElement(By.xpath("//android.widget.TextView[@text='3']")).click();
		driver.findElement(By.id(id + "option_selector")).click();
		driver.findElements(By.xpath("//android.widget.CheckedTextView")).get(1).click();
		driver.findElement(By.id(id + "id_answer")).sendKeys("96");

		driver.findElement(By.xpath("//android.widget.TextView[@text='4']")).click();

		driver.findElements(By.id(id + "id_answer")).get(0).sendKeys("5");
		driver.findElements(By.id(id + "id_answer")).get(1).sendKeys("6");

		driver.findElement(By.xpath("//android.widget.TextView[@text='5']")).click();

		driver.findElement(By.id(id + "id_answer")).sendKeys("Average");

		driver.findElement(By.id(id + "submit")).click();

		driver.findElement(By.id("android:id/button1")).click();

	}

}
//driver.findElement(By.id( "")).click();