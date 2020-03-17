package org.iitp.mmp.patient.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Inprogress {
	public static void main(String[] args) {
		Random rnd = new Random();
	WebDriverManager.chromedriver().setup();
	HashMap<String, String> hMap= new HashMap <String, String > ();
	//System.setProperty("webdriver.chrome.driver", "/Users/sinhapra/Downloads/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/registration.php");
	driver.manage().window().maximize();
	
	WebElement firstNameTxtField = driver.findElement(By.id("firstname"));
	firstNameTxtField.sendKeys("testFN"+(char)(65+rnd.nextInt(26))+""+(char)(65+rnd.nextInt(26)));
	hMap.put("firstname", firstNameTxtField.getAttribute(("value")));
	WebElement dobTxtField= driver.findElement(By.id("datepicker"));
	SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
	dobTxtField.sendKeys(sdf.format(new Date()));
	hMap.put("dob",dobTxtField.getAttribute("value"));
	WebElement licenseTxtField= driver.findElement(By.id("license"));
	licenseTxtField.sendKeys(""+(10000000+rnd.nextInt(90000000)));
	hMap.put("license", licenseTxtField.getAttribute("value"));
	
	System.out.println(hMap);
	}
}
