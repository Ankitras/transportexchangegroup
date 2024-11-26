package testFiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basePackage.BaseClass;
import pageFiles.HomePage;
import pageFiles.LoginPage;

public class LoginPageTests extends BaseClass{

	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void pageFileSetUp()
	{
		loginPage = new LoginPage(getDriver());
		homePage= new HomePage(getDriver());
	}


	@Test
	public void positive1_logoText()
	{
		getDriver().get(configFileReader1.getUrl());
		Assert.assertEquals(loginPage.logoText(),"Swag Labs","Logo text not as expected");
	}

	@Test
	public void positive2_ValidCred()
	{
		SoftAssert s1 = new SoftAssert();
		loginPage.login();
		getDriver().getCurrentUrl();
		s1.assertEquals(getDriver().getCurrentUrl(),configFileReader1.gethomePageurl(),"Product page Not seen");
		s1.assertEquals(homePage.HomelogoText(), "Swag Labs", "After Login, Logo text is not as expecetd");
		homePage.logoutApp();
		s1.assertAll();


	}


	@Test
	public void positive3_logOut()
	{
		loginPage.login();
		homePage.logoutApp();
		Assert.assertEquals(getDriver().getCurrentUrl(), configFileReader1.getUrl(),"Logout not working");


	}





	@Test
	public void negative1_InvalidUserName()
	{
		// only username is invalid but password is correct

		getDriver().get(configFileReader1.getUrl());
		SoftAssert s1 = new SoftAssert();
		loginPage.userName.sendKeys(configFileReader1.getUserName("InvalidUser"));
		loginPage.passWord.sendKeys(configFileReader1.getPassword());
		loginPage.login.click(); 
		s1.assertEquals(loginPage.errorBox.getText(), configFileReader1.geterrorMessage(),"Error Message is not availablle");
		s1.assertEquals(getDriver().getCurrentUrl(), configFileReader1.getUrl(), "Login In with invalid cred");
		s1.assertAll();

	}


	@Test
	public void negative2_InvalidPassword()
	{

		// only password is invalid but username is correct
		SoftAssert s1 = new SoftAssert();
		getDriver().get(configFileReader1.getUrl());
		loginPage.userName.sendKeys(configFileReader1.getUserName("validUser"));
		loginPage.passWord.sendKeys("invalid");
		loginPage.login.click(); 
		s1.assertEquals(loginPage.errorBox.getText(), configFileReader1.geterrorMessage(),"Error Message is not availablle");
		s1.assertEquals(getDriver().getCurrentUrl(), configFileReader1.getUrl(), "Login In with invalid cred");
		s1.assertAll();

	}
	
	
	@Test
	public void negative3_lockedUser()
	{
		// only username is invalid but password is correct

		getDriver().get(configFileReader1.getUrl());
		SoftAssert s1 = new SoftAssert();
		loginPage.userName.sendKeys(configFileReader1.getUserName("lockedUser"));
		loginPage.passWord.sendKeys(configFileReader1.getPassword());
		loginPage.login.click(); 
		s1.assertEquals(loginPage.errorBox.getText(), configFileReader1.getlockedErrorMessage(),"Error Message as per expected");
		s1.assertEquals(getDriver().getCurrentUrl(), configFileReader1.getUrl(), "Login In with invalid cred");
		s1.assertAll();

	}

	@Test()
	public void localStorage() throws InterruptedException
	{
		loginPage.login(); 

		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Object keys = js.executeScript("return Object.keys(localStorage);");

		// Convert Object to List
		List<String> keyList = (ArrayList<String>) keys;
		Boolean sessionkey=false;
		for(String storagekey:keyList)
		{
			//System.out.println("for");
			if(storagekey.contains("session"))
			{
				sessionkey=true;
			}
		}

		Assert.assertFalse(sessionkey,"session key available");


	}


	@Test(dataProvider = "creds", dataProviderClass = util.DataProviderClass.class)
	public void dataUsingDataProvider(String userName, String passWord)
	{
		getDriver().get(configFileReader1.getUrl());
		
		loginPage.userName.sendKeys(userName);
		loginPage.passWord.sendKeys(passWord);
		loginPage.login.click();
		
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(getDriver().getCurrentUrl(),configFileReader1.gethomePageurl(),"Product page Not seen");
		s1.assertEquals(homePage.HomelogoText(), "Swag Labs", "After Login, Logo text is not as expecetd");
		homePage.logoutApp();
		s1.assertAll();
		}


}
