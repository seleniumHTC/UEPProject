package com.htc.uep.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.htc.uep.browserFactory.BrowserFactory;
import com.htc.uep.configDataProvider.ConfigDataProvider;
import com.htc.uep.logger.PropertyLog4j;
import com.htc.uep.pages.LoginPage;

public class TestBaseClass {

	public static WebDriver driver = null;
	protected LoginPage login = null;
	
	
	
	protected ConfigDataProvider config;
	protected static ExtentReports extent;
	protected static ExtentTest test;
	protected static ExtentTest childTest;
	//Object creation

	@BeforeSuite
	public void setupSuite() {
		
		PropertyLog4j.loadInLoggerFile();
		config=new ConfigDataProvider();
		
		}

	@BeforeClass
	public void setup() throws InterruptedException {
		driver=BrowserFactory.startApplication(driver,config.getBrowser(), config.getQAURL());
		login=new LoginPage(driver);
	}

	@AfterClass
	public void tearDown(){
		BrowserFactory.quitBrowser(driver);
	}


	@AfterSuite
	public void tearDownSuiteLevel() {
		driver.quit();
	}
	public  WebDriver getDriver() {
		return driver;
	}

	
	


}
