package com.qa.BankDemo.Tests;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.BankDemo.BasePage.BasePage;
import com.qa.BankDemo.Pages.HomePage;
import com.qa.BankDemo.Pages.loginPage;
import com.qa.BankDemo.UTil.Util;
import com.qa.BankDemo.UTil.getScreenShot;

public class loginPageTest extends BasePage{
	
	loginPage LoginPage;
	HomePage homePage;
	getScreenShot screenShot;
	
	
	public loginPageTest() throws IOException {
		super();
	}
	
	
	@BeforeMethod
	public void setUP() throws IOException {
		Initialization();
		LoginPage = new loginPage();
		homePage = new HomePage();
		Util util;
		
	}
	
	@Test
	public void loginTest() throws IOException {
	homePage=LoginPage.loginIntoApp(prop.getProperty("userID"), prop.getProperty("password"));
	}
	
	@DataProvider
	
	public Object[][] getData() throws IOException{
		
		 Object data[][] =Util.testData("C:\\Users\\SandeepGoud\\eclipse-workspace\\Guru99DemoBank\\src\\main\\java\\com\\qa\\TestData\\testData2.xls", "sheet2");
      return data;
	}
	
	
	@Test(dataProvider = "getData")
	
	public void loginVerifivation(String userID, String password) throws IOException {
	
			homePage= LoginPage.loginIntoApp(userID, password);
			
			
			try{ 
				
		       	Alert alt = driver.switchTo().alert();
		       
				String actualBoxMsg = alt.getText(); // get content of the Alter Message				
				String EXPECT_ERROR = "User or Password is not valid";
				alt.accept();
				 // Compare Error Text with Expected Error Value					
				Assert.assertEquals(actualBoxMsg,EXPECT_ERROR);
				System.out.println("alert message  :"+actualBoxMsg);
				
				
			}    
		    catch (NoAlertPresentException Ex){ 
		    	String actualTitle = driver.getTitle();
		    	String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
				// On Successful login compare Actual Page Title with Expected Title
		    	Assert.assertEquals(actualTitle,EXPECT_TITLE);
		    	System.out.println("homePageTitle  :"+actualTitle);	    	
		    					
					screenShot.getScreenShot("Error");
				}
		
	        } 

			
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
