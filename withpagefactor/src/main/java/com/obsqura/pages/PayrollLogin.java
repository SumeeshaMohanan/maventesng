package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayrollLogin {
	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"loginform-username\"]")
	WebElement txtusername;
	@FindBy(xpath = "//*[@id=\"loginform-password\"]")
	WebElement txtpassword;
	@FindBy(xpath = "//*[@id=\"login-form\"]/div[5]/button")
	WebElement loginbtn;
	@FindBy(xpath = "//*[@id=\"login-form\"]/div[3]")
	WebElement chkbox;

	public PayrollLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setusername(String username) {
		txtusername.sendKeys(username);
	}
	public void setpassword(String password) {
		txtpassword.sendKeys(password);
	}
	public void chkboxClick() {
		chkbox.click();
	}

	public void btnClick() {
		loginbtn.click();
	}

	public void login(String username, String password) {
		this.setusername(username);
		this.setpassword(password);
		this.chkboxClick();
		this.btnClick();
	}

	
}
