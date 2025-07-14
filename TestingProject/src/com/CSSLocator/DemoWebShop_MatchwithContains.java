package com.CSSLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShop_MatchwithContains {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/register");
		
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[id*='gender-female']")).click();
		driver.findElement(By.cssSelector("input[id*='FirstName']")).sendKeys("FirstName");
		driver.findElement(By.cssSelector("input[id*='LastName']")).sendKeys("LastName");
		driver.findElement(By.cssSelector("input[id*='Email']")).sendKeys("gbonde@gmail.com");
		
		driver.findElement(By.cssSelector("input[id*='Password']")).sendKeys("password");
		driver.findElement(By.cssSelector("input[id*='ConfirmPassword']")).sendKeys("password");
		
		driver.findElement(By.cssSelector("input[id*='register-button']")).click();
		
		Thread.sleep(2000);
		driver.close();
}}
