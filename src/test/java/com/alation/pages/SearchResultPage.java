package com.alation.pages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.alation.component.AmazonComp;
import com.cedarsoftware.util.io.JsonWriter;

public class SearchResultPage
{
	private static WebDriver driver;
	private static AmazonComp comp;
	
	private By bookTitle=By.xpath("//div[@id='atfResults']//li[1]//h2");
	private By bookDate=By.xpath("//div[@id='atfResults']//li[1]//h2//parent::a//following-sibling::span[string-length(text()) > 0]");
	private By bookAuth=By.xpath("//div[@id='atfResults']//li[1]//span[text()='by ']//following-sibling::span");
	private By bookPrime=By.xpath("//div[@id='atfResults']//li[1]//i[contains(@class,'a-icon-prime')]");
	private By paperback=By.xpath("//div[@id='atfResults']//li[1]//a[@title='Paperback']");
	private By paperbackPrice=By.xpath("//div[@id='atfResults']//li[1]//a[@title='Paperback']/parent::div/following-sibling::div[1]/a/span[2]");
	private By hardcover=By.xpath("//div[@id='atfResults']//li[1]//a[@title='Hardcover']");
	private By hardcoverPrice=By.xpath("//div[@id='atfResults']//li[1]//a[@title='Hardcover']/parent::div/following-sibling::div[1]/a/span[2]");
	private By kindle=By.xpath("//div[@id='atfResults']//li[1]//a[@title='Kindle Edition']");
	private By kindlePrice=By.xpath("//div[@id='atfResults']//li[1]//a[@title='Kindle Edition']/parent::div/following-sibling::div[1]/a/span[2]");
	
	protected Map<String,String> json=new HashMap<String,String>();
	
	public SearchResultPage(WebDriver driver)
	{
		SearchResultPage.driver=driver;
		comp=new AmazonComp(driver);
	}
	
	public void getBookTitle()
	{
		String title=comp.getText(bookTitle);
		System.out.println("Title: "+title);
		json.put("Title",title);
		
	}
	public void getBookDate()
	{
		String dateBook=comp.getText(bookDate);
		System.out.println("Book Date: "+dateBook);
		json.put("Date",dateBook);
		
	}
	
	public void getBookAuthor()
	{
		String bookAuthor=comp.getText(bookAuth);
		System.out.println("Book Author: "+bookAuthor);
		json.put("Author",bookAuthor);
		
	}
	
	public void getBookPrimeInfo()
	{
		String primeInfo;
		if(comp.isElementPresent(bookPrime)) 
		{
			primeInfo="Eligible for Prime";
		}
		else
		{
			primeInfo="Not Eligible for Prime";
		}
		System.out.println("Book prime Info: "+primeInfo);
		json.put("PrimeInfo",primeInfo);
		
	}
	
	public void getEditionPrice()
	{
		if(comp.isElementPresent(paperback))
		{
			json.put("PaperbackPrice", "INR "+comp.getText(paperbackPrice));
		}
		if(comp.isElementPresent(hardcover))
		{
			json.put("HardcoverPrice", "INR "+comp.getText(hardcoverPrice));
		}
		if(comp.isElementPresent(kindle))
		{
			json.put("KindleEditionPrice", "INR "+comp.getText(kindlePrice));
		}
	}
	
	
	public void writeToJson(String file) throws IOException
	{
		JSONObject jsonObj=new JSONObject(json);
		 
		FileWriter fileJson=new FileWriter(new File(Paths.get("./src/test/resources/output/"+file+".json").toString()));
		fileJson.write(JsonWriter.formatJson(jsonObj.toString()));
		fileJson.flush();
		fileJson.close();
	}
}