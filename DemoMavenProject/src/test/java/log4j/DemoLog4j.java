package log4j;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DemoLog4j {
	WebDriver driver;
	Logger log = Logger.getLogger(DemoLog4j.class.getName());

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("----BeforeRun----");

	}

	@BeforeTest
	public void beforeTest() {
		driver.get("https://demo.automationtesting.in/WebTable.html");
		log.info("----BrforeTest----");
	}

	@BeforeClass
	public void beforeClass() {
		driver.manage().window().maximize();
		log.info("----BeforeClass----");
	}

	@BeforeMethod
	public void beforeMethod() {
		Set<Cookie> c = driver.manage().getCookies();
		log.info("-----Cookies Count is:----- " + c.size());

	}

	@Test
	public void f() {
		SoftAssert sa = new SoftAssert();
		try {
			driver.findElement(By.xpath("//a[text()='Register']")).click();
			driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Gauri");
			driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Bonde");
			driver.findElement(By.cssSelector("textarea[class='form-control ng-pristine ng-untouched ng-valid']"))
					.sendKeys("Rukhmini Nagar Deomali, Amravati");

			// Enter email
			driver.findElement(By.cssSelector("input[type='email']")).sendKeys("gauri");

			// Validate email input (intentionally incorrect to test logging)
			String actualEmail = driver.findElement(By.cssSelector("input[type='email']")).getAttribute("value");
			if (!actualEmail.equals("gauri@gmail.com")) {
				log.error("-----Email mismatch: Expected 'gauri@gmail.com' but found '-----" + actualEmail + "'");
			}
			sa.assertEquals(actualEmail, "gauri@gmail.com", "Email is incorrect");

			driver.findElement(By.cssSelector("input[type='tel']")).sendKeys("9876543212");

			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				WebElement submitBtn = wait
						.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id='submitbtn']")));
				submitBtn.click();
				log.info("-----Submit button clicked successfully.-----");
			} catch (Exception e) {
				log.error("-----Error clicking on Submit button:----- " + e.getMessage());
			}

		} catch (Exception e) {
			log.error("-----Error during form submission:----- " + e.getMessage());
		} finally {
			try {
				sa.assertAll(); // Will throw if any soft assertions failed
			} catch (AssertionError ae) {
				log.error("-----Assertion failure:----- " + ae.getMessage(), ae);
			}
		}

	}

	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public void afterClass() throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\My-Data\\JAVA\\ScreenShots\\maven\\reg.png"));
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();

	}

	@AfterSuite
	public void afterSuite() {
	}

}
