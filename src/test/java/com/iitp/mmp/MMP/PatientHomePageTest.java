package com.iitp.mmp.MMP;

import org.testng.annotations.Test;

import java.io.IOException;

import org.iitp.mmp.patient.pages.HomePage;
import org.iitp.mmp.patient.pages.PatientHomePage;
import org.iitp.mmp.patient.pages.PatientLoginPage;
import org.iitp.mmp.patient.pages.PatientProfilePage;
import org.iitp.mmp.patient.resources.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PatientHomePageTest extends base{
	
	@Test
	public void viewReportTest() throws IOException {
		
		driver=initializeDriver();
		driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000");
		patientLogin(driver) ;
		
		PatientHomePage patientHomPg=new PatientHomePage(driver);
		patientHomPg.getPatientProfileLink().click();
		PatientProfilePage patientProfPage=new PatientProfilePage(driver);
		patientProfPage.getViewReportLink().click();
		System.out.println(patientProfPage.getAttachment().getText());
		
		
		
	}
	public   void patientLogin(WebDriver driver) {
		
		HomePage homePg= new HomePage(driver);
		homePg.getPatientLoginBtn().click();
		String pName = "testunB43";//"ria1";//
		String password="testpdT148";//"Ria12345";//
		PatientLoginPage patientLog =new PatientLoginPage(driver);
		patientLog.getPatientNameTxt().sendKeys(pName);
		patientLog.getPatientPasswdTxt().sendKeys(password);
		patientLog.getPatientSigninBtn().click();
		
		
		
		
		
	}

}
