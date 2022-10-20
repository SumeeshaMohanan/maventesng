package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(testScripts.ListenerDemo.class)
public class ListenerMain {
	public WebDriver driver;

	@Test
	public void launch() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.demo.guru99.com/V4/");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("user1");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("password");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
	}
	@Test
	public void TestFail() {
		System.out.println("Method to test fail");
		Assert.assertTrue(false);
		
	}
}