package com.alertsInteface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
public static void main(String[] args) throws InterruptedException{
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://demoqa.com/alerts");
	
	driver.manage().window().maximize();
    driver.findElement(By.xpath("//*[@id=\"javascriptAlertsWrapper\"]/div[1]/div[2]")).click();
    Thread.sleep(2000);
    driver.switchTo().alert().accept();
    Thread.sleep(2000);

//driver.findElement(By.id("timerAlertButton")).click();
//driver.switchTo().alert().accept();
//
//driver.findElement(By.id("confirmButton")).click();
//Thread.sleep(2000);
//driver.switchTo().alert().dismiss();
//
//driver.findElement(By.id("promtButton")).click();
//Thread.sleep(2000);
//driver.switchTo().alert().sendKeys("CJC Pune");
//driver.switchTo().alert().accept();

}
}
