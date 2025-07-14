package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Indexpg_Immediate_Preceding_Sibling {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\\\My-Data\\\\JAVA\\\\Selenium\\\\131\\\\chromedriver-win64\\\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("D:\\My-Data\\JAVA\\Selenium\\index.html");
		
		//By using Immediate Sibling
		driver.findElement(By.xpath("//button/preceding-sibling::*[11]")).sendKeys("gauri");
		driver.findElement(By.xpath("//button/preceding-sibling::*[7]")).sendKeys("gaurib");
		
		//By using following-sibling
		driver.findElement(By.xpath("//label[2]/following-sibling::select/option[3]")).click();
		
		Thread.sleep(500);
		driver.findElement(By.xpath("//select[@id=\"browser\"]/following-sibling::button[1]")).click();
	}
}
