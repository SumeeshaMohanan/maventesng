package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PriorityDemo {
	public WebDriver driver;

	@BeforeTest
	public void lauchBrowser(ITestContext context) {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
	}

	@Test(priority=0)
	public void titleAssert() {
		String title = driver.getTitle();
		System.out.println(title);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("Obsqura Tes", title,"hello");
		System.out.println("Assert");
		softAssert.assertAll();
	}
	@Test(priority=1)
	public void gettitle() {
		String title = driver.getTitle();
		System.out.println(title);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("Obsqura", title,"hi");
		System.out.print("gettitle method");
		softAssert.assertAll();
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
