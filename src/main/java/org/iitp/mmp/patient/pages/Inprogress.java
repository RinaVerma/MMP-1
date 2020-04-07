package org.iitp.mmp.patient.pages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Inprogress {
	public static void main(String[] args) throws IOException, SQLException {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000");
	//HomePage homePg= new HomePage(driver);
	//homePg.getPatientLoginBtn().click();
	//PatientLoginPage patientLog =new PatientLoginPage(driver);

	
	String host="localhost";
	String port="3306";
	Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/MMPdb2"+"?useTimezone=true&serverTimezone=UTC", "root", "Zircon@123");
	System.out.println("connected");
	Statement s=con.createStatement();
	ResultSet rs=s.executeQuery("select * from UsernamePwd ");
	while(rs.next()) {
		driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000");
		HomePage homePg= new HomePage(driver);
		homePg.getPatientLoginBtn().click();
		PatientLoginPage patientLog =new PatientLoginPage(driver);
		patientLog.getPatientNameTxt().sendKeys(rs.getString("username"));
		patientLog.getPatientPasswdTxt().sendKeys(rs.getString("password"));
		patientLog.getPatientSigninBtn().click();
		PatientHomePage pHomePg=new PatientHomePage(driver);
		//String expected=rs.getString("username");
		System.out.println(pHomePg.getPatientNameHeader().getText());
		
		//Assert.assertEquals(expected, pHomePg.getPatientNameHeader().getText());
		pHomePg.getLogoutBtn().click();
	}	
	}
}
