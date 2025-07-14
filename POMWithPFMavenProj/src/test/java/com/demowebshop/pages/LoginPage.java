package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@class='ico-login']")
	WebElement logIn;

	@FindBy(name = "Email")

	@CacheLookup
	WebElement email;

	@FindBy(xpath = "//input[@name='Password']")
	WebElement pass;

	@FindBy(xpath = "//input[@class='button-1 login-button']")
	WebElement login;

	public void LoginCheck(String em, String pw) {
		logIn.click();
		email.sendKeys(em);
		pass.sendKeys(pw);
		login.click();
	}
}
