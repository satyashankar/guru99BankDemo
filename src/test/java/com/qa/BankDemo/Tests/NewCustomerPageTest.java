package com.qa.BankDemo.Tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.BankDemo.BasePage.BasePage;
import com.qa.BankDemo.Pages.CustomerDetailPage;
import com.qa.BankDemo.Pages.HomePage;
import com.qa.BankDemo.Pages.NewCustomer;
import com.qa.BankDemo.Pages.loginPage;
import com.qa.BankDemo.UTil.Util;

public class NewCustomerPageTest extends BasePage {
	
	loginPage LoginPage;
	HomePage homePage;
	NewCustomer newCustomerPage;
	Util util;

	public NewCustomerPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	public  void SetUP() throws IOException {
		Initialization();
		LoginPage = new loginPage();
		homePage = new HomePage();
		newCustomerPage = new NewCustomer();
		
	}
	
	@DataProvider
	public Object[][] getData11() throws IOException{
		Object Customerdata[][] = util.testData("C:\\Users\\SandeepGoud\\eclipse-workspace\\Guru99DemoBank\\src\\main\\java\\com\\qa\\TestData\\testData2.xls", "Sheet3");
		return Customerdata;
	}
	
	@Test(dataProvider="getData11")
	public void verify_adding_NewCustomer(String CustomerName,String BirthDate, String Address, String City,String State,String Pin, String Mobile,String Email,String Password) throws IOException, InterruptedException {
		homePage = LoginPage.loginIntoApp(prop.getProperty("userID"), prop.getProperty("password"));
		//Thread.sleep(5000);
		newCustomerPage.addNewCustomer(CustomerName,BirthDate,Address,City,State,Pin,Mobile,Email,Password);
	}
	

}
