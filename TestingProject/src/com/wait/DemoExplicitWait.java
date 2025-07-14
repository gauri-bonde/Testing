package com.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoExplicitWait {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/addUser");
		driver.manage().window().maximize();
		WebElement fn =  driver.findElement(By.xpath("//input[@id='firstName']"));
		fn.sendKeys("John");
		
		WebElement ln = driver.findElement(By.xpath("//input[@id='lastName']"));
		ln.sendKeys("Doe");

		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("doeqjohn@gmail.com");
		
		WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
		pass.sendKeys("john@123");
		
		WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
		submit.click();
		
		//using Excplicit Wait
		//WebElement addNew = driver.findElement(By.xpath("//button[@id='add-contact']"));
		WebDriverWait addNew = new WebDriverWait(driver, 10);
		addNew.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-contact"))).click();
		
		//driver.findElement(By.id("add-contact")).click();
		
		
	
		Thread.sleep(2000);
		//driver.close();
	}
}
