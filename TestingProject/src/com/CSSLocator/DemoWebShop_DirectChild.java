//Direct Child CSS
package com.CSSLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShop_DirectChild {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/register");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("div.gender>input#gender-female")).click();
		driver.findElement(By.cssSelector("div.inputs>input#FirstName")).sendKeys("FirstName");
		driver.findElement(By.cssSelector("div.inputs>input#LastName")).sendKeys("LastName");
		driver.findElement(By.cssSelector("div.inputs>input#Email")).sendKeys("email@gmail.com");
		
		driver.findElement(By.cssSelector("div.inputs>input#Password")).sendKeys("Password");
		driver.findElement(By.cssSelector("div.inputs>input#ConfirmPassword")).sendKeys("Password");
		driver.findElement(By.cssSelector("div.buttons>input#register-button")).click();
		
		Thread.sleep(2000);
        driver.close();
	}
}
