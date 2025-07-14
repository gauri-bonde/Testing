package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\\\My-Data\\\\JAVA\\\\Selenium\\\\131\\\\chromedriver-win64\\\\chromedriver.exe");
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		
		String title =driver.getTitle();
		System.out.println(title);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		//driver.close();
	}
}
