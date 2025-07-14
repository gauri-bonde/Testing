package com.wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class DemoFluentWait {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();
	driver.get("https://softwaretestingplace.blogspot.com/2017/02/selenium-fluent-wait.html");
	
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div[1]/div/div/div[1]/article/div[2]/div[1]/button")).click();
	
	Wait<WebDriver> wait = new FluentWait<WebDriver>
	                         (driver).withTimeout(Duration.ofSeconds(10))
	                         .pollingEvery(Duration.ofSeconds(2))
	                         .ignoring(NoSuchElementException.class);
	
	wait.until(new Function<WebDriver, WebElement>() {
		public WebElement apply(WebDriver t)
		{
			WebElement msg = t.findElement(By.id("demo"));
			System.out.println("Fluent wait");
			String s = msg.getText();
			if(s.equals("Software Testing Material - DEMO PAGE"))
			{
				System.out.println(s);
				return msg;
			}
			else {
			return null;
			}
		}
	});
	
}
}
