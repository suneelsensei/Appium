package EngrowRo_app;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



public class Mobile_login {
 
	
	static AppiumDriver<MobileElement> driver;
	public static void main(String[] args)  {
		try {
			opencalc();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
		
	public static void opencalc() throws Exception {
			

			DesiredCapabilities cap= new DesiredCapabilities();
			
			cap.setCapability("deviceName", "redmi note 8 pro");
			cap.setCapability("udid", "5p9xojj7c6rkmbmv");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "11.0");
			cap.setCapability("appPackage", "com.miui.calculator");
			cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
			cap.setCapability("noReset","true");
			
			URL url=new URL("http://192.168.2.78:4723/wd/hub");
			
			driver = new AppiumDriver<MobileElement>(url,cap);
			
			System.out.println("Done");
		}
		
	
}

