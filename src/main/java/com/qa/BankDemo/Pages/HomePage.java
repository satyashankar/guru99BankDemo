package com.qa.BankDemo.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BankDemo.BasePage.BasePage;

public class HomePage extends BasePage{
	
	//page factory object
	@FindBy(xpath="//td[contains(text(),'Manger Id : mngr270888')]")
    WebElement managerID;
	
	@FindBy(xpath="//a[contains(text(),'Change Password')]")
	WebElement changePasswdBtn;
	
	@FindBy(xpath="//input[@name='oldpassword']")
	WebElement enterOldPassword;
	
	@FindBy(xpath="//input[@name='newpassword']")
	WebElement entNewPassword;
	
	@FindBy(xpath="//input[@name='confirmpassword']")
	WebElement entConfirmPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitBTN;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement logOutBTN;
	

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyingManagerId() {
		String actualManagerIDText = managerID.getText();
		return actualManagerIDText;
		
	}
 
	public String  homePageTitle() {
		return driver.getTitle();
	}
	
	public void changePassword(String oldPassword, String newPassword, String confirmPassword) {
		changePasswdBtn.click();
		enterOldPassword.sendKeys(oldPassword);
		entNewPassword.sendKeys(newPassword);
		entConfirmPassword.sendKeys(confirmPassword);
		submitBTN.click();
	}
	
	public void logoutFromAPP() {
		logOutBTN.click();
	}
}
