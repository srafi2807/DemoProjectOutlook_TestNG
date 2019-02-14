package com.outlook.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.outlook.qa.base.TestBaseSetup;
import com.outlook.qa.pages.MailBoxPage;
import com.outlook.qa.pages.SignUpPage;


//For implementing the Testnglistener
@Listeners(com.outlook.qa.util.TestNG_Listener.class)

public class MailBoxPageTest extends TestBaseSetup {
    
public static ExtentReports report;	
public static ExtentTest logger;
	SignUpPage signupPage;
	MailBoxPage mailboxpage;



	public MailBoxPageTest() {
		super();
	}
	
	@BeforeSuite()
	public void beforesuite() {
	report = new ExtentReports(System.getProperty("user.dir") + "/test-output/testReport.html", true);
	report.loadConfig(new File(System.getProperty("user.dir") + "/src/main/java/com/qa/reporting/ExtentConfig.xml" ));
	
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
	//	report1.startReport("Windows", "chrome");
		logger = report.startTest(this.getClass().getSimpleName());
		initialization("chrome");
		giveUrl("outlooksignup");
		signupPage = new SignUpPage();
	}
	


	@Test(priority = 1)
	public void loginTest() throws InterruptedException {
		signupPage.signInNewUser();
		//Logging
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Signed In Successfully");
		
		mailboxpage = new MailBoxPage();
		mailboxpage.clicknewmail();
		logger.log(LogStatus.PASS, "Clicked on New Email");
		mailboxpage.composenewmail();
		
		

		

	}

	@AfterMethod()
	public void cbrowser() {
        driver.quit();
		//Logging
		logger.log(LogStatus.PASS, "Browser closed Successfully");
        report.endTest(logger);
	}
	
	@AfterSuite()
	public void aftersuite() {
		report.flush();
		report.close();
		
	}
	
	

}
