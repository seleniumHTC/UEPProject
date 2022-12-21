package com.htc.uep.utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider(name = "InputData")
	public Object[][] dataProvider(Method method){
		
		ExcelFileReadHandler ref = new ExcelFileReadHandler(Constant.datarepository_UEP_ExcelFile_location);
		Object[][] dataSet = null;
		
		if(method.getName().equals("loginApplication"))
		{
			dataSet = ref.getDataUsingMap(Constant.datarepository_UEP_sheetname_Login);
		}
		else if(method.getName().equals("creationOfNewEventTemplate")) 
		{
			dataSet = ref.getDataUsingMap(Constant.datarepository_UEP_sheetname_CreateNewEventTemplate);
		}
		
		
		return dataSet;
	}
	
	
}
