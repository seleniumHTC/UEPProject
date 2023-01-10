package com.htc.uep.logger;
import org.apache.log4j.PropertyConfigurator;

import com.htc.uep.constant.Constant;




public class PropertyLog4j {

	public static void loadInLoggerFile() {
		PropertyConfigurator.configure(Constant.propertyLoggerLocation);
		
	}
	
	
	
	
}
