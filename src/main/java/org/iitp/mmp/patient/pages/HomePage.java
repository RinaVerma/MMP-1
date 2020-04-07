package org.iitp.mmp.patient.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	 private  final WebDriver driver;
	 public HomePage(WebDriver driver)
		{
			this.driver = driver;

	     }
	 public WebElement getAdminLoginBtn() {
		 WebElement adminLoginBtn=driver.findElement(By.xpath("//a[@class='button']"));
		 return adminLoginBtn;
	 }
	 public WebElement getPatientLoginBtn() {
		 WebElement patientLoginBtn=driver.findElement(By.xpath("//section/div/div/div/div[2]/a"));
	     return patientLoginBtn;
	 }
	
}
