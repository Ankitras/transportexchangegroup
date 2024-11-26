package util;

import org.testng.annotations.DataProvider;

import basePackage.BaseClass;

public class DataProviderClass {


	@DataProvider(name = "creds")
	public Object[][] Credentials() {
    	return new Object[][] {
        {"standard_user", "secret_sauce"},
        {"error_user", "secret_sauce"}  };	
    
	}



}
