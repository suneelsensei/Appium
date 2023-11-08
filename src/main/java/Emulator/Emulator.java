package Emulator;


import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Emulator {
	static String id ="com.sensei.encore.collections.demo:id/";

	public static void main(String[] args) throws Exception {
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
				
		cap.setCapability("platformName", "android");
		cap.setCapability("appPackage", "com.sensei.encore.collections.demo");
		cap.setCapability("appActivity", "com.sensei.encore.collections.activity.AgentActivity");
		cap.setCapability("noReset","true");
		
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement>(url,cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Login to the app
				try {
					// Enter userName
					driver.findElement(By.id(""+id+"username_text_view")).sendKeys("hoagent");
					// Enter Password
					driver.findElement(By.id(""+id+"password_text_view")).sendKeys("Admin@123");
					// Click on sign in
					driver.findElement(By.id(""+id+"sign_in")).click();
					System.out.println("Login Successful");
				} catch (Exception e) {
					System.out.println("Device already logged in");
				}
		
				// Click on Collection Items
				driver.findElement(By.id(""+id+"btn_pending_tasks")).click();
				String name = "Rahul Kumar Bangivandala";
				driver.findElement(By.xpath("//android.widget.TextView[@text='" + name + "']")).click();
				// Click on Pay
				driver.findElement(By.id(""+id+"payment_layout")).click();

				// Unselect the check and Enter the amount
				driver.findElement(By.id(""+id+"cb_full_payment")).click();
				driver.findElement(By.id(""+id+"et_amount_paid")).sendKeys("5s0");
		
		
	}

}
