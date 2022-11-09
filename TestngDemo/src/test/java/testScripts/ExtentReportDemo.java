package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {

	WebDriver driver;
	ExtentReports extent;
	ExtentSparkReporter spark;
	public static ExtentTest test1;
	
	@BeforeTest
	public void lauchBrowser() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		 extent = new ExtentReports();
		 spark = new ExtentSparkReporter("sparks.html");
		 extent.attachReporter(spark);

			
	}
	
	@Test
	public void reportDemo() {
		
		
		
		test1=extent.createTest("Google Search test", "This test is to validate google functionality");
				test1.addScreenCaptureFromPath("extent.png");
				test1.pass(MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());

			

		test1.log(Status.INFO, "Starting Testcase");
		
		
		
		driver.get("https://www.google.com/");
		test1.pass("Navigated to Google search");
		System.out.println("hello1");
		WebElement p=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		p.sendKeys("Selenium");
		test1.pass("Entered Message Displayed Succesfully");
		p.sendKeys(Keys.RETURN);
		test1.pass("Passed the Search");
		Assert.assertTrue(true);
		extent.flush();
	
		}
	@AfterMethod
	public void afterMethod() {
	    extent.flush();
	    driver.close();
	}

	}

