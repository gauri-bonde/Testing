package com.CSSLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShopTagnameAttributeValue {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/register");
		
		driver.manage().window().maximize();

		//Your Personal Details
		driver.findElement(By.cssSelector("input[id='gender-female']")).click();
		driver.findElement(By.cssSelector("input[id='FirstName']")).sendKeys("FirstName");
		driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("LastName");
		driver.findElement(By.cssSelector("input[id='Email']")).sendKeys("gaurib@gmail.com");
		
		driver.findElement(By.cssSelector("input[id='Password']")).sendKeys("password");
		driver.findElement(By.cssSelector("input[id='ConfirmPassword']")).sendKeys("password");
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id='register-button']")).click();

		
	}

	private static By ByCssSelector(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
