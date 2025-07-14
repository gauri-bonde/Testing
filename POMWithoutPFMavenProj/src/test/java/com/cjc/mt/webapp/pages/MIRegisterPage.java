package com.cjc.mt.webapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MIRegisterPage {
WebDriver driver;

public MIRegisterPage(WebDriver driver) {
	super();
	this.driver = driver;
}
By firstName= By.name("firstName");
By lastName =By.name("lastName");
By phone = By.name("phone");
By email = By.name("userName");
By address = By.name("address1");
By city = By.name("city");
By state=By.name("state");
By postalCode = By.name("postalCode");
By country = By.name("country");
By userName = By.name("email");
By password = By.name("password");
By confPass = By.name("confirmPassword");
By submit = By.name("submit");
By signOn = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]");

public void RegistrationPage(String fn, String ln, String ph, String em, String add, String c
		,String sta, String pcode, String coun, String uname, String pass, String cPass)
{
	driver.findElement(firstName).sendKeys(fn);
	driver.findElement(lastName).sendKeys(ln);
	driver.findElement(phone).sendKeys(ph);
	driver.findElement(email).sendKeys(em);
	driver.findElement(address).sendKeys(add);
	driver.findElement(city).sendKeys(c);
	driver.findElement(state).sendKeys(sta);
	driver.findElement(postalCode).sendKeys(pcode);
	driver.findElement(country).sendKeys(coun);
	driver.findElement(userName).sendKeys(uname);
	driver.findElement(password).sendKeys(pass);
	driver.findElement(confPass).sendKeys(cPass);
	driver.findElement(submit).click();
	driver.findElement(signOn).click();
}


}
