package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
public static void main(String[] args)throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");

WebDriver driver = new ChromeDriver();

driver.get("https://demo.guru99.com/test/newtours/index.php");

driver.manage().window().maximize();

Thread.sleep(2000);
WebElement uname = driver.findElement(By.name("userName"));
uname.sendKeys("John");

Thread.sleep(2000);
WebElement pass = driver.findElement(By.name("password"));
pass.sendKeys("john");

WebElement submit = driver.findElement(By.name("submit"));
pass.click();

Thread.sleep(2000);
driver.close();
}
}
