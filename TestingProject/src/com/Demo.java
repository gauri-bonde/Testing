package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args)throws InterruptedException  {
		System.out.println("Hello");
		//System.setProperties("webdriver.ie.driver", ""); // for internal exploere
		System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");
		/*How to Check Chrome Version and Download Compatible ChromeDriver for Selenium
		  Step 1: Check your current Chrome browser version
                  - Open Google Chrome.
                  - Click on the three vertical dots (top-right corner).
                  - Go to Help → About Google Chrome.
                  - your Chrome version.Example: 131.0.6778.70
                  
         Step 2: Download the matching ChromeDriver
                  - Open Google and search for:chrome driver download for selenium
                  - Click on the official link: https://developer.chrome.com/docs/chromedriver/downloads
                  - On the downloads page, scroll down and find the version that matches the major version of your Chrome.
                    * For version 131.x, click on the corresponding ChromeDriver 131 download link.
                  - Download the correct ChromeDriver for your system (Windows/Linux/Mac).*/

	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize(); //to maximize window
		
		String title = driver.getTitle() ; //to get title
		System.out.println(title);
		
		String curl = driver.getCurrentUrl(); //to get url
		System.out.println(curl);
		
		 String ps = driver.getPageSource();
		 //System.out.println(ps);
		   
		   WebElement us =  driver.findElement(By.name("email"));
		   us.sendKeys("gauri"); 
		  
		  
		    //driver.close();
		  
		   //driver.quit();
		   
		   Thread.sleep(2000);
		   driver.navigate().to("https://www.google.co.in/");
	
		   Thread.sleep(2000);
	       driver.navigate().back();
	       
	       Thread.sleep(2000);
	       driver.navigate().forward();
	}
}
