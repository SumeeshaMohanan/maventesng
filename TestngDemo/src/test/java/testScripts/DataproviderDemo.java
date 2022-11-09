package testScripts;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderDemo {
  @Test(dataProvider="mydata")
  public void search(String uname, String passwd) {
	  
		System.out.println("Username:"+uname+"  Password:"+passwd);
  }
  @DataProvider(name = "mydata")
	public Object[][] dataProvFunc(){
      	return new Object[][]{
            	{"user1","pwd1"},{"user2","pwd2"},{"user3","pwd3"}
      	};
	}
}
