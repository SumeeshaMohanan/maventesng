package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ImplicitWait {
	WebDriver driver;

	@BeforeTest(alwaysRun = true)
	public void lauchBrowser() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void printText() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://selenium.obsqurazone.com/index.php");
		WebElement slideText = driver
				.findElement(By.xpath("//*[contains(text(),' Bootstrap 4 Responsive Slider with Text Animation ')]"));
		slideText.click();
		System.out.println("The message :" + slideText.getText());

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
