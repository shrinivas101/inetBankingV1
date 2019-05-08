package com.inetBanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass {
	
	@Test
	public void addCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uName);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addCust = new AddCustomerPage(driver);
		addCust.clickAddNewCustomer();
		addCust.setCustName("deven");
		addCust.setCustGender("male");
		addCust.setCustdob("10","06","1972");
		Thread.sleep(3000);
		addCust.setCustAddress("India");
		addCust.setCustState("MH");
		addCust.setCustCity("Pune");
		addCust.setCustPinNumber("411030");
		addCust.setCustTelepHoneNumber("123456789");
		String email = randomString() + "@gmail.com";
		addCust.setCustEmail(email);
		addCust.setCustPassword("123456aA!");
		addCust.clickCustSubmit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully");
		
		if(res == true) {
			Assert.assertTrue(true);
		}else {
			captureScreenshot(driver, "addNewCustoer");
			Assert.assertTrue(false);
		}
	}
	


}
