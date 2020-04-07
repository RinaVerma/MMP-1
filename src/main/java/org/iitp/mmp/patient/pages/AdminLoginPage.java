package org.iitp.mmp.patient.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLoginPage {
	private  final WebDriver driver;
	 public AdminLoginPage(WebDriver driver)
		{
			this.driver = driver;

	     }
	 public WebElement getAdminNameTxt() {
		 WebElement adminNameTxt=driver.findElement(By.id("username"));
		 return adminNameTxt;
		 
	 }
	 public WebElement getAdminPasswdTxt() {
		 WebElement adminPasswdTxt=driver.findElement(By.id("password"));
		 return adminPasswdTxt;
		 
	 }
	 public WebElement getAdminSigninBtn() {
		 WebElement signInBtn=driver.findElement(By.xpath("//input[@name='admin']"));
		 return signInBtn;
		 
	 }

}
