package org.iitp.mmp.patient.pages;

import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class RegisterPatientPage {
	   private  final WebDriver driver;
       Random rnd = new Random();
       HashMap<String, String> hMap= new HashMap <String, String > ();
	
	public RegisterPatientPage(WebDriver driver)
	{
		this.driver = driver;

     }
	
	public  HashMap <String,String> putFirstNameTxt() {
		
		WebElement firstNameTxtField = driver.findElement(By.id("firstname"));
		firstNameTxtField.sendKeys("testFN"+(char)(65+rnd.nextInt(26))+""+(char)(65+rnd.nextInt(26)));
		hMap.put("firstname", firstNameTxtField.getAttribute(("value")));
		return hMap;
		
	}
	
	public HashMap <String,String> putLastNameTxt() {
		WebElement lastNameTxtField= driver.findElement(By.id("lastname"));
		lastNameTxtField.sendKeys("testLN"+(char)(65+rnd.nextInt(26))+""+(char)(65+rnd.nextInt(26)));
		hMap.put("lastname", lastNameTxtField.getAttribute("value"));
		return hMap;
	}
	/*public HashMap <String,String> putDOBTxt() {
		WebElement dobTxtField= driver.findElement(By.id("datepicker"));
		SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
		dobTxtField.sendKeys(sdf.format(new Date()));
		hMap.put("dob",dobTxtField.getAttribute("value"));
		return hMap;
	}*/
	public HashMap <String,String> putLicense() {
		WebElement licenseTxtField= driver.findElement(By.id("license"));
		licenseTxtField.sendKeys(""+(10000000+rnd.nextInt(90000000)));
		hMap.put("license", licenseTxtField.getAttribute("value"));
		return hMap;	
	}
	
	public HashMap <String,String> putSSN() {
		WebElement ssnTxtField=  driver.findElement(By.id("ssn"));
		ssnTxtField.sendKeys(""+(100000000+rnd.nextInt(900000000)));	
		hMap.put("ssn", ssnTxtField.getAttribute("value"));
		return hMap;	
	}
	public HashMap <String,String> putState() {
		WebElement stateTxtField= driver.findElement(By.id("state"));
		stateTxtField.sendKeys("Georgia");	
		hMap.put("state", stateTxtField.getAttribute("value"));
		return hMap;	
	}
	public HashMap <String,String> putCity() {
		WebElement cityTxtField= driver.findElement(By.id("city"));
		cityTxtField.sendKeys("Cicero");	
		hMap.put("city", cityTxtField.getAttribute("value"));
		return hMap;	
	}
	public HashMap <String,String> putAddress() {
		WebElement addressTxtField= driver.findElement(By.id("address"));
		addressTxtField.sendKeys("20 Abc Street ");	
		hMap.put("city", addressTxtField.getAttribute("value"));
		return hMap;	
	}
	public HashMap <String,String> putZipcode() {
		WebElement zipcodeTxtField = driver.findElement(By.id("zipcode"));
		long zipValue = 10000 + rnd.nextInt(90000);
		zipcodeTxtField.sendKeys(""+zipValue);
		hMap.put("zipcode", zipcodeTxtField.getAttribute(("value")));
		return hMap;	
	}
	public HashMap <String,String> putAge() {
		WebElement ageValueTxtField = driver.findElement(By.id("age"));
		long ageValue =  rnd.nextInt(90);
		ageValueTxtField.sendKeys(""+ageValue);
		hMap.put("age", ageValueTxtField.getAttribute(("value")));
		return hMap;	
	}
	public HashMap <String,String> putHeight() {
		WebElement heightTxtField = driver.findElement(By.id("height"));
		long heightValue = 10+rnd.nextInt(90);
		heightTxtField.sendKeys(""+heightValue);
		hMap.put("height", heightTxtField.getAttribute(("value")));
		return hMap;	
	}
	
	public HashMap <String,String> putWeight() {
		WebElement weightTxtField = driver.findElement(By.id("weight"));
		long weightValue = rnd.nextInt(90);
		weightTxtField.sendKeys(""+weightValue);
		hMap.put("weight", weightTxtField.getAttribute(("value")));
		return hMap;	
	}
	
	public HashMap <String,String> putEmail() {
		WebElement emailTxtField = driver.findElement(By.id("email"));
		emailTxtField.sendKeys("testEmail"+((char)(65+rnd.nextInt(26))+""+
									(char)(65+rnd.nextInt(26)))+ "@gmail.com");
		hMap.put("email", emailTxtField.getAttribute(("value")));
		return hMap;	
	}
	
	public HashMap <String,String> putUsername(String username) {
		WebElement usernameTxtField = driver.findElement(By.id("username"));
		usernameTxtField.sendKeys(username);
		hMap.put("username", usernameTxtField.getAttribute(("value")));
		return hMap;	
	}
	public HashMap <String,String> putPassword(String password) {
		WebElement passwordTxtField = driver.findElement(By.id("password"));
		passwordTxtField.clear();
		passwordTxtField.sendKeys(password);
		hMap.put("password", passwordTxtField.getAttribute(("value")));
		return hMap;	
	}
	public HashMap <String,String> putConfirmPassword(String password) {
		WebElement confirmpasswordTxtField = driver.findElement(By.id("confirmpassword"));
		confirmpasswordTxtField.sendKeys(password);
		hMap.put("confirmpassword", confirmpasswordTxtField.getAttribute(("value")));
		 
		return hMap;	
	}
	public void selectSecurityQ() {
		new Select(driver.findElement(By.id("security"))).selectByVisibleText("what is your best friend name");			
		 
		
	}
	public HashMap <String,String> putSecurityQ(String username) {
	WebElement answerTxtField = driver.findElement(By.id("answer"));
	answerTxtField.sendKeys(username);
	hMap.put("answer", answerTxtField.getAttribute(("value")));
	return hMap;
	
	
}
	public HashMap <String,String> clickRegister() throws InterruptedException {
	driver.findElement(By.name("register")).click();
	Thread.sleep(3000);
	Alert regAlert = driver.switchTo().alert();
	String successMsg = regAlert.getText();
	regAlert.accept();
	
    hMap.put("message", successMsg);
    
	return hMap;
}
}
	
	

