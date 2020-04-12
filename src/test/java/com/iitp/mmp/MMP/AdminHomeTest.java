package com.iitp.mmp.MMP;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.iitp.mmp.patient.pages.AdminHomePage;
import org.iitp.mmp.patient.resources.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

      
public class AdminHomeTest extends base{
	
	

	@Test
	public void adminAddReportsTest() throws InterruptedException, AWTException, IOException {
	driver=initializeDriver();
	driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/admin");
	//driver.manage().window().fullscreen();
	AdminHomePage adminHmPg= new AdminHomePage(driver);
	adminHmPg.getPatientLink().click();
	adminHmPg.getPatientSearchTxt().sendKeys("437793116");
	adminHmPg.getPatientSearchBtn().click();
	Thread.sleep(2000);
	String patientName=adminHmPg.getPatientNameLink().getText();
	adminHmPg.getPatientNameLink().click();
	Thread.sleep(2000);
	adminHmPg.getReportsBtn().click();
	Thread.sleep(2000);
	adminHmPg.getApptSelect().selectByIndex(1);
	Thread.sleep(2000);
	adminHmPg.getReportsNameTxt().sendKeys(patientName+"XRay");
	Thread.sleep(2000);
	
	Thread.sleep(500);
	
	//uploadFileUsingPath(driver);
	uploadFileRobot(driver);
	Thread.sleep(500);	
    adminHmPg.getDescTxt().sendKeys(patientName+" XRay Report");
    Thread.sleep(500);	
	adminHmPg.getSubmitBtn().click();
	System.out.println("abc");
	
	
	
	
}
	public void uploadFileUsingPath(WebDriver driver) throws InterruptedException {
		WebElement addFile = driver.findElement(By.xpath(".//input[@type='file']"));
		Thread.sleep(500);
		addFile.sendKeys("/Users/sinhapra/Xray/Xray.pages");
		
	}
	public void uploadFileRobot(WebDriver driver) throws AWTException, InterruptedException {
		AdminHomePage adminHmPg= new AdminHomePage(driver);
		adminHmPg.getChooseFileBtn().click();
		Robot robot = new Robot();
		Thread.sleep(500);
		String handle=driver.getWindowHandle();
		System.out.println(handle);
		driver.switchTo().window(handle);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_X);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_X);
		Thread.sleep(500);	
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);	
		robot.keyPress(KeyEvent.VK_META);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_O);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_O);
		
	}
	
}
