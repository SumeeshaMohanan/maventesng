package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicTable {
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

		String pname = "Cedric Kelly";
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td"));
		int rowCount = rows.size();
		System.out.println("No of rows are : " + rowCount);
		for (int i = 1; i <= rowCount; i++) {
			String sValue = null;
			sValue = driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[" + i + "]/td[1]")).getText();
			
			if (sValue.equalsIgnoreCase(pname)) {
				System.out.println(sValue);
				//*[@id="dtBasicExample"]/tbody/tr[4]/td[6]
							//	for (int j = 1; j <= rowCount - 1; j++) {
					String rowValue = driver
							.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[" + i + "]/td[6]"))
							.getText();
					System.out.println(rowValue);
					break;
				//}
				
			}
		}

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
