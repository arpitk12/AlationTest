package com.alation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.alation.component.AmazonComp;



public class AmazonPage
{
	private static WebDriver driver;
	private static AmazonComp comp;
	private By categoryList=By.xpath("//select[@id='searchDropdownBox']");
	private By searchBox=By.id("twotabsearchtextbox");
	private By searchbtn=By.xpath("//input[@type='submit']");
	private By firstItem=By.xpath("//div[@id='atfResults']/ul/li[1]/div/div/div/div");
	private By prod=By.id("productTitle");
	public AmazonPage(WebDriver driver)
	{
		AmazonPage.driver=driver;
		
	}
	
	public void launchApp(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		AmazonPage.comp=new AmazonComp(driver);
	}
	
	public void searchByCategory(String cat,String item)
	{
		comp.selectListByValue(categoryList,cat);
		comp.enterValue(searchBox,item);
		comp.clickOn(searchbtn);
	}
	
	public void selectFirstItem()
	{
		comp.clickOn(firstItem);
	}
	
	public void getProductInfo()
	{
		System.out.println(comp.getText(prod));
	}
}