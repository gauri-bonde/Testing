package dataProvider;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeSuite;

public class Demo {
  
	static WebDriver driver;
	@BeforeSuite
	  public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();  
	}
	
	@BeforeTest
	  public void enterUrl() 
	  {
		driver.get("https://demo.guru99.com/test/newtours/login.php");
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
  public void f(String usName, String pass) throws InterruptedException {
	  driver.findElement(By.name("userName")).sendKeys(usName);
	  driver.findElement(By.name("password")).sendKeys(pass);
	  
	  driver.findElement(By.name("submit")).click();
	  
	  Thread.sleep(2000);
	  driver.navigate().back();
	  driver.findElement(By.name("userName")).clear();
	  driver.findElement(By.name("password")).clear();
	  
  }
  @AfterMethod
  public void browserClose()throws InterruptedException {
	  Thread.sleep(5000);
	  //driver.close();
  }
  @DataProvider
  public Object[][] getData()
  {
	return new Object[][]
			{
		new Object[] {"gauri","gauri@123"},
		new Object[] {"kkkk", "kkkk$321"}
			};
	  
  }
}
