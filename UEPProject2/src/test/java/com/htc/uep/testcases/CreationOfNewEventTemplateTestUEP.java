package com.htc.uep.testcases;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.htc.uep.base.TestBaseClass;
import com.htc.uep.dataProvider.TestDataProvider;
import com.htc.uep.exceptionHandler.UserDefinedException;
import com.htc.uep.pages.DashboardPage;
import com.htc.uep.pages.EventTemplatePage;
import com.htc.uep.pages.LoginPage;

public class CreationOfNewEventTemplateTestUEP extends TestBaseClass {


	@Test(dataProviderClass=TestDataProvider.class,dataProvider ="InputData" )
	public void creationOfNewEventTemplate(Map<String,String> mapData) throws InterruptedException {

	//	logger=report.createTest("Login to the UEP Application");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		//logger.info("Starting the application");
		try {
			loginPage.loginToUEP(mapData.get("Email"), mapData.get("password"));
		} catch (UserDefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//logger.pass("Logged in to the UEP Application");

		DashboardPage dashBoardPage=PageFactory.initElements(driver, DashboardPage.class);
		//logger.info("Navigated to Dashboard page");
		dashBoardPage.navigateToEventTemplatePage();
	//	logger.info("Navigated to Event Template page");
		
		EventTemplatePage eventTemplatePage=PageFactory.initElements(driver, EventTemplatePage.class);
	
		eventTemplatePage.creationOfNewEventTemplate(mapData.get("Template Name Max Characters"
				+ ""), mapData.get("Template Description Max Characters"),mapData.get("Template Name"),
				mapData.get("Template Description"));

	}

}
