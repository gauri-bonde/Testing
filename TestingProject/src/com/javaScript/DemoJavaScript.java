package com.javaScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoJavaScript {
public static void main(String[] args)throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.apsrtconline.in/oprs-web/guest/home.do?h=1");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("(scrollBy(0, 200))");
	
	WebElement fromCity = driver.findElement(By.name("source"));
	fromCity.sendKeys("VIJ");
	
	String cityValue ="return document.getElementById(\"fromPlaceName\").value;";
    
	String cityv = (String)js.executeScript(cityValue);
	
	System.out.println(cityv);
	
	while (!cityv.equalsIgnoreCase("VIJAYAWADA INTERNATIONAL AIRPORT"))
	{
		fromCity.sendKeys(Keys.DOWN);
		cityValue ="return document.getElementById(\"fromPlaceName\").value;";
		cityv =(String)js.executeScript(cityValue);
		System.out.println(cityv);
		Thread.sleep(2000);
	}
    fromCity.sendKeys(Keys.ENTER);
    
    //To City
    WebElement toCity = driver.findElement(By.name("destination"));
    toCity.sendKeys("MUM");
    
    String toCityVal = "return document.getElementById(\"toPlaceName\").value;";
    
    String cityVal =(String)js.executeScript(toCityVal);
    System.out.println(cityVal);
    
    while(!cityVal.equalsIgnoreCase("MUMMIDIVARAM"))
    {
    	toCity.sendKeys(Keys.DOWN);
    	toCityVal="return document.getElementById(\"toPlaceName\").value;";
    
    	cityVal= (String)js.executeScript(toCityVal);
    	System.out.println(cityVal);
    	Thread.sleep(2000);
    }
    toCity.sendKeys(Keys.ENTER);
    
    Thread.sleep(2000);
    driver.close();
 }
}
