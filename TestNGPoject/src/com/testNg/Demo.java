package com.testNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo {
	WebDriver driver ;
@BeforeSuite
public void browserOpen() {
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
	System.out.println("Browser Opened");
}

@BeforeTest
public void enterUrl()

{
	 driver = new ChromeDriver();
	 driver.get("https://www.facebook.com/");
	 System.out.println("Pass the URL Details");
}

@BeforeClass
public void maximizeScrren()
{
	driver.manage().window().maximize();
	System.out.println("We can maximize our screen or can do Database Connectivity");
}
@BeforeMethod
public void cookiesDetails()
{
	System.out.println("Get cookied Detail");
}

@Test
public void loginCheck() throws InterruptedException
{
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("gauri.bonde@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("gauri@B");
	
	//create new account
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//a[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]")).click();

	Thread.sleep(2000);
	driver.close();
}
@AfterSuite
public void browserClose()
{
	driver.close();
	System.out.println("----Browser Closed----");
}
}


