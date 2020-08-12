package com.qa.BankDemo.Pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.BankDemo.BasePage.BasePage;

public class NewCustomer extends BasePage {

	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement newCustomerBTN;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement customerName;
	
	@FindBy(xpath="//input[@type='radio' and @value='m']")
	WebElement maleRadioBTN;
	
	@FindBy(id="dob")
	WebElement dateOfBirth;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement address;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement cityName;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement stateName;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement pinCode;
	
	@FindBy(name="telephoneno")
	WebElement telephoneNumber;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement emailID;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement subBTN;
	
	public NewCustomer()throws IOException{
		
		PageFactory.initElements(driver, this);
	}
	public void selectBirthDate(WebDriver driver, WebElement element, String dateVal) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
		
	}
	
	public void addNewCustomer(String CustName,String DOB, String addrs, String cityNme,String StateName, String PIN,String mobileNum,String mailID,String psswrd) throws InterruptedException {
		newCustomerBTN.click();
		//Thread.sleep(5000);
		customerName.clear();
		customerName.sendKeys(CustName);
		maleRadioBTN.click();
		
		selectBirthDate(driver,dateOfBirth,DOB);
		//Select select = new Select(dateOfBirth);
				//select.selectByValue(DOB);
		address.sendKeys(addrs);
		cityName.sendKeys(cityNme);
		stateName.sendKeys(StateName);
		pinCode.sendKeys(PIN);
		telephoneNumber.clear();
		telephoneNumber.sendKeys(mobileNum);
		emailID.sendKeys(mailID);
		password.sendKeys(psswrd);
		subBTN.click();
				
		
				
		
	}
	
}
