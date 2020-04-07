package org.iitp.mmp.patient.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientHomePage {
	private  final WebDriver driver;
	
	 public  PatientHomePage(WebDriver driver)
		{
			this.driver = driver;

	     }
	 
	 public WebElement getPatientProfileLink() {
		 WebElement patientProfileLink=driver.findElement(By.xpath("//span[contains(text(),'Profile')]"));
		 return patientProfileLink;
	 }
	 
	 public WebElement getPatientNameHeader() {
		 WebElement patientNameHeader=driver.findElement(By.xpath("//h3[@class='page-header']"));
		 return patientNameHeader;
	 }
	 public WebElement getLogoutBtn() {
		 WebElement logoutBtn=driver.findElement(By.xpath("//span[contains(text(),'Logout')]"));
		 return logoutBtn;
	 }
	 
	 
	 

}
