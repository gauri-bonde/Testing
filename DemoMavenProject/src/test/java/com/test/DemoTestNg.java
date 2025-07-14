package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DemoTestNg {
	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void beforeTest() {
		driver.get("https://demowebshop.tricentis.com/");
	}

	@BeforeClass
	public void beforeClass() {
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		Set<Cookie> s = driver.manage().getCookies();
		System.out.println(s.size());

	}

	@Test
	public void f() {
		driver.findElement(By.xpath("//*[text()='Register']")).click();
	}

	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
	}

	@AfterSuite
	public void afterSuite() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

	@AfterClass
	public void afterClass() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\My-Data\\JAVA\\ScreenShots\\maven\\sc.png"));
	}

}
