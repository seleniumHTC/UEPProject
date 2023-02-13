package com.htc.uep.pageObjects;

import org.openqa.selenium.By;

public interface EventTemplatesPageObjects {
	
	
	public By eventTemplatePageHeading=By.xpath("//div[@class='page-title p-mb-3']/h4");
	public By createEventTemplateButton=By.xpath("//span[@class='p-button-label p-c'][text()='Create Event Template']");
	public By templateNameChecking=By.xpath("//td[1]");
	public By sectorChecking=By.xpath("//td[1]//following::td[1]");
	public By geoLocationChecking=By.xpath("//td[1]//following::td[2]");
	public By createdDateChecking=By.xpath("//td[1]//following::td[3]");
	public By statusChecking=By.xpath("//td[1]//following::td[4]");
	public By editButton=By.xpath("//button[@title='Edit']");
	public By viewButton=By.xpath("//button[@title='View']");
	
	

}
