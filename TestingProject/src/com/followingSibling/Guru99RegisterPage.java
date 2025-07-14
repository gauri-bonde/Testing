package com.followingSibling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Guru99RegisterPage {
	

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[5]/preceding-sibling::tr[3]/td[2]/input[@name=\"firstName\"]")).sendKeys("FirstName");

		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[2]/following-sibling::tr[1]/td[2]/input[@name=\"lastName\"]")).sendKeys("LastName");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[2]/following-sibling::tr[2]/td[2]/input[@name=\"phone\"]")).sendKeys("987654321");

		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[2]/following-sibling::tr[3]/td[2]/input[@name=\"userName\"]")).sendKeys("example@gmail.com");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[2]/following-sibling::tr[5]/td[2]/input[@name=\"address1\"]")).sendKeys("Address1");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[2]/following-sibling::tr[6]/td[2]/input[@name=\"city\"]")).sendKeys("City");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[2]/following-sibling::tr[7]/td[2]/input[@name=\"state\"]")).sendKeys("State");
	
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[2]/following-sibling::tr[8]/td[2]/input[@name=\"postalCode\"]")).sendKeys("555555");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[2]/following-sibling::tr[9]/td[2]/select/option[@value=\"INDIA\"]")).click();
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[2]/following-sibling::tr[11]/td[2]/input[@name=\"email\"]")).sendKeys("gauri");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[2]/following-sibling::tr[12]/td[2]/input[@name=\"password\"]")).sendKeys("gaurib");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[2]/following-sibling::tr[13]/td[2]/input[@name=\"confirmPassword\"]")).sendKeys("gaurib");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[2]/following-sibling::tr[15]/td[1]/input[@name=\"submit\"]")).click();

		
		
	}}
