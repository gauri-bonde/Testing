package com.CSSLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWeb_DirectChildAnotherSyntax {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/register");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("div[class='inputs'] input[id='gender-female']")).click();
		driver.findElement(By.cssSelector("div[class='inputs'] input[class='text-box single-line']")).sendKeys("FirstName");
		driver.findElement(By.cssSelector("div[class='inputs'] input[id='LastName']")).sendKeys("LastName");
		driver.findElement(By.cssSelector("div[class='inputs'] input[id='Email']")).sendKeys("demo@gmail.com");
		
		driver.findElement(By.cssSelector("div[class='inputs'] input[id='Password']")).sendKeys("password");
		driver.findElement(By.cssSelector("div[class='inputs'] input[id='ConfirmPassword']")).sendKeys("password");
		
		driver.findElement(By.cssSelector("div[class='buttons'] input[name=\"register-button\"]")).click();

		Thread.sleep(2000);
		driver.close();
	}
}
