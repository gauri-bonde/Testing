package com.alertsInteface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoAlertsInterface {
public static void main(String[] args)throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://demo.automationtesting.in/Alerts.html");
	
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//button[@class=\"btn btn-danger\"]")).click();
	
	Thread.sleep(2000);
	driver.switchTo().alert().accept(); 
	
	Thread.sleep(500);
	//For dismiss();
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]")).click();
	driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
	Thread.sleep(2000);
	driver.switchTo().alert().dismiss();
	
	//getText();
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]")).click();
	driver.findElement(By.xpath("//*[@id=\"Textbox\"]")).click();
	Thread.sleep(2000);
	
	driver.switchTo().alert().sendKeys("CJC");
	driver.switchTo().alert().accept();
	
	
}
}
