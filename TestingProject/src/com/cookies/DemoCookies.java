package com.cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoCookies {
	public static void main(String[] args)throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		Set<Cookie> cookies = driver.manage().getCookies();
		int ccount = cookies.size();
		System.out.println(ccount);
		
		for(Cookie cookie : cookies)
		{
			System.out.println("The name of cookie is :" +cookie.getName());
			System.out.println("The domain of cookie is :" +cookie.getDomain());
			System.out.println("The path of cookie is :" +cookie.getPath());
			System.out.println("The values of cookie is :" +cookie.getValue());
			System.out.println("The class of cookie is :" +cookie.getClass());
			System.out.println("The Http only of cookie is :" +cookie.isHttpOnly());
			System.out.println("The Secure of cookie is :" +cookie.isSecure());
			System.out.println("The Expiry of cookie is :" +cookie.getExpiry());

			System.out.println("--------------------------------------");
		}
		//Delet Cookies
		driver.manage().deleteCookieNamed("i18n-prefs");
	    Set<Cookie> cookies1 = driver.manage().getCookies();
	    int ccount1 = cookies1.size();
	    System.out.println(ccount1);
	    
	    //Add cookie
	    Cookie username = new Cookie("Gauri", "Java");
	    driver.manage().addCookie(username);
	}	
}
