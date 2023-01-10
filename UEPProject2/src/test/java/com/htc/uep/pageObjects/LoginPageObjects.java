package com.htc.uep.pageObjects;

import org.openqa.selenium.By;

public interface LoginPageObjects {

	public By signInWithEmailButton=By.xpath("//span[text()='Sign in with email']");
	public By emailTextBox=By.name("email");
	public By nextButton=By.xpath( "//button[text()='Next']");
	public By passwordTextBox=By.name("password");
	public By signInButton=By.xpath("//button[text()='Sign In']");
	public By profileName=By.xpath("//span[@class='name']");
	
	
}
