package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(linkText ="Register")
	WebElement register;
	
	@FindBy(id = "gender-female")
	WebElement gender;

	@CacheLookup

	@FindBy(id = "FirstName")
	WebElement fn;
	
	@FindBy(id = "LastName")
	WebElement ln;
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement pass;

	@FindBy(id="ConfirmPassword")
	WebElement confPass;
	
	@FindBy(name="register-button")
	WebElement regBtn;
	
	public void RegCheck(String firstName, String lastName, String emailId, String password, String conPass) {
		register.click();
		gender.click();
		fn.sendKeys(firstName);
		ln.sendKeys(lastName);
		email.sendKeys(emailId);
		pass.sendKeys(password);
		confPass.sendKeys(conPass);
		regBtn.click();
		
		

	}
}
