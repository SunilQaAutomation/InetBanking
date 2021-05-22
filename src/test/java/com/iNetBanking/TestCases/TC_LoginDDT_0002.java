package com.iNetBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iNetBanking.PageObjects.LoginPage;
import com.iNetBanking.Utilities.XLUtils;

public class TC_LoginDDT_0002 extends BaseClass {

	@Test(dataProvider = "loginData")
	public void loginDDT(String name, String password) throws IOException {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(name);
		Logger.info("User Name is entered");
		lp.setPassword(password);
		Logger.info("Password is entered");
		lp.clikcLogin();

		if (isAlertPresent() == true) {
			
			System.out.println("text in the alert :" +driver.switchTo().alert().getText());
			driver.switchTo().alert().accept(); 
			driver.switchTo().defaultContent();
			Logger.info("Login failed");
			captureScreen(driver, "loginDDT");
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			lp.clikcLogOut();
			System.out.println("text in the alert :" +driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Logger.info("Login Pass");
			
		}
	}

	// User defined method to verify the alert present or not
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "loginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/iNetBanking/TestData/LoginTestData.xlsx";
		int rowNum = XLUtils.getRowCount(path, "Login");
		int colCount = XLUtils.getCellCount(path, "Login", 1);

		String loginData[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(path, "Login", i, j);
			}
		}
		return loginData;
	}

}
