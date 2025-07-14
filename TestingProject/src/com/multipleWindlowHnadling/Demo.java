package com.multipleWindlowHnadling;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//1. Total Hyperlink count
		List<WebElement> l =driver.findElements(By.tagName("a"));
		//System.out.println(l);
		int thl = l.size();
		System.out.println(thl);
		
		//2. Footer Hyperlink count
		WebElement fdriver = driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]"));
		List<WebElement> flist =fdriver.findElements(By.tagName("a"));
		int fcount = flist.size();
		System.out.println(fcount);
		
		//3. Perticular footer link
		WebElement pfdriver = driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[1]"));
		List<WebElement> pflist = pfdriver.findElements(By.tagName("a"));
		int pfcount = pflist.size();
		System.out.println(pfcount);
		
		//4. Open all hyperlink in sepertae window
		for(int i=1; i<pfcount; i++)
		{
			String clicklink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			pfdriver.findElements(By.tagName("a")).get(i).sendKeys(clicklink);
			Thread.sleep(2000);
		}
		
		//5.Travers one window to another window
		Set<String> s =driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(s);
		
		Iterator<String> itr =al.iterator();
		while(itr.hasNext()) {
			driver.switchTo().window(itr.next());
			String url = driver.getCurrentUrl();
			System.out.println(url);
			Thread.sleep(2000);
			
			if(url.equalsIgnoreCase("https://www.restapitutorial.com/"))
			{
				driver.findElement(By.xpath("//*[@id=\"R-topics\"]/ul/li[1]/a")).click();
				
			}
		}
	//driver.quit();
	}
	
}

