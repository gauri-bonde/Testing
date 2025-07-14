package dataProvider;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookPage {
	static WebDriver driver;
	@BeforeSuite
	  public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();  
	}
	
	@BeforeTest
	  public void enterUrl() 
	  {
		driver.get("https://www.facebook.com/");
	  }
	
	@BeforeClass
	  public void maximizeBrowser() 
	  {
		driver.manage().window().maximize();
	  }
	
	@BeforeMethod
	  public void getCookiesDetails() 
	  {
	  Set<Cookie> co =driver.manage().getCookies();
		System.err.println(co.size());	  
	  }  
	
	@Test(dataProvider = "getData")
	public void loginCheck(String un,String ps) throws InterruptedException
	{
		
		driver.findElement(By.name("email")).sendKeys(un);
		driver.findElement(By.name("pass")).sendKeys(ps);

		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("pass")).clear();
	}
	@DataProvider
	  public Object[][] getData()
	  {
		  return new Object[][]
				  {
			  new Object[]{"Gauri","gauri@4412!"},
		  new Object[]{"John","john&123#"}
//			  new Object[] {"AAAA","aaaa"}
				  };
	  }
}
