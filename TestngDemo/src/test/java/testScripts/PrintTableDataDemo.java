package testScripts;

import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrintTableDataDemo {
	WebDriver driver;

	@BeforeTest(alwaysRun = true)
	public void lauchBrowser() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");

	}

	@Test
	public void printData() {
		driver.navigate().to("https://selenium.obsqurazone.com/table-pagination.php");

		/*
		 * these are used to fetch and display a particular value from a static table
		 * String salary=
		 * driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[4]/td[6]"))
		 * .getText(); System.out.println(salary);
		 */
		
		// Fetch total column and rows from a dynamic table
		
		List<WebElement> columnsNumber = driver.findElements(By.xpath("//*[@id=\"dtBasicExample\"]/thead/tr/th"));
		int colCount = columnsNumber.size();
		System.out.println("No of cols are : " + colCount);
		// No.of rows
		List<WebElement>  rows = driver.findElements(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td"));
		int rowCount = rows.size();
		System.out.println("No of rows are : " + rowCount);
//to fetch a particular row, particular column value,here we define the row number and column number
		WebElement rowdata=driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[4]/td[6]"));
		String rowvalue=rowdata.getText();
		System.out.println("Value ="+ rowvalue);

	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
