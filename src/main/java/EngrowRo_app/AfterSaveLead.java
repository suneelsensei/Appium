package EngrowRo_app;

import org.openqa.selenium.By;

public class AfterSaveLead {
	
	public static void main(String[] args) throws Exception {
		RO_Lead.leadCreation();
		applicationgeneration();
	}
	
	public static void applicationgeneration() throws Exception {
		
		String Purpose ="Shop";
		
	
		//enter the Requested amount
//		RO_Lead.driver.findElement(By.id("com.sensei.engrow.ro.debug:id/etRequestedAmount")).sendKeys("200000");
		
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.ro.debug:id/etRequestedAmount")).sendKeys(RO_Lead.driver.findElement(By.id("com.sensei.engrow.ro.debug:id/requestMax2")).getText());
		
		//Enter the Tenure
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.ro.debug:id/etTenure")).sendKeys(RO_Lead.driver.findElement(By.id("com.sensei.engrow.ro.debug:id/tenureMax2")).getText());
		
		//Enter the Purpose
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.ro.debug:id/etPurpose")).sendKeys(Purpose);
		
		//click on save
		RO_Lead.driver.findElement(By.id("com.sensei.engrow.ro.debug:id/saveButton")).click();
	}
	
//	driver.findElement(By.id("")).click();	
}










