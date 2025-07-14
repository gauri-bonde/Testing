package com.CSSLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShop_MatchwithPrifix {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/register");
		
		driver.manage().window().maximize();
		
		//Your Personal Details
				driver.findElement(By.cssSelector("input[id^='gender-f']")).click();
				driver.findElement(By.cssSelector("input[id^='Fir']")).sendKeys("FirstName");
				driver.findElement(By.cssSelector("input[id^='Las']")).sendKeys("LastName");
				driver.findElement(By.cssSelector("input[id^='Ema']")).sendKeys("gaurib@gmail.com");
				
				driver.findElement(By.cssSelector("input[id^='Pas']")).sendKeys("password");
				driver.findElement(By.cssSelector("input[id^='Conf']")).sendKeys("password");
				
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("input[id^='register-butt']")).click();
}}
