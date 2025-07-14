package com.calender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoCalender {
public static void main(String[] args) throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://jqueryui.com/datepicker/");
	driver.manage().window().maximize();
	
	driver.switchTo().frame(0);
	driver.findElement(By.id("datepicker")).click();
	
	//By using Xpath
//	while (!driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]")).getText().contains("August"))
//	{
//		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]")).click();
//	}
	
	//By using cssSelector
	while(!driver.findElement(By.cssSelector("[class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all'] [class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']")).getText().contains("September"))
	{
		driver.findElement(By.cssSelector("[class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all'] [class='ui-icon ui-icon-circle-triangle-e']")).click();
	}
}
}
