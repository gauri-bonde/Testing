package com.immediateProcedingSibling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demowebshop {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/register");
		
		driver.manage().window().maximize();
		
		//Your Personal Details
		driver.findElement(By.xpath("")).click();

	
	
	
	}}
