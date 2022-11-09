package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicitWait {
	WebDriver driver;

	@BeforeTest(alwaysRun = true)
	public void lauchBrowser() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test
	public void printText() {

		driver.get("https://selenium.obsqurazone.com/index.php");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// to check that the element is present
		WebElement slideText = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(text(),' Bootstrap 4 Responsive Slider with Text Animation ')]")));

		/* Different Types of conditions that are used in explicit Wait */

		// check the title contains the word "obsqura"
		Boolean txtbox = wait.until(ExpectedConditions.titleContains("Obsqura"));
		
		// To check the title is same as of the string provided ("obsqura testing")
		// return boolean value
		Boolean title = wait.until(ExpectedConditions.titleIs("Obsqura Testing"));
		
		System.out.println("title present/not :" + txtbox);

		System.out.println("The message :" + slideText.getText());
	
		System.out.println("title is :" + title);

			}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
