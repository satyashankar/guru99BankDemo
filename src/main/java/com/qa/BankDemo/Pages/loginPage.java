package com.qa.BankDemo.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BankDemo.BasePage.BasePage;

public class loginPage extends BasePage {
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement  userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement  password;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement loginBTN;

	public loginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage loginIntoApp(String uID, String psswd) throws IOException {
		
		userName.sendKeys(uID);
		password.sendKeys(psswd);
		loginBTN.click();
		return new HomePage();
	}

}
