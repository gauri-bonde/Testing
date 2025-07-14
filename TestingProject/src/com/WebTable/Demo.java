package com.WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
	driver.manage().window().maximize();
	
	driver.findElement(By.id("customers"));
	List<WebElement> allTableRows = driver.findElements(By.tagName("tr")); 
	int trCount = allTableRows.size();
	System.out.println(trCount);
	
	//To print all table row data
	for (WebElement printRows : allTableRows) {
	List<WebElement> atd = printRows.findElements(By.tagName("td"));
	int atdCount = atd.size();
	//System.out.println(atdCount);
	
	for (WebElement cols : atd) {
		System.out.println(cols.getText());
	}
	}
		
	//to print perticular row of data
	System.out.println("---------------Print Tr4------------");
	List<WebElement> trData = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[4]"));
	for (WebElement pCol : trData) {
		System.out.println(pCol.getText());
	}
	driver.close();
}
}
