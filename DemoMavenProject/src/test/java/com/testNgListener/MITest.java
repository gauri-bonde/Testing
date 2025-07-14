package com.testNgListener;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(com.testNgListener.DemoISuiteListener.class)
public class MITest {
	WebDriver driver;

	@BeforeSuite(groups = "abc")
	public void broweserDetails() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("----BeforeSuite----");
	}

	@BeforeTest
	public void browserDetails() {
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		System.out.println("----BeforeTest----");
	}

	@BeforeClass
	public void maximizeBrowser() {
		driver.manage().window().maximize();
		System.out.println("----BrforeClass----");
	}

	@BeforeMethod
	public void getCookiesDetails() {
		Set<Cookie> co = driver.manage().getCookies();
		System.out.println(co.size());
		System.out.println("----BeforeMethod----");
	}

	@Test
	public void loginCheck() {
		driver.findElement(By.name("email")).sendKeys("gb@gmail.com");
		driver.findElement(By.name("password")).sendKeys("gauri@2344");
		driver.findElement(By.name("confirmPassword")).sendKeys("gauri@2344");
		driver.findElement(By.name("submit")).click();
		System.out.println("----This is Login check- Actual Test----");
	}

	@AfterSuite
	public void browserClose() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
