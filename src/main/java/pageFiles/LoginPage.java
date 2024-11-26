package pageFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import util.ConfigFileReader;

public class LoginPage {
	WebDriver driver;
	

	public ConfigFileReader configFileReader1 = new ConfigFileReader();
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id=\"user-name\"]")
	public WebElement userName;

	@FindBy(xpath="//input[@id=\"password\"]")
	public WebElement passWord;
	
	@FindBy(xpath="//input[@id=\"login-button\"]")
	public WebElement login;
	
	
	@FindBy(xpath="//div[@class=\'login_logo\']")
	public WebElement logoText;
	
	@FindBy(xpath="//h3[@data-test=\"error\"]")
	public WebElement errorBox;
	
	
	
	public void login()
	{
		driver.get(configFileReader1.getUrl());
		userName.sendKeys(configFileReader1.getUserName("validUser"));

		passWord.sendKeys(configFileReader1.getPassword());

		login.click();

	}
	
	public String logoText()
	{
		return logoText.getText();
	}
	
	
}


