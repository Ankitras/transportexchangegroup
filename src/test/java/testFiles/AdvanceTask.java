package testFiles;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pageFiles.HomePage;
import pageFiles.LoginPage;
import util.ReuseMethods;

public class AdvanceTask extends BaseClass{
	

	
	
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void pageFileSetUp()
	{
		loginPage = new LoginPage(getDriver());
		homePage= new HomePage(getDriver());
	}
	
	
	@Test
	public void positive4_Cookie(Method method) throws IOException  // 1,4
	{
		//System.out.println("===="+method.getName().toString());
		loginPage.login();
		ReuseMethods.takeScreenshots(method.getName().toString());
		Cookie sessionCookie = getDriver().manage().getCookieNamed("session-username");
		String cookieValue=sessionCookie.getValue();
		Assert.assertEquals(cookieValue, configFileReader1.getUserName("validUser"));
		homePage.logoutApp();
	}

	
	@Test
	public void validateOverRideGetText() // 2,3
	{
		getDriver().get(configFileReader1.getUrl());
		System.out.println("=="+ReuseMethods.getText(loginPage.logoText));
		Assert.assertEquals(ReuseMethods.getText(loginPage.logoText),"Swag Labs","Logo text not as expected");
	}
}
