package com.iNetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		
		Logger.info("URL is opened");

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		Logger.info("userName is Entered");

		lp.setPassword(password);
		Logger.info("password is Entered");

		lp.clikcLogin();
		

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			Logger.info("Login Test is passed");
		} else {
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			Logger.info("Login Test is failed");
			
		}

	}

}
