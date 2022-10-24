package com.obsqura.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.obsqura.pages.PomDemoHome;
import com.obsqura.pages.PomDemoLogin;

public class PomMainDemo {
	public WebDriver driver;

	@BeforeTest
	public void lauchBrowser() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/V4/");
	}
	@Test
	public void testHome(){
		PomDemoLogin objlogin=new PomDemoLogin(driver);
		objlogin.loginmain("mgr123", "mgr!23");
		PomDemoHome objhome=new PomDemoHome(driver);
		Assert.assertTrue(objhome.getUsername().toLowerCase().contains("manger id : mgr123"));
		}
	@AfterTest
	public void browserClose() {
		driver.close();
	}
}
