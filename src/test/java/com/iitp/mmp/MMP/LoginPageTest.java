package com.iitp.mmp.MMP;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.iitp.mmp.patient.pages.AdminLoginPage;
import org.iitp.mmp.patient.pages.HomePage;
import org.iitp.mmp.patient.pages.PatientHomePage;
import org.iitp.mmp.patient.pages.PatientLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginPageTest {

	@Test(enabled = false)
	public void adminLogin() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000");
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HomePage homePg = new HomePage(driver);
		homePg.getAdminLoginBtn().click();
		AdminLoginPage adminLog = new AdminLoginPage(driver);
		Thread.sleep(1000);
		adminLog.getAdminNameTxt().sendKeys("Thomas_444");

		Thread.sleep(1000);
		adminLog.getAdminPasswdTxt().sendKeys("edison_444");
		adminLog.getAdminSigninBtn().click();

		AssertJUnit.assertEquals("home", driver.getTitle());

	}

	@Test(enabled = false)
	public void PatLogin() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000");
		// HomePage homePg= new HomePage(driver);
		// homePg.getPatientLoginBtn().click();
		// PatientLoginPage patientLog =new PatientLoginPage(driver);
		String currentDir = System.getProperty("user.dir");

		File src = new File(currentDir + "/src/main/java/org/iitp/mmp/patient/pages/UsernamePwd.xlsx");
		FileInputStream inputStream = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sh1 = wb.getSheetAt(0);
		int rowCount = sh1.getLastRowNum();
		for (int i = 1; i <= rowCount; i++) {
			driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000");
			HomePage homePg = new HomePage(driver);
			homePg.getPatientLoginBtn().click();
			PatientLoginPage patientLog = new PatientLoginPage(driver);

			String pName = sh1.getRow(i).getCell(0).getStringCellValue();
			String password = sh1.getRow(i).getCell(1).getStringCellValue();
			patientLog.getPatientNameTxt().sendKeys(pName);
			patientLog.getPatientPasswdTxt().sendKeys(password);
			patientLog.getPatientSigninBtn().click();
			PatientHomePage pHomePg = new PatientHomePage(driver);
			String expected = pName;
			System.out.println(pHomePg.getPatientNameHeader().getText());

			Assert.assertEquals(expected, pHomePg.getPatientNameHeader().getText());
			pHomePg.getLogoutBtn().click();

		}

	}

	@Test
	public void usernamePwdFrmdatabase() throws SQLException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000");
		String host = "localhost";
		String port = "3306";
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://" + host + ":" + port + "/MMPdb2" + "?useTimezone=true&serverTimezone=UTC", "root",
				"Zircon@123");
		System.out.println("connected");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from UsernamePwd ");
		// PatientLoginPage patientLog =new PatientLoginPage(driver);
		while (rs.next()) {
			driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000");
			HomePage homePg = new HomePage(driver);
			homePg.getPatientLoginBtn().click();
			PatientLoginPage patientLog = new PatientLoginPage(driver);
			patientLog.getPatientNameTxt().sendKeys(rs.getString("username"));
			patientLog.getPatientPasswdTxt().sendKeys(rs.getString("password"));
			patientLog.getPatientSigninBtn().click();
			PatientHomePage pHomePg = new PatientHomePage(driver);
			String expected = rs.getString("username");
			System.out.println(pHomePg.getPatientNameHeader().getText());

			Assert.assertEquals(expected, pHomePg.getPatientNameHeader().getText());
			pHomePg.getLogoutBtn().click();
		}

	}

}
