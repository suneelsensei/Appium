package appium1;




import org.openqa.selenium.remote.DesiredCapabilities;



public class Mobile_signIN {
 
	public static void main(String[] args) throws Exception {
		
		
		DesiredCapabilities cap= new DesiredCapabilities();
		
		cap.setCapability("deviceName", "realme C3");
		cap.setCapability("udid", "9TUCGYG6F6SSYPSC");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("appPackage", "com.coloros.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		
		
		
//		URL url=new URL("http://127.0.0.1:4723/wd/hub");
//		AppiumDriver driver = new AppiumDriver(url,cap);
		
		
		System.out.println("DONE");
		
	}
}
