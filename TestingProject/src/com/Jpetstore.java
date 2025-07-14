package com;

import java.time.temporal.ChronoField;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jpetstore {
public static void main(String[] args) throws InterruptedException{
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://jpetstore.aspectran.com/account/newAccountForm");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table/tbody/tr/td[2]/child::input")).sendKeys("John");
	
	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table/tbody/tr[2]/td[2]/child::input")).sendKeys("johnd");
	
	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table/tbody/tr[3]/td[2]/child::input")).sendKeys("johnd");

    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr/td[2]/child::input")).sendKeys("John");
    
    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[2]/td[2]/child::input")).sendKeys("Doe");

    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[3]/td[2]/child::input")).sendKeys("example@gamil.com");

    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[4]/td[2]/child::input")).sendKeys("9876543213");
   
    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[5]/td[2]/child::input")).sendKeys("Address one");
  
    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[6]/td[2]/child::input")).sendKeys("Address Two");

    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[7]/td[2]/child::input")).sendKeys("City");
    
    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[8]/td[2]/child::input")).sendKeys("State");
    
    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[9]/td[2]/child::input")).sendKeys("Zip");
    
    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[10]/td[2]/child::input")).sendKeys("Country");
    
    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[3]/tbody/tr/td[2]/select/child::option[@value=\"german\"]")).click();

    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[3]/tbody/tr[2]/td[2]/select/child::option[@value=\"DOGS\"]")).click();
    
    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[3]/tbody/tr[3]/td[2]/child::input")).click();
    
    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[3]/tbody/tr[4]/td[2]/child::input")).click();
    
    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/div/child::button")).click();

 
    Thread.sleep(5000);
    driver.close();

}
}
