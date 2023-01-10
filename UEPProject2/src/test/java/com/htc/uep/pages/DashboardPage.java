package com.htc.uep.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

	WebDriver driver;


	public DashboardPage(WebDriver ldriver) 
	{
		this.driver=ldriver;	
		
	}
	
	@FindBy(xpath = "//span[@class='activity-title'][text()='Event Template']") WebElement eventTemplateButton;
	
	@FindBy(xpath = "//div[@class='page-title p-mb-3']/h4") WebElement eventTemplatePageHeading;
	
	public void navigateToEventTemplatePage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",eventTemplateButton);
		assertEquals("Events Templates", eventTemplatePageHeading.getText(),"Unable to navigate to Events Templates Page");
		
	}
	
	
		
}
