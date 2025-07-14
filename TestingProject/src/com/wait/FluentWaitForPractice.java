package com.wait;

import java.awt.Scrollbar;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitForPractice {
//https://softwaretestingplace.blogspot.com/2017/02/selenium-fluent-wait.html
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://softwaretestingplace.blogspot.com/2017/02/selenium-fluent-wait.html");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("(scrollBy(0, 600))");
		
		driver.findElement(By.xpath("//*[@id=\"post-body-5280210221385817166\"]/div[1]/button")).click();

		Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		w.until(new Function<WebDriver, WebElement>()
				{

					@Override
					public WebElement apply(WebDriver t) {
						// TODO Auto-generated method stub
						WebElement msg = t.findElement(By.id("demo"));
						String s = msg.getText();
						if(s.equals("Software Testing Material - DEMO PAGE"))
						{
						return msg;
						}
						else
						{
							return null;
						}
					}
			
				});
		
		Thread.sleep(3000);
		driver.close();
	}
}
