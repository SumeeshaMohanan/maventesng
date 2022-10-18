package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderDemo {
  @Test(dataProvider="mydata")
  public void search() {
	  String path = System.getProperty("user.dir");
		System.out.println();
  }
  @DataProvider(name = "mydata")
	public Object[][] dataProvFunc(){
      	return new Object[][]{
            	{"user1","pwd1"},{"user2","pwd2"},{"user3","pwd3"}
      	};
	}
}
