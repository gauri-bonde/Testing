package com.precedingSibling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JpetstoreWebPage {
public static void main(String[] args) throws InterruptedException{
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();
	driver.get("https://jpetstore.aspectran.com/account/newAccountForm");
	
	driver.manage().window().maximize();
	
	//User Information
	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table/tbody/tr[3]/preceding-sibling::tr[2]/td[2]/input[@name=\"username\"]")).sendKeys("userid");
	
	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table/tbody/tr[3]/preceding-sibling::tr[1]/td[2]/input[@name=\"password\"]")).sendKeys("password");

	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table/tbody/tr[2]/following-sibling::tr[1]/td[2]/input[@name=\"repeatedPassword\"]")).sendKeys("password");

    //Account Information
	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[10]/preceding-sibling::tr[9]/td[2]/input[@name=\"firstName\"]")).sendKeys("FirstName");
	
	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[10]/preceding-sibling::tr[8]/td[2]/input[@name=\"lastName\"]")).sendKeys("LastName");
	
	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[10]/preceding-sibling::tr[7]/td[2]/input[@name=\"email\"]")).sendKeys("example@gmail.com");

	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[10]/preceding-sibling::tr[6]/td[2]/input[@name=\"phone\"]")).sendKeys("0987654321");
	
	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[10]/preceding-sibling::tr[5]/td[2]/input[@name=\"address1\"]")).sendKeys("Address1");

	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[10]/preceding-sibling::tr[4]/td[2]/input[@name=\"address2\"]")).sendKeys("Address2");
	
	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[10]/preceding-sibling::tr[3]/td[2]/input[@name=\"city\"]")).sendKeys("City");

	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[10]/preceding-sibling::tr[2]/td[2]/input[@name=\"state\"]")).sendKeys("State");
	
	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[10]/preceding-sibling::tr[1]/td[2]/input[@name=\"zip\"]")).sendKeys("567849");
	
	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[2]/tbody/tr[9]/following-sibling::tr[1]/td[2]/input[@name=\"country\"]")).sendKeys("INDIA");
	
	//Profile Information
	driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[3]/tbody/tr[4]/preceding-sibling::tr[3]/td[2]/select/option[@value=\"french\"]")).click();

    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[3]/tbody/tr[4]/preceding-sibling::tr[2]/td[2]/select/option[@value=\"DOGS\"]")).click();
    
    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[3]/tbody/tr[4]/preceding-sibling::tr[1]/td[2]/input[@name=\"listOption\"]")).click();
    
    driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table[3]/tbody/tr[3]/following-sibling::tr[1]/td[2]/input[@name=\"bannerOption\"]")).click();
    
    //Save Account Information
    driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/div/button")).click();

}

}
