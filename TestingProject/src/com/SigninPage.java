package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SigninPage {
	public static void main(String[] args)throws InterruptedException {
		//https://demo.guru99.com/test/newtours/register.php
		
		System.setProperty("webdriver.chrome.driver","D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		WebElement fName = driver.findElement(By.name("firstName"));
		fName.sendKeys("John");
		
		Thread.sleep(2000);
		WebElement lName = driver.findElement(By.name("lastName"));
		lName.sendKeys("Doe");
		
		
		Thread.sleep(2000);
		WebElement phone = driver.findElement(By.name("phone"));
		phone.sendKeys("9876543212");
		
		Thread.sleep(2000);
		WebElement email = driver.findElement(By.name("userName"));
		email.sendKeys("example@gamil.com");
		
		/*mailing Information*/
		Thread.sleep(2000);
		WebElement address = driver.findElement(By.name("address1"));
		address.sendKeys("Abc Xyz");
		
		Thread.sleep(2000);
		WebElement city = driver.findElement(By.name("city"));
		city.sendKeys("Pune");
		
		Thread.sleep(2000);
		WebElement state = driver.findElement(By.name("state"));
		state.sendKeys("Maharashtra");
		
		Thread.sleep(2000);
		WebElement pCode = driver.findElement(By.name("postalCode"));
		pCode.sendKeys("555555");
		
		/*User Information*/
		
		Thread.sleep(2000);
		WebElement uName = driver.findElement(By.id("email"));
		uName.sendKeys("example@gamil.com");
		
		Thread.sleep(2000);
		WebElement uPass = driver.findElement(By.name("password"));
		uPass.sendKeys("abc");
		
		Thread.sleep(2000);
		WebElement confPass = driver.findElement(By.name("confirmPassword"));
		confPass.sendKeys("abc");
		
		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();
		
		Thread.sleep(5000);
		driver.close();
		
	}

}
