package com.htc.uep.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.htc.uep.utility.BrowserFactory;
import com.htc.uep.utility.ConfigDataProvider;
import com.htc.uep.utility.Constant;

import com.htc.uep.utility.Helper;
import com.htc.uep.utility.ScreenShots;

public class BaseClass {

	protected WebDriver driver;
	protected ConfigDataProvider config;
	protected ExtentReports report;
	protected ExtentTest logger;
	protected JavascriptExecutor js;
	//Object creation

	@BeforeSuite
	public void setupSuite() {

		config=new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/UEP"+"_"+ Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);

	}

	@BeforeClass
	public void setup() throws InterruptedException {
		driver=BrowserFactory.startApplication(driver,config.getBrowser(), config.getQAURL());
	}

	@AfterClass
	public void tearDown(){
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) {

		try {
			if(result.getStatus()==ITestResult.FAILURE) {


				logger.fail("TestFailed", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShots.captureScreenShot(driver,
						result.getMethod().getMethodName(), Constant.ScreenshotFailedFilePath)).build());

			}
			else if(result.getStatus()==ITestResult.SUCCESS)
			{
				logger.pass("TestPassed", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShots.captureScreenShot(driver,
						result.getMethod().getMethodName(),Constant.ScreenshotPassedFilePath)).build());
			}
		} catch (IOException e) {

			System.out.println("Unable to take the screenshot >>"+e.getMessage());
		}

		report.flush();
	}

	//	@AfterSuite
	//	public void tearDownSuiteLevel() {
	//		driver.quit();
	//	}



}
