package com.iNetBanking.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.PageObjects.LoginPage;
import com.iNetBanking.PageObjects.NewCustomer;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws IOException, InterruptedException {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("User Name provided");
		lp.setPassword(password);
		Logger.info("Password provided");
		lp.clikcLogin();

		NewCustomer addCust = new NewCustomer(driver);
		Logger.info("Customer Details are providing........");
		addCust.clickNewCustomer();
		addCust.customerName("ram");
		addCust.custgender("male");
		addCust.custdob("10", "05", "1985");
		addCust.custAddress("INDIA");
		addCust.custCity("HYD");
		addCust.custState("AP");
		addCust.custPinno("123456");
		addCust.custMobile("9876543210");
		addCust.custEmail(randomString() + "@gmail.com");
		addCust.custPassword("afkdfjls");
		addCust.custSubmit();
		Thread.sleep(5000);

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) {
			Assert.assertTrue(true);
			Logger.info("test case passed");
		}

		else {
			captureScreen(driver,"addNewCustomer");
			Logger.info("test case failed");
			Assert.assertTrue(false);
		}
		
	}

	


}
