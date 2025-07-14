package com.propertiesFile;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
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

public class DemoPropertiesFile {
	WebDriver driver;
	Properties pro = new Properties();
	static Logger log = Logger.getLogger(DemoPropertiesFile.class.getName());

	@BeforeSuite
	public void beforeSuite() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream("src\\test\\resources\\demo.properties");
		pro.load(fis);
		log.info("Properties file loaded successfully");
	}

	@BeforeTest
	public void beforeTest() {
		String url = pro.getProperty("url");
		if (url == null || url.trim().isEmpty()) {
			log.warn("URL is missing or empty in the property file");
		} else {
			try {
				driver.get(url);
				log.info("Navigate to url: " + url);
			} catch (Exception e) {
				// TODO: handle exception
				log.warn("Exception occurred while navigating to the URL: " + url);
			}
		}
	}

	@BeforeClass
	public void beforeClass() {
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		Set<Cookie> s = driver.manage().getCookies();
		log.info("Number of cookies before test: " + s.size());
	}

	@Test
	public void f() {
		log.info("Starting login test");
		driver.findElement(By.name("userName")).sendKeys(pro.getProperty("uname"));
		log.info("Entered username: " + pro.getProperty("uname"));
		driver.findElement(By.name("password")).sendKeys(pro.getProperty("pass"));
		log.info("Entered password: " + pro.getProperty("pass"));
		driver.findElement(By.name("submit")).click();
		log.info("Clicked on submit");
	}

	@AfterMethod
	public void afterMethod() {
		log.info("Deleting all cookies after method");
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public void afterClass() throws IOException {
		log.info("Taking screenshot after test class execution");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = "D:\\My-Data\\JAVA\\ScreenShots\\maven\\pro.png";
		FileUtils.copyFile(src, new File(path));
		log.info("Screenshot saved at: " + path);

	}

	@AfterTest
	public void afterTest() {
	}

	@AfterSuite
	public void afterSuite() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
