package com.followingSibling;

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
	    driver.findElement(By.xpath("//div[@class=\"fieldset\"]/div[2]/div[4]/preceding-sibling::div[3]/div[2]/input")).click();
	    
	    driver.findElement(By.xpath("//div[@class=\"fieldset\"]/div[2]/div[1]/following-sibling::div[1]/input")).sendKeys("FirstName");
	    
	    driver.findElement(By.xpath("//div[@class=\"fieldset\"]/div[2]/div[1]/following-sibling::div[2]/input")).sendKeys("LastName");	
	    
	    driver.findElement(By.xpath("//div[@class=\"fieldset\"]/div[2]/div[1]/following-sibling::div[3]/input")).sendKeys("gauri@gmail.com");		

	    //Your Password
	  		driver.findElement(By.xpath("//div[4]/div[1]/div[4]/div[2]/form/div[1]/div[2]/div[3]/div[2]/div[2]/preceding-sibling::div/input")).sendKeys("password");
	  		driver.findElement(By.xpath("//div[4]/div[1]/div[4]/div[2]/form/div[1]/div[2]/div[3]/div[2]/div[1]/following-sibling::div[1]/input")).sendKeys("password");
	  		
	  		Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class=\"buttons\"]/input[@id=\"register-button\"]")).click();
			}
}
