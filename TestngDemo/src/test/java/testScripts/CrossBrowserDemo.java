package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserDemo {
	WebDriver driver;

	@BeforeTest
	public void openBrowser(ITestContext context) {
		launchBrowser(context.getCurrentXmlTest().getParameter("browser"));
		driver.get("https://www.google.com/");

	}

	@Test(alwaysRun = true)
	public void browserchk() {
		System.getProperty("browser");
		// System.out.println("hello");

	}

	@Parameters({ "browser" })
	public void launchBrowser(String browser) {
		// System.out.println(browser);
		if (browser.equalsIgnoreCase("Chrome")) {

			String path = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();// initializing chrome

		} else if (browser.equalsIgnoreCase("firefox")) {

			String path = System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver", path + "\\src\\main\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();// initializing chrome

		} else if (browser.equalsIgnoreCase("edge")) {
			String path = System.getProperty("user.dir");
			System.setProperty("webdriver.edge.driver", path + "\\src\\main\\resources\\msedgedriver.exe");
			driver = new EdgeDriver();

		}

	}
	@AfterTest
	public void close() {
		driver.close();
	}
}
