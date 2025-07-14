package com.cjc.mt.webapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {// created constructor
		super();
		this.driver = driver;
	}

	
	By user = By.name("userName");
	By pass = By.name("password");
	By login = By.name("submit");

	public void LoginCheck(String un, String pw) {
		
		driver.findElement(user).sendKeys(un);
		driver.findElement(pass).sendKeys(pw);
		driver.findElement(login).click();
	}
}
