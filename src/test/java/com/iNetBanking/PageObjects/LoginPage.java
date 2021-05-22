package com.iNetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


		
		//Web elements identification by using findby
		@FindBy(xpath="//input[@name='uid']")
		@CacheLookup
		WebElement txtUserName;

		
		@FindBy(xpath="//input[@name='password']")
		@CacheLookup
		WebElement txtPassword;
		
		@FindBy(xpath="//input[@name='btnLogin']")
		@CacheLookup
		WebElement btnLogin;
		
		@FindBy(xpath="//a[normalize-space()='Log out']")
		@CacheLookup
		WebElement btnLogOut;
		
		
		//Action Methods
		public void setUserName(String name)
		{
			txtUserName.sendKeys(name);
		}

		public void setPassword(String password)
		{
			txtPassword.sendKeys(password);
		}
		
		public void clikcLogin()
		{
			btnLogin.click();
		}
		
		public void clikcLogOut()
		{
			btnLogOut.click();
		}



}
