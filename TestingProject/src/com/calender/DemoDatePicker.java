package com.calender;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoDatePicker {
	public static void main(String[] args)throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver","D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://jqueryui.com/datepicker/");
	driver.manage().window().maximize();
	
	driver.switchTo().frame(0);
	driver.findElement(By.id("datepicker")).click();
	//By using cssSelector
		while(!driver.findElement(By.cssSelector("[class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all'] [class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']")).getText().contains("September"))
		{
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("[class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all'] [class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		List<WebElement> ls = driver.findElements(By.cssSelector("td[data-handler='selectDay']"));
		int count = ls.size();
		System.out.println("Total Day Count " +count);
		for(int i=0; i<count; i++)
		{
			String dayValue = driver.findElements(By.cssSelector("td[data-handler='selectDay']"))
			.get(i).getText();
			System.out.println(dayValue);
			
			if(dayValue.equalsIgnoreCase("15"))
			{
				driver.findElements(By.cssSelector("td[data-handler='selectDay']"))
				.get(i).click();
			}
		}
		
		Thread.sleep(2000);
		driver.close();
		
}
}
