package com.iitp.mmp.MMP;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.iitp.mmp.patient.pages.RegisterPatientPage;
import org.iitp.mmp.patient.resources.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PatientRegisterTest extends base{
	////checking now
	
	@Test(description="US_004 Validating the approve patient")
	public void approvePatient() throws InterruptedException, IOException
	{
		driver=initializeDriver();
		driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/portal/registration.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RegisterPatientPage regPage = new RegisterPatientPage(driver);
		Random rnd = new Random();
		String username = "testun"+ (char)(65+rnd.nextInt(26))  + rnd.nextInt(100);
		String password = "testpd"+(char)(65+rnd.nextInt(26))+rnd.nextInt(200);
		
		HashMap<String,String> hMap = regPage.putFirstNameTxt();
		 hMap = regPage.putLastNameTxt();
		//hMap=regPage.putDOBTxt();
		
		hMap=regPage.putSSN();
		hMap=regPage.putState();
		hMap=regPage.putCity();
		hMap=regPage.putAddress();
		hMap=regPage.putZipcode();
		hMap=regPage.putAge();
		hMap=regPage.putHeight();
		hMap=regPage.putWeight();
		hMap=regPage.putPassword(password);
		hMap=regPage.putEmail();
		hMap=regPage.putUsername(username);
		hMap=regPage.putPassword(password);
		hMap=regPage.putConfirmPassword(password);
		regPage.selectSecurityQ();
		hMap=regPage.putSecurityQ(username);
		Thread.sleep(3000);
		hMap=regPage.putLicense();
		System.out.println(hMap);
		hMap=regPage.clickRegister();
		Set<String> keySetValues = hMap.keySet();
		for(String key : keySetValues)
		{
			System.out.println("Key is ::"   + key);
			System.out.println("Value is ::" +hMap.get(key));
		}
		String expectedMsg = "Thank you for registering with MMP.";
		String actualMsg = hMap.get("message");
		AssertJUnit.assertEquals(actualMsg.trim(),expectedMsg.trim());

}
}