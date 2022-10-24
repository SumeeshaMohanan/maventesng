package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PomDemoHome {
  WebDriver driver;
  By homeusername=By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td");
  
  public  PomDemoHome(WebDriver driver) {
	  this.driver=driver;
  }
  public String getUsername() {
	  return driver.findElement(homeusername).getText();
	  
  }
 
}
