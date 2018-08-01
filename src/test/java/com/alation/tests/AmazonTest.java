package com.alation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alation.pages.AmazonPage;

public class AmazonTest {
  
	private WebDriver driver;
	
	//initiation of webdriver with chrome browser
  @BeforeClass
  public void setupDriver() {
	
	  System.setProperty("webdriver.chrome.driver", "src/test/resources/lib/chromedriver.exe");
	  driver=new ChromeDriver();
	  
  }

  @Test
  public void testAmazon() {
	  AmazonPage page=new AmazonPage(driver);
	  page.launchApp("http://amazon.in");
	  page.searchByCategory("Books","data catalog");
	  page.selectFirstItem();
	  page.getProductInfo();
	  
  }
  
  
  @AfterClass
  public void closeAll() {
  }

}
