package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoSelenium {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
       WebDriver driver= new ChromeDriver();
       driver.get("https://demowebshop.tricentis.com/");
       
       driver.close();
       
	}
}
