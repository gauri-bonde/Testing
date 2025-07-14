package com.frameConcept;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoDragDrop {
public static void main(String[] args)throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://jqueryui.com");
	
	driver.manage().window().maximize();
	WebElement dropable = driver.findElement(By.linkText("Droppable"));
	dropable.click();
	
	//driver.switchTo().frame(0);
	WebElement iframe = driver.findElement(By.className("demo-frame"));
	driver.switchTo().frame(iframe);
	
	WebElement source = driver.findElement(By.id("draggable"));
	WebElement target = driver.findElement(By.id("droppable"));
	
	Actions ac = new Actions(driver);
	//ac.dragAndDrop(source, target).build().perform();  //dragAndDrop() method
	
    //clickAndHold() method
	ac.clickAndHold(source).build().perform();
	Thread.sleep(2000);
	ac.dragAndDrop(source, target).release().perform();
	
	
//	Thread.sleep(2000);
//	driver.close();
}
}
