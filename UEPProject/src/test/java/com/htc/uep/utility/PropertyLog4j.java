package com.htc.uep.utility;
import org.apache.log4j.PropertyConfigurator;




public class PropertyLog4j {

	public static void loadInLoggerFile() {
		PropertyConfigurator.configure(Constant.propertyLoggerLocation);
		
	}
	
	
	
	
}
