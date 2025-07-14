package com.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class DemoSikuli {
	public static void main(String[] args) throws FindFailed {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\138\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");

		Screen sc = new Screen();
		// register page
		Pattern fn = new Pattern("D:\\My-Data\\JAVA\\Selenium\\SikuliScrrenShot\\register\\firstName.PNG");
		Pattern ln = new Pattern("D:\\My-Data\\JAVA\\Selenium\\SikuliScrrenShot\\register\\lastName.PNG");
		Pattern phone = new Pattern("D:\\My-Data\\JAVA\\Selenium\\SikuliScrrenShot\\register\\phone.PNG");
		Pattern email = new Pattern("D:\\My-Data\\JAVA\\Selenium\\SikuliScrrenShot\\register\\email.PNG");
		Pattern add = new Pattern("D:\\My-Data\\JAVA\\Selenium\\SikuliScrrenShot\\register\\address.PNG");
		Pattern city = new Pattern("D:\\My-Data\\JAVA\\Selenium\\SikuliScrrenShot\\register\\city.PNG");
		
		
		
		
		
		
//		// signOn page
//		Pattern signOn = new Pattern("D:\\My-Data\\JAVA\\Selenium\\SikuliScrrenShot\\SignOn.PNG");
//		Pattern un = new Pattern("D:\\My-Data\\JAVA\\Selenium\\SikuliScrrenShot\\username.PNG");
//		Pattern pw = new Pattern("D:\\My-Data\\JAVA\\Selenium\\SikuliScrrenShot\\password.PNG");
//		Pattern login = new Pattern("D:\\My-Data\\JAVA\\Selenium\\SikuliScrrenShot\\submitBtn.PNG");

		driver.manage().window().maximize();
		sc.type(fn, "Gauri");
		sc.type(ln, "Bonde");
		sc.type(phone,"9876543234");
		sc.type(email,"gauri@gmail.com");
		sc.type(add,"Address");
		sc.type(city,"Pune");
		
		
//		sc.click(signOn);
//		sc.type(un, "gauri");
//		sc.type(pw, "gauri123");
//		sc.click(login);
	}
}
