package parameters;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MTTest {
	WebDriver driver;

	@BeforeSuite(groups = "abc")
	public void broweserDetails() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("----BeforeSuite----");
	}

	@BeforeTest(groups = "abc")
	@Parameters({ "url" })
	public void browserDetails(String aurl) {
		driver.get(aurl);
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

	@Test(groups = "abc")
	@Parameters({ "user", "pass", "confpass" })
	public void loginCheck(String un, String pw, String cpw) {
		driver.findElement(By.name("email")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.name("confirmPassword")).sendKeys(cpw);
		driver.findElement(By.name("submit")).click();
		System.out.println("----This is Login check- Actual Test----");
	}

	@AfterSuite(groups = "abc")
	public void browserClose() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}