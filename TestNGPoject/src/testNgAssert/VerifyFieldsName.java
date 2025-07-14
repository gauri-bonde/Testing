package testNgAssert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class VerifyFieldsName {
	WebDriver driver;
	SoftAssert sa = new SoftAssert();

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void beforeTest() {
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		System.out.println("----BeforeTest----");
	}

	@BeforeClass
	public void beforeClass() {
		driver.manage().window().maximize();
		System.out.println("----BrforeClass----");
	}

	@BeforeMethod
	public void beforeMethod() {
		Set<Cookie> s = driver.manage().getCookies();
		System.out.println(s.size());
	}

	@Test
	public void f() {
		WebElement label= driver.findElement(By.xpath("//*[text()='Phone:']"));
	    sa.assertEquals(label.getText().trim(),"Phone:");
	    sa.assertAll();
	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClass() {
	}

	@AfterTest
	public void afterTest() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
