package com.htc.uep.utility;

import org.apache.log4j.xml.DOMConfigurator;

public class XMLlog4jConfigurator {

	
	public static void loadInLoggerFile() {
		DOMConfigurator.configure(Constant.xmlLoggerLocation);
		}
	
	
}
