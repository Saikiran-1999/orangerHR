package com.orangeHr.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	
	@FindBy(xpath="//input[@name='username']")
	WebElement txtUsername;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;

	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnLogin;
	
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
	WebElement userdetails;
	
	@FindBy(linkText = "Logout")
	WebElement logoutbtn;
	

	
	
	public void setUsername(String uname) {
		
		txtUsername.sendKeys(uname);
		
	}
	
public void setPassword(String pword) {
		
		txtPassword.sendKeys(pword);
		
	}

public void loginbutton() {
	
	btnLogin.click();
	
}

public void logoutbutton() {
	
	userdetails.click();
	logoutbtn.click();
}

}
