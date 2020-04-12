package org.iitp.mmp.patient.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	public WebDriver driver;
 public WebDriver initializeDriver() throws IOException {
	 Properties prop=new Properties();
	 FileInputStream fis=new FileInputStream("/Users/sinhapra/eclipse-workspace/MMPproject/src/main/java/org/iitp/mmp/patient/resources/data.properties");
	 prop.load(fis);
	 String browserName=prop.getProperty("browser");
	 if(browserName.equals("chrome") ){
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	 }
	 else if (browserName.equals("firefox") ){
		 WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
	 }
	 else if (browserName.equals("IE")) {
		 WebDriverManager.iedriver().setup();
		 driver= new InternetExplorerDriver();
	 }
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return driver;	 
 }
}
