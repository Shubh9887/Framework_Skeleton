package testClasses;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import testUtility.BrowserWait;
import testUtility.CaptureScreenshot;
import testUtility.StaticBrowser;

public class BaseClass {

	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest logger;
	static ExtentHtmlReporter extent;
	
	@Parameters ({"browser"})
	
	@BeforeTest
	public void beforeTest(String browser) {
		WebDriver driver = StaticBrowser.openBrowser(browser, "https://www.google.com");
		this.driver=driver;
		BrowserWait.waitForBrowser(10, driver);
		
		report = new ExtentReports();
		extent = new ExtentHtmlReporter("test-output" + File.separator + "Reports" + File.separator + System.currentTimeMillis() + ".html");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		BrowserWait.waitForBrowser(5, driver);
		if(result.getStatus()==ITestResult.FAILURE) {
			String path =CaptureScreenshot.capturePageScreenshot(driver);
			logger.fail("Test Case is failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		else {
			CaptureScreenshot.capturePageScreenshot(driver);
		}
		logger.pass("Test Case is passed");
		report.flush();
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
}
