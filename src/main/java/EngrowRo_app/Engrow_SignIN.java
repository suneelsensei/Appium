package EngrowRo_app;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Engrow_SignIN {

	public static void main(String[] args) throws Exception {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "realme C3");
		cap.setCapability("udid", "9TUCGYG6F6SSYPSC");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11.0");
		// package name
		// calculator
//			cap.setCapability("appPackage", "com.coloros.calculator");
//			//package activity
//			cap.setCapability("appActivity", "com.android.calculator2.Calculator");

		cap.setCapability("appPackage", "com.sensei.engrow.ro.debug");
		cap.setCapability("appActivity", "com.sensei.engrow.MainActivity");

		cap.setCapability("noReset", "true");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement>(url, cap);

		// Enter userName
		driver.findElement(By.id("com.sensei.engrow.ro.debug:id/input_name")).sendKeys("100013");
		// Enter Password
		driver.findElement(By.id("com.sensei.engrow.ro.debug:id/input_password")).sendKeys("Engrow@1");
		// Click on sign in
		driver.findElement(By.id("com.sensei.engrow.ro.debug:id/button_login")).click();

//			driver.findElement(By.id("")).click();

//			System.out.println("DONE");

	}
}
