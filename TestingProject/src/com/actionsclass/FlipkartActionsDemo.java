package com.actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartActionsDemo {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	
	Actions ac = new Actions(driver);
	
	WebElement electronicEqu = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[3]/div/div/div/div"));
	ac.click(electronicEqu).build().perform();
	
	WebElement flipkart = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[1]/div"));
	ac.doubleClick(flipkart).build().perform();
	
	WebElement cart = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div[1]/div/header/div[2]/div[3]/div"));
	ac.contextClick(cart).build().perform();
	
	WebElement d = driver.findElement(By.xpath("//*[@class='_3RX0a- _3jeYYh']"));
	ac.contextClick(d).build().perform();
}
}
