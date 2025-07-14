package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Indexpg_Immediate_Following_Sibling {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\\\My-Data\\\\JAVA\\\\Selenium\\\\131\\\\chromedriver-win64\\\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("D:\\My-Data\\JAVA\\Selenium\\index.html");
		
		driver.findElement(By.xpath("//label[1]/following-sibling::*[1]")).sendKeys("gauri");
		
		driver.findElement(By.xpath("//label[1]/following-sibling::*[5]")).sendKeys("gaurib");
		
		Thread.sleep(500);
		driver.findElement(By.xpath("//option/following-sibling::*")).click();
		
		Thread.sleep(500);
		driver.findElement(By.xpath("//select/following-sibling::*[4]")).click();
		
		Thread.sleep(500);
		driver.close();
		
}}
