package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME,using="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how= How.NAME,using="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how= How.NAME,using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how= How.NAME,using="addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how= How.NAME,using="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how= How.NAME,using="state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how= How.NAME,using="pin")
	@CacheLookup
	WebElement txtpin;
	
	@FindBy(how= How.NAME,using="mobno")
	@CacheLookup
	WebElement txtmobno;
	
	@FindBy(how= How.NAME,using="email")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(how= How.NAME,using="pwd")
	@CacheLookup
	WebElement txtpwd;
	
	@FindBy(name="btnSubmit")
	@CacheLookup
	WebElement  btnSubmit;
	
	@FindBy(name="btnRest")
	@CacheLookup
	WebElement  btnReset;
	
	@FindBy(how = How.XPATH,xpath="html/body/div[3]/u1/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	
	public void setCustName(String custName) {
		txtCustomerName.sendKeys(custName);
	}
	
	public void setCustGender(String custGend) {
		rdGender.click();
	}
	
	public void setCustdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void setCustAddress(String custAddress) {
		txtaddress.sendKeys(custAddress);
	}
	
	public void setCustCity(String custCity) {
		txtcity.sendKeys(custCity);
	}
	
	public void setCustState(String custState) {
		txtstate.sendKeys(custState);
	}
	
	public void setCustPinNumber(String custPinNumber) {
		txtpin.sendKeys(String.valueOf(custPinNumber));
	}
	
	public void setCustTelepHoneNumber(String custTelepHoneNumber) {
		txtmobno.sendKeys(custTelepHoneNumber);
	}
	public void setCustEmail(String custEmail) {
		txtemail.sendKeys(custEmail);
	}
	public void setCustPassword(String custPwd) {
		txtpwd.sendKeys(custPwd);
	}
	
	public void clickCustSubmit() {
		btnSubmit.click();
	}
	
	public void clickRest() {
		btnReset.click();
	}
	

	

}
