package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class HardAssertionDemo {
	public WebDriver driver;

	@BeforeTest
	public void lauchBrowser() {
		
	}

	@Test
	public void titleAssert() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
		String title = driver.getTitle();
		System.out.print(title);
		Assert.assertEquals("", title);
		
	}
}
