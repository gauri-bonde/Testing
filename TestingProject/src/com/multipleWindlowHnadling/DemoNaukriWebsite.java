package com.multipleWindlowHnadling;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoNaukriWebsite {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.naukri.com/");
	driver.manage().window().maximize();
	
//1.find total hyperlink
	List<WebElement> list = driver.findElements(By.tagName("a"));
	int thl = list.size();
	System.out.println(thl);
	
	//2.Footer hyperlink
	WebElement fdriver = driver.findElement(By.className("nI-gNb-footer"));
	List<WebElement> flist =fdriver.findElements(By.tagName("a"));
	int fcount = flist.size();
	System.out.println(fcount);
	
	//3.Perticular footer link
	WebElement pfdriver = driver.findElement(By.xpath("//*[@id=\"root\"]/footer/section[1]/div/div/div[2]"));
	List<WebElement> pflist = pfdriver.findElements(By.tagName("a"));
	int pfcount = pflist.size();
	System.out.println(pfcount);
	
	//4.open all hyperlink in seperate window
	for(int i = 0; i<pfcount; i++ )
	{
		String clicklink = Keys.chord(Keys.CONTROL, Keys.ENTER);
		pfdriver.findElements(By.tagName("a")).get(i).sendKeys(clicklink);
		Thread.sleep(3000);
	}
	
	//5.
	Set<String> s = driver.getWindowHandles();
	for(String string : s)
	{
		driver.switchTo().window(string);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Thread.sleep(5000);
		if(url.equalsIgnoreCase("https://careers.infoedge.com/infoedge/"))
		{
			driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/div/ul/li[2]")).click();
		}
	}
	Thread.sleep(2000);
	driver.close();
}
}
