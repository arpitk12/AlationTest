package com.alation.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AmazonComp
{
	private WebDriver driver;
	
	
	public AmazonComp(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void selectListByValue(By element,String text)
	{
		
		Select list=new Select(driver.findElement(element));
		list.selectByVisibleText(text);
	}
	
	public void enterValue(By element,String text)
	{
		WebElement textbox=driver.findElement(element);
		textbox.sendKeys(text);
		
	}
	
	public void clickOn(By element)
	{
		driver.findElement(element).click();
	}
	
	
	public String getText(By element)
	{
		return driver.findElement(element).getText();
	}
	
	public Boolean isElementPresent(By element)
	{
		if(driver.findElements(element).size()>0)
		{
			return true;
		}
		return false;
	}
	
}