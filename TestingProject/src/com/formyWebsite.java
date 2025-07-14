package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class formyWebsite {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://formy-project.herokuapp.com/autocomplete");
	
	driver.manage().window().maximize();
	
	WebElement address = driver.findElement(By.id("autocomplete"));
	address.sendKeys("ABC XYZ");
	
	WebElement sAddress =driver.findElement(By.id("route"));
	sAddress.sendKeys("gggggg");
	
	WebElement city = driver.findElement(By.id("locality"));
	city.sendKeys("Pune");
	
	WebElement state = driver.findElement(By.id("administrative_area_level_1"));
	state.sendKeys("Maharashtra");
	
	WebElement zipCode = driver.findElement(By.id("postal_code"));
	zipCode.sendKeys("444566");
	
	WebElement country = driver.findElement(By.id("country"));
	country.sendKeys("India");
	
	Thread.sleep(5000);
	driver.close();
}
}
