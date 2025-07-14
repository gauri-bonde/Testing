package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParabankRegister {
public static void main(String[] args)throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");

    //https://parabank.parasoft.com/parabank/register.htm;jsessionid=BA013D50A7B7EA02FD45F63B8D833345
	WebDriver driver = new ChromeDriver();
	driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=BA013D50A7B7EA02FD45F63B8D833345");
    driver.manage().window().maximize();
    
    driver.findElement(By.id("customer.firstName")).sendKeys("Gauri");
    
    driver.findElement(By.id("customer.lastName")).sendKeys("Bonde");
    
    driver.findElement(By.id("customer.address.street")).sendKeys("Abc Xyz");
    
    driver.findElement(By.id("customer.address.city")).sendKeys("Pune");
    
    driver.findElement(By.id("customer.address.state")).sendKeys("Maharashtra");
    
    driver.findElement(By.id("customer.address.zipCode")).sendKeys("556789");
    
    driver.findElement(By.id("customer.phoneNumber")).sendKeys("9876543212");
    
    driver.findElement(By.id("customer.ssn")).sendKeys("999");
    
    driver.findElement(By.id("customer.username")).sendKeys("gauri");
    
    driver.findElement(By.id("customer.password")).sendKeys("gaurib");
    
    driver.findElement(By.id("repeatedPassword")).sendKeys("gaurib");
    
    Thread.sleep(2000);
   driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[13]/td[2]/input")).click();
}
}
