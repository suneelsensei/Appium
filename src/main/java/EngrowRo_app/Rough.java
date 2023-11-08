package EngrowRo_app;



import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Rough {

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
			RO_Lead.driver.findElement(By.id("" + RO_Lead.id + "input_name")).sendKeys("100013");
			// Enter Password
			RO_Lead.driver.findElement(By.id("" + RO_Lead.id + "input_password")).sendKeys("Engrow@1");
			// Click on sign in
			RO_Lead.driver.findElement(By.id("" + RO_Lead.id + "button_login")).click();
			System.out.println("Login Successful");
		} catch (Exception e) {
			System.out.println("Device already logged in");
		}
		
		// Create Lead
		RO_Lead.driver.findElement(By.id(""+RO_Lead.id+"buttonAddNewLead")).click();
		
		Thread.sleep(3000);
		TouchAction touch = new TouchAction(RO_Lead.driver);
		touch.press(PointOption.point(150,1400)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(200, 200)).release().perform();

//		Dimension dim = RO_Lead.driver.manage().window().getSize();
//		int height = dim.getHeight(); 		//1448
//		int width = dim.getWidth();		 	//720
//		System.out.println(height +" "+ width);
//		int startx,endx,starty,endy;
//		
//		startx  = width/2;
//		endx	=	width/2;
//		starty =(int) (height*0.4);
//		endy  =(int) (height*0.1);
//		
//		TouchAction touch = new TouchAction(RO_Lead.driver);
//		touch.press(PointOption.point(startx,starty)).moveTo(PointOption.point(endx, endy)).release().perform();

		
	}


}
