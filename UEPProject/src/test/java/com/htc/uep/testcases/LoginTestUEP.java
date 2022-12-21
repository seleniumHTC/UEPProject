package com.htc.uep.testcases;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.htc.uep.pages.BaseClass;
import com.htc.uep.pages.LoginPage;
import com.htc.uep.utility.TestDataProvider;

public class LoginTestUEP extends BaseClass{


	@Test(dataProviderClass=TestDataProvider.class,dataProvider ="InputData" )
	public void loginApplication(Map<String,String> mapData) {
		logger=report.createTest("Login to the UEP Application");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting the application");
		loginPage.loginToUEP(mapData.get("Email"), mapData.get("password"));
		logger.pass("Logged in to the UEP Application");
	}
	
}
















//@Test
//public void loginApplication(){
//
//	logger=report.createTest("Login to the UEP Application");
//	
//	LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
//
//	logger.info("Starting the application");
//	
//	loginPage.loginToUEP(excel.getStringData("LoginCredentials", 0, 0), excel.getStringData("LoginCredentials", 0, 1));
//
//	logger.pass("Logged in to the UEP Application");
//}