package com.actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoAction {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	Actions ac = new Actions(driver);
	
//	WebElement mobile = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/ul/li[5]/div/a"));
//	ac.click(mobile).build().perform();
//	
//	
//	WebElement mobAcc =driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[1]/ul/li[3]/span/a"));
//	ac.contextClick(mobAcc).build().perform();
//	
//	WebElement amazon = driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]"));
//	ac.doubleClick(amazon).build().perform();
			
    //moveToElement()  - mouse hover
	WebElement login = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/a/span"));
	ac.moveToElement(login).build().perform();
	
}
}
