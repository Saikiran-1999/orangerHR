package com.orangeHr.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.orangeHr.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void loginTest() throws IOException {
		
		
		
		logger.info("URL is Opened");
		LoginPage lp = new LoginPage(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		lp.setUsername(username);
		logger.info("Username Added");
		
		
		lp.setPassword(password);
		logger.info("Password Added");
		lp.loginbutton();
		
		
		if(driver.getTitle().equals("OrangeHRM")){
			
			Assert.assertTrue(true);
			
			logger.info("Login Successful");
			
			}
		
		else
		{
			
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
		
		
		
		
		
	}
	
	

}
