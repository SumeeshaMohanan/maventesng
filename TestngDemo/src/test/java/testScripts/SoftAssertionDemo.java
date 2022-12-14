package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionDemo {
	public WebDriver driver;

	@BeforeTest
	public void lauchBrowser(ITestContext context) {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
	}

	@Test
	public void titleAssert() {
		String title = driver.getTitle();
		System.out.println(title);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("Obsqura", title);//actaul and expcted result are different
		System.out.println("Assert");
		softAssert.assertAll();
	}
	/* Assert with message and actaul and expected result are different
	 @Test
	
	public void titleAssert() {
		String title = driver.getTitle();
		System.out.println(title);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("Obsqura Testi", title,"Assert Message");
		System.out.println("Assert");
		softAssert.assertAll();
	} */
	/* Assert without message and actaul and expected result are Same
	@Test
	public void titleAssert() {
		String title = driver.getTitle();
		System.out.println(title);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("Obsqura Testing", title);
		System.out.println("Assert");
		softAssert.assertAll();
	}*/
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
