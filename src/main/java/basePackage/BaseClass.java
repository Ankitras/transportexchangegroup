package basePackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import util.ConfigFileReader;

public class BaseClass {

	WebDriver driver;
	static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

	public ConfigFileReader configFileReader1 = new ConfigFileReader();

	@BeforeClass
	public void setUp()
	{
		System.out.println("setUp start");
		if(configFileReader1.getBrowser().equalsIgnoreCase("chrome"))
		{	
			driver= new ChromeDriver();
		}
		else
			driver=new EdgeDriver();
		threadLocalDriver.set(driver);
//		/getDriver().get(configFileReader1.getUrl());
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		System.out.println("setUp done");
		
	}

	
	public static WebDriver getDriver()
	{
		return threadLocalDriver.get();
	}
	
	@AfterClass
	public void tearDown()
	{
		getDriver().quit();
		threadLocalDriver.remove();
	}
	
	
}
