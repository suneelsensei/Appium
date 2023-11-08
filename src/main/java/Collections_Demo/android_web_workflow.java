package Collections_Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class android_web_workflow {
	
	static String customername = "Siva Krishna";
	
	public static void main(String[] args) throws Exception {
		allocation();
		DemoApp.androidworkflow();
		web_Flow_Imp.webworkflow();

	}

	

	public static void allocation() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// URL
		driver.get("https://encorecollections-test.senseitech.com/#/signin");
		driver.manage().window().maximize();
		// Enter User name
		driver.findElement(By.name("username")).sendKeys(web_Flow_Imp.BMuser);
		// Enter Password
		driver.findElement(By.name("password")).sendKeys("Admin@123");
		// Click on Sign in
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[2]/div/div/form/div/button"))
				.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click on Allocation
		driver.findElement(By
				.xpath("//*[@id='sidenav']/div/mat-nav-list/app-side-nav/mat-nav-list/div[3]/app-side-nav-list/a/div"))
				.click();

		// Click on Filter
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-collection-item/mat-sidenav-container/mat-sidenav-content/div[1]/div/button[1]"))
				.click();

		// Enter the name
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-collection-item/mat-sidenav-container/mat-sidenav-content/div[1]/form/mat-grid-list/div/mat-grid-tile[4]/div/mat-form-field/div/div[1]/div/input"))
				.sendKeys(customername);

		// Click on search
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-collection-item/mat-sidenav-container/mat-sidenav-content/div[1]/form/mat-grid-list/div/mat-grid-tile[9]/div/button[1]"))
				.click();
		// Click on 1st Allocate
		try {
			driver.findElement(By.xpath(
					"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-collection-item/mat-sidenav-container/mat-sidenav-content/table/tbody/tr[1]/td[9]/span[2]/button"))
					.click();
		} catch (Exception e) {
			driver.findElement(By.xpath(
					"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-collection-item/mat-sidenav-container/mat-sidenav-content/table/tbody/tr[1]/td[9]/span[2]/button"))
					.click();
		}
		// Click on Employee
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-collection-item/mat-sidenav-container/mat-sidenav/div/app-task-allocation/div/form/mat-card[1]/mat-card-content/div/mat-radio-group/div[2]/mat-radio-button/label"))
				.click();

		// Click on Drop-down
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-collection-item/mat-sidenav-container/mat-sidenav/div/app-task-allocation/div/form/mat-card[2]/mat-card-content/div/mat-form-field"))
				.click();

		// Select the drop-down
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[3]")).click();
		// Click on Allocate for Customer
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-collection-item/mat-sidenav-container/mat-sidenav/div/app-task-allocation/div/form/mat-card[3]/mat-card-content/div/mat-radio-group/div[1]/mat-radio-button/label"))
				.click();
		// Click on SAVE
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-collection-item/mat-sidenav-container/mat-sidenav/div/app-task-allocation/div/mat-card/mat-card-content[2]/div/button"))
				.click();

	}
}
//driver.findElement(By.xpath("")).click();