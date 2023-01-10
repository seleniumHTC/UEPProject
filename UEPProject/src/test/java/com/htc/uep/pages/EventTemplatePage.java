package com.htc.uep.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EventTemplatePage {

	WebDriver driver;
	//WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));

	public EventTemplatePage(WebDriver ldriver) 
	{
		this.driver=ldriver;	

	}

	@FindBy(xpath = "//span[@class='p-button-label p-c'][text()='Create Event Template']") WebElement createEventTemplateButton;

	@FindBy(xpath = "//div[@class='p-card p-p-3 eventTemplate']/h3[text()='Create Event Template']") WebElement createEventTemplateHeading;

	@FindBy(xpath = "//input[@class='p-inputtext p-component templateInput']") WebElement templateName;

	@FindBy(xpath = "//textarea[@class='p-inputtextarea p-inputtext p-component templateInput']") WebElement templateDiscription;
	

	public void navigateToCreateEventTemplate() throws InterruptedException {
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",createEventTemplateButton);
		assertEquals("Create Event Template", createEventTemplateHeading.getText(),
				"Unable to Navigate to Create Event Template page");
		Thread.sleep(4000);
	}
	public void validatingNumberOfCharactersInTemplateName(int maxCharacter,String templateNameValue) {
		
		if(templateNameValue.length()>maxCharacter) {
			Assert.fail("The Template Name should not exceed 100 words");

		}
		else {
			templateName.sendKeys(templateNameValue);
		}

	}

	public void validatingNumberOfCharactersInTemplateDiscription(int maxCharacter,String templateDiscriptionValue) {

		if(templateDiscriptionValue.length()>maxCharacter) {
			Assert.fail("The Template Discription should not exceed 200 words");
		}
		else {
			templateDiscription.sendKeys(templateDiscriptionValue);
		}

	}

	public void creationOfNewEventTemplate(String templateNameCharCount,String templateDescriptionCharCount,
			String templateName,String templateDescription) throws InterruptedException {
		navigateToCreateEventTemplate();
		
		String removedZeroFromtemplateNameCharCount= templateNameCharCount.contains(".") ? templateNameCharCount.replaceAll("0*$","").
				replaceAll("\\.$","") : templateNameCharCount;
		String removedZeroFromtemplateDescriptionCharCount= templateDescriptionCharCount.contains(".") ? templateDescriptionCharCount.replaceAll("0*$","").
				replaceAll("\\.$","") : templateDescriptionCharCount;
		
		validatingNumberOfCharactersInTemplateName(Integer.parseInt(removedZeroFromtemplateNameCharCount),templateName);
		validatingNumberOfCharactersInTemplateDiscription(Integer.parseInt(removedZeroFromtemplateDescriptionCharCount),templateDescription);
		
		System.out.println("Creation of event passed");
		
	}




}
