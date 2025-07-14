package com.cjc.mt.webapp.test;

import org.testng.annotations.Test;

import com.cjc.mt.webapp.pages.LoginPage;
import com.cjc.mt.webapp.pages.MIRegisterPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MITest {
	WebDriver driver;
	static Logger log = Logger.getLogger(MITest.class.getName());

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\138\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("----BeforeSuite: Browser launched----");
	}

	@BeforeTest
	public void beforeTest() {

		String curl = "https://demo.guru99.com/test/newtours/register.php";
		if (curl == null || curl.trim().isEmpty()) {
			log.warn("Exception occurred while navigating to the URL: " + curl);
		} else {
			try {
				driver.get(curl);
				log.info("Navigate to url: " + curl);
			} catch (Exception e) {
				// TODO: handle exception
				log.warn("Exception occurred while navigating to the URL: " + curl);
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
		log.info("Size of Cookies is: " + s.size());
	}

	@Test
	public void f() throws InterruptedException {
		MIRegisterPage rp = new MIRegisterPage(driver);

		rp.RegistrationPage("Gauri", "Bonde", "9876543212", "g@gmail.com", "address", "city", "State", "444444",
				"India", "gauri", "gauri123", "gauri123");
		log.info("---Registration Successfully!----");

		Thread.sleep(2000);
		LoginPage lp = new LoginPage(driver);
		lp.LoginCheck("gauri", "gauri123");
		log.info("---Login Successfully!----");
		
		Thread.sleep(2000);
		driver.close();
	}

	@AfterMethod
	public void afterMethod() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = "D:\\My-Data\\JAVA\\ScreenShots\\maven\\MITest.png";
		FileUtils.copyFile(src, new File(path));
		log.info("Screenshot saved at: " + path);
	}

	@AfterSuite
	public void afterSuite() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
