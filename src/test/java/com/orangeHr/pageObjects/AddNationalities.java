package com.orangeHr.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNationalities {
	
	WebDriver ldriver;
	
	public AddNationalities(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	@FindBy(how = How.XPATH, using="//span[text()='Admin']")
	@CacheLookup
	WebElement admin;
	
	@FindBy(how = How.LINK_TEXT, using= "Nationalities")
	@CacheLookup
	WebElement nation;
	
	@FindBy(how = How.XPATH, using= "//button[text()=' Add ']")
	@CacheLookup
	WebElement addnation;
	
	
	@FindBy(how = How.XPATH, using= "//div [@class='oxd-form-row']//descendant::input[@class='oxd-input oxd-input--active']")
	@CacheLookup
	WebElement enterNationality;
	
	
	@FindBy(how = How.XPATH, using= "//button[text()=' Save ']")
	@CacheLookup
	WebElement savebtn;
	
	
	
	public void clickAdminbtn() {
		
		admin.click();
	}
	
public void natinalities() {
		
	nation.click();
	}

public void clickAdd() {
	
	addnation.click();
}

public void enterNation(String enternat) {
	
	enterNationality.sendKeys(enternat);
}

public void saveButton() {
	
	savebtn.click();
}
	
	
	
	
	
	
	

}
