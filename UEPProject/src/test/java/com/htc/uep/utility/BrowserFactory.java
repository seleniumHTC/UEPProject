package com.htc.uep.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class BrowserFactory {

	
public static WebDriver startApplication(WebDriver driver,String browser,String url) throws InterruptedException {
		
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",Constant.chrome_driverLocation);
			driver=new ChromeDriver();
//			ChromeOptions options=new ChromeOptions();
//			options.addArguments("disable-blink-features=AutomationControlled");
//			driver=new ChromeDriver(options);
			Reporter.log("CHROME DRIVER IS LOADED SUCCESSFULLY", true);
			//log.info("CHROME DRIVER IS LOADED SUCCESSFULLY"+"_"+browser);

		}else  if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",Constant.gecko_driverLocation);
			driver=new FirefoxDriver();
			Reporter.log("FIREFOX DRIVER IS LOADED SUCCESSFULLY", true);
			//log.info("FIREFOX DRIVER IS LOADED SUCCESSFULLY");
		}else {
			Assert.assertTrue(false,"NO BROWSER IS LAUNCHED, SEND A PROPER BROWSER NAME");
			//log.info("NO BROWSER IS LAUNCHED, SEND A PROPER BROWSER NAME"+"_"+browser);
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constant.wait_secounds));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constant.wait_secounds));
		driver.get(url);
		Reporter.log("URL IS LOADED SUCCESSFULLY:"+browser+"URL:"+url, true);
		//log.info("URL IS LOADED SUCCESSFULLY"+"_"+url);
		return driver;
	}
	//*****Closig Browser*****//
	public static void quitBrowser(WebDriver driver) {
		driver.close();
		//log.info("DRIVER IS CLOSED SUCCESSFULLY");
	}
	
	
	
}
