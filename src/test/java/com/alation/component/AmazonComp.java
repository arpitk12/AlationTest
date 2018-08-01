package com.alation.component;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonComp
{
	private WebDriver driver;
	private WebDriverWait wait;
	public AmazonComp(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver,30);
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
		Set<String> windowhandles=driver.getWindowHandles();
		String current=driver.getWindowHandle();
		
		for(String handle:windowhandles)
		{
			if(handle!=current)
			{
				driver.switchTo().window(handle);
			}
		}
		return driver.findElement(element).getText();
	}
}