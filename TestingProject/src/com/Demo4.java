package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.FindElement;

public class Demo4 {
public static void main(String[] args) throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();
	driver.get("D:\\My-Data\\JAVA\\Selenium\\index.html");
	
	driver.manage().window().maximize();
	
	/*to get titiel*/
	String title = driver.getTitle();
	System.out.println(title);
	
	WebElement uname = driver.findElement(By.name("uname"));
	uname.sendKeys("Gauri");
	
	Thread.sleep(2000);
	WebElement pass = driver.findElement(By.name("pass"));
	pass.sendKeys("gauri");
	
	Thread.sleep(2000);
	WebElement click = driver.findElement(By.name("login"));
	click.click();
	
	Thread.sleep(3000);
	
	driver.close();
}
}
