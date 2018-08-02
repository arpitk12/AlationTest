package com.alation.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alation.pages.AmazonPage;
import com.alation.pages.SearchResultPage;

public class AmazonTest {
  
	private WebDriver driver;
	
	//initiation of webdriver with chrome browser
  @BeforeClass
  public void setupDriver() {
	
	  System.setProperty("webdriver.chrome.driver", "src/test/resources/lib/chromedriver.exe");
	  driver=new ChromeDriver();
	  
  }

  @Test
  public void testAmazon() throws IOException {
	  AmazonPage page=new AmazonPage(driver);
	  SearchResultPage searchpage=new SearchResultPage(driver);
	  page.launchApp("http://amazon.in");
	  page.searchByCategory("Books","data catalog");
	  searchpage.getBookTitle();
	  searchpage.getBookAuthor();
	  searchpage.getBookDate();
	  searchpage.getBookPrimeInfo();
	  searchpage.getEditionPrice();
	  searchpage.writeToJson("Books");
	  
  }
  
  
  @AfterClass
  public void closeAll() {
  }

}
