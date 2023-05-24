package com.orangeHr.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHr.pageObjects.AddNationalities;
import com.orangeHr.pageObjects.LoginPage;

public class TC_AddNatioanlities_003 extends BaseClass {
	
	@Test
	public void addNationality() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("username is added");
		lp.setPassword(password);
		logger.info("password is added");
		lp.loginbutton();
		
		Thread.sleep(3000);
		
		AddNationalities addnat = new AddNationalities(driver);
		
		addnat.clickAdminbtn();
		addnat.natinalities();
		addnat.clickAdd();
		addnat.enterNation(randomString());
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(10000);
		 addnat.saveButton();
		 Thread.sleep(10000);
		 logger.info("Validation Started");
		 
		 
		 boolean res = driver.getPageSource().contains("Successfully Saved");
		 
		 if(res==true) {
			 Assert.assertTrue(false);
			 logger.info("test case failed");
		 }
		 else
		 {
			 captureScreen(driver, "addNationality");
			 logger.info("test case passed");
			 Assert.assertTrue(true);
		 }
		 
		
	
		 
		
		 
		
		
	}
	
	
}
