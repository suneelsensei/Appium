package EngrowRo_app;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;

public class OTP {
	static String OTP;

	public static void main(String[] args) throws Exception {

		otp();
	}

	public static void otp() throws Exception {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "realme C3");
		cap.setCapability("udid", "9TUCGYG6F6SSYPSC");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11.0");
		// Ro app
		cap.setCapability("appPackage", "com.google.android.gm");
		cap.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");
		cap.setCapability("noReset", "true");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		RO_Lead.driver = new AppiumDriver<MobileElement>(url, cap);
		RO_Lead.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String otptext = RO_Lead.driver.findElement(By.xpath("//android.view.ViewGroup[contains(@text,'engrowalert')]"))
				.getText();
		int index = otptext.indexOf("Otp,");
		OTP = otptext.substring(index + 5, index + 9);
		System.out.println(OTP);

		DesiredCapabilities cap1 = new DesiredCapabilities();
		cap1.setCapability("deviceName", "realme C3");
		cap1.setCapability("udid", "9TUCGYG6F6SSYPSC");
		cap1.setCapability("platformName", "Android");
		cap1.setCapability("platformVersion", "11.0");
		cap1.setCapability("appPackage", "com.sensei.engrow.ro.debug");
		cap1.setCapability("appActivity", "com.sensei.engrow.MainActivity");
		cap1.setCapability("noReset", "true");

		URL url1 = new URL("http://127.0.0.1:4723/wd/hub");
		RO_Lead.driver = new AppiumDriver<MobileElement>(url1, cap1);
	}
}
