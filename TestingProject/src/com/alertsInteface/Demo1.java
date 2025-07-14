package com.alertsInteface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/alerts.html");
		
		driver.manage().window().maximize();
	    driver.findElement(By.xpath("//*[@id=\"alert\"]")).click();
	    Thread.sleep(2000);
	    driver.switchTo().alert().accept();
	    
	    driver.findElement(By.xpath("//*[@id=\"empty-alert\"]")).click();
	    Thread.sleep(2000);
	    driver.switchTo().alert().accept();
	    
	    driver.findElement(By.xpath("//*[@id=\"prompt\"]")).click();
	    Thread.sleep(2000);
	    driver.switchTo().alert().sendKeys("CJC Pune");
	    driver.switchTo().alert().accept();
	    
	    driver.findElement(By.xpath("//*[@id=\"double-prompt\"]")).click();
	    Thread.sleep(2000);
	    driver.switchTo().alert().sendKeys("CJC");
	    driver.switchTo().alert().accept();
	    Thread.sleep(1000);
	    driver.switchTo().alert().sendKeys("CJC Pune");
	    driver.switchTo().alert().accept();
	    
	    driver.findElement(By.xpath("//*[@id=\"confirm\"]")).click();
	    Thread.sleep(2000);
	    driver.switchTo().alert().accept();
	    Thread.sleep(2000);
	    driver.navigate().back();
	    
	    
	    WebElement iframe =  driver.findElement(By.xpath("//html/body/p[9]/iframe"));
	    driver.switchTo().frame(iframe);
	    driver.findElement(By.xpath("//*[@id=\"alertInFrame\"]")).click();
	    driver.switchTo().alert().accept();
	    
	    
	    //2 iframe
	    WebElement iframe1 = driver.findElement(By.xpath("/html/body/p[10]/iframe"));
	    driver.switchTo().frame(iframe1);
	    WebElement iframe2 = driver.findElement(By.xpath("/html/body/iframe"));
	    driver.switchTo().frame(iframe2);
	    driver.findElement(By.xpath("//*[@id=\"alertInFrame\"]")).click();
	    Thread.sleep(2000);
	    driver.switchTo().alert().accept();
	}
}
