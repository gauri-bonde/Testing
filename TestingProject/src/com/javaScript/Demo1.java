package com.javaScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.railyatri.in/train-ticket?utm_source=ttb_pf_max&pt_source=googleads&pt_medium=cpc&pt_campaign=&gad_source=1&gad_campaignid=21023153239&gbraid=0AAAAADtj8mzx7FtnfI8Gd9eT7wyIxTXEX&gclid=CjwKCAjwr5_CBhBlEiwAzfwYuNpgrOg8EX0JUVem2RLaYU18GXoH25q7UYEc7AHiegqioBzOzCWE0RoCGbYQAvD_BwE");
	driver.manage().window().maximize();
	
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement fromSta =  driver.findElement(By.xpath("//*[@id=\"fromstation\"]"));
	fromSta.sendKeys("ISM");	
	
	String stationVal = "return document.getElementById(\"fromstation\").value;";
	String staVal =(String)js.executeScript(stationVal);
	System.out.println(staVal);
	
	while(!staVal.equalsIgnoreCase("ISMAILPUR | IMGE"))
	{
		fromSta.sendKeys(Keys.DOWN);
		stationVal = "return document.getElementById(\"fromstation\").value;";
		staVal =(String)js.executeScript(stationVal);
		System.out.println(staVal);
		Thread.sleep(2000);
	}
	fromSta.sendKeys(Keys.ENTER);
	
	Thread.sleep(5000);
	driver.close();
}
}
