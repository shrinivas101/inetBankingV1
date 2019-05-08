package com.inetBanking.testCases;
import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.testCases.BaseClass;

public class TC_AddCustomerDDT_004 extends BaseClass {
	
	public <AddNewCustomerPage> void AddCustomerDDT() throws InterruptedException {
		
		AddCustomerPage adCust = new AddCustomerPage(driver);
		Thread.sleep(500);
		
	} 

}
