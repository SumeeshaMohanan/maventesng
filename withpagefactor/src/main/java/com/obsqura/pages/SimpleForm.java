package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleForm {
	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"single-input-field\"]")
	WebElement txtMessage;
	@FindBy(xpath = "//*[@id=\"button-one\"]")
	WebElement showbtn;
	@FindBy(xpath = "//*[@id=\"message-one\"]")
	WebElement showmsg;

	public SimpleForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setText(String msg) {
		txtMessage.sendKeys(msg);
	}

	public void btnClick() {
		showbtn.click();
	}

	public void insertTxt(String message) {
		this.setText(message);
		this.btnClick();
	}

	public String getTxtmsg() {
		//System.out.println(showmsg.getText());
		
		return showmsg.getText();

	}
}
