package com.frameConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoFrame {
	public static void main(String[] args)throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.id("datepicker")).click();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("About")).click();
		
		Thread.sleep(500);
		driver.close();
}
}