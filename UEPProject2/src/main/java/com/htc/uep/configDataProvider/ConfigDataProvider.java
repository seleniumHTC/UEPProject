package com.htc.uep.configDataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.htc.uep.constant.Constant;

public class ConfigDataProvider {
	
	Properties prop ;


	public  ConfigDataProvider() {

		File source=new File(Constant.properties_file_location);
		try {
			FileInputStream fileInputStream=new FileInputStream(source);
			prop= new Properties();
			prop.load(fileInputStream);
			
		} catch (Exception e) {
			System.out.println("Not able to load config file "+e.getMessage());
		}
		 
	}


	public String getBrowser() {
		return prop.getProperty("browser");
	}

	public String getQAURL() {
		return prop.getProperty("qaURL");
	}

	public String getDataFromConfig(String keyToSearch) {
		return prop.getProperty(keyToSearch);
	}
	
	

}
