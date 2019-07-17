package AdvancedReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class reportsTest {
	WebDriver driver;
	ExtentTest test;
	ExtentReports report;
  @BeforeTest
  public void OpenBrowser() {
	  ExtentHtmlReporter reporter = new ExtentHtmlReporter(".\\Data_Files\\new.html");
	  report = new ExtentReports();
	  report.attachReporter(reporter);
	  test = report.createTest("Test One");
	  
	  System.setProperty("webdriver.chrome.driver", ".\\Data_Files\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://secure.payrollspan.net/");
	  test.log(Status.PASS, "Site Displayed");
  }
	  
	  @Test
	  public void Credentials(){
		  test = report.createTest("Test Two");
		  String Email = "arunkumar.dhanasekar+always1@spanllc.com";
		  test.log(Status.PASS, Email);
		  driver.findElement(By.id("EmailAddress")).sendKeys(Email);
		  test.log(Status.PASS, "Email Address Entered: "+Email);
		  
	  }
  @AfterTest
  public void endTest(){
	  report.flush();
  }
}
