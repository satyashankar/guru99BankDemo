package com.qa.BankDemo.Tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BankDemo.BasePage.BasePage;
import com.qa.BankDemo.Pages.HomePage;
import com.qa.BankDemo.Pages.loginPage;

public class HomePageTest extends BasePage {
	
	loginPage LoginPage;
	HomePage homePage;
	
	public HomePageTest() throws IOException {		
		super();
	}
	
	@BeforeMethod
	public  void SetUP() throws IOException {
		Initialization();
		LoginPage = new loginPage();
		homePage = new HomePage();
	}
	
	@Test(priority=1)
	public void homePageTitleVerification() throws IOException {
		
		homePage = LoginPage.loginIntoApp(prop.getProperty("userID"), prop.getProperty("password"));
		String title = homePage.homePageTitle();
		String expectedTitle =  "Guru99 Bank Manager HomePage";			
		Assert.assertEquals(title,expectedTitle);
		System.out.println("homePage Titile.."+ title);
		}
	
	@Test(priority=2)
	public void validatingMaanagerIDText() throws IOException {
		
		homePage = LoginPage.loginIntoApp(prop.getProperty("userID"), prop.getProperty("password"));
		String actualManagerID = homePage.verifyingManagerId();
		String expected_managerID = "Manger Id : mngr270888";
		Assert.assertEquals(actualManagerID,  expected_managerID);
	}
	
	@Test(priority=3)
	public void VerifyPasswordChange() throws IOException {
		homePage = LoginPage.loginIntoApp(prop.getProperty("userID"), prop.getProperty("password"));
		homePage.changePassword("yqadypewee", "123456","123456");
		Alert alt = driver.switchTo().alert();
		String altMsg = alt.getText();
		System.out.println(altMsg);
		alt.accept();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Guru99 Bank New Customer Entry Page";
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println(actualTitle);
		
	}
	
	@Test(priority=4)
	public void VerifyPasswordChange_test2() throws IOException {
		homePage = LoginPage.loginIntoApp(prop.getProperty("userID"), prop.getProperty("password"));
		homePage.changePassword("yqadype", "@123456","@123456");
		Alert alt = driver.switchTo().alert();
		String message = alt.getText();
		System.out.println(message);
		alt.accept();
		homePage.logoutFromAPP();
		Alert alt2 = driver.switchTo().alert();
		String altMessage = alt2.getText();
		System.out.println(altMessage);
		alt2.accept();
		String actualTitle1 = driver.getTitle();
		String expectedTitle2 = "Guru99 Bank Home Page";
		Assert.assertEquals(actualTitle1, expectedTitle2);
		System.out.println(actualTitle1);
	}
		
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		
	}

}
