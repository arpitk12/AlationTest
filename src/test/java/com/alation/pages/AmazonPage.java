package com.alation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.alation.component.AmazonComp;



public class AmazonPage
{
	private static WebDriver driver;
	private static AmazonComp comp;
	private By categoryList=By.xpath("//select[@id='searchDropdownBox']");
	private By searchBox=By.id("twotabsearchtextbox");
	private By searchbtn=By.xpath("//input[@type='submit']");
	private By logo=By.xpath("//div[@id='nav-logo']");
	private By searchResult=By.xpath("//div[@id='atfResults']");
	
	public AmazonPage(WebDriver driver)
	{
		AmazonPage.driver=driver;
		
	}
	
	public void launchApp(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		AmazonPage.comp=new AmazonComp(driver);
		// assertion is used to check if webpage is loaded. script should fail and stop if page not loaded 
		Assert.assertTrue(comp.isElementPresent(logo));
	}
	
	public void searchByCategory(String cat,String item)
	{
		comp.selectListByValue(categoryList,cat);
		comp.enterValue(searchBox,item);
		comp.clickOn(searchbtn);
		Assert.assertTrue(comp.isElementPresent(searchResult));
	}
	
	
	
	
	
}