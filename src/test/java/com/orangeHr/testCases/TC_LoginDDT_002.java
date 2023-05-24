package com.orangeHr.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangeHr.pageObjects.LoginPage;
import com.orangeHr.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(user);
		logger.info("username is provided");
		lp.setPassword(pwd);
		logger.info("password is provided");
		lp.loginbutton();
		
		Thread.sleep(3000);
		
		if(isErrorDisplayed()==true) {
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		
		else {
			Assert.assertTrue(true);
			logger.info("Login Successful");
			
			lp.logoutbutton();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			
		}
		
		
		
	}
	
	public boolean isErrorDisplayed() // user defined method 
	{
		
		
		try {
		driver.findElement(By.xpath("//p[text()='Invalid credentials']")).isDisplayed();
		return true;
		
		}
		catch(Exception e) {
			
			
			return false;
			
		}
		

		
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
		String path="E:\\selenium\\orangeHr\\src\\test\\java\\com\\orangeHr\\testData\\LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "sheet1");
		int colcount = XLUtils.getCellCount(path, "sheet1", 1);
		
		String logindata[][] = new String[rownum][colcount];
		
		for(int i=1; i<=rownum;i++) {
			
			for(int j=0;j<colcount;j++) {
				
				logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j); // 1 0
			}
		}
		return logindata;
	}
	

}
