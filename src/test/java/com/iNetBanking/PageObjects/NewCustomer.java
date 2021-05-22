package com.iNetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {

	public WebDriver driver;

	public NewCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='New Customer']")
	WebElement linkNewCustomer;

	@FindBy(xpath = "//input[@name='name']")
	WebElement txtcustomerName;

	@FindBy(name = "rad1")
	WebElement rdGender;

	@FindBy(id = "dob")
	WebElement txtdob;

	@FindBy(name = "addr")
	WebElement txtAddress;

	@FindBy(name = "city")
	WebElement txtCity;

	@FindBy(name = "state")
	WebElement txtState;

	@FindBy(name = "pinno")
	WebElement txtPinNo;

	@FindBy(name = "telephoneno")
	WebElement txtMobile;

	@FindBy(name = "emailid")
	WebElement txtEmail;

	@FindBy(name = "password")
	WebElement txtPassWord;

	@FindBy(name = "sub")
	WebElement btnSubmit;

	public void clickNewCustomer() {
		linkNewCustomer.click();
	}

	public void customerName(String name) {
		txtcustomerName.sendKeys(name);
	}

	public void custgender(String gender) {
		rdGender.click();
	}

	public void custdob(String mm, String dd, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}

	public void custAddress(String addr) {
		txtAddress.sendKeys(addr);
	}

	public void custCity(String city) {
		txtCity.sendKeys(city);
	}

	public void custState(String state) {
		txtState.sendKeys(state);
	}

	public void custPinno(String pin) {
		txtPinNo.sendKeys(String.valueOf(pin));
	}

	public void custMobile(String mobile) {
		txtMobile.sendKeys(mobile);
	}

	public void custEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void custPassword(String password) {
		txtPassWord.sendKeys(password);
	}

	public void custSubmit() {
		btnSubmit.click();
	}
}
