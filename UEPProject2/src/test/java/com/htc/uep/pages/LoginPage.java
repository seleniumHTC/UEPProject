package com.htc.uep.pages;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import com.htc.uep.base.BasePage;
import com.htc.uep.exceptionHandler.UserDefinedException;
import com.htc.uep.pageObjects.LoginPageObjects;

public class LoginPage extends BasePage implements LoginPageObjects {

	
	
	//Constructor for initalizing the driver
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	Logger log = Logger.getLogger(LoginPage.class.getName());
	
	
	
	public void loginToUEP(String emailAddress,String Password) throws UserDefinedException{
	
		try {
			clickableMethod(signInWithEmailButton);
			sendKeysMethod(emailTextBox, emailAddress);
			clickableMethod(nextButton);
			sendKeysMethod(passwordTextBox, Password);
			clickableMethod(signInButton);
			//Assert.assertEquals(actualString,Expected);
			assertEquals("Johna Rheaume",gettingTextOfElement(driver, profileName));
			log.info("--LOGIN ACTION METHOD IS EXICUTED SUCCESSFULLY--");
		} catch (UserDefinedException e) {
			throw new UserDefinedException("--LOGIN ACTION METHOD IS FAILED--"+e.getMessage());
		}
		
//		signInWithEmailButton.click();
//		emailTextBox.sendKeys(emailAddress);
//		nextButton.click();
//		passwordTextBox.sendKeys(Password);
//		signInButton.click();
//		assertEquals("Johna Rheaume", profileName.getText(),"Loged in successfully");
	}
	
}
