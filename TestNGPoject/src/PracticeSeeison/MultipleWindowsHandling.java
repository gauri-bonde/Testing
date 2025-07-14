package PracticeSeeison;

import org.testng.annotations.*;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class MultipleWindowsHandling {
	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void beforeTest() {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	}

	@BeforeClass
	public void windowMax() {
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void getCookiesDetails() {
		Set<Cookie> co = driver.manage().getCookies();
		int coCount = co.size();
		System.err.println(coCount);
	}

	@Test
	public void f() throws InterruptedException {
    List<WebElement> list = driver.findElements(By.tagName("a"));
    int listCount = list.size();
    System.out.println("Total Hyperlink count is: "+listCount);
    
    //Fotter Hyperlink
    List<WebElement> footerLink =driver.findElements(By.xpath("//div[@id='gf-BIG']"));
    int flCount = footerLink.size();
    System.out.println("Footer Hyperlink Count is : "+flCount);
    
    //perticular footer link
    WebElement footerLink1 =driver.findElement(By.xpath("//*[@id='gf-BIG']/table/tbody/tr/td[1]"));
    List<WebElement> pfl = footerLink1.findElements(By.tagName("a"));
    int pflCount = pfl.size();
    System.out.println("perticular footer link Count is: " +pflCount);
    
    //open all links in seperate window
    for(int i=1; i<pflCount;i++)
    {
    	String clickLink = Keys.chord(Keys.CONTROL, Keys.ENTER );
    	footerLink1.findElements(By.tagName("a")).get(i).sendKeys(clickLink);
    	Thread.sleep(2000);
    }
	}

	@AfterMethod
	public void takeScreenShoot() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\My-Data\\JAVA\\ScreenShots\\img1.jpg"));
		
	}

	@AfterClass
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("");
	}

	@AfterSuite
	public void afterSuite() throws InterruptedException {
	Thread.sleep(2000);
	driver.close();
	}
	

}
