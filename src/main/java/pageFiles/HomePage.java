package pageFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ConfigFileReader;

public class HomePage {

	WebDriver driver;


	public ConfigFileReader configFileReader1 = new ConfigFileReader();
	
	public HomePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath="//div[@class='app_logo']")
	WebElement homePageLogo;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement homePageMenu;
	
	@FindBy(xpath="//a[@id=\"logout_sidebar_link\"]")
	WebElement logOutButton;
	
	
	public String HomelogoText()
	{
		return homePageLogo.getText();
	}

	public void logoutApp()
	{
		homePageMenu.click();
		logOutButton.click();
	}


}
