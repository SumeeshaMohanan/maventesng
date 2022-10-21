package com.obsqura.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.obsqurapages.SimpleForm;


public class SimpleFormScript {
	public WebDriver driver;

	@BeforeTest
	public void lauchBrowser(ITestContext context)  {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AROMAL\\eclipse-workspace\\pomwithpagefactor\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	}
	@Test
	public void testInputForm(){
		SimpleForm objform=new SimpleForm(driver);
		objform.insertTxt("Hello");
		String actualval=objform.getTxtmsg();
		System.out.println("my msg displayed is "+ actualval);
		//Assert.assertTrue(s.toLowerCase().contains("Your Message : Hello"));
		Assert.assertEquals("Your Message : Hello", actualval);
		}
	@AfterTest
	public void browserClose() {
		driver.close();
	}
}
