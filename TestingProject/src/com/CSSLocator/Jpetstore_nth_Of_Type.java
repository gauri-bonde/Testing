package com.CSSLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jpetstore_nth_Of_Type {
	public static void main(String[] args) throws InterruptedException{
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();
	driver.get("https://jpetstore.aspectran.com/account/newAccountForm");
	
	driver.manage().window().maximize();
	
	driver.findElement(By.cssSelector("td input:nth-of-type(1)")).sendKeys("johndoe");

}
}
