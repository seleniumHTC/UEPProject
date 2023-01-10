package com.htc.uep.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	
	WebDriver driver;
	
	//Constructor for initalizing the driver 
	public LoginPage(WebDriver ldriver) 
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath = "//span[text()='Sign in with email']") WebElement signInWithEmailButton;
	
	@FindBy(name = "email") WebElement emailTextBox;
	
	@FindBy(xpath = "//button[text()='Next']") WebElement nextButton;
	
	@FindBy(name = "password") WebElement passwordTextBox;
	
	@FindBy(xpath = "//button[text()='Sign In']") WebElement signInButton;
	
	@FindBy(xpath = "//span[@class='name']") WebElement profileName;
	
	
	
	public void loginToUEP(String emailAddress,String Password)
	{
		signInWithEmailButton.click();
		emailTextBox.sendKeys(emailAddress);
		nextButton.click();
		passwordTextBox.sendKeys(Password);
		signInButton.click();
		assertEquals("Johna Rheaume", profileName.getText(),"Loged in successfully");
	}
	
}
