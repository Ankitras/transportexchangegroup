package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import basePackage.BaseClass;

public class ReuseMethods extends BaseClass {
	static String workingDir = System.getProperty("user.dir");
    private final static String screenShotDir= workingDir+"/target/screenhot/";

	public static void  takeScreenshots(String MethodName) throws IOException
	{
		
		File f1 = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(f1, new File(screenShotDir+MethodName+".png"));
		
	}
	
    public static String getText(WebElement element) {
   
        String text = element.getText();

        // trying with javscript
        if (text.isEmpty()) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            text = (String) js.executeScript("return arguments[0].textContent || arguments[0].innerText;", element);
        }

        return text;
    }

}
