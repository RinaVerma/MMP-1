package org.iitp.mmp.patient.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientLoginPage {
	
	private  final WebDriver driver;
	
	 public  PatientLoginPage(WebDriver driver)
		{
			this.driver = driver;

	     }
	 
	 public WebElement getPatientNameTxt() {
		 WebElement patientNameTxt=driver.findElement(By.id("username"));
		 return patientNameTxt;
		 
	 }
	 public WebElement getPatientPasswdTxt() {
		 WebElement patientPasswdTxt=driver.findElement(By.id("password"));
		 return patientPasswdTxt;
		 
	 }
	 public WebElement getPatientSigninBtn() {
		 WebElement signInBtn=driver.findElement(By.cssSelector("input[name='submit']"));
		 return signInBtn;
		 
	 }
}