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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeSuite;

public class HardSoftAssert {
	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void beforeTest() {
		driver.get("https://demo.guru99.com/test/newtours/login.php");

	}

	@BeforeClass
	public void beforeClass() {
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		Set<Cookie> co = driver.manage().getCookies();
		System.out.println(co.size());
	}

	@Test(priority = 1, dataProvider = "getData")
	public void f(String uname, String pass) {
		SoftAssert sa = new SoftAssert();
		String curl = driver.getCurrentUrl();
		Assert.assertEquals(curl, "https://demo.guru99.com/test/newtours/login.php");

		WebElement un = driver.findElement(By.xpath("//input[@name='userName']"));
		un.sendKeys(uname);
		sa.assertEquals(uname, "Gauri");

		WebElement pw = driver.findElement(By.xpath("//input[@name='password']"));
		pw.sendKeys(pass);
		sa.assertEquals(pass, "gauri123");
		sa.assertAll();
	}

	@Test(priority = 2)
	@Parameters({ "fname", "lname" })
	public void demoWebShop(String fn, String ln) {
		SoftAssert sa = new SoftAssert();
		driver.get("https://demowebshop.tricentis.com/register");
		driver.findElement(By.id("FirstName")).sendKeys(fn);
		sa.assertEquals(fn, "Gau");
		
		driver.findElement(By.id("LastName")).sendKeys(ln);
		sa.assertEquals(ln, "Bonde");
		
		sa.assertAll();
	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClass() {
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { new Object[] { "Gauri", "gauri123" } };
	}

}
