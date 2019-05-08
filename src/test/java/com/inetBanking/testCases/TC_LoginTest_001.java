package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		driver.get(baseUrl);
		
		logger.info("URL OPENED");
		LoginPage lp = new LoginPage(driver);
		
		
		lp.setUserName(uName);
		logger.info("ENTERED USE NAME");
		lp.setPassword(password);
		logger.info("ENETERED PASSWORD");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
			AssertJUnit.assertTrue(true);
			logger.info(driver.getTitle());
			logger.info("LOGIN TEST PASSED");
		}
		else {
			captureScreenshot(driver, "loginTest");
			AssertJUnit.assertTrue(false);
			logger.info("LOGIN TEST FAILED");
		}
	}
}
