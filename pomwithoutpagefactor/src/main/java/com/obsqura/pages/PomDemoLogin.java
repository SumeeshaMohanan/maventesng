package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PomDemoLogin {
	WebDriver driver;

	By userName = By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input");
	By password = By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input");
	By loginbtn = By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]");
//constructor
	public PomDemoLogin(WebDriver driver) {

		this.driver = driver;

	}

	public void setUserName(String strUname) {

		driver.findElement(userName).sendKeys(strUname);
	}

	public void setPassword(String strPwd) {

		driver.findElement(password).sendKeys(strPwd);
	}

	public void clickLogin() {

		driver.findElement(loginbtn).click();

	}

	public void loginmain(String strUname, String strPwd) {

		this.setUserName(strUname);
		this.setPassword(strPwd);
		this.clickLogin();
	}

}
