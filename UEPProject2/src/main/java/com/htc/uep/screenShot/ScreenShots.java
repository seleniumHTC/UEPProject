package com.htc.uep.screenShot;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.htc.uep.javaUtil.Helper;

public class ScreenShots {

public static String captureScreenShot(WebDriver driver, String fileName, String filePath ) {
		
		String screenshotPath=System.getProperty("user.dir")+filePath + fileName +"_"+ Helper.getCurrentDateTime() +".png";
		try {
			System.out.println("capture screeshot method");
			TakesScreenshot screenShot = (TakesScreenshot) driver;
			File source = screenShot.getScreenshotAs(OutputType.FILE);
			File destination=new File(screenshotPath);	
			FileHandler.copy(source,destination);
		} catch (Exception e) {
			System.out.println("Unable to capture the screenshot"+e.getMessage());
		}
		return screenshotPath;
	}
	
	
}
