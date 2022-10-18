package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionDemo {
	public WebDriver driver;
	@BeforeTest
	public void lauchBrowser() {
		 String path = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://selenium.obsqurazone.com/index.php");
	}
  @Test
  public void titleAssert() {
	 
		
	String title= driver.getTitle();
	SoftAssert softAssert=new SoftAssert();
	softAssert.assertEquals("Obsqura Tes", title);
	System.out.print(title);
  }
}
