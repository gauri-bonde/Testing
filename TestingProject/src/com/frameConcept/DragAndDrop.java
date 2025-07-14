package com.frameConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args)throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		
		driver.manage().window().maximize();
		WebElement iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(iframe);
		
		WebElement source = driver.findElement(By.xpath("//*[@id=\"gallery\"]/li[1]"));
		WebElement target = driver.findElement(By.xpath("//*[@id=\"trash\"]"));
		
		WebElement imgdrap = driver.findElement(By.xpath("//*[@id=\"gallery\"]/li[3]"));
		
		
		Actions ac = new Actions(driver);
		ac.dragAndDrop(source, target).build().perform();
		
		Thread.sleep(5000);
		ac.dragAndDrop(imgdrap, target).build().perform();
	}
}
