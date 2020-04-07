package org.iitp.mmp.patient.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientProfilePage {
	private  final WebDriver driver;
	
	 public  PatientProfilePage(WebDriver driver)
		{
			this.driver = driver;

	     }
	 
	 public WebElement getViewReportLink() {
		 WebElement viewReportLink=driver.findElement(By.xpath("//button[contains(text(),'View Reports')]"));
		 return viewReportLink;
	 }
	 public WebElement getAttachment() {
		 WebElement attachmentLink=driver.findElement(By.xpath("//td[1]//a[1]//ul[1]//li[1]"));
		return attachmentLink;
	 }

}
