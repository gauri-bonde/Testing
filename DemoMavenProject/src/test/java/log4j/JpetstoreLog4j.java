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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class JpetstoreLog4j {
	WebDriver driver;

	static Logger log = Logger.getLogger(JpetstoreLog4j.class.getName());

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest

	public void beforeTest() {
		driver.get("https://jpetstore.aspectran.com");

	}

	@BeforeClass
	public void beforeClass() {
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		Set<Cookie> co = driver.manage().getCookies();
		log.info("Total Cookies: " + co.size());
	}

	@Test(priority = 1)
	@Parameters({ "userId", "newPw", "confPw", "fName", "lName", "email", "phone", "add1", "add2", "city", "state",
			"zip", "count" })
	public void signUp(String userid, String nwepw, String confpw, String fname, String lname, String emailid, String pNum,
			String address1, String address2, String city, String states, String zipCode, String country) {

		log.info("=== Test Execution Started for userId: " + userid + " ===");

		// Hard Assert
		String curl = driver.getCurrentUrl();
		log.info("Current URL: " + curl);
		Assert.assertTrue(curl.contains("jpetstore.aspectran.com"), "URL did not match");

		WebDriverWait wait = new WebDriverWait(driver, 15);

		SoftAssert sa = new SoftAssert();

		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sign Up']"))).click();
			log.info("Clicked on Sign Up");

			// sa.assertNotEquals(userid, "gauri", "Invalid test data: userid should not be
			// 'gauri'");
			WebElement userId = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
			log.info("Entering User ID: " + userid);
			userId.sendKeys(userid);

			WebElement newPw = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
			// sa.assertTrue(newPw.isDisplayed(), "New Password field not visible");
			newPw.sendKeys(nwepw);

			WebElement confPw = wait.until(ExpectedConditions.elementToBeClickable(By.name("repeatedPassword")));
			confPw.sendKeys(confpw);

			log.info("Entering Name: " + fname + " " + lname);
			WebElement fName = wait.until(ExpectedConditions.elementToBeClickable(By.name("firstName")));
			fName.sendKeys(fname);

			WebElement lName = wait.until(ExpectedConditions.elementToBeClickable(By.name("lastName")));
			lName.sendKeys(lname);

			WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.name("email")));
			email.sendKeys(emailid);

			WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.name("phone")));
			phone.sendKeys(pNum);
			log.info("Entering Address: " + address1 + "," + city + "," + states + "," + zipCode + "," + country);
			WebElement add1 = wait.until(ExpectedConditions.elementToBeClickable(By.name("address1")));
			add1.sendKeys(address1);

			WebElement add2 = wait.until(ExpectedConditions.elementToBeClickable(By.name("address2")));
			add2.sendKeys(address2);

			WebElement cityp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='city']")));
			cityp.sendKeys(city);

			WebElement state = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='state']")));
			state.sendKeys(states);

			WebElement zip = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='zip']")));
			zip.sendKeys(zipCode);

			WebElement count = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='country']")));
			count.sendKeys(country);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save Account Information']")))
					.click();
			sa.assertAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("-----Error during form submission: " + e.getMessage());
			log.error("Exception Stack Trace: ", e);
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

	}
	@Test(priority = 2, dataProvider = "getData", dependsOnMethods = "signUp")
	public void login(String uId, String pw) throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='username']")).clear();
		driver.findElement(By.xpath("//input[@name='password']")).clear();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(uId);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pw);
		log.info("User Credentials entered Successfully: "+ "User ID: " +uId+ "PassWord: " +pw);
		
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		log.info("User Login Successfully");
	}

	@AfterMethod
	public void afterMethod() {
		   driver.manage().deleteAllCookies();
		    log.info("Deleted all cookies.");
	}

	@AfterClass
	public void afterClass() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\My-Data\\JAVA\\ScreenShots\\maven\\jpestore.png"));
		log.info("TakesScreenshot Done");
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

	@AfterSuite
	public void afterSuite() {
		if (driver != null) {
	        driver.quit();
	        log.info("Driver quit successfully");
	    }
	}

	@DataProvider 
	public Object[][] getData()
	{
		return new Object[][]
				{
			new Object[] {"abcdefg","abcdefg123"}
				};
    }
}