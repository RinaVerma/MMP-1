package org.iitp.mmp.patient.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminHomePage {
	private  final WebDriver driver;
	
	 public AdminHomePage(WebDriver driver)//constructor to give life to driver
		{
			this.driver = driver;//the driver created in this class is assigned the driver from initializeDriver

	     }
	 
public WebElement getPatientLink(){
	WebElement patientLink=driver.findElement(By.xpath("//span[contains(text(),'Patients')]"));
	return patientLink;
}
public Select getApptSelect(){
	Select s= new Select (driver.findElement(By.id("app_date")));
	
	return s;
}
public WebElement getPatientSearchTxt(){
	WebElement patientLink=driver.findElement(By.id("search"));
	return patientLink;
	
}
public WebElement getPatientSearchBtn(){
	WebElement patientSrchBtn=driver.findElement(By.xpath("//input[@value='search']"));
	return patientSrchBtn;
}
public WebElement getPatientNameLink(){
	WebElement patientNameLink=driver.findElement(By.xpath("//tr/td[1]/a"));
	return patientNameLink;
}
public WebElement getReportsBtn(){
	WebElement reportsBtn=driver.findElement(By.cssSelector("input[value='Reports']"));
	return reportsBtn;
}
public WebElement getReportsNameTxt(){
	WebElement reportsNameTxt=driver.findElement(By.id("exampleInputcardnumber1"));
	return reportsNameTxt;
}
public WebElement getChooseFileBtn(){
	WebElement chooseFileBtn=driver.findElement(By.xpath("//form[1]/div[4]"));
	return chooseFileBtn;
}
public WebElement getDescTxt(){
	WebElement descTxt=driver.findElement(By.name("report_desc"));
	return descTxt;
}
public WebElement getSubmitBtn(){
	WebElement submitBtn=driver.findElement(By.cssSelector("input[value='submit']"));
	return submitBtn;
}


}
