package com.htc.uep.testcases;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.htc.uep.pages.BaseClass;
import com.htc.uep.pages.DashboardPage;
import com.htc.uep.pages.EventTemplatePage;
import com.htc.uep.pages.LoginPage;
import com.htc.uep.utility.TestDataProvider;

public class CreationOfNewEventTemplateTestUEP extends BaseClass {


	@Test(dataProviderClass=TestDataProvider.class,dataProvider ="InputData" )
	public void creationOfNewEventTemplate(Map<String,String> mapData) throws InterruptedException {

		logger=report.createTest("Login to the UEP Application");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting the application");
		loginPage.loginToUEP(mapData.get("Email"), mapData.get("password"));
		logger.pass("Logged in to the UEP Application");

		DashboardPage dashBoardPage=PageFactory.initElements(driver, DashboardPage.class);
		logger.info("Navigated to Dashboard page");
		dashBoardPage.navigateToEventTemplatePage();
		logger.info("Navigated to Event Template page");
		
		EventTemplatePage eventTemplatePage=PageFactory.initElements(driver, EventTemplatePage.class);
	
		eventTemplatePage.creationOfNewEventTemplate(mapData.get("Template Name Max Characters"
				+ ""), mapData.get("Template Description Max Characters"),mapData.get("Template Name"),
				mapData.get("Template Description"));

	}

}
