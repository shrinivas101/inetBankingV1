package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBaning.utilities.XLUtils;
import com.inetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user,String password) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(500);
		lp.setUserName(user);
		logger.info("userName provided");
		lp.setPassword(password);
		logger.info("userName provided");
		lp.clickSubmit();
		
		
		Thread.sleep(3000);
		if(isalertPresent() == true) {
			
			driver.switchTo().alert().accept(); //close the Alerts
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
			
		}else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			
			lp.clickLogOut();
			Thread.sleep(3000);
			
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
		}
	}
	//user defined method to check if alerts is present
	public boolean isalertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch (NoAlertPresentException e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String path = System.getProperty("user.dir")+"/src/test/java/com//inetBanking//testData//LoginData.xlsx";
		int rowNum = XLUtils.getRowCount(path, "ldata");
		int colCount = XLUtils.getCellCount(path, "ldata", 1);
		
		String loginData[][] = new String[rowNum][colCount];
		
		for(int i=0;i<rowNum;i++) {
			
			for(int j=0;j<colCount;j++) {
				
				loginData [i][j] = XLUtils.getCellData(path, "ldata", i, j); //1 0
			}
		}
		
		//System.out.println(loginData);
		return loginData;
	}

}
