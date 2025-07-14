package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationForm {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("https://demowebshop.tricentis.com/register");
    
    driver.manage().window().maximize();
    
    //gender-female
    WebElement gender = driver.findElement(By.id("gender-female"));
    gender.click();
    
    WebElement fName= driver.findElement(By.name("FirstName"));
    fName.sendKeys("Gauri");
    
    WebElement lName= driver.findElement(By.name("LastName"));
    lName.sendKeys("Bonde");
    
    WebElement email = driver.findElement(By.name("Email"));
    email.sendKeys("gb1@gmail.com");
    
    //Password  
    WebElement pass = driver.findElement(By.name("Password"));
    pass.sendKeys("gaurib");
    
    WebElement cPass = driver.findElement(By.name("ConfirmPassword"));
    cPass.sendKeys("gaurib");
    
    Thread.sleep(2000);
    WebElement submit = driver.findElement(By.name("register-button"));
    submit.click();
    
    
    
    }
}
