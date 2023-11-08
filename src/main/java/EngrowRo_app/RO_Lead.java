package EngrowRo_app;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class RO_Lead {

	static AppiumDriver<MobileElement> driver;
	// Enter the product type
	static String Product_type = "Secured";
	static String id = "com.sensei.engrow.ro.debug:id/";
	// Enter Owner Name
	static String Owner_name = "Marina";
	// Enter mobile number
	static String Mobileno = "8569854859";
	// select Business Nature
	static String Bussiness_Nature = "Wood business";

	static String Bussiness_N = '"' + Bussiness_Nature + '"';
	// Enter Business Name
	static String Business_name = Owner_name + " " + Bussiness_Nature;
	// Enter the Pin code
	static String Pin_code = "784586";
	// Select Lead Sorce
	static String Lead_Source = "Cold Call";

	public static void main(String[] args) throws Exception {
		leadCreation();
	}

	public static void leadCreation() throws Exception {
//		DesiredCapabilities cap = new DesiredCapabilities();
//
//		cap.setCapability("deviceName", "realme C3");
//		cap.setCapability("udid", "9TUCGYG6F6SSYPSC");
//		cap.setCapability("platformName", "Android");
//		cap.setCapability("platformVersion", "11.0");
//
//
//
//		// Ro app
//		cap.setCapability("appPackage", "com.sensei.engrow.ro.debug");
//		cap.setCapability("appActivity", "com.sensei.engrow.MainActivity");
//		cap.setCapability("noReset", "true");
//
//		URL url = new URL("http://127.0.0.1:4723/wd/hub");
//		driver = new AppiumDriver<MobileElement>(url, cap);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {
			// Enter userName
			driver.findElement(By.id(""+id+"input_name")).sendKeys("100013");
			// Enter Password
			driver.findElement(By.id(""+id+"input_password")).sendKeys("Engrow@1");
			// Click on sign in
			driver.findElement(By.id(""+id+"button_login")).click();
			System.out.println("Login Successful");
		} catch (Exception e) {
			System.out.println("Device already logged in");
		}

		// Create Lead
		driver.findElement(By.id("" + id + "buttonAddNewLead")).click();

//		//Capture the image
//		driver.findElement(By.id(""+id+"ivPhoto")).click();
//		driver.findElement(By.id(""+id+"imgCapture")).click();
//		dr"+id+"nsei.engrow.ro.debug:id/saveImage")).click();
//		driver.findElement(By.id(""+id+"crop_image_menu_crop")).click();

		driver.findElement(By.id("" + id + "etOwnerName")).sendKeys(Owner_name);

		driver.findElement(By.id("" + id + "etMobileNumber")).sendKeys(Mobileno);

		driver.findElement(By.id("" + id + "etBusinessName")).sendKeys(Business_name);

		driver.findElement(By.id("" + id + "spBusinessNature")).click();

		AndroidElement list = (AndroidElement) driver.findElement(By.id("" + id + "spinnerTextview"));
		try {
			list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
					+ "new UiSelector().text(" + Bussiness_N + "));"));
		} catch (Exception e) {
			driver.findElement(By.xpath("//android.widget.TextView[@text='" + Bussiness_Nature + "']")).click();
		}

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Pin Code\"));"))
				.sendKeys(Pin_code);

		driver.findElement(By.id("" + id + "spLeadSource")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + Lead_Source + "']")).click();

		// Click on Yes radio Button
		driver.findElement(By.id("" + id + "rbInterested")).click();
		//click on No radio button
		//driver.findElement(By.id(""+id+"rbNotInterested")).click();

		// Click on Product type
		driver.findElement(By.id("" + id + "spProductType")).click();
		// select the product type
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + Product_type + "']")).click();

		// Scroll Click on Save and Initiate application
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"SAVE & INITIATE APPLICATION\"));"))
				.click();

//		driver.findElement(By.id("")).click();
	}

}
//Dimension dim = driver.manage().window().getSize();
//int height = dim.getHeight();
//int width = dim.getWidth();
//
//int startx,endx,starty,endy;
//
//startx  = width/2;
//endx	=	width/2;
//starty =(int) (height*0.4);
//endy  =(int) (height*0.1);
//
//TouchAction touch = new TouchAction(driver);
//touch.press(PointOption.point(startx,starty)).moveTo(PointOption.point(endx, endy)).release().perform();

//TouchAction touch = new TouchAction(driver);
//touch.press(PointOption.point(200,1300)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(200, 670)).release().perform();
