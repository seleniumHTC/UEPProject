package com.htc.uep.testcases;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.htc.uep.base.TestBaseClass;
import com.htc.uep.dataProvider.TestDataProvider;
import com.htc.uep.exceptionHandler.UserDefinedException;
import com.htc.uep.pages.LoginPage;

public class LoginTestUEP extends TestBaseClass{


	@Test(dataProviderClass=TestDataProvider.class,dataProvider ="InputData" )
	public void loginApplication(Map<String,String> mapData) {
		try {
			childTest=test.createNode("Login Account Verification");
			LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
			loginPage.loginToUEP(mapData.get("Email"), mapData.get("password"));
			childTest.pass("Logged in to the UEP Application");
		} catch (UserDefinedException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}
















