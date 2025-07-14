package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IndexHtml {
public static void main(String[] args)throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");
   WebDriver driver = new ChromeDriver();
   
   driver.get("D:\\My-Data\\JAVA\\Selenium\\index.html");
   
//   driver.findElement(By.className("username")).sendKeys("Gauri");
//   driver.findElement(By.className("pass")).sendKeys("gaurib");
   
   driver.findElement(By.xpath("/html/body/form/div[1]/input[1]")).sendKeys("Gauri");
   driver.findElement(By.xpath("/html/body/form/div[1]/input[2]")).sendKeys("gauri");    
   
   
   Thread.sleep(2000);
   WebElement sel = driver.findElement(By.tagName("select"));
   Select s = new Select(sel);
  // s.selectByValue("firefox");
   s.selectByIndex(2);
   
   driver.findElement(By.xpath("/html/body/form/div[1]/button")).click();
   
   Thread.sleep(1000);
   //driver.close();
}
}
