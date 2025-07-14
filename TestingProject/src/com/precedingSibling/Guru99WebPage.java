package com.precedingSibling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Guru99WebPage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[5]/preceding-sibling::tr[3]/td[2]/input[@name=\"firstName\"]")).sendKeys("FirstName");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[5]/preceding-sibling::tr[2]/td[2]//input[@name=\"lastName\"]")).sendKeys("LastName");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[5]/preceding-sibling::tr[1]/td[2]//input[@name=\"phone\"]")).sendKeys("9876543212");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[7]/preceding-sibling::tr[2]/td[2]/input[@id=\"userName\"]")).sendKeys("example@gmail.com");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[11]/preceding-sibling::tr[4]/td[2]/input[@name=\"address1\"]")).sendKeys("Address1");
	
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[11]/preceding-sibling::tr[3]/td[2]//input[@name=\"city\"]")).sendKeys("City");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[11]/preceding-sibling::tr[2]/td[2]//input[@name=\"state\"]")).sendKeys("State");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[11]/preceding-sibling::tr[1]/td[2]//input[@name=\"postalCode\"]")).sendKeys("456789");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[13]/preceding-sibling::tr[2]/td[2]/select/option[@value=\"INDIA\"]")).click();
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[17]/preceding-sibling::tr[4]/td[2]/input[@name=\"email\"]")).sendKeys("gauri");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[17]/preceding-sibling::tr[3]/td[2]/input[@name=\"password\"]")).sendKeys("gaurib");
		
		driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[17]/preceding-sibling::tr[2]/td[2]/input[@name=\"confirmPassword\"]")).sendKeys("gaurib");
	
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[15]/following-sibling::tr[2]/td[1]/input[@name=\"submit\"]")).click();
	}
}
