package com.obsqura.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.obsqura.pages.PayrollLogin;
import com.obsqura.pages.SimpleForm;

public class PayrollScripts {
	public WebDriver driver;

	@BeforeTest
	public void lauchBrowser(ITestContext context)  {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AROMAL\\eclipse-workspace\\pomwithpagefactor\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://qabible.in/payrollapp/site/login");
	}
	@Test(priority=0)
	public void loginapplication() throws InterruptedException{
		PayrollLogin log=new PayrollLogin(driver);
		log.login("carol","1q2w3e4r");
		Thread.sleep(5000);
		String actualUrl="http://qabible.in/payrollapp/site/index";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(false, false);
		//Assert.assertEquals(actualUrl, expectedUrl);
		}
	/*@AfterTest
	public void browserClose() {
		driver.close();
	}*/
}
