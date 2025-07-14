package com.demowebshop.test;

import org.testng.annotations.Test;

import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.RegistrationPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DemoWebshopTest {

	WebDriver driver;
	static Logger log = Logger.getLogger(DemoWebshopTest.class.getName());

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\138\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void beforeTest() {
		driver.get("https://demowebshop.tricentis.com/");
		String curUrl = driver.getCurrentUrl();
		log.info(":" + curUrl);

	}

	@BeforeClass
	public void beforeClass() {
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		Set<Cookie> ca = driver.manage().getCookies();
		log.info("Cookies : " + ca.size());
	}

	@Test(priority = 1)
	@Parameters({ "fName", "lName", "email", "pass", "cPass" })
	public void f(String firstName, String lastName, String emailId, String password,
			String conPass) {
		RegistrationPage reg = PageFactory.initElements(driver, RegistrationPage.class);
		reg.RegCheck(firstName, lastName, emailId, password, conPass);

		
	}

	@Test(priority = 2, dataProvider = "getData")
	public void loginPg(String em, String pw) {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.LoginCheck(em, pw);
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

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { new Object[] { "gauri@gamil.com", "gauri@1234" }

		};
	}
}
