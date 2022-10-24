package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GroupingDemo {
	public WebDriver driver;

	@BeforeTest(alwaysRun=true)
	public void lauchBrowser() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
		
	}

	@Test(enabled=true,groups= "regression")
	public void chkTitle() {
		driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
		String title = driver.getTitle();
		Assert.assertEquals("Obsqura Testing", title);
		System.out.println("Title of the Web Page  : " + title);
	}

	@Test(enabled=true,groups= "regression")
	public void showMessage() {
		driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.findElement(By.xpath("//*[@id=\"single-input-field\"]")).sendKeys("Hello World");
		driver.findElement(By.id("button-one")).click();
		String s2 = driver.findElement(By.xpath("//*[@id=\"message-one\"]")).getText();
		Assert.assertEquals("Your Message : Hello World", s2);
		System.out.println("Your Message : Hello World"+ s2);
		
	}

	@Test(enabled=true,groups= "regression")
	public void sumCalculation() {
		driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.findElement(By.xpath("//*[@id=\"value-a\"]")).sendKeys("25");
		driver.findElement(By.cssSelector("#value-b")).sendKeys("10");
		driver.findElement(By.id("button-two")).click();
		String s3 = driver.findElement(By.xpath("//*[@id=\"message-two\"]")).getText();
		Assert.assertEquals("Total A + B : 35", s3);
	}

	@Test(groups= {"checkradio"})
	public void checkBoxSelectall() {
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		driver.findElement(By.xpath("//*[@id=\"gridCheck\"]")).click();
		String s3 = driver.findElement(By.xpath("//*[@id=\"message-one\"]")).getText();
		Assert.assertEquals("Success - Check box is checked", s3);
	}
	@Test(groups= {"checkradio"})
	public void selectRadio() {
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		driver.findElement(By.xpath("//*[@id=\"inlineRadio2\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"button-one\"]")).click();
		String s=driver.findElement(By.xpath("//*[@id=\"message-one\"]")).getText();
		Assert.assertEquals("Radio button 'Female' is checked", s);
	}
	@AfterTest
	public void browserClose() {
		driver.close();
	}
	
}
