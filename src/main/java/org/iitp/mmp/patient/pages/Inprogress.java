package org.iitp.mmp.patient.pages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Inprogress {
	public static void main(String[] args) throws IOException, SQLException {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	String expected="Login";
	String actual=driver.getTitle();
	boolean res=false;
	if(actual.contentEquals(expected)) {
		 res= true;
		 }
	System.out.println(res);
	}
	}	
	

