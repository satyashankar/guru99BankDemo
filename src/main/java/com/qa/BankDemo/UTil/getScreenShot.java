package com.qa.BankDemo.UTil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.BankDemo.BasePage.BasePage;

public class getScreenShot extends BasePage  {


	public getScreenShot() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void getScreenShot(String testMethodName) throws IOException{
		
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("C:\\Users\\SandeepGoud\\eclipse-workspace\\Guru99DemoBank\\screenShots//"+testMethodName+"_"+".jpg");
		
		FileUtils.copyFile(srcFile, targetFile);
		
		
	}

	
	
}
