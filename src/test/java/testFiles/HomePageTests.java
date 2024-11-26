package testFiles;

import org.testng.annotations.BeforeMethod;

import basePackage.BaseClass;
import pageFiles.HomePage;
import pageFiles.LoginPage;

public class HomePageTests  extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void pageFileSetUp()
	{
		homePage = new HomePage(getDriver());
	}
	
	
	

}
